package com.klaus.iv.userapi.vo;


import com.klaus.iv.commonbase.model.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("RoleVo")
public class RoleVo extends BaseVo {

    @ApiModelProperty(name = "name", value = "zhangsan", notes = "名称")
    private String name;
    @ApiModelProperty(name = "code", value = "zhangsan", notes = "编码")
    private String code;
}
