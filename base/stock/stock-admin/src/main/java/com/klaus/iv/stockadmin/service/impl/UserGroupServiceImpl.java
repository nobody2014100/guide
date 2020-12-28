package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import com.klaus.iv.commonjpa.service.impl.BaseServiceImpl;
import com.klaus.iv.stockadmin.converter.UserGroupDtoConverter;
import com.klaus.iv.stockadmin.converter.UserGroupVoConverter;
import com.klaus.iv.stockadmin.po.UserGroup;
import com.klaus.iv.stockadmin.repo.UserGroupRepo;
import com.klaus.iv.stockadmin.service.UserGroupService;
import com.klaus.iv.stockapi.dto.UserGroupDto;
import com.klaus.iv.stockapi.vo.UserGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserGroupServiceImpl extends BaseServiceImpl<UserGroup, Long> implements UserGroupService {

    @Autowired
    private UserGroupRepo userGroupRepo;

    public UserGroupServiceImpl(DSLContext dsl, UserGroupRepo userGroupRepo) {
        super(dsl, userGroupRepo);
    }

    @Override
    protected UserGroupVo converterToVo(UserGroup userGroup) {
        return new UserGroupVoConverter().converterFromEntity(userGroup);
    }

    @Override
    protected  <D extends BaseDto> UserGroup converterToEntity(D dto) {
        UserGroupDto userGroupDto = (UserGroupDto)dto;
        return new UserGroupDtoConverter().converterFromDto((UserGroupDto) dto);
    }

}
