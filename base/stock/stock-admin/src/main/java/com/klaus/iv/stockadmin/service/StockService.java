package com.klaus.iv.stockadmin.service;

import com.klaus.iv.commonjpa.service.BaseService;
import com.klaus.iv.stockadmin.po.YiStock;
import com.klaus.iv.stockapi.qo.StockQo;
import com.klaus.iv.stockapi.vo.StockVo;

import java.util.List;

public interface StockService extends BaseService<YiStock, Long> {


    /**
     *
     * @param userId
     * @param groupId
     * @return
     */
    List<StockVo> findByUserIdAndGroupId(Long userId, Long groupId);

    /**
     * search by name and code
     * @param stockQo
     * @return
     */
    List<StockVo> search(StockQo stockQo);

}
