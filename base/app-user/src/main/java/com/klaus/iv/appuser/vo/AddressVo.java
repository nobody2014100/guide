package com.klaus.iv.appuser.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressVo {
    private AddressType type;
    private String detail;
    private String streetCode;
    private String districtCode;
    private String cityCode;
    private String provenceCode;
    private String countryCode;


    @Getter
    public static enum  AddressType {
        HOME(0), COMPANY(1);
        private AddressType(int value) {
            this.value = value;
        }
        private final int value;
    }
}
