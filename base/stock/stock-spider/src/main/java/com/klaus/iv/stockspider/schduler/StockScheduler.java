package com.klaus.iv.stockspider.schduler;


import com.klaus.iv.stockspider.facade.StockFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_ALL;
import static com.klaus.iv.stockspider.constants.NetEaseApi.REDIS_STOCK_CODE_SET_GUIDE_ERROR;


@Slf4j
@Component
public class StockScheduler {

    @Autowired
    private StockFacade stockFacade;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *      关于定时表达式说明
     *      秒 分 时 day month week
     *      *  *  *   *    *     *
     *      0 0 3 * * ? 每天3点执行 
     *      0 5 3 * * ? 每天3点5分执行 
     *      0 5 3 ? * * 每天3点5分执行，与上面作用相同
     *      0 5/10 3 * * ? 每天3点的 5分，15分，25分，35分，45分，55分这几个时间点执行 
     *      0 10 3 ? * 1 每周星期天，3点10分 执行，注：1表示星期天 
     *      0 10 3 ? * 1 #3 每个月的第三个星期，星期天 执行，#号只能出现在星期的位置 
     *
     *     周一到周五16：10 开始执行
     */
//    @Scheduled(cron = "0 30 11,15 ? * 1,2,3,4,5")
    public void syncStockDaysData(){
        Long startTime = System.currentTimeMillis();
        log.info("------------------syncStockDaysData started at:{}----------------------------", startTime);
        //log.info("{} {} {}", LocalDateTime.now().getDayOfWeek().getLong(DAY_OF_WEEK), LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getDayOfYear());
        stockFacade.syncData();
        log.info("------------------syncStockDaysData finished , total time use is:{}----------------------------", System.currentTimeMillis() - startTime);
    }

    // 同步自选股数据
    //@Scheduled(cron = "0/10 * 9,10,11,13,14,20 * * ?")
    public void syncStockRealtimeData(){
        Long startTime = System.currentTimeMillis();
        log.info("------------------syncStockRealtimeData started at:{}----------------------------", startTime);
        //log.info("{} {} {}", LocalDateTime.now().getDayOfWeek().getLong(DAY_OF_WEEK), LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getDayOfYear());
        stockFacade.syncRealTimeData();
        stockFacade.monitorRealtimeState();
        log.info("------------------syncStockRealtimeData finished , total time use is:{}----------------------------", System.currentTimeMillis() - startTime);
    }

    /**
     * 每天15.50开始统计guide数据
     */
//    @Scheduled(cron = "0 50 15 * * ?")
    public void computeGuide() {
        Long startTime = System.currentTimeMillis();
        Set<String> stocks = redisTemplate.opsForSet().members(REDIS_STOCK_CODE_SET_ALL);
        int days = LocalDateTime.now().getDayOfYear();
        log.info("days is :{}, and stocks is:{}", days, stocks);

        stocks.stream().forEach(stockCode -> {
            //log.info("stockCode is :{}", stockCode);
            try {
                stockFacade.guide(stockCode, days);
            } catch (Exception e) {
                log.error("stock is:{}, guide error :{}", stockCode, e);
                redisTemplate.opsForSet().add(REDIS_STOCK_CODE_SET_GUIDE_ERROR, stockCode);
            }
        });
        log.info("------------------computeGuide finished , total time use is:{}----------------------------", System.currentTimeMillis() - startTime);


    }



}
