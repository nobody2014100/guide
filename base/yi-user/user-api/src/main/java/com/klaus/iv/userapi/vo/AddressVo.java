package com.klaus.iv.userapi.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
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
@ApiModel("AddressVo")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressVo extends BaseVo {
    @ApiModelProperty(name = "detail", value = "湖南省永州市xxx县xxx镇xxx村xxx号", notes = "名称")
    private String detail;
    private String street;
    private String city;
    private String province;
    private String country;
    private String zipCode;
    private String mobile;
    private String fixTelephone;
    private int addressType;

}
