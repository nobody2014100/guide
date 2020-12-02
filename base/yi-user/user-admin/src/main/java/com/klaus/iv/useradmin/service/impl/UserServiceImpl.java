package com.klaus.iv.useradmin.service.impl;

import com.klaus.iv.useradmin.converter.UserDtoConverter;
import com.klaus.iv.useradmin.converter.UserVoConverter;
import com.klaus.iv.useradmin.po.User;
import com.klaus.iv.useradmin.repo.UserRepo;
import com.klaus.iv.useradmin.service.UserService;
import com.klaus.iv.userapi.dto.UserDto;
import com.klaus.iv.userapi.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void save(UserDto userDto) {
        User user = new UserDtoConverter().converterFromDto(userDto);
        userRepo.save(user);
    }

    @Override
    public UserVo findById(Long id) {
        return new UserVoConverter().converterFromEntity(userRepo.getOne(id));
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);

    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }
}
