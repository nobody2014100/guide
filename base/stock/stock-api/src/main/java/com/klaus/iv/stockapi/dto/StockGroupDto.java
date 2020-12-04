package com.klaus.iv.stockapi.dto;

import com.klaus.iv.stockapi.vo.StockGroupVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "股票分组实体DTO")
public class StockGroupDto extends StockGroupVo {
    @ApiModelProperty(name = "id", dataType = "Long", value = "1")
    private Long id;
}
