package com.klaus.iv.stockapi.qo;

import com.klaus.iv.commonbase.model.qo.BaseQo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockQo extends BaseQo {

    @ApiModelProperty(name = "name", dataType = "String", value = "中金股份")
    private String name;

    @ApiModelProperty(name = "code", dataType = "String", value = "600787")
    private String code;
}
