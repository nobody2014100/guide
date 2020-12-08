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
public class YiGroup extends BasePo {
    public static final String CODE_DEFAULT = "self_choose";

    private String name;
    private String code;
    private String groupDesc;
}
