package com.klaus.iv.stockapi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "股票实体")
public class StockVo {
    @ApiModelProperty(name = "id", dataType = "long", value = "1")
    private Long id;
    @ApiModelProperty(name = "name", dataType = "string", value = "中金股份")
    private String name;
    @ApiModelProperty(name = "code", dataType = "string", value = "600787")
    private String code;
    @ApiModelProperty(name = "stockDesc", dataType = "string", value = "中金公司, A股市场第一的券商")
    private String stockDesc;

}
