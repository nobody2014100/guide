package com.klaus.iv.stockadmin.service;

import com.klaus.iv.stockapi.dto.StockGroupDto;
import com.klaus.iv.stockapi.vo.StockGroupVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StockGroupService {


    public Page<StockGroupVo> findPage(Pageable pageable);
    public StockGroupVo findById(Long id);
    public void deleteById(Long id);
    public void save(StockGroupDto stockGroupDto);

}
