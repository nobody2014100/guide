package com.klaus.iv.commonjpa.handle;

import org.jooq.DSLContext;
import org.jooq.conf.RenderNameStyle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class JooQHandle {

    protected static final String ALIAS = "t";

    @Autowired
    protected DSLContext dsl;

    @PostConstruct
    private void init() {
        //		去掉sql中的单引号
        dsl.settings().withRenderNameStyle(RenderNameStyle.AS_IS);
    }
}
