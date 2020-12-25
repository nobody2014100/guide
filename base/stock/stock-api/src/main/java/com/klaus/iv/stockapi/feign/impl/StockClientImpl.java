package com.klaus.iv.stockapi.feign.impl;

import com.klaus.iv.commonweb.R;
import com.klaus.iv.gatewayapi.service.AppService;
import com.klaus.iv.stockapi.feign.StockClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class StockClientImpl implements StockClient {
    @Override
    public ResponseEntity<R> findByUserID(Long userId, Long groupId) {
        log.info("feign client call service: {} path :{} fail!", AppService.stock_admin, "findByUserID");
        return null;
    }
}
