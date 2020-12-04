package com.klaus.iv.stockapi.dto;

import com.klaus.iv.stockapi.vo.GroupVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "分组实体DTO")
public class GroupDto extends GroupVo {

    @ApiModelProperty(name = "id", dataType = "Long", value = "1")
    private Long id;

}
