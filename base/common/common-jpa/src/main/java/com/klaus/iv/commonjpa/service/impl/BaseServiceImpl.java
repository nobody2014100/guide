package com.klaus.iv.commonjpa.service.impl;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import com.klaus.iv.commonbase.model.vo.BaseVo;
import com.klaus.iv.commonjpa.po.BasePo;
import com.klaus.iv.commonjpa.repo.BaseRepo;
import com.klaus.iv.commonjpa.service.BaseService;
import org.jooq.DSLContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
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
    public void update(T entity) {
        baseRepo.save(entity);
    }

    @Override
    public <D extends BaseDto> void save(D dto) {
        baseRepo.save(converterToEntity(dto));
    }

    @Override
    public <D extends BaseDto> void update(D dto) {
        baseRepo.save(converterToEntity(dto));
    }

    @Override
    public void deleteById(E id) {
        baseRepo.deleteById(id);
    }

    @Override
    public <V extends BaseVo> V findById(E id) {
        Optional<T> tOptional = baseRepo.findById(id);
        if (tOptional.isPresent()) {
            return converterToVo(tOptional.get());
        }
        return null;
    }

    @Override
    public <V extends BaseVo> Page<V> findAllWithPage(Pageable pageable) {
        Page<T> page =  baseRepo.findAll(pageable);
        List<V> data = page.getContent().stream().map(item -> (V) converterToVo(item)).collect(Collectors.toList());
        return new PageImpl<V>(data,pageable, page.getTotalElements());
    }

    @Override
    public Page<T> listAllWithPage(Pageable pageable) {
        return   baseRepo.findAll(pageable);
    }

    public abstract <V extends BaseVo> V converterToVo(T t);

    public abstract <D extends BaseDto> T converterToEntity(D dto);
}