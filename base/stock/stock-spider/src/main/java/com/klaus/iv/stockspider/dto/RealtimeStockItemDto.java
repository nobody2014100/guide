package com.klaus.iv.stockspider.dto;

import com.klaus.iv.stockspider.utils.StockComputeUtil;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * 股票名称、今日开盘价、昨日收盘价、当前价格、今日最高价、今日最低价、竞买价、竞卖价、成交股数、成交金额、买1手、买1报价、买2手、买2报价、…、买5报价、…、卖5报价、日期、时间
 * var hq_str_sh688366="昊海生科,138.450,138.800,128.000,138.800,125.880,128.000,128.290,1670774,218196351.000,57481,128.000,200,127.970,1600,127.940,3000,127.890,600,127.880,290,128.290,600,128.990,1481,129.000,1450,129.330,79,129.400,2020-07-15,15:29:59,00,D|0|0.00";
 */
@Data
@ToString
@Slf4j
public class RealtimeStockItemDto {

    public static RealtimeStockItemDto patseRealtimeStockItemDto(String item) {
        log.info("--------------------item is :{}",item);
        String data = item.substring(item.indexOf("\"")+1, item.lastIndexOf("\""));
        String[] values = data.split(",");
        //Arrays.stream(values).forEach(i -> log.info("item is :{}", i));
        RealtimeStockItemDto stockItemDto = new RealtimeStockItemDto();
        stockItemDto.setStockName(values[0]);
        stockItemDto.setStartPrice(values[1]);
        stockItemDto.setLastEndPrice(values[2]);
        stockItemDto.setPrice(values[3]);
        stockItemDto.setHighestPrice(values[4]);
        stockItemDto.setLowestPrice(values[5]);
        stockItemDto.setBuyPrice(values[6]);
        stockItemDto.setSellPrice(values[7]);
        stockItemDto.setDealCountTotal(values[8]);
        stockItemDto.setDealPriceTotal(values[9]);
        stockItemDto.setBuyOneCount(values[10]);
        stockItemDto.setBuyOnePrice(values[11]);
        stockItemDto.setBuyTwoCount(values[12]);
        stockItemDto.setBuyTwoPrice(values[13]);
        stockItemDto.setBuyThreeCount(values[14]);
        stockItemDto.setBuyThreePrice(values[15]);
        stockItemDto.setBuyFourCount(values[16]);
        stockItemDto.setBuyFourPrice(values[17]);
        stockItemDto.setBuyFiveCount(values[18]);
        stockItemDto.setBuyFivePrice(values[19]);
        stockItemDto.setSellOneCount(values[20]);
        stockItemDto.setSellOnePrice(values[21]);
        stockItemDto.setSellTwoCount(values[22]);
        stockItemDto.setSellTwoPrice(values[23]);
        stockItemDto.setSellThreeCount(values[24]);
        stockItemDto.setSellThreePrice(values[25]);
        stockItemDto.setSellFourCount(values[26]);
        stockItemDto.setSellFourPrice(values[27]);
        stockItemDto.setSellFiveCount(values[28]);
        stockItemDto.setSellFivePrice(values[29]);
        stockItemDto.setTime(StockComputeUtil.stringToDate(values[30]+" "+values[31]));
        //log.info("stockItemDto is :{}", stockItemDto);
        return stockItemDto;
    }
    private String stockName;
    private String startPrice;
    private String lastEndPrice;
    private String price;
    private String highestPrice;
    private String lowestPrice;
    private String buyPrice;
    private String sellPrice;
    private String dealCountTotal;
    private String dealPriceTotal;
    private String buyOneCount;
    private String buyOnePrice;
    private String buyTwoCount;
    private String buyTwoPrice;
    private String buyThreeCount;
    private String buyThreePrice;
    private String buyFourCount;
    private String buyFourPrice;
    private String buyFiveCount;
    private String buyFivePrice;
    private String sellOneCount;
    private String sellOnePrice;
    private String sellTwoCount;
    private String sellTwoPrice;
    private String sellThreeCount;
    private String sellThreePrice;
    private String sellFourCount;
    private String sellFourPrice;
    private String sellFiveCount;
    private String sellFivePrice;
    private LocalDateTime time;



    public static void main(String[] args) {
        patseRealtimeStockItemDto("var hq_str_sh688366=\"昊海生科,138.450,138.800,128.000,138.800,125.880,128.000,128.290,1670774,218196351.000,57481,128.000,200,127.970,1600,127.940,3000,127.890,600,127.880,290,128.290,600,128.990,1481,129.000,1450,129.330,79,129.400,2020-07-15,15:29:59,00,D|0|0.00\";");
    }


}
