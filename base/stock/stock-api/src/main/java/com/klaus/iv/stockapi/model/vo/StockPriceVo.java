package com.klaus.iv.stockapi.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class StockPriceVo {


    @ApiModelProperty(example = "123456")
    private String code;
    @ApiModelProperty(example = "0", notes = "发行价")
    private Long initPrice = new Long(0);
    @ApiModelProperty(example = "0", notes = "交易价")
    private Long buyPrice = new Long(0);
    @ApiModelProperty(example = "0", notes = "最新价，每十分钟更新一次")
    private Long currentPrice = new Long(0);
}
