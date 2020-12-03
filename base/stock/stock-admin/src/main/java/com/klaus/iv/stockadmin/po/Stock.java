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
public class Stock extends BasePo {
    private String name;
    private String code;
    private String stockDesc;
}
