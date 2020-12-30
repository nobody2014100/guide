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
        @Index(name = "index_name", columnList = "name", unique = true)
})
public class YiGroup extends BasePo {
    public static final String CODE_DEFAULT = "self_choose";
    private String name;
    private String groupDesc;
}
