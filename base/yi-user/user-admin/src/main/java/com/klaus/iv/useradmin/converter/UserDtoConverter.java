package com.klaus.iv.useradmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.useradmin.po.User;
import com.klaus.iv.useradmin.po.User.UserType;
import com.klaus.iv.userapi.dto.UserDto;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.function.Function;

public class UserDtoConverter extends Converter<UserDto, User> {
    public UserDtoConverter() {
        super(new UserDtoFunction(), new UserFunction() );
    }

    static class UserDtoFunction implements Function<UserDto, User> {
        @Override
        public User apply(UserDto userDto) {
            // 可定制需要复制的属性
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            Optional<UserType> us = UserType.of(userDto.getUserType());
            if (us.isPresent()) {
                user.setUserType(us.get());
            } else {
                user.setUserType(UserType.ACCOUNT);
            }
            return user;
        }
    }

    static class UserFunction implements Function<User, UserDto> {
        @Override
        public UserDto apply(User user) {
            // 可定制需要复制的属性
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            userDto.setUserType(user.getUserType().getValue());
            return userDto;
        }
    }

}
