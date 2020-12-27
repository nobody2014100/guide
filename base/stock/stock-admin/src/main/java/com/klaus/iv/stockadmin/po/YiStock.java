package com.klaus.iv.stockadmin.po;

import com.klaus.iv.commonjpa.po.BasePo;
import lombok.*;

import javax.persistence.Column;
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
        @Index(name = "index_name", columnList = "name", unique = true),
        @Index(name = "index_code", columnList = "code", unique = true)
})
public class YiStock extends BasePo {

    private String name;
    private String code;
    private String stockDesc;
    private int status;
}
