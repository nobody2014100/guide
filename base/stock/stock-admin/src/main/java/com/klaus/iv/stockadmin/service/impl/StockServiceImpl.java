package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.stockadmin.converter.StockDtoConverter;
import com.klaus.iv.stockadmin.converter.StockVoConverter;
import com.klaus.iv.stockadmin.po.YiStock;
import com.klaus.iv.stockadmin.repo.StockRepo;
import com.klaus.iv.stockadmin.service.StockService;
import com.klaus.iv.stockapi.dto.StockDto;
import com.klaus.iv.stockapi.qo.StockQo;
import com.klaus.iv.stockapi.vo.StockVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        Page<YiStock> page = stockRepo.findAll(pageable);
        List<StockVo> contents = page.getContent().stream().map(i -> new StockVoConverter().converterFromEntity(i)).collect(Collectors.toList());
        return new PageImpl<StockVo>(contents, pageable, page.getTotalElements());

    }

    @Override
    public StockVo findById(Long id) {
        Optional<YiStock> stockPo = stockRepo.findById(id);
        if (stockPo.isPresent()) {
            return new StockVoConverter().converterFromEntity(stockPo.get());
        }
        return null;
    }

    @Override
    public List<StockVo> findByUserIdAndGroupId(Long userId, Long groupId) {



        return null;
    }

    @Override
    public void deleteById(Long id) {
        stockRepo.deleteById(id);
    }

    @Override
    public void save(StockDto stockDto) {
        YiStock yiStock = new StockDtoConverter().converterFromDto(stockDto);
        log.info("yiStock is :{}, stockDto is :{}", yiStock, stockDto);
        if (!stockRepo.existsDistinctByCode(stockDto.getCode())) {
            stockRepo.save(yiStock);
        }
    }

    @Override
    public List<StockVo> search(StockQo stockQo) {
        List<YiStock> yiStocks = null;
        if ( !StringUtils.isEmpty(stockQo.getCode())) {
            yiStocks = stockRepo.findYiStocksByCodeLike(String.format("*%s*", stockQo.getCode()));
        } else if ( !StringUtils.isEmpty(stockQo.getName())) {
            yiStocks = stockRepo.findYiStocksByNameLike(String.format("*%s*", stockQo.getName()));
        }
        if (yiStocks != null && !yiStocks.isEmpty()) {
            List<StockVo> contents = yiStocks.stream().map(i -> new StockVoConverter().converterFromEntity(i)).collect(Collectors.toList());
            return contents;
        } else {
            Page<StockVo> page = findPage(PageRequest.of(0, 10));
            return page.getContent();
        }
    }
}
