package com.klaus.iv.useradmin.po;

import com.klaus.iv.commonjpa.po.BasePo;
import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Resource extends BasePo {

    private String name;
    private String code;

    @Getter
    public static enum RoleType {
        MOBILE(0),ACCOUNT(1),WECHAT(2), QQ(3),
        GITHUB(4), EMAIL(5),OSS(6), OTHER(7);
        private int value;
        private RoleType(int value) {
            this.value = value;
        }
    }

}
