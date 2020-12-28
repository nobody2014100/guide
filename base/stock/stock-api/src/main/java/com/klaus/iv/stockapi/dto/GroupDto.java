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
@ApiModel(value = "分组实体DTO")
public class GroupDto extends BaseDto {

    @ApiModelProperty(name = "id", dataType = "Long", value = "1")
    private Long id;
    @ApiModelProperty(name = "name", dataType = "String", value = "中金股份")
    private String name;
    @ApiModelProperty(name = "code", dataType = "String", value = "600787")
    private String code;
    @ApiModelProperty(name = "groupDesc", dataType = "String", value = "麒麟才子，刘毅大神的分组")
    private String groupDesc;

}
