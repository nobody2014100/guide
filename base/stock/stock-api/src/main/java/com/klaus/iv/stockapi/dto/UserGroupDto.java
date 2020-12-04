package com.klaus.iv.stockapi.dto;

import com.klaus.iv.stockapi.vo.UserGroupVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户分组DTO")
public class UserGroupDto extends UserGroupVo {
    @ApiModelProperty(name = "id", dataType = "Long", value = "1")
    private Long id;
}
