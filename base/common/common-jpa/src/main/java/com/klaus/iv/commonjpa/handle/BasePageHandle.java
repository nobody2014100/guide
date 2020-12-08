package com.klaus.iv.commonjpa.handle;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectLimitStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableField;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePageHandle<T> {
    private DSLContext dsl;
    private Pageable pageable;
    private Class<T> type;

    protected BasePageHandle(DSLContext dsl, Pageable pageable, Class<T> type) {
        this.dsl = dsl;
        this.pageable = pageable;
        this.type = type;
    }

    /**
     * sql查询的列集合
     *
     * @return sql查询的列集合
     */
    public abstract Field[] fields();

    /**
     * form及之后的sql
     *
     * @param selectColumns 查询语句的select部分
     * @return 完整的sql
     */
    public abstract SelectLimitStep<Record> beginWithFormSql(SelectSelectStep selectColumns);

    public Page<T> fetch() {
        int total = beginWithFormSql(dsl.selectCount()).fetchOneInto(int.class);
        int pageNumber = pageable.getPageNumber() > 1 ? pageable.getPageNumber() - 1 : 0;
        List<T> list;
        if (total != 0) {
            list = beginWithFormSql(dsl.select(fields() == null ? new TableField[]{} : fields()))
                    .limit(pageable.getPageSize())
                    .offset(pageNumber * pageable.getPageSize()).fetchInto(type);
        } else {
            list = new ArrayList<>();
        }
        return new PageImpl<>(list, pageable, total);
    }
}
