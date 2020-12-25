package com.klaus.iv.stockspider.constants;

import lombok.Getter;

public class NetEaseApi {

    private NetEaseApi() {

    }


    /**
     * http://img1.money.126.net/data/[沪深拼音]/time/today/[区域][股票代码].json
     * 深证成指当日分时图数据
     * 沪深拼音: hs
     * 区域: [sh:0, sz:1]
     * 股票代码: 399001
     * 分时图获取数据依次是count节点数量、symbol股票代码、name股票名称、data数据，其中数据依次是小时分钟时间、价格、均价、成交量。
    */
    public static final String DAILY_TIME_DATA = "http://img1.money.126.net/data/hs/time/today/%s%s.json";


    /**
     * 获取4天分时数据
     * http://img1.money.126.net/data/hs/time/4days/[股票代码].json
     *
     * 返回结果：获取4天分时数据；和上述分时图相似，但数据是连续4天的数据，不包括当天的数据。
     *
     */
    public static final String FOUR_DAILY_TIME_DATA = "http://img1.money.126.net/data/hs/time/4days/%s%s.json";


    /**
     * 获取日线数据
     * http://img1.money.126.net/data/[沪深拼音]/[是否复权]/day/history/[年份]/[股票代码].json
     *
     * 返回结果：获取日线数据。
     *
     * 其中，是否复权，不复权为kline，复权为klinederc。
     *
     * 例如，http://img1.money.126.net/data/hs/kline/day/history/2015/1399001.json，获取深证成指2015年所有日线数据。
     */
    public static final String HISTORY_DAILY_TIME_DATA = "http://img1.money.126.net/data/hs/kline/day/history/%s/%s%s.json";


    /**
     * http://hq.sinajs.cn/list=sh601006
     *
     * 返回结果：JSON实时数据，以逗号隔开相关数据，数据依次是“股票名称、今日开盘价、昨日收盘价、当前价格、今日最高价、今日最低价、竞买价、竞卖价、成交股数、成交金额、买1手、买1报价、买2手、买2报价、…、买5报价、…、卖5报价、日期、时间”。
     */
    public static final String NOW_DATA = "http://hq.sinajs.cn/list=%s%s";


    public static String REDIS_STOCK_CODE_SET_ALL = "redis:stock:code:set";
    public static String REDIS_STOCK_CODE_SET_SELF_CHOOSE = "redis:stock:code:set:self:choose";
    public static String REDIS_STOCK_PREFIX = "fun-nearby:stock";
    public static String REDIS_STOCK_CODE_SET_FETCH_ERROR = "redis:stock:code:error";
    public static String REDIS_STOCK_CODE_SET_GUIDE_ERROR = "redis:stock:guide:error";
    public static String REDIS_STOCK_CODE_SET_GUIDE_UP_100 = "redis:stock:code:set:up:100";
    public static String REDIS_STOCK_CODE_SET_GUIDE_UP_70 = "redis:stock:code:set:up:70";
    public static String REDIS_STOCK_CODE_SET_GUIDE_UP_50 = "redis:stock:code:set:up:50";
    public static String REDIS_STOCK_CODE_SET_GUIDE_UP_30 = "redis:stock:code:set:up:30";
    public static String REDIS_STOCK_CODE_SET_GUIDE_UP_10 = "redis:stock:code:set:up:10";
    public static String REDIS_STOCK_CODE_SET_GUIDE_DOWN_100 = "redis:stock:code:set:down:100";
    public static String REDIS_STOCK_CODE_SET_GUIDE_DOWN_70 = "redis:stock:code:set:down:70";
    public static String REDIS_STOCK_CODE_SET_GUIDE_DOWN_50 = "redis:stock:code:set:down:50";
    public static String REDIS_STOCK_CODE_SET_GUIDE_DOWN_30 = "redis:stock:code:set:down:30";
    public static String REDIS_STOCK_CODE_SET_GUIDE_DOWN_10 = "redis:stock:code:set:down:10";

    public static String REDIS_STOCK_CODE_SET_GUIDE_7_MONTH = "redis:stock:code:choose:buzhang:30";//高于10%低于30%，有望补涨的股票
    public static String EASTMONEY_STOCKS_URL = "http://6.push2.eastmoney.com/api/qt/clist/get?pz=20&np=3&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:0+t:6,m:0+t:13,m:0+t:80,m:1+t:2,m:1+t:23&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1591270754415";



    @Getter
    public enum Region {
        SH("sh"), SZ("sz");
        private String value;
        private Region(String value) {
            this.value = value;
        }
    }


}
