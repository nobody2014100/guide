package com.klaus.iv.stockadmin.service;

import com.klaus.iv.stockapi.dto.GroupDto;
import com.klaus.iv.stockapi.vo.GroupVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupService {


    public Page<GroupVo> findPage(Pageable pageable);
    public GroupVo findById(Long id);
    public void deleteById(Long id);
    public void save(GroupDto groupDto);

}
