package com.klaus.iv.stockapi.dto;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "股票实体DTO")
public class StockDto extends BaseDto {

    @ApiModelProperty(name = "id", dataType = "Long", value = "1")
    private Long id;

    @ApiModelProperty(name = "name", dataType = "String", value = "中金股份")
    private String name;

    @ApiModelProperty(name = "code", dataType = "String", value = "600787")
    private String code;

    @ApiModelProperty(name = "stockDesc", dataType = "String", value = "中金公司, A股市场第一的券商")
    private String stockDesc;

}
