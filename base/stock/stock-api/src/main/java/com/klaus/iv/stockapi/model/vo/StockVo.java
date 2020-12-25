package com.klaus.iv.stockapi.model.vo;


import com.klaus.iv.commonbase.model.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class StockVo extends BaseVo {
    @ApiModelProperty(name = "code", example = "123456")
    private String code;
    @ApiModelProperty(name = "name", example = "ZSYH")
    private String name;
    @ApiModelProperty(name = "industry", example = "IT")
    private String industry;
    @ApiModelProperty(name = "tags", example = "云计算|大数据|新能源汽车")
    private String tags;
}