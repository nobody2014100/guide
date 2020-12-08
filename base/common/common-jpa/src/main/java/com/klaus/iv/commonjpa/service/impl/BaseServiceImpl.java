package com.klaus.iv.commonjpa.service.impl;

import com.klaus.iv.commonbase.model.vo.BaseVo;
import com.klaus.iv.commonjpa.po.BasePo;
import com.klaus.iv.commonjpa.repo.BaseRepo;
import com.klaus.iv.commonjpa.service.BaseService;
import org.jooq.DSLContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @param <T>
 * @param <E>
 */
public abstract class BaseServiceImpl<T extends BasePo, E> implements BaseService<T, E> {
    protected DSLContext dsl;
    protected BaseRepo<T, E> baseRepo;

    public BaseServiceImpl(DSLContext dsl, BaseRepo baseRepo) {
        this.dsl = dsl;
        this.baseRepo = baseRepo;
    }
    @Override
    public void save(T entity) {
        baseRepo.save(entity);
    }

    @Override
    public void update(T po) {
        baseRepo.save(po);
    }

    @Override
    public <R extends BaseVo> Page<R> list(Pageable pageable) {
        Page<T> page =  baseRepo.findAll(pageable);
        List<R> data = (List<R>) page.getContent().stream().map(item -> converterVo(item)).collect(Collectors.toList());
        return new PageImpl<R>(data,pageable, page.getTotalElements());
    }

    public abstract <R extends BaseVo> R converterVo(T t);



}