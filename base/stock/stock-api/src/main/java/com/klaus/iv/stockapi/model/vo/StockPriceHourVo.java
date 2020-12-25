package com.klaus.iv.stockapi.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ApiModel
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class StockPriceHourVo {
    @ApiModelProperty(example = "20190821", notes = "format:yyyymmdd")
    private Long day;
    @ApiModelProperty(example = "081059", notes = "format:hhmmss")
    private Integer hour;
    @ApiModelProperty(example = "123456", notes = "stock code")
    private String code;
    @ApiModelProperty(example = "4323642312361", notes = "timestamp")
    private Long timePoint;
    @ApiModelProperty(example = "10.00", notes = "stock's price")
    private Long curPrice;



}
