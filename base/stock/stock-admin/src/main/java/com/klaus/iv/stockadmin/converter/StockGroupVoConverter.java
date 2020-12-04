package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.StockGroup;
import com.klaus.iv.stockapi.vo.StockGroupVo;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;


public class StockGroupVoConverter extends Converter<StockGroupVo, StockGroup> {
    public StockGroupVoConverter() {
        super(new StockGroupDtoFunction(), new StockGroupFunction() );
    }

    static class StockGroupDtoFunction implements Function<StockGroupVo, StockGroup> {
        @Override
        public StockGroup apply(StockGroupVo stockVo) {
            // 可定制需要复制的属性
            StockGroup stock = new StockGroup();
            BeanUtils.copyProperties(stockVo, stock);
            return stock;
        }
    }

    static class StockGroupFunction implements Function<StockGroup, StockGroupVo> {
        @Override
        public StockGroupVo apply(StockGroup stock) {
            // 可定制需要复制的属性
            StockGroupVo stockVo = new StockGroupVo();
            BeanUtils.copyProperties(stock, stockVo);
            return stockVo;
        }
    }

}