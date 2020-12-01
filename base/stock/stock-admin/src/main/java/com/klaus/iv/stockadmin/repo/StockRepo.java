package com.klaus.iv.stockadmin.repo;

import com.klaus.iv.stockadmin.po.StockPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<StockPo ,Long > {


}
