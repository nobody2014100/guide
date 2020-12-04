package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.YiStock;
import com.klaus.iv.stockapi.dto.StockDto;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;


public class StockDtoConverter extends Converter<StockDto, YiStock> {
    public StockDtoConverter() {
        super(new StockDtoFunction(), new StockFunction() );
    }

    static class StockDtoFunction implements Function<StockDto, YiStock> {
        @Override
        public YiStock apply(StockDto stockDto) {
            // 可定制需要复制的属性
            YiStock yiStock = new YiStock();
            BeanUtils.copyProperties(stockDto, yiStock);
            return yiStock;
        }
    }

    static class StockFunction implements Function<YiStock, StockDto> {
        @Override
        public StockDto apply(YiStock yiStock) {
            // 可定制需要复制的属性
            StockDto stockDto = new StockDto();
            BeanUtils.copyProperties(yiStock, stockDto);
            return stockDto;
        }
    }

}