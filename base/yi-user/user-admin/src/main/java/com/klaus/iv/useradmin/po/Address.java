package com.klaus.iv.useradmin.po;

import com.klaus.iv.commonjpa.po.BaseSnapshotPo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Address extends BaseSnapshotPo {

    //@Column(columnDefinition = "")
    private String detail;
    private String street;
    private String city;
    private String province;
    private String country;
    private String zipCode;
    private String mobile;
    private String fixTelephone;
    private AddressType type;

    @Getter
    public static enum AddressType {
        HOME(0),WORK(1),Templore(2);
        private int value;
        private AddressType(int value) {
            this.value = value;
        }
    }


}
