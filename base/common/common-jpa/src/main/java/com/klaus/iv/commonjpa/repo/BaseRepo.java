package com.klaus.iv.commonjpa.repo;

import com.klaus.iv.commonjpa.po.BasePo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepo<T extends BasePo, E> extends JpaRepository<T, E> {
}