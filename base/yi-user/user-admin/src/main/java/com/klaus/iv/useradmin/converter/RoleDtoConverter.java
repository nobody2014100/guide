package com.klaus.iv.useradmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.useradmin.po.Role;
import com.klaus.iv.userapi.dto.RoleDto;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public class RoleDtoConverter extends Converter<RoleDto, Role> {
    public RoleDtoConverter() {
        super(new RoleDtoFunction(), new RoleFunction() );
    }

    static class RoleDtoFunction implements Function<RoleDto, Role> {
        @Override
        public Role apply(RoleDto roleDto) {
            // 可定制需要复制的属性
            Role role = new Role();
            BeanUtils.copyProperties(roleDto, role);
            return role;
        }
    }

    static class RoleFunction implements Function<Role, RoleDto> {
        @Override
        public RoleDto apply(Role address) {
            // 可定制需要复制的属性
            RoleDto userDto = new RoleDto();
            BeanUtils.copyProperties(address, userDto);
            return userDto;
        }
    }

}
