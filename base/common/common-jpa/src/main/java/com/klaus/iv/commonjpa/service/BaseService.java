package com.klaus.iv.commonjpa.service;

import com.klaus.iv.commonbase.model.vo.BaseVo;
import com.klaus.iv.commonjpa.po.BasePo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService <T extends BasePo, E>{

    /**
     * 保存实体
     *
     * @param po 待保存的实体
     */
    void save(T po);

    /**
     * 更新实体
     *
     * @param po 持久化对象
     */
    void update(T po);

    /**
     * 分页查询
     *
     * @param pageable 分页
     * @return spring-data的分页对象
     */
    <R extends BaseVo> Page<R>  list(Pageable pageable);


}
