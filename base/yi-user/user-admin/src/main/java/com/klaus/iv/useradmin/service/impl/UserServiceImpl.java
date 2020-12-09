package com.klaus.iv.useradmin.service.impl;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import com.klaus.iv.commonjpa.service.impl.BaseServiceImpl;
import com.klaus.iv.useradmin.converter.UserDtoConverter;
import com.klaus.iv.useradmin.converter.UserRoleDtoConverter;
import com.klaus.iv.useradmin.converter.UserVoConverter;
import com.klaus.iv.useradmin.db.tables.Address;
import com.klaus.iv.useradmin.db.tables.Role;
import com.klaus.iv.useradmin.db.tables.UserRole;
import com.klaus.iv.useradmin.po.User;
import com.klaus.iv.useradmin.repo.UserRepo;
import com.klaus.iv.useradmin.repo.UserRoleRepo;
import com.klaus.iv.useradmin.service.UserService;
import com.klaus.iv.userapi.dto.UserDto;
import com.klaus.iv.userapi.dto.UserRoleDto;
import com.klaus.iv.userapi.dto.UserRolesDto;
import com.klaus.iv.userapi.vo.RoleVo;
import com.klaus.iv.userapi.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{
    public static final com.klaus.iv.useradmin.db.tables.Address ADDRESS = Address.ADDRESS;
    public static final com.klaus.iv.useradmin.db.tables.User USER = com.klaus.iv.useradmin.db.tables.User.USER;
    public static final com.klaus.iv.useradmin.db.tables.Role ROLE = Role.ROLE;
    public static final com.klaus.iv.useradmin.db.tables.UserRole USER_ROLE = UserRole.USER_ROLE;

    public UserServiceImpl(DSLContext dsl, UserRepo userRepo) {
        super(dsl, userRepo);
    }
    @Autowired
    private UserRoleRepo userRoleRepo;



    @Override
    public List<RoleVo> findRolesByUserId(Long userId) {
        return this.dsl.select(ROLE.NAME, ROLE.CODE)
                .from(USER).join(USER_ROLE).on(USER.ID.equal(USER_ROLE.USER_ID))
                .join(ROLE).on(ROLE.ID.eq(USER_ROLE.ROLE_ID))
                .where(USER.ID.equal(userId))
                .fetch()
                .map(record -> record.into(RoleVo.class));
    }

    @Override
    public boolean addRoleToUser(UserRolesDto userRolesDto) {
        log.info("userRolesDto is :{}", userRolesDto);
        List<UserRoleDto> userRoleDtos = userRolesDto.getRoleIds().stream().map(i -> new UserRoleDto(userRolesDto.getUserId(),i))
                .collect(Collectors.toList());
        log.info("userRoleDtos is :{}", userRoleDtos);
        userRoleRepo.saveAll(new UserRoleDtoConverter().batchConverterFromDto(userRoleDtos));
        return true;
    }

    @Override
    public UserVo converterToVo(User user) {
        return new UserVoConverter().converterFromEntity(user);
    }

    @Override
    public <D extends BaseDto> User converterToEntity(D dto) {
        return new UserDtoConverter().converterFromDto((UserDto) dto);
    }
}
