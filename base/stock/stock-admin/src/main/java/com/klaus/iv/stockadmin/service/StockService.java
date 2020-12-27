package com.klaus.iv.stockadmin.service;

import com.klaus.iv.stockapi.dto.StockDto;
import com.klaus.iv.stockapi.qo.StockQo;
import com.klaus.iv.stockapi.vo.StockVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockService {


    Page<StockVo> findPage(Pageable pageable);
    StockVo findById(Long id);
    List<StockVo> findByUserIdAndGroupId(Long userId, Long groupId);
    void deleteById(Long id);
    void save(StockDto stockDto);

    /**
     * search by name and code
     * @param stockQo
     * @return
     */
    List<StockVo> search(StockQo stockQo);

}
