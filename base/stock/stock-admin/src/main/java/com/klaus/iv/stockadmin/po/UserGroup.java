package com.klaus.iv.stockadmin.po;

import com.klaus.iv.commonjpa.po.BasePo;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity

@Table(indexes = {
        @Index(name = "index_code", columnList = "userId,groupId", unique = true)
})
public class UserGroup extends BasePo {
    private Long userId;
    private Long groupId;
    private String addComments;
}
