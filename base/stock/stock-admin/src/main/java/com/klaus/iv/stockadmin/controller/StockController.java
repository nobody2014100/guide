package com.klaus.iv.stockadmin.controller;


import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.base.BaseController;
import com.klaus.iv.stockadmin.service.StockService;
import com.klaus.iv.stockapi.dto.StockDto;
import com.klaus.iv.stockapi.vo.StockVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@Api(tags = "股票管理")
@Slf4j
public class StockController extends BaseController {

    @Autowired
    private StockService stockService;

    @GetMapping
    @ApiOperation(value = "获取股票列表")
    public ResponseEntity<R> list() {
        return R.suc(stockService.findPage(PageRequest.of(0,10)));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取股票")
    @ApiImplicitParam(name = "id", value = "请传递一个股票ID参数",required = true, dataTypeClass = Integer.class, paramType = "path")
    public ResponseEntity<R> findByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        return R.suc(stockService.findById(id));
    }

    @GetMapping("/user/{id}/{groupid}")
    @ApiOperation(value = "获取用户股票")
    @ApiImplicitParam(name = "id", value = "请传递一个股票ID参数",required = true, dataTypeClass = Integer.class, paramType = "path")
    public ResponseEntity<R> findByUserID(@RequestParam("userId") Long userId, @RequestParam("groupId") Long groupId) {
        log.info("userId is:{}, groupId is :{}", userId, groupId);
        return R.suc(stockService.findByUserIdAndGroupId(userId, groupId));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除股票")
    @ApiImplicitParam(name = "id", value = "请传递一个股票ID参数",required = true, dataTypeClass = Integer.class, paramType = "path")
    public ResponseEntity<R> deleteByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        stockService.deleteById(id);
        return  R.suc(true);
    }

    @PostMapping
    @ApiOperation(value = "新增股票")
    @ApiImplicitParam(name = "stockDto", value = "股票实体DTO",defaultValue = "{}",required = true, dataTypeClass = StockDto.class, paramType = "body")
    public ResponseEntity<R> save(@RequestBody StockDto stockDto) {
        log.info("stockVo is:{}", stockDto);
        stockService.save(stockDto);
        return  R.suc(true);
    }


}
