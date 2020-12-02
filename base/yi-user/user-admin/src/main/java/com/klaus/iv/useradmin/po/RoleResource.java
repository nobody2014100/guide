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
public class RoleResource extends BasePo {

    private Long roleId;
    private Long resourceId;

}
