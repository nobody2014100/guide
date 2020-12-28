package com.klaus.iv.stockadmin.repo;

import com.klaus.iv.commonjpa.repo.BaseRepo;
import com.klaus.iv.stockadmin.po.YiStock;

import java.util.List;

public interface StockRepo extends BaseRepo<YiStock,Long > {

    boolean existsDistinctByCode(String code);

    List<YiStock> findYiStocksByCodeLike(String code);

    List<YiStock> findYiStocksByNameLike(String name);

}
