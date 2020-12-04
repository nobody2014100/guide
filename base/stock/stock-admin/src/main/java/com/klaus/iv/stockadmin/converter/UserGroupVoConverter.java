package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.UserGroup;
import com.klaus.iv.stockapi.vo.UserGroupVo;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;


public class UserGroupVoConverter extends Converter<UserGroupVo, UserGroup> {
    public UserGroupVoConverter() {
        super(new UserGroupDtoFunction(), new UserGroupFunction() );
    }

    static class UserGroupDtoFunction implements Function<UserGroupVo, UserGroup> {
        @Override
        public UserGroup apply(UserGroupVo stockVo) {
            // 可定制需要复制的属性
            UserGroup stock = new UserGroup();
            BeanUtils.copyProperties(stockVo, stock);
            return stock;
        }
    }

    static class UserGroupFunction implements Function<UserGroup, UserGroupVo> {
        @Override
        public UserGroupVo apply(UserGroup stock) {
            // 可定制需要复制的属性
            UserGroupVo stockVo = new UserGroupVo();
            BeanUtils.copyProperties(stock, stockVo);
            return stockVo;
        }
    }

}