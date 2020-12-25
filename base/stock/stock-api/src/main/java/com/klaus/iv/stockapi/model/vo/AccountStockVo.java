package com.klaus.iv.stockapi.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountStockVo {

    @ApiModelProperty(example = "klaus", notes = "user's name")
    private String username;
    @ApiModelProperty(example = "10000", notes = "stock's amount")
    private Integer stockAmount;
    @ApiModelProperty(example = "123456", notes = "stock's code")
    private String stockCode;
    @ApiModelProperty(example = "15000.90", notes = "stock's cost value")
    private Integer costValue;
    @ApiModelProperty(example = "16000.45", notes = "stock's market value")
    private Long marketValue;

}
