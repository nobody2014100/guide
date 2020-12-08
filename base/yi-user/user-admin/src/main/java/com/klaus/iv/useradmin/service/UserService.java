package com.klaus.iv.useradmin.service;

import com.klaus.iv.commonjpa.service.BaseService;
import com.klaus.iv.useradmin.po.User;
import com.klaus.iv.userapi.dto.UserDto;
import com.klaus.iv.userapi.vo.RoleVo;
import com.klaus.iv.userapi.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    public void save(UserDto userDto) ;
    public UserVo findById(Long id);
    public void deleteById(Long id);
    public Page<User> findAll(Pageable pageable);
    List<RoleVo> findRolesByUserId(Long userId);
}
