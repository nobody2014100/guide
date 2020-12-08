package com.klaus.iv.useradmin.service.impl;

import com.klaus.iv.commonjpa.repo.BaseRepo;
import com.klaus.iv.commonjpa.service.impl.BaseServiceImpl;
import com.klaus.iv.useradmin.converter.UserDtoConverter;
import com.klaus.iv.useradmin.converter.UserVoConverter;
import com.klaus.iv.useradmin.po.User;
import com.klaus.iv.useradmin.service.UserService;
import com.klaus.iv.userapi.dto.UserDto;
import com.klaus.iv.userapi.vo.RoleVo;
import com.klaus.iv.userapi.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{

    public UserServiceImpl(DSLContext dsl, BaseRepo baseRepo) {
        super(dsl, baseRepo);
    }

    @Override
    public void save(UserDto userDto) {
        User user = new UserDtoConverter().converterFromDto(userDto);
        baseRepo.save(user);
    }

    @Override
    public UserVo findById(Long id) {
        return new UserVoConverter().converterFromEntity(baseRepo.getOne(id));
    }

    @Override
    public void deleteById(Long id) {
        baseRepo.deleteById(id);

    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return baseRepo.findAll(pageable);
    }

    @Override
    public List<RoleVo> findRolesByUserId(Long userId) {

        this.dsl.selectFrom("");
        return null;
    }

    @Override
    public UserVo converterVo(User user) {
        return new UserVoConverter().converterFromEntity(user);
    }
}
