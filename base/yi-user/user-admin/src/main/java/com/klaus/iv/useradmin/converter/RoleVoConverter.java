package com.klaus.iv.useradmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.useradmin.po.Role;
import com.klaus.iv.userapi.vo.RoleVo;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public class RoleVoConverter extends Converter<RoleVo, Role> {
    public RoleVoConverter() {
        super(new RoleDtoFunction(), new RoleFunction() );
    }

    static class RoleDtoFunction implements Function<RoleVo, Role> {
        @Override
        public Role apply(RoleVo addressVo) {
            // 可定制需要复制的属性
            Role address = new Role();
            BeanUtils.copyProperties(addressVo, address);
            return address;
        }
    }

    static class RoleFunction implements Function<Role, RoleVo> {
        @Override
        public RoleVo apply(Role address) {
            // 可定制需要复制的属性
            RoleVo addressVo = new RoleVo();
            BeanUtils.copyProperties(address, addressVo);
            return addressVo;
        }
    }

}
