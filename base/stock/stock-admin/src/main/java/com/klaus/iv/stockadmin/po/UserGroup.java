package com.klaus.iv.stockadmin.po;

import com.klaus.iv.commonjpa.po.BasePo;
import lombok.*;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class UserGroup extends BasePo {
    private Long userId;
    private Long groupId;
    private String addComments;
}
