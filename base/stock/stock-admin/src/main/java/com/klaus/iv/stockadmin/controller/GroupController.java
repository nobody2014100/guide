package com.klaus.iv.stockadmin.controller;


import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.base.BaseController;
import com.klaus.iv.stockadmin.service.GroupService;
import com.klaus.iv.stockapi.dto.GroupDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
@Api(tags = "分组管理")
@Slf4j
public class GroupController extends BaseController {

    @Autowired
    private GroupService stockService;

    @GetMapping
    @ApiOperation(value = "获取分组列表")
    public ResponseEntity<R> list() {
        return R.suc(stockService.findPage(PageRequest.of(0,10)));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取分组")
    @ApiImplicitParam(name = "id", value = "请传递一个分组ID参数",required = true, dataTypeClass = Integer.class, paramType = "path")
    public ResponseEntity<R> findByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        return R.suc(stockService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除分组")
    @ApiImplicitParam(name = "id", value = "请传递一个分组ID参数",required = true, dataTypeClass = Integer.class, paramType = "path")
    public ResponseEntity<R> deleteByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        stockService.deleteById(id);
        return  R.suc(true);
    }

    @PostMapping
    @ApiOperation(value = "新增分组")
    @ApiImplicitParam(name = "groupDto", value = "分组实体DTO",defaultValue = "{}",required = true, dataTypeClass = GroupDto.class, paramType = "body")
    public ResponseEntity<R> save(@RequestBody GroupDto groupDto) {
        log.info("groupDto is:{}", groupDto);
        stockService.save(groupDto);
        return  R.suc(true);
    }


}
