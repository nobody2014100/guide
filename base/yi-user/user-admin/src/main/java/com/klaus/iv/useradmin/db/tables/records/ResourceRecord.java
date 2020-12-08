/*
 * This file is generated by jOOQ.
 */
package com.klaus.iv.useradmin.db.tables.records;


import com.klaus.iv.useradmin.db.tables.Resource;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ResourceRecord extends UpdatableRecordImpl<ResourceRecord> implements Record8<Long, Long, LocalDateTime, Integer, Long, LocalDateTime, String, String> {

    private static final long serialVersionUID = -1987172294;

    /**
     * Setter for <code>user_center.resource.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>user_center.resource.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>user_center.resource.create_by</code>.
     */
    public void setCreateBy(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>user_center.resource.create_by</code>.
     */
    public Long getCreateBy() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>user_center.resource.create_dt</code>.
     */
    public void setCreateDt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>user_center.resource.create_dt</code>.
     */
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>user_center.resource.is_delete</code>.
     */
    public void setIsDelete(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>user_center.resource.is_delete</code>.
     */
    public Integer getIsDelete() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>user_center.resource.update_by</code>.
     */
    public void setUpdateBy(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>user_center.resource.update_by</code>.
     */
    public Long getUpdateBy() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>user_center.resource.update_dt</code>.
     */
    public void setUpdateDt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>user_center.resource.update_dt</code>.
     */
    public LocalDateTime getUpdateDt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>user_center.resource.code</code>.
     */
    public void setCode(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>user_center.resource.code</code>.
     */
    public String getCode() {
        return (String) get(6);
    }

    /**
     * Setter for <code>user_center.resource.name</code>.
     */
    public void setName(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>user_center.resource.name</code>.
     */
    public String getName() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, LocalDateTime, Integer, Long, LocalDateTime, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Long, Long, LocalDateTime, Integer, Long, LocalDateTime, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Resource.RESOURCE.ID;
    }

    @Override
    public Field<Long> field2() {
        return Resource.RESOURCE.CREATE_BY;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Resource.RESOURCE.CREATE_DT;
    }

    @Override
    public Field<Integer> field4() {
        return Resource.RESOURCE.IS_DELETE;
    }

    @Override
    public Field<Long> field5() {
        return Resource.RESOURCE.UPDATE_BY;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Resource.RESOURCE.UPDATE_DT;
    }

    @Override
    public Field<String> field7() {
        return Resource.RESOURCE.CODE;
    }

    @Override
    public Field<String> field8() {
        return Resource.RESOURCE.NAME;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getCreateBy();
    }

    @Override
    public LocalDateTime component3() {
        return getCreateDt();
    }

    @Override
    public Integer component4() {
        return getIsDelete();
    }

    @Override
    public Long component5() {
        return getUpdateBy();
    }

    @Override
    public LocalDateTime component6() {
        return getUpdateDt();
    }

    @Override
    public String component7() {
        return getCode();
    }

    @Override
    public String component8() {
        return getName();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getCreateBy();
    }

    @Override
    public LocalDateTime value3() {
        return getCreateDt();
    }

    @Override
    public Integer value4() {
        return getIsDelete();
    }

    @Override
    public Long value5() {
        return getUpdateBy();
    }

    @Override
    public LocalDateTime value6() {
        return getUpdateDt();
    }

    @Override
    public String value7() {
        return getCode();
    }

    @Override
    public String value8() {
        return getName();
    }

    @Override
    public ResourceRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ResourceRecord value2(Long value) {
        setCreateBy(value);
        return this;
    }

    @Override
    public ResourceRecord value3(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public ResourceRecord value4(Integer value) {
        setIsDelete(value);
        return this;
    }

    @Override
    public ResourceRecord value5(Long value) {
        setUpdateBy(value);
        return this;
    }

    @Override
    public ResourceRecord value6(LocalDateTime value) {
        setUpdateDt(value);
        return this;
    }

    @Override
    public ResourceRecord value7(String value) {
        setCode(value);
        return this;
    }

    @Override
    public ResourceRecord value8(String value) {
        setName(value);
        return this;
    }

    @Override
    public ResourceRecord values(Long value1, Long value2, LocalDateTime value3, Integer value4, Long value5, LocalDateTime value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ResourceRecord
     */
    public ResourceRecord() {
        super(Resource.RESOURCE);
    }

    /**
     * Create a detached, initialised ResourceRecord
     */
    public ResourceRecord(Long id, Long createBy, LocalDateTime createDt, Integer isDelete, Long updateBy, LocalDateTime updateDt, String code, String name) {
        super(Resource.RESOURCE);

        set(0, id);
        set(1, createBy);
        set(2, createDt);
        set(3, isDelete);
        set(4, updateBy);
        set(5, updateDt);
        set(6, code);
        set(7, name);
    }
}
