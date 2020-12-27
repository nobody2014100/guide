package com.klaus.iv.commonweb.qo;

import com.klaus.iv.commonbase.model.qo.BaseQo;
import lombok.Data;
import org.springframework.data.domain.PageRequest;

@Data
public class BasePageQo extends BaseQo {
    protected PageRequest pageRequest;
}
