package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.StockGroup;
import com.klaus.iv.stockapi.dto.StockGroupDto;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;


public class StockGroupDtoConverter extends Converter<StockGroupDto, StockGroup> {
    public StockGroupDtoConverter() {
        super(new StockGroupDtoFunction(), new StockGroupFunction() );
    }

    static class StockGroupDtoFunction implements Function<StockGroupDto, StockGroup> {
        @Override
        public StockGroup apply(StockGroupDto stockDto) {
            // 可定制需要复制的属性
            StockGroup stock = new StockGroup();
            BeanUtils.copyProperties(stockDto, stock);
            return stock;
        }
    }

    static class StockGroupFunction implements Function<StockGroup, StockGroupDto> {
        @Override
        public StockGroupDto apply(StockGroup stock) {
            // 可定制需要复制的属性
            StockGroupDto stockDto = new StockGroupDto();
            BeanUtils.copyProperties(stock, stockDto);
            return stockDto;
        }
    }

}