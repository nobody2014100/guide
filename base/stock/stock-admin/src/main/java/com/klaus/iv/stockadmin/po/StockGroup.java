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
        @Index(name = "index_code", columnList = "stockCode,groupId", unique = true)
})
public class StockGroup extends BasePo {
    private String stockCode;
    private Long groupId;
    // snapshot info, 用于计算自选收益
    private Long price;
    private String addComments;

}
