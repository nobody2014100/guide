package com.klaus.iv.useradmin.controller;


import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.base.BaseController;
import com.klaus.iv.useradmin.service.UserService;
import com.klaus.iv.userapi.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api("用户信息")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ApiOperation("根据Id获取用户信息")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return R.suc(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据Id删除用户信息")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return R.suc();
    }


    @GetMapping()
    @ApiOperation("分页获取用户信息")
    public ResponseEntity list() {
        return R.suc(userService.findAll(PageRequest.of(0,10)));
    }


    @PostMapping()
    @ApiOperation("新增/更新用户信息")
    public ResponseEntity save(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return R.suc();
    }

}
