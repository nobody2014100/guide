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
public class UserExt extends BasePo {

    private String username;
    private String openID;
    private String password;
    private String mobile;
    private String email;

}
