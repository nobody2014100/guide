package com.klaus.iv.stockadmin.controller;


import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.base.BaseController;
import com.klaus.iv.stockadmin.service.UserGroupService;
import com.klaus.iv.stockapi.dto.UserGroupDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usergroup")
@Api(tags = "用户分组管理")
@Slf4j
public class UserGroupController extends BaseController {

    @Autowired
    private UserGroupService userGroupService;

    @GetMapping
    @ApiOperation(value = "获取用户分组列表")
    public ResponseEntity<R> list() {
        return R.suc(userGroupService.findAllWithPage(PageRequest.of(0,10)));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户分组")
    @ApiImplicitParam(name = "id", value = "请传递一个用户分组ID参数",required = true, dataTypeClass = Integer.class, paramType = "path")
    public ResponseEntity<R> findByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        return R.suc(userGroupService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户分组")
    @ApiImplicitParam(name = "id", value = "请传递一个用户分组ID参数",required = true, dataTypeClass = Integer.class, paramType = "path")
    public ResponseEntity<R> deleteByID(@PathVariable("id") Long id) {
        log.info("id is:{}", id);
        userGroupService.deleteById(id);
        return  R.suc(true);
    }

    @PostMapping
    @ApiOperation(value = "新增用户分组")
    @ApiImplicitParam(name = "userGroupDto", value = "用户分组实体DTO",defaultValue = "{}",required = true, dataTypeClass = UserGroupDto.class, paramType = "body")
    public ResponseEntity<R> save(@RequestBody UserGroupDto userGroupDto) {
        log.info("stockVo is:{}", userGroupDto);
        userGroupService.save(userGroupDto);
        return  R.suc(true);
    }


}
