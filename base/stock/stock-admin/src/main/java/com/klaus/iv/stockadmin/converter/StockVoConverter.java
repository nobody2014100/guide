package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.Stock;
import com.klaus.iv.stockapi.vo.StockVo;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;



public class StockVoConverter extends Converter<StockVo, Stock> {
    public StockVoConverter() {
        super(new StockDtoFunction(), new StockFunction() );
    }

    static class StockDtoFunction implements Function<StockVo, Stock> {
        @Override
        public Stock apply(StockVo stockVo) {
            // 可定制需要复制的属性
            Stock stock = new Stock();
            BeanUtils.copyProperties(stockVo, stock);
            return stock;
        }
    }

    static class StockFunction implements Function<Stock, StockVo> {
        @Override
        public StockVo apply(Stock stock) {
            // 可定制需要复制的属性
            StockVo stockVo = new StockVo();
            BeanUtils.copyProperties(stock, stockVo);
            return stockVo;
        }
    }

}