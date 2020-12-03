package com.klaus.iv.stockadmin.service;

import com.klaus.iv.stockapi.dto.StockDto;
import com.klaus.iv.stockapi.vo.StockVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StockService {


    public Page<StockVo> findPage(Pageable pageable);
    public StockVo findById(Long id);
    public void deleteById(Long id);
    public void save(StockDto stockDto);

}
