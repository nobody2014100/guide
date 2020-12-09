package com.klaus.iv.useradmin.service;

import com.klaus.iv.commonjpa.service.BaseService;
import com.klaus.iv.useradmin.po.User;
import com.klaus.iv.userapi.dto.UserRolesDto;
import com.klaus.iv.userapi.vo.RoleVo;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    List<RoleVo> findRolesByUserId(Long userId);


    boolean addRoleToUser(UserRolesDto userRolesDto);
}
