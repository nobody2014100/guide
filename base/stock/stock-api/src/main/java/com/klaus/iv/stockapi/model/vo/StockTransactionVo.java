package com.klaus.iv.stockapi.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class StockTransactionVo {

    @ApiModelProperty(example = "123456")
    private String stockCode;
    @ApiModelProperty(example = "klaus")
    private String username;
    @ApiModelProperty(example = "5.5")
    private Long transFee;
    @ApiModelProperty(example = "15")
    private Long transPrice;
    @ApiModelProperty(example = "100")
    private Integer transCount;
    @ApiModelProperty(example = "B", notes = "交易类型, B:买入, S:卖出")
    private String transType;
}
