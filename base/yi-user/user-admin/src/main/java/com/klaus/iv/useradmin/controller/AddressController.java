package com.klaus.iv.useradmin.controller;


import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.base.BaseController;
import com.klaus.iv.useradmin.service.AddressService;
import com.klaus.iv.userapi.dto.AddressDto;
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
@RequestMapping("/address")
@Api("地址信息")
@Slf4j
public class AddressController extends BaseController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    @ApiOperation("根据Id获取地址信息")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return R.suc(addressService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据Id删除地址信息")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        addressService.deleteById(id);
        return R.suc();
    }


    @GetMapping()
    @ApiOperation("分页获取地址信息")
    public ResponseEntity list() {
        log.info("invoking list......");
        return R.suc(addressService.findAllWithPage(PageRequest.of(0,10)));
    }


    @PostMapping()
    @ApiOperation("新增/更新地址信息")
    public ResponseEntity save(@RequestBody AddressDto addressDto) {
        addressService.save(addressDto);
        return R.suc();
    }

}
