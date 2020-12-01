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
public class User extends BasePo {

    private String username;
    private String openID;
    private String password;
    private String mobile;
    private String email;
    private UserType userType;

    @Getter
    public static enum UserType {
        MOBILE(0),ACCOUNT(1),WECHAT(2), QQ(3),
        GITHUB(4), EMAIL(5),OSS(6), OTHER(7);
        private int value;
        private UserType(int value) {
            this.value = value;
        }
    }

}
