package com.klaus.iv.stockspider.controller;


import com.klaus.iv.commonbase.util.CommonConstants;
import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.base.BaseController;
import com.klaus.iv.stockapi.dto.StockDto;
import com.klaus.iv.stockapi.feign.StockClient;
import com.klaus.iv.stockspider.facade.StockFacade;
import com.klaus.iv.stockspider.utils.RestTemplateUtils;
import com.klaus.iv.stockspider.utils.StockComputeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.klaus.iv.stockspider.constants.NetEaseApi.EASTMONEY_STOCKS_URL;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_ALL;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_ERROR;
import static com.klaus.iv.stockspider.utils.StockComputeUtil.getStockRedisRealtimeKey;
import static org.springframework.web.client.HttpClientErrorException.NotFound;

@RestController
@RequestMapping("/stock")
@Slf4j
@Api("Stock Data Module")
public class StockDataController extends BaseController {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    public KafkaTemplate kafkaTemplate;
//
//    @Autowired
//    public AdminClient adminClient;

    @Autowired
    private StockFacade stockFacade;

    @Autowired
    private StockClient stockClient;


//    @Value("${spring.kafka.topic}")
    private String topic;

    @GetMapping("/allguide/{guideLevel}/{type}")
    @ApiOperation(notes = "type : up/down, guideLevel: 1/3/5/7/10", value = "get guide for level and type")
    public ResponseEntity getAllguide(@PathVariable(name = "guideLevel") String guideLevel, @PathVariable(name = "type") String type) {

        Set<String> stocks = null;
        if(type.equals("all")) {
            stocks = redisTemplate.opsForSet().members(REDIS_STOCK_CODE_SET_ALL);
        } else {
            stocks = redisTemplate.opsForSet().members(String.format("redis:stock:code:set:%s:%s", type, guideLevel));

        }
        int days = LocalDateTime.now().getDayOfYear();
        log.info("days is :{}, and stocks is:{}", days, stocks);
        List<HashMap<String ,Object>> result = null;
        if (stocks!=null && !stocks.isEmpty()) {
            result = stocks.stream().map(stockCode -> {
                log.info("stockCode is :{}", stockCode);
                try {
                    return stockFacade.guide(stockCode, days);
                } catch (Exception e) {
                    log.error("stock is:{}, guide error :{}", stockCode, e);
                } finally {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_ERROR, stockCode);
                    HashMap<String ,Object> rateMaps = new HashMap<>();
                    rateMaps.put(stockCode, null);
                    return rateMaps;
                }
            }).collect(Collectors.toList());
        }
        return R.suc(result);

    }


    /**
     *
     * 根据股票代码计算这只股票最近一个月内的累计数据变化
     * 600797 日涨幅 3日涨幅 5日涨幅 7日涨幅 14日涨幅 30日涨幅
     * @param stockCode
     * @return
     */
    @GetMapping("/guide")
    @ApiOperation(value = "guide", tags = {"guide"})
    public ResponseEntity guide(@RequestParam("stockCode") String stockCode, @RequestParam("days") int days) {
        log.info("stockCode is :{}", stockCode);
        try {
            return ResponseEntity.ok(stockFacade.guide(stockCode, days));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.suc(Collections.EMPTY_MAP);
    }

    @GetMapping()
    @ApiOperation(value = "list", notes = "JSON实时数据")
    public ResponseEntity list() {
        Set<String> result = redisTemplate.opsForSet().members(REDIS_STOCK_CODE_SET_ALL);
        return R.suc(result);
    }




    @GetMapping("/sync")
    @ApiOperation(value = "syncData", notes = "临时同步数据")
    public ResponseEntity<Boolean> syncData() {
        stockFacade.syncData();
        return ResponseEntity.ok(true);
    }

    @GetMapping("/today")
    @ApiOperation(value = "fetchTodayData", notes = "获取股票每日分时数据")
    public ResponseEntity todayData(@RequestParam("stockCode") String stockCode) {
        ResponseEntity<HashMap> daily = stockFacade.fetchTodayData(StockComputeUtil.getRegion(stockCode), stockCode);
        if (daily.getStatusCodeValue() == 200) {
            //kafkaTemplate.send(topic, daily.getBody());
            //redisTemplate.opsForValue().set(getStockRedisDayKey(stockCode, "daily", CommonConstants.DataPattern.YYYYMMDD), daily.getBody(), Duration.ofDays(30));
            log.info("daily result is :{}", daily.getBody());
            return R.suc(daily.getBody());
        }
        return R.suc(true);
    }

    @GetMapping("/now")
    @ApiOperation(value = "nowData", notes = "JSON实时数据")
    public ResponseEntity nowData(@RequestParam("stockCode") String stockCode) {
        ResponseEntity<String > now ;
        try {
            now = stockFacade.nowData(StockComputeUtil.getRegion(stockCode), stockCode);

            redisTemplate.opsForSet().add(getStockRedisRealtimeKey(stockCode, "real-time", CommonConstants.DataPattern.YYYYMMDD), now.getBody());
            if (log.isInfoEnabled()) {
                log.info("now result is :{}", now.getBody());
            }
            return R.suc(now.getBody());
        } catch (NotFound e) {
            log.error("stock error, can't find data, region is :{}, stock is :{}", StockComputeUtil.getRegion(stockCode), stockCode);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("error invoked :{}", e);
            return ResponseEntity.badRequest().build();
        }
    }



    @GetMapping("/fetch/{code}")
    @ApiOperation(value = "findStocksYearByCode", notes = "JSON实时数据")
    public ResponseEntity<HashMap> findStocksYearByCode(@PathVariable(name = "code") String code) {
        return this.stockFacade.saveYearDataToRedis(code);
    }

    @GetMapping("/fetch")
    @ApiOperation(value = "findStocks", notes = "JSON实时数据")
    public ResponseEntity<Boolean> findStocks() {

        ResponseEntity<HashMap> data = RestTemplateUtils.get(EASTMONEY_STOCKS_URL, HashMap.class);
//        log.info("data is :{}", data.getBody());
        HashMap<String, Object> result = data.getBody();
        HashMap<String, Object> datas = (HashMap<String, Object>) result.get("data");
        List<HashMap> dataNodes = (List<HashMap>) datas.get("diff");
        log.info("data size is:{}", dataNodes.size());

        dataNodes.stream()
            .map(node -> {
                StockDto stockDto = new StockDto();
                stockDto.setCode((String) node.get("f12"));
                stockDto.setName((String) node.get("f14"));
                return stockDto;
            })
            .forEach(
                    node -> {
                        redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_ALL, node.getCode());
                        try {
                            stockClient.save(node);
                        }  catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            );
        return ResponseEntity.ok(true);
    }

}
