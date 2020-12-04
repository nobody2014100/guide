package com.klaus.iv.stockadmin.service;

import com.klaus.iv.stockapi.dto.UserGroupDto;
import com.klaus.iv.stockapi.vo.UserGroupVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserGroupService {


    public Page<UserGroupVo> findPage(Pageable pageable);
    public UserGroupVo findById(Long id);
    public void deleteById(Long id);
    public void save(UserGroupDto userGroupDto);

}
