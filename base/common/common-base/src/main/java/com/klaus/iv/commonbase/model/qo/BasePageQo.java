package com.klaus.iv.commonbase.model.qo;

import lombok.Data;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

@Data
public class BasePageQo extends BaseQo {

    private Pageable pageable;

}
