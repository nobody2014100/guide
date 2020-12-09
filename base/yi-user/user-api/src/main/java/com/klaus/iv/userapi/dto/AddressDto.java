package com.klaus.iv.userapi.dto;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressDto extends BaseDto {

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
