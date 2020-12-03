package com.klaus.iv.stockadmin.po;

import com.klaus.iv.commonjpa.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockGroup extends BasePo {
    private String stockCode;
    private String groupCode;
    // snapshot info
    private Long price;
    private String comments;

}
