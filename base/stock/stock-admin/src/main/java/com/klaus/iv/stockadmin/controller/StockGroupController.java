package com.klaus.iv.stockadmin.controller;


import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.base.BaseController;
import com.klaus.iv.stockadmin.service.StockGroupService;
import com.klaus.iv.stockapi.dto.StockGroupDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stockgroup")
@Api(tags = "股票分组管理")
@Slf4j
public class StockGroupController extends BaseController {

    @Autowired
    private StockGroupService stockGroupService;

    @GetMapping
    @ApiOperation(value = "获取股票分组列表")
    public ResponseEntity<R> list() {
        return R.suc(stockGroupService.findAllWithPage(PageRequest.of(0,10)));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取股票分组")
    @ApiImplicitParam(name = "id", value = "请传递一个股票分组ID参数",required = true, dataTypeClass = Integer.class, paramType = "path")
    public ResponseEntity<R> findByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        return R.suc(stockGroupService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除股票分组")
    @ApiImplicitParam(name = "id", value = "请传递一个股票分组ID参数",required = true, dataTypeClass = Integer.class, paramType = "path")
    public ResponseEntity<R> deleteByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        stockGroupService.deleteById(id);
        return  R.suc(true);
    }

    @PostMapping
    @ApiOperation(value = "新增股票分组")
    @ApiImplicitParam(name = "stockGroupDto", value = "股票分组实体DTO",defaultValue = "{}",required = true, dataTypeClass = StockGroupDto.class, paramType = "body")
    public ResponseEntity<R> save(@RequestBody StockGroupDto stockGroupDto) {
        log.info("stockVo is:{}", stockGroupDto);
        stockGroupService.save(stockGroupDto);
        return  R.suc(true);
    }


}
