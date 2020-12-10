package com.klaus.iv.useradmin.service.impl;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import com.klaus.iv.commonjpa.service.impl.BaseServiceImpl;
import com.klaus.iv.useradmin.converter.RoleDtoConverter;
import com.klaus.iv.useradmin.converter.RoleVoConverter;
import com.klaus.iv.useradmin.po.Role;
import com.klaus.iv.useradmin.repo.RoleRepo;
import com.klaus.iv.useradmin.service.RoleService;
import com.klaus.iv.userapi.dto.RoleDto;
import com.klaus.iv.userapi.vo.RoleVo;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService{

    public RoleServiceImpl(DSLContext dsl, RoleRepo roleRepo) {
        super(dsl, roleRepo);
    }

    @Override
    public RoleVo converterToVo(Role role) {
        return new RoleVoConverter().converterFromEntity(role);
    }

    @Override
    public <D extends BaseDto> Role converterToEntity(D dto) {
        return new RoleDtoConverter().converterFromDto((RoleDto) dto);
    }
}
