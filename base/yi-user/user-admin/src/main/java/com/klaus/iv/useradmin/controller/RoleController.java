package com.klaus.iv.useradmin.controller;


import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.base.BaseController;
import com.klaus.iv.useradmin.service.RoleService;
import com.klaus.iv.userapi.dto.RoleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@Api("角色信息")
@Slf4j
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    @ApiOperation("根据Id获取角色信息")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return R.suc(roleService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据Id删除角色信息")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        roleService.deleteById(id);
        return R.suc();
    }

    @GetMapping()
    @ApiOperation("分页获取角色信息")
    public ResponseEntity list() {
        log.info("invoking list......");
        return R.suc(roleService.findAllWithPage(PageRequest.of(0,10)));
    }

    @PostMapping()
    @ApiOperation("新增/更新角色信息")
    public ResponseEntity save(@RequestBody RoleDto roleDto) {
        roleService.save(roleDto);
        return R.suc();
    }

}
