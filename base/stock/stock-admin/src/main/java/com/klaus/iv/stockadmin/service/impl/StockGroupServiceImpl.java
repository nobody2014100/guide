package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import com.klaus.iv.commonbase.model.vo.BaseVo;
import com.klaus.iv.commonjpa.service.impl.BaseServiceImpl;
import com.klaus.iv.stockadmin.po.StockGroup;
import com.klaus.iv.stockadmin.repo.StockGroupRepo;
import com.klaus.iv.stockadmin.service.StockGroupService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockGroupServiceImpl extends BaseServiceImpl<StockGroup, Long> implements StockGroupService {

    @Autowired
    private StockGroupRepo stockGroupRepo;

    public StockGroupServiceImpl(DSLContext dsl, StockGroupRepo stockGroupRepo) {
        super(dsl, stockGroupRepo);
    }

    @Override
    protected <V extends BaseVo> V converterToVo(StockGroup stockGroup) {
        return null;
    }

    @Override
    protected <D extends BaseDto> StockGroup converterToEntity(D dto) {
        return null;
    }

}
