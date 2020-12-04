package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.stockadmin.converter.GroupDtoConverter;
import com.klaus.iv.stockadmin.converter.GroupVoConverter;
import com.klaus.iv.stockadmin.po.YiGroup;
import com.klaus.iv.stockadmin.repo.GroupRepo;
import com.klaus.iv.stockadmin.service.GroupService;
import com.klaus.iv.stockapi.dto.GroupDto;
import com.klaus.iv.stockapi.vo.GroupVo;
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
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepo groupRepo;

    @Override
    public Page<GroupVo> findPage(Pageable pageable) {
        Page<YiGroup> page = groupRepo.findAll(pageable);
        List<GroupVo> contents = page.getContent().stream().map(i -> new GroupVoConverter().converterFromEntity(i)).collect(Collectors.toList());
        Page<GroupVo> stockVos = Page.empty();
        return stockVos;

    }

    @Override
    public GroupVo findById(Long id) {
        Optional<YiGroup> stockPo = groupRepo.findById(id);
        if (stockPo.isPresent()) {
            return new GroupVoConverter().converterFromEntity(stockPo.get());
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        groupRepo.deleteById(id);
    }

    @Override
    public void save(GroupDto stockDto) {
        YiGroup stock = new GroupDtoConverter().converterFromDto(stockDto);
        log.info("stock is :{}, stockDto is :{}", stock, stockDto);
        groupRepo.save(stock);
    }
}
