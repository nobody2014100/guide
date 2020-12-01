package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.stockadmin.po.StockPo;
import com.klaus.iv.stockadmin.repo.StockRepo;
import com.klaus.iv.stockadmin.service.StockService;
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
        Page<StockPo> page = stockRepo.findAll(pageable);
        List<StockVo> contents = page.getContent().stream().map(i -> i.convertor()).collect(Collectors.toList());
        Page<StockVo> stockVos = Page.empty();
        return stockVos;
    }

    @Override
    public StockVo findById(Long id) {
        Optional<StockPo> stockPo = stockRepo.findById(id);
        if (stockPo.isPresent()) {
            return stockPo.get().convertor();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        stockRepo.deleteById(id);
    }

    @Override
    public void save(StockVo stockVo) {
        StockPo stockPo = new StockPo();
        BeanUtils.copyProperties(stockVo, stockPo);
//        BeanUtils.copyProperties(stockPo, stockVo);
        log.info("stockPo is :{}, stockVo is :{}", stockPo, stockVo);
        stockRepo.save(stockPo);
    }
}
