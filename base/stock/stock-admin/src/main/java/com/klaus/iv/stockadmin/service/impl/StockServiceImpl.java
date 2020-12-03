package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.stockadmin.converter.StockDtoConverter;
import com.klaus.iv.stockadmin.converter.StockVoConverter;
import com.klaus.iv.stockadmin.po.Stock;
import com.klaus.iv.stockadmin.repo.StockRepo;
import com.klaus.iv.stockadmin.service.StockService;
import com.klaus.iv.stockapi.dto.StockDto;
import com.klaus.iv.stockapi.vo.StockVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepo stockRepo;

    @Override
    public Page<StockVo> findPage(Pageable pageable) {
        Page<Stock> page = stockRepo.findAll(pageable);
        List<StockVo> contents = page.getContent().stream().map(i -> new StockVoConverter().converterFromEntity(i)).collect(Collectors.toList());
        Page<StockVo> stockVos = Page.empty();
        return stockVos;

    }

    @Override
    public StockVo findById(Long id) {
        Optional<Stock> stockPo = stockRepo.findById(id);
        if (stockPo.isPresent()) {
            return new StockVoConverter().converterFromEntity(stockPo.get());
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        stockRepo.deleteById(id);
    }

    @Override
    public void save(StockDto stockDto) {
        Stock stock = new StockDtoConverter().converterFromDto(stockDto);
//        Stock stock = new Stock();
//        BeanUtils.copyProperties(stockDto, stock);
        log.info("stock is :{}, stockDto is :{}", stock, stockDto);
        stockRepo.save(stock);
    }
}
