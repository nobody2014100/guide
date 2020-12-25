package com.klaus.iv.stockapi.feign;


import com.klaus.iv.commonweb.R;
import com.klaus.iv.gatewayapi.service.AppService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = AppService.stock_admin, path = "/stock-admin")
public interface StockClient {
    @GetMapping(value = "/stock/user",produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<R> findByUserID(@RequestParam("userId") Long userId, @RequestParam("groupId") Long groupId) ;


}
