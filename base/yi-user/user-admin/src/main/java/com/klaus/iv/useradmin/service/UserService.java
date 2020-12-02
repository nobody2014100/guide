package com.klaus.iv.useradmin.service;

import com.klaus.iv.useradmin.po.User;
import com.klaus.iv.userapi.dto.UserDto;
import com.klaus.iv.userapi.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    public void save(UserDto userDto) ;
    public UserVo findById(Long id);
    public void deleteById(Long id);
    public Page<User> findAll(Pageable pageable);
}
