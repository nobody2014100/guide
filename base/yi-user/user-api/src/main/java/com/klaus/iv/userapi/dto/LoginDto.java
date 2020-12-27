package com.klaus.iv.userapi.dto;


import com.klaus.iv.commonbase.model.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "LoginDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonFormat()
public class LoginDto extends BaseDto {

    @ApiModelProperty(value = "loginType")
    private String loginType;
    @ApiModelProperty(value = "username")
    private String username;
    @ApiModelProperty(value = "password")
    private String password;
    @ApiModelProperty(value = "mobile")
    private String mobile;
    @ApiModelProperty(value = "openID")
    private String openID;
    @ApiModelProperty(value = "email")
    private String email;

}
