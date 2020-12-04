package com.klaus.iv.stockadmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.stockadmin.po.YiStock;
import com.klaus.iv.stockapi.vo.StockVo;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;



public class StockVoConverter extends Converter<StockVo, YiStock> {
    public StockVoConverter() {
        super(new StockDtoFunction(), new StockFunction() );
    }

    static class StockDtoFunction implements Function<StockVo, YiStock> {
        @Override
        public YiStock apply(StockVo stockVo) {
            // 可定制需要复制的属性
            YiStock yiStock = new YiStock();
            BeanUtils.copyProperties(stockVo, yiStock);
            return yiStock;
        }
    }

    static class StockFunction implements Function<YiStock, StockVo> {
        @Override
        public StockVo apply(YiStock yiStock) {
            // 可定制需要复制的属性
            StockVo stockVo = new StockVo();
            BeanUtils.copyProperties(yiStock, stockVo);
            return stockVo;
        }
    }

}