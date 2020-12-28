package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import com.klaus.iv.commonbase.model.vo.BaseVo;
import com.klaus.iv.commonjpa.service.impl.BaseServiceImpl;
import com.klaus.iv.stockadmin.po.YiGroup;
import com.klaus.iv.stockadmin.repo.GroupRepo;
import com.klaus.iv.stockadmin.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GroupServiceImpl extends BaseServiceImpl<YiGroup, Long> implements GroupService {

    @Autowired
    private GroupRepo groupRepo;

    public GroupServiceImpl(DSLContext dsl, GroupRepo groupRepo) {
        super(dsl, groupRepo);
    }

    @Override
    protected <V extends BaseVo> V converterToVo(YiGroup yiGroup) {
        return null;
    }

    @Override
    protected <D extends BaseDto> YiGroup converterToEntity(D dto) {
        return null;
    }
}
