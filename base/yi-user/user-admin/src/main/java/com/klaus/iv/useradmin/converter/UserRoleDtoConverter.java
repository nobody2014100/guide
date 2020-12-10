package com.klaus.iv.useradmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.useradmin.po.UserRole;
import com.klaus.iv.userapi.dto.UserRoleDto;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public class UserRoleDtoConverter extends Converter<UserRoleDto, UserRole> {
    public UserRoleDtoConverter() {
        super(new UserRoleDtoFunction(), new UserRoleFunction() );
    }

    static class UserRoleDtoFunction implements Function<UserRoleDto, UserRole> {
        @Override
        public UserRole apply(UserRoleDto roleDto) {
            // 可定制需要复制的属性
            UserRole role = new UserRole();
            BeanUtils.copyProperties(roleDto, role);
            return role;
        }
    }

    static class UserRoleFunction implements Function<UserRole, UserRoleDto> {
        @Override
        public UserRoleDto apply(UserRole address) {
            // 可定制需要复制的属性
            UserRoleDto userDto = new UserRoleDto();
            BeanUtils.copyProperties(address, userDto);
            return userDto;
        }
    }

}
