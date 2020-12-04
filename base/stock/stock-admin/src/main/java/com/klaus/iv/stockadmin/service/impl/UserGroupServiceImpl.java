package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.stockadmin.converter.UserGroupDtoConverter;
import com.klaus.iv.stockadmin.converter.UserGroupVoConverter;
import com.klaus.iv.stockadmin.po.UserGroup;
import com.klaus.iv.stockadmin.repo.UserGroupRepo;
import com.klaus.iv.stockadmin.service.UserGroupService;
import com.klaus.iv.stockapi.dto.UserGroupDto;
import com.klaus.iv.stockapi.vo.UserGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    private UserGroupRepo userGroupRepo;

    @Override
    public Page<UserGroupVo> findPage(Pageable pageable) {
        Page<UserGroup> page = userGroupRepo.findAll(pageable);
        List<UserGroupVo> contents = page.getContent().stream().map(i -> new UserGroupVoConverter().converterFromEntity(i)).collect(Collectors.toList());
        Page<UserGroupVo> stockVos = Page.empty();
        return stockVos;

    }

    @Override
    public UserGroupVo findById(Long id) {
        Optional<UserGroup> stockPo = userGroupRepo.findById(id);
        if (stockPo.isPresent()) {
            return new UserGroupVoConverter().converterFromEntity(stockPo.get());
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        userGroupRepo.deleteById(id);
    }

    @Override
    public void save(UserGroupDto userGroupDto) {
        UserGroup stock = new UserGroupDtoConverter().converterFromDto(userGroupDto);
        log.info("stock is :{}, userGroupDto is :{}", stock, userGroupDto);
        userGroupRepo.save(stock);
    }
}
