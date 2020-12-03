package com.klaus.iv.stockadmin.po;

import com.klaus.iv.commonjpa.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group extends BasePo {
    private String name;
    private String code;
    private String groupDesc;
}
