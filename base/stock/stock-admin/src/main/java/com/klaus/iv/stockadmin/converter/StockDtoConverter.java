package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.Stock;
import com.klaus.iv.stockapi.dto.StockDto;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;


public class StockDtoConverter extends Converter<StockDto, Stock> {
    public StockDtoConverter() {
        super(new StockDtoFunction(), new StockFunction() );
    }

    static class StockDtoFunction implements Function<StockDto, Stock> {
        @Override
        public Stock apply(StockDto stockDto) {
            // 可定制需要复制的属性
            Stock stock = new Stock();
            BeanUtils.copyProperties(stockDto, stock);
            return stock;
        }
    }

    static class StockFunction implements Function<Stock, StockDto> {
        @Override
        public StockDto apply(Stock stock) {
            // 可定制需要复制的属性
            StockDto stockDto = new StockDto();
            BeanUtils.copyProperties(stock, stockDto);
            return stockDto;
        }
    }

}