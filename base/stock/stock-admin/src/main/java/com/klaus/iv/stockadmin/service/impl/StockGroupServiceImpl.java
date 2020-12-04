package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.stockadmin.converter.StockGroupDtoConverter;
import com.klaus.iv.stockadmin.converter.StockGroupVoConverter;
import com.klaus.iv.stockadmin.po.StockGroup;
import com.klaus.iv.stockadmin.repo.StockGroupRepo;
import com.klaus.iv.stockadmin.service.StockGroupService;
import com.klaus.iv.stockapi.dto.StockGroupDto;
import com.klaus.iv.stockapi.vo.StockGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StockGroupServiceImpl implements StockGroupService {

    @Autowired
    private StockGroupRepo stockGroupRepo;

    @Override
    public Page<StockGroupVo> findPage(Pageable pageable) {
        Page<StockGroup> page = stockGroupRepo.findAll(pageable);
        List<StockGroupVo> contents = page.getContent().stream().map(i -> new StockGroupVoConverter().converterFromEntity(i)).collect(Collectors.toList());
        Page<StockGroupVo> stockVos = Page.empty();
        return stockVos;

    }

    @Override
    public StockGroupVo findById(Long id) {
        Optional<StockGroup> stockPo = stockGroupRepo.findById(id);
        if (stockPo.isPresent()) {
            return new StockGroupVoConverter().converterFromEntity(stockPo.get());
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        stockGroupRepo.deleteById(id);
    }

    @Override
    public void save(StockGroupDto stockDto) {
        StockGroup stock = new StockGroupDtoConverter().converterFromDto(stockDto);
        log.info("stock is :{}, stockDto is :{}", stock, stockDto);
        stockGroupRepo.save(stock);
    }
}
