package com.klaus.iv.stockadmin.po;

import com.klaus.iv.commonjpa.po.BasePo;
import com.klaus.iv.stockapi.vo.StockVo;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class StockPo extends BasePo {
    private String name;
    private String code;
    private String stockDesc;

    public StockVo convertor() {
        StockVo stockVo = new StockVo();
        BeanUtils.copyProperties(stockVo,  this);
        return stockVo;
    }

}
