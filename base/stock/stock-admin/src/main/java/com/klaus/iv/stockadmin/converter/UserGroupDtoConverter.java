package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.UserGroup;
import com.klaus.iv.stockapi.dto.UserGroupDto;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;


public class UserGroupDtoConverter extends Converter<UserGroupDto, UserGroup> {
    public UserGroupDtoConverter() {
        super(new UserGroupDtoFunction(), new UserGroupFunction() );
    }

    static class UserGroupDtoFunction implements Function<UserGroupDto, UserGroup> {
        @Override
        public UserGroup apply(UserGroupDto stockDto) {
            // 可定制需要复制的属性
            UserGroup stock = new UserGroup();
            BeanUtils.copyProperties(stockDto, stock);
            return stock;
        }
    }

    static class UserGroupFunction implements Function<UserGroup, UserGroupDto> {
        @Override
        public UserGroupDto apply(UserGroup stock) {
            // 可定制需要复制的属性
            UserGroupDto stockDto = new UserGroupDto();
            BeanUtils.copyProperties(stock, stockDto);
            return stockDto;
        }
    }

}