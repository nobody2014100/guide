package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.YiGroup;
import com.klaus.iv.stockapi.vo.GroupVo;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;


public class GroupVoConverter extends Converter<GroupVo, YiGroup> {
    public GroupVoConverter() {
        super(new GroupDtoFunction(), new GroupFunction() );
    }

    static class GroupDtoFunction implements Function<GroupVo, YiGroup> {
        @Override
        public YiGroup apply(GroupVo stockVo) {
            // 可定制需要复制的属性
            YiGroup stock = new YiGroup();
            BeanUtils.copyProperties(stockVo, stock);
            return stock;
        }
    }

    static class GroupFunction implements Function<YiGroup, GroupVo> {
        @Override
        public GroupVo apply(YiGroup stock) {
            // 可定制需要复制的属性
            GroupVo stockVo = new GroupVo();
            BeanUtils.copyProperties(stock, stockVo);
            return stockVo;
        }
    }

}