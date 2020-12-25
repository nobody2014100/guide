package com.klaus.iv.stockspider.facade;


import com.klaus.iv.commonbase.util.CommonConstants;
import com.klaus.iv.stockspider.constants.NetEaseApi;
import com.klaus.iv.stockspider.dto.GuideRateFragmentDto;
import com.klaus.iv.stockspider.dto.RealtimeStockItemDto;
import com.klaus.iv.stockspider.utils.RestTemplateUtils;
import com.klaus.iv.stockspider.utils.StockComputeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.klaus.iv.stockspider.constants.NetEaseApi.DAILY_TIME_DATA;
import static com.klaus.iv.stockspider.constants.NetEaseApi.FOUR_DAILY_TIME_DATA;
import static com.klaus.iv.stockspider.constants.NetEaseApi.HISTORY_DAILY_TIME_DATA;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_FETCH_ERROR;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_DOWN_10;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_DOWN_100;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_DOWN_30;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_DOWN_50;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_DOWN_70;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_UP_10;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_UP_100;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_UP_30;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_UP_50;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_UP_70;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_SELF_CHOOSE;
import static com.klaus.iv.stockspider.utils.StockComputeUtil.findGreatestSumOfSubArray;
import static com.klaus.iv.stockspider.utils.StockComputeUtil.findMinestSumOfSubArray;
import static com.klaus.iv.stockspider.utils.StockComputeUtil.findRateMaps;
import static com.klaus.iv.stockspider.utils.StockComputeUtil.getStockRedisDayKey;
import static com.klaus.iv.stockspider.utils.StockComputeUtil.getStockRedisRealtimeKey;
import static com.klaus.iv.stockspider.utils.StockComputeUtil.getStockRedisYearKey;

@Component
@Slf4j()
public class StockFacade {


    @Autowired
    private RedisTemplate redisTemplate;


    private ExecutorService executorService = Executors.newCachedThreadPool();


    /**
     * 获取日线
     * @param datas
     * @return
     */
    public Map dayLine(List<ArrayList> datas) {
        Map<String, Double> dayLines = new HashMap();
        dayLines.put("5_days_line", StockComputeUtil.daysLine(datas.stream().map(node -> (Double) node.get(6)).collect(Collectors.toList()), 5));
        dayLines.put("10_days_line", StockComputeUtil.daysLine(datas.stream().map(node -> (Double) node.get(6)).collect(Collectors.toList()), 10));
        dayLines.put("30_days_line", StockComputeUtil.daysLine(datas.stream().map(node -> (Double) node.get(6)).collect(Collectors.toList()), 50));
        dayLines.put("100_days_line", StockComputeUtil.daysLine(datas.stream().map(node -> (Double) node.get(6)).collect(Collectors.toList()), 100));

        dayLines.put("5_days_line_price", StockComputeUtil.daysLine(datas.stream().map(node -> (Double) node.get(2)).collect(Collectors.toList()), 5));
        dayLines.put("10_days_line_price", StockComputeUtil.daysLine(datas.stream().map(node -> (Double) node.get(2)).collect(Collectors.toList()), 10));
        dayLines.put("30_days_line_price", StockComputeUtil.daysLine(datas.stream().map(node -> (Double) node.get(2)).collect(Collectors.toList()), 50));
        dayLines.put("100_days_line_price", StockComputeUtil.daysLine(datas.stream().map(node -> (Double) node.get(2)).collect(Collectors.toList()), 100));
        return dayLines;
    }

    /**
     *
     * @param datas
     */
    private List<GuideRateFragmentDto> guideRates(List<ArrayList> datas) {
        HashMap<String, Double> fragments = new HashMap<>();
        List<GuideRateFragmentDto> guideRateFragmentDtos = new ArrayList<>();
        boolean flag = false;
        String startFrament = null;
        BigDecimal tempRate = new BigDecimal(0.0);
        int dataSize = datas.size();
        for (int i =0 ; i< dataSize; i++) {
            ArrayList node = datas.get(i);
//            Double rate = (Double)node.get(6);
            BigDecimal rate = new BigDecimal((Double) node.get(6));
            String frament = (String) node.get(0);
            if (Math.abs(tempRate.doubleValue()) > Math.abs(tempRate.add(rate).doubleValue()) || i == dataSize -1) {
                flag = true;
            }
            tempRate = tempRate.add(rate);
            if (!flag && StringUtils.isEmpty( startFrament)) {
                startFrament = frament;
            }
            if (flag) {
                GuideRateFragmentDto guideRateFragmentDto = new GuideRateFragmentDto();
                if (!StringUtils.isEmpty(startFrament)) {
                    guideRateFragmentDto.setFragment(String.format("%s:%s", frament, startFrament));
                } else {
//                    if (Math.abs(tempRate)>1) {
                        log.info("------------------------------------ rate is:{}", tempRate);
                        guideRateFragmentDto.setFragment(String.format("%s:%s", frament, frament));
//                    }
                }

                guideRateFragmentDto.setRate(tempRate);
                guideRateFragmentDtos.add(guideRateFragmentDto);
                flag = false;
                startFrament = null;
                tempRate = new BigDecimal(0.0);
            }
        }
        log.debug("guideRateFragmentDtos is :{}", guideRateFragmentDtos);
        return guideRateFragmentDtos;
    }

    public void findFragmentMax(List<ArrayList> datas) {
//        datas.stream().re
    }

    //根据涨跌幅计算复杂度


    /**
     *
     */
    public void monitorRealtimeState() {
        Set<String> codes = redisTemplate.opsForSet().members(REDIS_STOCK_CODE_SET_SELF_CHOOSE);

        // 10秒获取一次实时数据, 一共去10分钟的数据
        codes.forEach(stockCode -> {
            Set<String> items = redisTemplate.opsForSet().members(getStockRedisRealtimeKey(stockCode, "real-time", CommonConstants.DataPattern.YYYYMMDD));
            log.info("items-----{}, {}", items.size(), items);
            List<RealtimeStockItemDto> realtimeStockItemDtos = items.stream().filter(i -> StringUtils.isNotEmpty(i)&& !"null".equals(i)).map(node -> {
                log.info("realtimeStockItemDtos--------{}", node);
                return RealtimeStockItemDto.patseRealtimeStockItemDto(node);
            }).sorted(Comparator.comparing(RealtimeStockItemDto::getTime)).limit(60).collect(Collectors.toList());
            log.info("realtimeStockItemDtos is :{}", realtimeStockItemDtos);


        });
    }

    /**
     * 指导交易
     * @param stockCode
     * @param days
     * @return
     * @throws Exception
     */
    public HashMap<String ,Object> guide( String stockCode, int days) throws Exception{
        HashMap<String ,Object> rateMaps = new HashMap<>();
        List<ArrayList> datas = redisTemplate.opsForList().range(getStockRedisYearKey(stockCode, "history-year", CommonConstants.DataPattern.YYYY), 0,days-1);
        List<Double> rates = datas.stream().map(i -> (Double)i.get(6)).collect(Collectors.toList());
        // 最大连续涨幅
        double maxRate = findGreatestSumOfSubArray(rates);
        // 最大连续跌幅
        double minRate = findMinestSumOfSubArray(rates);
        //分类最大连续涨幅
        handleGuideLevel(maxRate, stockCode);
        //分类最大连续跌幅
        handleGuideLevel(minRate, stockCode);
        List<GuideRateFragmentDto> guideRateFragmentDtos = guideRates(datas);
        //分区涨幅与跌幅
        rateMaps.put("guideRates", guideRateFragmentDtos);
        rateMaps.put("guideGroupBy", guideRateFragmentDtos.stream().map(node -> node.getRate().doubleValue()).collect(Collectors.groupingBy(node -> node>0?1:0)));
        rateMaps.put("totalGuideRates", guideRateFragmentDtos.stream().mapToDouble(node -> Math.abs(node.getRate().doubleValue())).sum());
        rateMaps.put(String.format("maxRateWith%sdays", days), maxRate);
        rateMaps.put(String.format("minRateWith%sdays", days), minRate);
        //累计涨跌幅
        rateMaps.put(String.format("%sdays", days), findRateMaps(datas));
        rateMaps.put("dayLine", dayLine(datas));
        rateMaps.put("stockCode", stockCode);
        return rateMaps;
    }

    /**
     * 处理 guide level
     * @param rate
     * @param stockCode
     */
    void handleGuideLevel(double rate, String stockCode) {
        int level = (int)rate/10;
        switch (Math.abs(level)) {
            case 0:
            case 1: {
                if (level > 0) {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_UP_10, stockCode);
                } else {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_DOWN_10, stockCode);
                }
                break;
            }
            case 2:
            case 3: {
                if (level > 0) {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_UP_30, stockCode);
                } else {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_DOWN_30, stockCode);
                }
                break;
            }
            case 4:
            case 5: {
                if (level > 0) {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_UP_50, stockCode);
                } else {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_DOWN_50, stockCode);
                }
                break;
            }
            case 6:
            case 7: {
                if (level > 0) {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_UP_70, stockCode);
                } else {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_DOWN_70, stockCode);
                }
                break;
            }
            case 9:
            case 10:
            default: {
                if (level > 0) {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_UP_100, stockCode);
                } else {
                    redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_DOWN_100, stockCode);
                }
                break;
            }
        }
    }

    public void syncData() {
        Set<String> stocksSet  = redisTemplate.opsForSet().members(NetEaseApi.REDIS_STOCK_CODE_SET_ALL);
        stocksSet.forEach(
                stockCode -> {
                    try {
                        //daily data
                        ResponseEntity<HashMap> daily = this.fetchTodayData(StockComputeUtil.getRegion(stockCode), stockCode);
                        redisTemplate.opsForValue().set(getStockRedisDayKey(stockCode, "daily", CommonConstants.DataPattern.YYYYMMDD), daily.getBody(), Duration.ofDays(30));

//                        //four days data
//                        ResponseEntity<HashMap> fourDaysData = this.fetchFourDaysData(StockComputeUtil.getRegion(stockCode),stockCode);
//                        handleHistoryForDaysData(fourDaysData.getBody()).forEach(this::saveDailyDataToRedis);

                        // history year data
                        ResponseEntity<HashMap> historyData = this.fetchHistoryYearDaysData(StockComputeUtil.getRegion(stockCode), stockCode, LocalDateTime.now().format(DateTimeFormatter.ofPattern(CommonConstants.DataPattern.YYYY.getValue())));
                        saveHistoryYearData(historyData.getBody());
                    } catch (Exception e) {
                        log.error("exception type is: {}, stockCode is:{}", e.getClass(), stockCode);
                        redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_FETCH_ERROR, stockCode);

                    }
                }
        );
    }


    public void syncRealTimeData() {
        Set<String> stocksSet  = redisTemplate.opsForSet().members(NetEaseApi.REDIS_STOCK_CODE_SET_SELF_CHOOSE);
        stocksSet.forEach(
                stockCode -> {
                    executorService.submit(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //real time data
                                ResponseEntity<String > now = nowData(StockComputeUtil.getRegion(stockCode), stockCode);
                                redisTemplate.opsForSet().add(getStockRedisRealtimeKey(stockCode, "real-time", CommonConstants.DataPattern.YYYYMMDD), now.getBody());
                                if (log.isInfoEnabled()) {
                                    log.info("now result is :{}", now.getBody());
                                }
                            } catch (Exception e) {
                                log.error("exception type is: {}, stockCode is:{}", e.getClass(), stockCode);
                                redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_FETCH_ERROR, stockCode);
                            }
                        }
                    });
                }
        );
    }


    /**
     * 获取当日K线数据
     * @param region
     * @param stockCode
     * @return
     */
    public ResponseEntity<HashMap> fetchTodayData(String  region, String stockCode) {
        return RestTemplateUtils.get(getNetEaseUrl(DAILY_TIME_DATA, region, stockCode, null), HashMap.class);
    }

    /**
     *
     *
     * 获取4天分时数据
     * http://img1.money.126.net/data/hs/time/4days/[股票代码].json
     *
     * 返回结果：获取4天分时数据；和上述分时图相似，但数据是连续4天的数据，不包括当天的数据。
     *
     */
    public ResponseEntity<HashMap> fetchFourDaysData(String region, String stockCode) {
        return RestTemplateUtils.get(getNetEaseUrl(FOUR_DAILY_TIME_DATA, region, stockCode, null), HashMap.class);
    }

    /**
     * 获取日线数据
     * http://img1.money.126.net/data/[沪深拼音]/[是否复权]/day/history/[年份]/[股票代码].json
     * 返回结果：获取日线数据。
     * 其中，是否复权，不复权为kline，复权为klinederc。
     * 例如，http://img1.money.126.net/data/hs/kline/day/history/2015/1399001.json，获取深证成指2015年所有日线数据。
     */
    public ResponseEntity<HashMap> fetchHistoryYearDaysData(String region, String stockCode, String yearCode) {
        return RestTemplateUtils.get(getNetEaseUrl(HISTORY_DAILY_TIME_DATA, region, stockCode, yearCode), HashMap.class);
    }

    /**
     * 获取股票实时数据
     *
     * @param region
     * @param stockCode
     * @return
     */
    public ResponseEntity nowData(String region, String stockCode) {

        String url;
        switch (region) {
            case "sh" : {
                url = String.format(NetEaseApi.NOW_DATA, "sh", stockCode);
                break;
            }
            case "sz" : {
                url = String.format(NetEaseApi.NOW_DATA, "sz", stockCode);
                break;
            }
            default: {
                log.error("region: {} is not support!", region);
                return ResponseEntity.badRequest().build();
            }
        }
        if (log.isInfoEnabled()) {
            log.info("url is :{}", url);
        }
        return RestTemplateUtils.get(url, String.class);
    }




    /**
     * 获取实际数据调用地址
     * @param dataApi
     * @param region
     * @param stockCode
     * @return
     */
    public String getNetEaseUrl(String dataApi, String region, String stockCode, String dayCode) {

        String url;
        switch (region) {
            case "sh" : {
                url = getUrl(dataApi,"0", stockCode, dayCode);
                break;
            }
            case "sz" : {
                url = getUrl(dataApi,"1", stockCode, dayCode);
                break;
            }
            default: {
                url = null;
                log.error("region: {} is not support!", region);
            }
        }
        if (log.isInfoEnabled()) {
            log.info("stock url is :{}", url);
        }
        return url;
    }


    /**
     * 根据api格式组装访问地址
     * @param api
     * @param region
     * @param stockCode
     * @param yearCode
     * @return
     */
    public String getUrl(String api, String region, String stockCode, String yearCode) {
        switch (api) {
            case DAILY_TIME_DATA:
            case FOUR_DAILY_TIME_DATA: return String.format(api, region, stockCode);
            case HISTORY_DAILY_TIME_DATA: return String.format(api, yearCode, region, stockCode);
            default:{
                log.error("api is :{}, region is:{}, stockCode is :{}, yearCode is :{}", api, region, stockCode, yearCode);
                return null;
            }
        }
    }

    public void saveHistoryYearData(HashMap data) {
        /**
         *
         * {
         * symbol=002405,
         * data=[[20190102, 14.15, 14.16, 14.27, 13.96, 10865531, 0.35], [20190103, 14.11, 14.28, 14.54, 14.11, 17677480, 0.85], [20190104, 14.07, 14.84, 14.96, 14.03, 22966502, 3.92], [20190107, 14.9, 15.34, 15.49, 14.86, 29739198, 3.37], [20190108, 15.22, 15.1, 15.31, 15.07, 15531729, -1.56], [20190109, 15.19, 15.2, 15.45, 15.08, 22458853, 0.66], [20190110, 15.3, 15.04, 15.35, 15.01, 13606300, -1.05], [20190111, 15.21, 15.8, 15.9, 15.12, 40510121, 5.05], [20190114, 15.83, 15.65, 15.93, 15.55, 21808573, -0.95], [20190115, 15.66, 16.26, 16.47, 15.58, 36175811, 3.9], [20190116, 16.1, 16.09, 16.5, 15.97, 26907250, -1.05], [20190117, 16.01, 15.85, 16.33, 15.78, 19391110, -1.49], [20190118, 15.92, 15.85, 15.97, 15.49, 19001521, 0.0], [20190121, 15.85, 16.07, 16.24, 15.76, 16736491, 1.39], [20190122, 15.96, 15.69, 16.0, 15.52, 16057726, -2.36], [20190123, 15.61, 15.7, 15.75, 15.54, 8862015, 0.06], [20190124, 15.68, 15.86, 16.25, 15.58, 22270140, 1.02], [20190125, 15.85, 15.87, 16.11, 15.74, 15382833, 0.06], [20190128, 16.61, 16.49, 16.95, 16.33, 47220291, 3.91], [20190129, 16.48, 16.92, 16.98, 16.0, 43706196, 2.61], [20190130, 16.7, 16.65, 17.17, 16.6, 29926066, -1.6], [20190131, 16.76, 16.57, 17.03, 16.4, 24582143, -0.48], [20190201, 16.8, 17.49, 17.49, 16.7, 37601092, 5.55], [20190211, 17.6, 17.69, 17.83, 17.36, 27431702, 1.14], [20190212, 17.6, 17.83, 18.09, 17.53, 30141313, 0.79], [20190213, 18.41, 19.61, 19.61, 18.38, 42815163, 9.98], [20190214, 19.98, 19.35, 20.35, 19.16, 54037277, -1.33], [20190215, 19.35, 19.08, 19.52, 19.04, 35058231, -1.4], [20190218, 19.08, 20.32, 20.69, 19.08, 57555693, 6.5], [20190219, 20.2, 22.0, 22.05, 20.09, 83693930, 8.27], [20190220, 21.6, 21.36, 21.6, 20.98, 42834300, -2.91], [20190221, 21.35, 21.45, 22.0, 21.02, 45543852, 0.42], [20190222, 21.45, 22.35, 22.48, 21.15, 54152227, 4.2], [20190225, 22.64, 24.15, 24.59, 22.64, 78912473, 8.05], [20190226, 24.23, 23.73, 24.9, 23.06, 62497369, -1.74], [20190227, 23.3, 22.94, 23.93, 21.91, 56773287, -3.33], [20190228, 22.9, 23.22, 23.87, 22.23, 42903465, 1.22], [20190301, 23.22, 22.85, 23.39, 22.3, 37330383, -1.59], [20190304, 23.16, 22.88, 24.18, 22.7, 78751135, 0.13], [20190305, 22.5, 24.07, 24.1, 22.19, 83534296, 5.2], [20190306, 24.1, 23.73, 24.28, 23.12, 67275794, -1.41], [20190307, 23.5, 24.5, 25.76, 22.7, 100439526, 3.24], [20190308, 23.38, 23.58, 25.9, 23.08, 91484536, -3.76], [20190311, 24.0, 24.52, 25.22, 24.0, 65499704, 3.99], [20190312, 24.9, 25.2, 25.3, 24.25, 80175772, 2.77], [20190313, 25.53, 23.61, 25.68, 23.33, 67943959, -6.31], [20190314, 23.25, 22.11, 23.39, 21.72, 57044639, -6.35], [20190315, 22.38, 21.84, 22.59, 21.65, 42633896, -1.22], [20190318, 21.9, 22.41, 22.55, 21.54, 37536958, 2.61], [20190319, 22.41, 22.57, 23.14, 22.35, 36732761, 0.71], [20190320, 22.58, 22.69, 22.83, 21.91, 33464076, 0.53], [20190321, 22.79, 22.94, 23.2, 22.48, 43933522, 1.1], [20190322, 22.94, 22.55, 22.97, 22.06, 29922014, -1.7], [20190325, 22.0, 22.28, 22.8, 21.91, 30772954, -1.2], [20190326, 22.29, 21.0, 22.45, 20.86, 47070503, -5.75], [20190327, 21.29, 21.19, 21.42, 20.53, 26696566, 0.9], [20190328, 21.18, 21.36, 22.11, 20.9, 36834622, 0.8], [20190329, 21.43, 22.68, 22.69, 21.2, 53465278, 6.18], [20190401, 23.71, 24.18, 24.72, 23.6, 82516711, 6.61], [20190402, 24.2, 26.38, 26.6, 24.2, 129920278, 9.1], [20190403, 27.0, 26.3, 27.4, 25.76, 117531713, -0.3], [20190404, 26.5, 27.43, 28.73, 25.91, 100616065, 4.3], [20190408, 27.29, 25.61, 27.29, 25.5, 83632631, -6.64], [20190409, 24.99, 25.11, 25.61, 24.38, 52338996, -1.95], [20190410, 24.97, 26.37, 26.77, 24.66, 79510883, 5.02], [20190411, 27.01, 26.26, 27.27, 25.79, 65139986, -0.42], [20190412, 26.05, 25.29, 26.38, 24.8, 58158377, -3.69], [20190415, 25.81, 25.6, 27.06, 25.42, 65438524, 1.23], [20190416, 25.4, 27.44, 27.69, 24.53, 92410439, 7.19], [20190417, 26.98, 27.66, 30.18, 26.53, 133429428, 0.8], [20190418, 27.69, 26.4, 27.69, 26.26, 72354664, -4.56], [20190419, 26.6, 26.6, 26.85, 26.1, 37432111, 0.76], [20190422, 26.52, 25.59, 26.52, 25.38, 46434674, -3.8], [20190423, 25.65, 25.0, 25.84, 24.8, 36622660, -2.31], [20190424, 25.03, 26.2, 26.21, 24.72, 48055453, 4.8], [20190425, 25.84, 25.01, 26.37, 24.86, 40690446, -4.54], [20190426, 24.7, 24.93, 25.6, 24.61, 29143951, -0.32], [20190429, 25.27, 25.18, 25.84, 24.69, 46923308, 1.0], [20190430, 24.69, 23.49, 25.17, 22.68, 61651349, -6.71], [20190506, 21.9, 21.14, 22.64, 21.14, 50036793, -10.0], [20190507, 21.4, 21.14, 21.59, 20.46, 36118275, 0.0], [20190508, 20.55, 21.32, 21.84, 20.3, 33352947, 0.85], [20190509, 21.0, 20.89, 21.55, 20.8, 25897901, -2.02], [20190510, 21.28, 22.29, 22.46, 20.1, 52828038, 6.7], [20190513, 21.81, 21.48, 22.17, 21.28, 32926381, -3.63], [20190514, 21.16, 21.57, 21.8, 21.15, 12354279, 0.42], [20190515, 21.9, 21.87, 22.11, 21.75, 9753433, 1.11], [20190516, 22.44, 22.53, 23.07, 22.23, 36408022, -0.79], [20190517, 22.67, 21.34, 23.0, 21.25, 36431676, -5.28], [20190520, 21.5, 21.75, 21.97, 21.29, 22445957, 1.92], [20190521, 21.98, 22.37, 22.48, 21.47, 28212219, 2.85], [20190522, 22.3, 22.44, 22.75, 21.93, 30795552, 0.31], [20190523, 22.64, 22.51, 23.2, 22.1, 47461313, 0.31], [20190527, 21.77, 22.65, 22.85, 21.65, 34070819, 4.38], [20190529, 22.01, 22.0, 22.51, 21.89, 26844912, -1.21], [20190530, 22.1, 21.81, 22.2, 21.52, 23452863, -0.86], [20190531, 21.89, 21.69, 22.06, 21.64, 16457430, -0.55], [20190603, 21.94, 21.48, 21.99, 21.25, 19155563, -0.97], [20190604, 21.35, 21.5, 21.77, 21.31, 16083835, 0.09], [20190605, 21.73, 21.63, 21.88, 21.47, 16779903, 0.6], [20190606, 21.6, 21.77, 22.39, 21.55, 32593157, 0.65], [20190610, 22.05, 23.39, 23.47, 21.91, 55174861, 7.44], [20190611, 23.13, 23.91, 24.07, 22.89, 56945453, 2.22], [20190612, 23.7, 23.81, 24.37, 23.64, 38169286, -0.42], [20190613, 23.9, 24.59, 24.67, 23.68, 43014557, 3.28], [20190614, 24.37, 23.72, 24.5, 23.52, 39989615, -3.54], [20190617, 15.8, 15.64, 15.96, 15.28, 33095703, -1.01], [20190618, 15.83, 16.02, 16.38, 15.58, 53878615, 2.43], [20190619, 16.5, 16.05, 16.74, 16.02, 61491908, 0.19], [20190620, 15.91, 16.5, 16.79, 15.82, 75138486, 2.8], [20190621, 16.49, 16.5, 17.0, 16.41, 72062159, 0.0], [20190624, 16.57, 16.25, 16.62, 16.09, 42768489, -1.52], [20190625, 16.06, 15.97, 16.18, 15.63, 41875677, -1.72], [20190626, 15.81, 16.14, 16.51, 15.78, 37004795, 1.06], [20190627, 16.18, 16.49, 16.55, 15.95, 54004769, 2.17], [20190628, 16.36, 16.1, 16.36, 15.92, 33859323, -2.37], [20190701, 16.52, 17.2, 17.27, 16.32, 95648901, 6.83], [20190702, 17.0, 16.99, 17.28, 16.76, 60134748, -1.22], [20190703, 16.85, 16.58, 16.86, 16.43, 41489028, -2.41], [20190704, 16.67, 16.32, 16.78, 16.16, 34800058, -1.57], [20190705, 16.25, 16.35, 16.61, 16.18, 28914931, 0.18], [20190708, 16.36, 15.06, 16.37, 14.86, 77429429, -7.89], [20190709, 15.1, 15.13, 15.35, 14.9, 29866444, 0.46], [20190710, 15.14, 14.96, 15.2, 14.85, 21661654, -1.12], [20190711, 15.02, 14.0, 15.2, 13.51, 71285913, -6.42], [20190712, 14.03, 14.35, 14.57, 13.83, 40243968, 2.5], [20190715, 14.48, 14.72, 14.98, 14.04, 38930053, 2.58], [20190716, 14.74, 14.62, 14.85, 14.55, 23076465, -0.68], [20190717, 14.7, 14.58, 14.8, 14.45, 20194423, -0.27], [20190718, 14.42, 14.21, 14.51, 14.06, 20265439, -2.54], [20190719, 14.27, 14.41, 14.55, 14.27, 20528713, 1.41], [20190722, 14.39, 14.04, 14.4, 13.88, 21989501, -2.57], [20190723, 14.1, 14.48, 14.52, 14.1, 22216933, 3.13], [20190724, 14.48, 14.77, 14.92, 14.48, 33623819, 2.0], [20190725, 14.78, 14.88, 15.09, 14.64, 33614214, 0.74], [20190726, 14.96, 14.9, 15.01, 14.71, 22876614, 0.13], [20190729, 14.96, 14.8, 15.1, 14.65, 23112730, -0.67], [20190730, 14.84, 15.0, 15.15, 14.71, 28386893, 1.35], [20190731, 14.99, 15.01, 15.15, 14.85, 22723150, 0.07], [20190801, 14.75, 14.9, 15.04, 14.7, 17009455, -0.73], [20190802, 14.31, 14.51, 14.64, 14.21, 26187763, -2.62], [20190805, 14.55, 14.65, 15.22, 14.52, 38419640, 0.96], [20190806, 14.3, 14.23, 14.6, 13.78, 43290468, -2.87], [20190807, 14.33, 13.8, 14.4, 13.76, 30165384, -3.02], [20190808, 13.96, 13.88, 14.04, 13.7, 22479177, 0.58], [20190809, 14.02, 13.31, 14.04, 13.15, 47802348, -4.11], [20190812, 13.46, 13.99, 14.0, 13.23, 32511313, 5.11], [20190813, 13.81, 13.75, 13.95, 13.6, 19773605, -1.72], [20190814, 14.06, 14.01, 14.35, 13.94, 40474651, 1.89], [20190815, 13.69, 14.68, 14.78, 13.6, 55900190, 4.78], [20190816, 14.53, 14.64, 14.96, 14.48, 47425727, -0.27], [20190819, 14.83, 15.28, 15.3, 14.74, 57956117, 4.37], [20190820, 15.34, 15.17, 15.76, 15.1, 58526936, -0.72], [20190821, 15.21, 15.29, 15.5, 15.12, 41790264, 0.79], [20190822, 15.41, 15.38, 15.72, 15.23, 38618011, 0.59], [20190823, 15.59, 15.05, 15.59, 14.97, 50642145, -2.15], [20190826, 14.78, 14.88, 15.09, 14.67, 35918912, -1.13], [20190827, 15.0, 16.16, 16.37, 14.98, 162768966, 8.6], [20190828, 15.88, 16.26, 16.49, 15.7, 113177263, 0.62]],
         * name=四维图新}
         *
         */
        String stockCode = (String) data.get("symbol");
        List<ArrayList> datas = (List<ArrayList>)data.get("data");
        ListOperations<String , ArrayList> listOperations = redisTemplate.opsForList();
        String key = getStockRedisYearKey(stockCode,"history-year", CommonConstants.DataPattern.YYYY);
        Long oldSize = listOperations.size(key);
        int newSize = datas.size();
        if (oldSize.intValue() < datas.size()) {
            for (int in=oldSize.intValue(); in < newSize; in++ ) {
                listOperations.leftPush(key, datas.get(in));
            }
        } else if(oldSize == datas.size() && oldSize > 0){
            // 更新最新的数据
            listOperations.leftPop(key);
            listOperations.leftPush(key, datas.get(newSize-1));
        }
    }

    public ResponseEntity  saveYearDataToRedis(String stockCode) {
        // history year data
        ResponseEntity<HashMap> historyData = null;
        try {
            historyData = this.fetchHistoryYearDaysData(StockComputeUtil.getRegion(stockCode), stockCode, LocalDateTime.now().format(DateTimeFormatter.ofPattern(CommonConstants.DataPattern.YYYY.getValue())));
            saveHistoryYearData(historyData.getBody());
        } catch (HttpClientErrorException.NotFound e) {
            log.error("stockCode :{} is not right, please check!", stockCode);
            return ResponseEntity.ok("stockCode is not right, please check!");
        }
        return historyData;

    }


    public void saveDailyDataToRedis(HashMap data) {
        /**
         *   {
         *   date=20190828,
         *   symbol=002405,
         *   lastVolume=113177263,
         *   data=[[0930, 15.88, 15.88, 1020611], [0931, 16.0, 15.94, 8027042], [0932, 16.04, 15.973, 2461549], [0933, 16.02, 15.985, 2548300], [0934, 16.09, 16.006, 1646550], [0935, 16.16, 16.032, 1967700], [0936, 16.19, 16.054, 1819300], [0937, 16.15, 16.066, 1721200], [0938, 16.2, 16.081, 1398400], [0939, 16.16, 16.089, 1683400], [0940, 16.11, 16.091, 832500], [0941, 16.16, 16.097, 1209000], [0942, 16.16, 16.102, 956415], [0943, 16.31, 16.116, 1584250], [0944, 16.29, 16.128, 2300518], [0945, 16.23, 16.134, 1316400], [0946, 16.21, 16.139, 864750], [0947, 16.27, 16.146, 1183004], [0948, 16.26, 16.152, 1006863], [0949, 16.22, 16.155, 572900], [0950, 16.19, 16.157, 847850], [0951, 16.25, 16.161, 477850], [0952, 16.38, 16.171, 4346279], [0953, 16.36, 16.179, 1378000], [0954, 16.33, 16.185, 887600], [0955, 16.39, 16.193, 1859201], [0956, 16.35, 16.199, 1039713], [0957, 16.39, 16.205, 1134550], [0958, 16.37, 16.211, 1611500], [0959, 16.39, 16.217, 921550], [1000, 16.3, 16.22, 770950], [1001, 16.26, 16.221, 980300], [1002, 16.31, 16.224, 610316], [1003, 16.27, 16.225, 529050], [1004, 16.28, 16.227, 219700], [1005, 16.29, 16.228, 392700], [1006, 16.34, 16.231, 324550], [1007, 16.32, 16.234, 397100], [1008, 16.3, 16.235, 416500], [1009, 16.25, 16.236, 272450], [1010, 16.2, 16.235, 1054750], [1011, 16.19, 16.234, 921926], [1012, 16.22, 16.233, 390800], [1013, 16.23, 16.233, 372900], [1014, 16.24, 16.234, 259500], [1015, 16.35, 16.236, 728950], [1016, 16.32, 16.238, 209800], [1017, 16.3, 16.239, 188850], [1018, 16.3, 16.24, 167192], [1019, 16.36, 16.243, 600000], [1020, 16.33, 16.245, 282100], [1021, 16.34, 16.246, 257600], [1022, 16.35, 16.248, 353750], [1023, 16.41, 16.251, 1659940], [1024, 16.37, 16.253, 742400], [1025, 16.38, 16.256, 269750], [1026, 16.36, 16.258, 564750], [1027, 16.35, 16.259, 218538], [1028, 16.33, 16.26, 278962], [1029, 16.3, 16.261, 270300], [1030, 16.3, 16.262, 192650], [1031, 16.31, 16.262, 155800], [1032, 16.33, 16.263, 138250], [1033, 16.32, 16.264, 146900], [1034, 16.32, 16.265, 133350], [1035, 16.34, 16.266, 191950], [1036, 16.41, 16.269, 1607825], [1037, 16.41, 16.271, 700800], [1038, 16.39, 16.272, 146100], [1039, 16.39, 16.274, 324900], [1040, 16.45, 16.276, 902550], [1041, 16.45, 16.279, 1232150], [1042, 16.43, 16.281, 376978], [1043, 16.4, 16.283, 320222], [1044, 16.41, 16.284, 346850], [1045, 16.41, 16.286, 172350], [1046, 16.39, 16.287, 235928], [1047, 16.39, 16.289, 212650], [1048, 16.4, 16.29, 187300], [1049, 16.39, 16.291, 116900], [1050, 16.37, 16.292, 223622], [1051, 16.35, 16.293, 193600], [1052, 16.39, 16.294, 160228], [1053, 16.38, 16.295, 125372], [1054, 16.39, 16.296, 105450], [1055, 16.38, 16.297, 198850], [1056, 16.36, 16.298, 123700], [1057, 16.3, 16.298, 266100], [1058, 16.27, 16.298, 265400], [1059, 16.25, 16.297, 613400], [1100, 16.27, 16.297, 684050], [1101, 16.28, 16.297, 367850], [1102, 16.24, 16.296, 370700], [1103, 16.2, 16.295, 1276200], [1104, 16.25, 16.295, 171100], [1105, 16.22, 16.294, 220700], [1106, 16.27, 16.294, 212400], [1107, 16.22, 16.293, 128300], [1108, 16.22, 16.292, 237900], [1109, 16.26, 16.292, 116100], [1110, 16.22, 16.291, 110400], [1111, 16.23, 16.29, 251400], [1112, 16.27, 16.29, 149700], [1113, 16.28, 16.29, 49200], [1114, 16.28, 16.29, 64900], [1115, 16.26, 16.29, 101500], [1116, 16.27, 16.29, 65800], [1117, 16.27, 16.289, 124600], [1118, 16.29, 16.289, 57050], [1119, 16.3, 16.289, 172800], [1120, 16.31, 16.29, 127500], [1121, 16.26, 16.289, 136000], [1122, 16.26, 16.289, 73000], [1123, 16.28, 16.289, 77800], [1124, 16.28, 16.289, 81600], [1125, 16.3, 16.289, 121700], [1126, 16.27, 16.289, 107700], [1127, 16.22, 16.288, 279300], [1128, 16.25, 16.288, 132900], [1129, 16.21, 16.287, 328500], [1130, 16.21, 16.287, 3900], [1300, 16.22, 16.286, 205046], [1301, 16.2, 16.285, 171154], [1302, 16.11, 16.284, 992050], [1303, 16.1, 16.283, 211150], [1304, 16.1, 16.281, 321100], [1305, 16.11, 16.28, 411600], [1306, 16.1, 16.278, 209400], [1307, 16.09, 16.277, 310450], [1308, 16.06, 16.275, 288900], [1309, 15.99, 16.273, 1229700], [1310, 16.06, 16.271, 870816], [1311, 16.1, 16.27, 254800], [1312, 16.05, 16.269, 349400], [1313, 16.07, 16.267, 252200], [1314, 16.1, 16.266, 176950], [1315, 16.11, 16.265, 173400], [1316, 16.16, 16.264, 119300], [1317, 16.1, 16.263, 171400], [1318, 16.08, 16.261, 275900], [1319, 16.04, 16.26, 348700], [1320, 16.08, 16.259, 106600], [1321, 16.08, 16.257, 99800], [1322, 16.11, 16.256, 73600], [1323, 16.07, 16.255, 161950], [1324, 16.1, 16.254, 79950], [1325, 16.1, 16.253, 126000], [1326, 16.08, 16.252, 130400], [1327, 16.05, 16.25, 251150], [1328, 16.08, 16.249, 100300], [1329, 16.1, 16.248, 77400], [1330, 16.11, 16.247, 81300], [1331, 16.13, 16.247, 91650], [1332, 16.17, 16.246, 113900], [1333, 16.22, 16.246, 381396], [1334, 16.18, 16.246, 164204], [1335, 16.16, 16.245, 188500], [1336, 16.17, 16.244, 183800], [1337, 16.15, 16.244, 125700], [1338, 16.17, 16.243, 59250], [1339, 16.21, 16.243, 276000], [1340, 16.15, 16.243, 98150], [1341, 16.25, 16.243, 247400], [1342, 16.26, 16.243, 309000], [1343, 16.21, 16.243, 172800], [1344, 16.23, 16.243, 91500], [1345, 16.16, 16.242, 321000], [1346, 16.18, 16.242, 223900], [1347, 16.19, 16.241, 135900], [1348, 16.2, 16.241, 140050], [1349, 16.22, 16.241, 190450], [1350, 16.19, 16.241, 84800], [1351, 16.13, 16.24, 187900], [1352, 16.16, 16.24, 89650], [1353, 16.16, 16.239, 146800], [1354, 16.17, 16.239, 138200], [1355, 16.18, 16.238, 135300], [1356, 16.22, 16.238, 112350], [1357, 16.26, 16.238, 293250], [1358, 16.2, 16.238, 612000], [1359, 16.19, 16.238, 92800], [1400, 16.19, 16.238, 149150], [1401, 16.21, 16.238, 99750], [1402, 16.25, 16.238, 199400], [1403, 16.25, 16.238, 179350], [1404, 16.28, 16.238, 583900], [1405, 16.28, 16.238, 475750], [1406, 16.33, 16.239, 501999], [1407, 16.28, 16.239, 433695], [1408, 16.27, 16.239, 211056], [1409, 16.3, 16.239, 178900], [1410, 16.2, 16.239, 384000], [1411, 16.23, 16.239, 165600], [1412, 16.25, 16.239, 181650], [1413, 16.2, 16.239, 316300], [1414, 16.2, 16.239, 258600], [1415, 16.23, 16.239, 78000], [1416, 16.23, 16.239, 157100], [1417, 16.25, 16.239, 135200], [1418, 16.26, 16.239, 133500], [1419, 16.25, 16.239, 107000], [1420, 16.19, 16.239, 322600], [1421, 16.2, 16.238, 110200], [1422, 16.22, 16.238, 127450], [1423, 16.16, 16.238, 366550], [1424, 16.19, 16.238, 291200], [1425, 16.17, 16.237, 293100], [1426, 16.17, 16.237, 283427], [1427, 16.17, 16.237, 210875], [1428, 16.17, 16.236, 132700], [1429, 16.2, 16.236, 196200], [1430, 16.2, 16.236, 211450], [1431, 16.19, 16.236, 394400], [1432, 16.19, 16.236, 237700], [1433, 16.17, 16.235, 445127], [1434, 16.14, 16.235, 242073], [1435, 16.09, 16.234, 537254], [1436, 16.11, 16.234, 662722], [1437, 16.08, 16.233, 486024], [1438, 16.13, 16.233, 112650], [1439, 16.15, 16.232, 165326], [1440, 16.17, 16.232, 129750], [1441, 16.18, 16.232, 152600], [1442, 16.16, 16.231, 199400], [1443, 16.15, 16.231, 262925], [1444, 16.17, 16.231, 198250], [1445, 16.18, 16.23, 179150], [1446, 16.17, 16.23, 246500], [1447, 16.17, 16.23, 138850], [1448, 16.19, 16.23, 287700], [1449, 16.21, 16.23, 340750], [1450, 16.2, 16.23, 503950], [1451, 16.21, 16.229, 454850], [1452, 16.21, 16.229, 423850], [1453, 16.25, 16.229, 581850], [1454, 16.27, 16.23, 559750], [1455, 16.26, 16.23, 472500], [1456, 16.25, 16.23, 397950], [1457, 16.25, 16.23, 16700], [1458, 16.25, 16.23, 0], [1459, 16.25, 16.23, 0], [1500, 16.26, 16.23, 979800]],
         *   count=242,
         *   name=四维图新,
         *   yestclose=16.16}
         */
        String stockCode = (String) data.get("symbol");
        String dateCode = (String) data.get("date");
        redisTemplate.opsForValue().set(getStockRedisDayKey(stockCode, "daily", dateCode), data, Duration.ofDays(30));
    }
}



