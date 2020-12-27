package com.klaus.iv.stockadmin.repo;

import com.klaus.iv.stockadmin.po.YiStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepo extends JpaRepository<YiStock,Long > {

    boolean existsDistinctByCode(String code);

    List<YiStock> findYiStocksByCodeLike(String code);

    List<YiStock> findYiStocksByNameLike(String name);

}
