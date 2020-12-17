package com.klaus.iv.useradmin.controller;


import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.base.BaseController;
import com.klaus.iv.useradmin.service.UserService;
import com.klaus.iv.userapi.dto.UserDto;
import com.klaus.iv.userapi.dto.UserRolesDto;
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
@RequestMapping("/user")
@Api("用户信息")
@Slf4j
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
        log.info("invoking list......");
        return R.suc(userService.findAllWithPage(PageRequest.of(0,10)));
    }

    @PostMapping()
    @ApiOperation("新增/更新用户信息")
    public ResponseEntity save(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return R.suc();
    }

    @GetMapping("/role/{userId}")
    @ApiOperation("查询用户角色信息")
    public ResponseEntity findRoles(@PathVariable("userId") Long userId) {
        return R.suc(userService.findRolesByUserId(userId));
    }

    @PostMapping("/role")
    @ApiOperation("添加用户角色信息")
    public ResponseEntity addRoles(@RequestBody UserRolesDto userRolesDto) {
        return R.suc(userService.addRoleToUser(userRolesDto));
    }

    @GetMapping(value = "/user/email/{id}",produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<R> findByEmail(@PathVariable("email") String email) {
        return R.suc(userService.findByEmail(email));
    }

    @GetMapping(value = "/user/mobile/{id}",produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<R> findByMobile(@PathVariable("mobile") String mobile) {
        return R.suc(userService.findByMobile(mobile));
    }

    @GetMapping(value = "/user/username/{id}",produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<R> findByUsername(@PathVariable("username") String username) {
        return R.suc(userService.findByUsername(username));
    }
    @GetMapping(value = "/user/open/{openID}",produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<R> findByOpenID(@PathVariable("openID") String openID) {
        return R.suc(userService.findByOpenID(openID));
    }





}
