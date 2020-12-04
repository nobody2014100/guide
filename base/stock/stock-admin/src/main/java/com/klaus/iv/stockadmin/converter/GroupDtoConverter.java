package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.YiGroup;
import com.klaus.iv.stockapi.dto.GroupDto;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;


public class GroupDtoConverter extends Converter<GroupDto, YiGroup> {
    public GroupDtoConverter() {
        super(new GroupDtoFunction(), new GroupFunction() );
    }

    static class GroupDtoFunction implements Function<GroupDto, YiGroup> {
        @Override
        public YiGroup apply(GroupDto stockDto) {
            // 可定制需要复制的属性
            YiGroup stock = new YiGroup();
            BeanUtils.copyProperties(stockDto, stock);
            return stock;
        }
    }

    static class GroupFunction implements Function<YiGroup, GroupDto> {
        @Override
        public GroupDto apply(YiGroup stock) {
            // 可定制需要复制的属性
            GroupDto stockDto = new GroupDto();
            BeanUtils.copyProperties(stock, stockDto);
            return stockDto;
        }
    }

}