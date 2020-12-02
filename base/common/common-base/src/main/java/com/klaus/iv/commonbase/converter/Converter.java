package com.klaus.iv.commonbase.converter;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Converter<T, U> {

    // 从 T 转换为 U
    private Function<T, U> fromVo;

    // 从 U 转换为 T
    private Function<U, T> fromPo;

    public Converter(final Function<T, U> fromVo, final Function<U, T> fromPo) {
        this.fromVo = fromVo;
        this.fromPo = fromPo;
    }

    public final U converterFromDto(final T dto){
        return fromVo.apply(dto);
    }

    public final T converterFromEntity(final U entity){
        return fromPo.apply(entity);
    }

    public final List<U> batchConverterFromDto(final List<T> vos){
        return vos.stream().map(this::converterFromDto).collect(Collectors.toList());
    }

    public final List<T> batchConverterFromEntity(final List<U> entities){
        return entities.stream().map(this::converterFromEntity).collect(Collectors.toList());
    }
}
