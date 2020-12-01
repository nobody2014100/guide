package com.klaus.iv.stockadmin.controller;


import com.klaus.iv.stockadmin.service.StockService;
import com.klaus.iv.stockapi.vo.StockVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@Api(tags = "股票管理")
@Slf4j
public class StockController extends BaseController{

    @Autowired
    private StockService stockService;

    @GetMapping
    @ApiOperation(value = "获取股票列表")
    public ResponseEntity<Page<StockVo>> list() {
        return  ResponseEntity.ok(stockService.findPage(PageRequest.of(0,10)));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取股票")
    @ApiImplicitParam(name = "id", value = "请传递一个股票ID参数",required = true, dataType = "int", paramType = "path")
    public ResponseEntity<Page<StockVo>> findByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        return  ResponseEntity.ok(stockService.findPage(PageRequest.of(0,10)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除股票")
    @ApiImplicitParam(name = "id", value = "请传递一个股票ID参数",required = true, dataType = "int", paramType = "path")
    public ResponseEntity<Boolean> deleteByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        stockService.deleteById(id);
        return  ResponseEntity.ok(true);
    }

    @PostMapping
    @ApiOperation(value = "新增股票")
    public ResponseEntity<Boolean> save(@RequestBody StockVo stockVo) {
        log.info("stockVo is:{}", stockVo);
        stockService.save(stockVo);
        return  ResponseEntity.ok(true);
    }


}
