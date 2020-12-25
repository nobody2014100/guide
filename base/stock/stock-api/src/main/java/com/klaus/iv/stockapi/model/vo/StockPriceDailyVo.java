package com.klaus.iv.stockapi.model.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class StockPriceDailyVo {

    private Long day;
    private String code;
    private Long topPrice;
    private Long bottomPrice;
    private Long startPrice;
    private Long endPrice;
}
