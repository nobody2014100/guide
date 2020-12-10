package com.klaus.iv.commonjpa.config;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.conf.RenderNameStyle;

@Slf4j
//@Component
public class JooQHandle {

    protected static final String ALIAS = "t";

//    @Autowired
    protected DSLContext dsl;

//    @PostConstruct
    private void init() {
        log.info("------------------ invoke JooQHandle .............");
        //		去掉sql中的单引号
        dsl.settings().withRenderNameStyle(RenderNameStyle.AS_IS);
//        dsl.settings().setRenderNameStyle(RenderNameStyle.AS_IS);
    }
}
