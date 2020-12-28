/*
 * This file is generated by jOOQ.
 */
package com.klaus.iv.stockadmin.db.tables.records;


import com.klaus.iv.stockadmin.db.tables.UserExt;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserExtRecord extends UpdatableRecordImpl<UserExtRecord> implements Record11<Long, Long, LocalDateTime, Integer, Long, LocalDateTime, String, String, String, String, String> {

    private static final long serialVersionUID = -1334595643;

    /**
     * Setter for <code>guide.user_ext.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>guide.user_ext.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>guide.user_ext.create_by</code>.
     */
    public void setCreateBy(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>guide.user_ext.create_by</code>.
     */
    public Long getCreateBy() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>guide.user_ext.create_dt</code>.
     */
    public void setCreateDt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>guide.user_ext.create_dt</code>.
     */
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>guide.user_ext.is_delete</code>.
     */
    public void setIsDelete(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>guide.user_ext.is_delete</code>.
     */
    public Integer getIsDelete() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>guide.user_ext.update_by</code>.
     */
    public void setUpdateBy(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>guide.user_ext.update_by</code>.
     */
    public Long getUpdateBy() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>guide.user_ext.update_dt</code>.
     */
    public void setUpdateDt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>guide.user_ext.update_dt</code>.
     */
    public LocalDateTime getUpdateDt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>guide.user_ext.email</code>.
     */
    public void setEmail(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>guide.user_ext.email</code>.
     */
    public String getEmail() {
        return (String) get(6);
    }

    /**
     * Setter for <code>guide.user_ext.mobile</code>.
     */
    public void setMobile(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>guide.user_ext.mobile</code>.
     */
    public String getMobile() {
        return (String) get(7);
    }

    /**
     * Setter for <code>guide.user_ext.openid</code>.
     */
    public void setOpenid(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>guide.user_ext.openid</code>.
     */
    public String getOpenid() {
        return (String) get(8);
    }

    /**
     * Setter for <code>guide.user_ext.password</code>.
     */
    public void setPassword(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>guide.user_ext.password</code>.
     */
    public String getPassword() {
        return (String) get(9);
    }

    /**
     * Setter for <code>guide.user_ext.username</code>.
     */
    public void setUsername(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>guide.user_ext.username</code>.
     */
    public String getUsername() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<Long, Long, LocalDateTime, Integer, Long, LocalDateTime, String, String, String, String, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<Long, Long, LocalDateTime, Integer, Long, LocalDateTime, String, String, String, String, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return UserExt.USER_EXT.ID;
    }

    @Override
    public Field<Long> field2() {
        return UserExt.USER_EXT.CREATE_BY;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return UserExt.USER_EXT.CREATE_DT;
    }

    @Override
    public Field<Integer> field4() {
        return UserExt.USER_EXT.IS_DELETE;
    }

    @Override
    public Field<Long> field5() {
        return UserExt.USER_EXT.UPDATE_BY;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return UserExt.USER_EXT.UPDATE_DT;
    }

    @Override
    public Field<String> field7() {
        return UserExt.USER_EXT.EMAIL;
    }

    @Override
    public Field<String> field8() {
        return UserExt.USER_EXT.MOBILE;
    }

    @Override
    public Field<String> field9() {
        return UserExt.USER_EXT.OPENID;
    }

    @Override
    public Field<String> field10() {
        return UserExt.USER_EXT.PASSWORD;
    }

    @Override
    public Field<String> field11() {
        return UserExt.USER_EXT.USERNAME;
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
        return getEmail();
    }

    @Override
    public String component8() {
        return getMobile();
    }

    @Override
    public String component9() {
        return getOpenid();
    }

    @Override
    public String component10() {
        return getPassword();
    }

    @Override
    public String component11() {
        return getUsername();
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
        return getEmail();
    }

    @Override
    public String value8() {
        return getMobile();
    }

    @Override
    public String value9() {
        return getOpenid();
    }

    @Override
    public String value10() {
        return getPassword();
    }

    @Override
    public String value11() {
        return getUsername();
    }

    @Override
    public UserExtRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public UserExtRecord value2(Long value) {
        setCreateBy(value);
        return this;
    }

    @Override
    public UserExtRecord value3(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public UserExtRecord value4(Integer value) {
        setIsDelete(value);
        return this;
    }

    @Override
    public UserExtRecord value5(Long value) {
        setUpdateBy(value);
        return this;
    }

    @Override
    public UserExtRecord value6(LocalDateTime value) {
        setUpdateDt(value);
        return this;
    }

    @Override
    public UserExtRecord value7(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserExtRecord value8(String value) {
        setMobile(value);
        return this;
    }

    @Override
    public UserExtRecord value9(String value) {
        setOpenid(value);
        return this;
    }

    @Override
    public UserExtRecord value10(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserExtRecord value11(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UserExtRecord values(Long value1, Long value2, LocalDateTime value3, Integer value4, Long value5, LocalDateTime value6, String value7, String value8, String value9, String value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserExtRecord
     */
    public UserExtRecord() {
        super(UserExt.USER_EXT);
    }

    /**
     * Create a detached, initialised UserExtRecord
     */
    public UserExtRecord(Long id, Long createBy, LocalDateTime createDt, Integer isDelete, Long updateBy, LocalDateTime updateDt, String email, String mobile, String openid, String password, String username) {
        super(UserExt.USER_EXT);

        set(0, id);
        set(1, createBy);
        set(2, createDt);
        set(3, isDelete);
        set(4, updateBy);
        set(5, updateDt);
        set(6, email);
        set(7, mobile);
        set(8, openid);
        set(9, password);
        set(10, username);
    }
}