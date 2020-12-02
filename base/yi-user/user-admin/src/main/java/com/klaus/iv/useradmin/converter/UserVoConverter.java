package com.klaus.iv.useradmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.useradmin.po.User;
import com.klaus.iv.userapi.dto.UserDto;
import com.klaus.iv.userapi.vo.UserVo;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public class UserVoConverter extends Converter<UserVo, User> {
    public UserVoConverter() {
        super(new UserDtoFunction(), new UserFunction() );
    }

    static class UserDtoFunction implements Function<UserVo, User> {
        @Override
        public User apply(UserVo userVo) {
            // 可定制需要复制的属性
            User user = new User();
            BeanUtils.copyProperties(userVo, user);
            return user;
        }
    }

    static class UserFunction implements Function<User, UserVo> {
        @Override
        public UserVo apply(User user) {
            // 可定制需要复制的属性
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            return userVo;
        }
    }

}
