/*
 * This file is generated by jOOQ.
 */
package com.klaus.iv.stockadmin.db.tables;


import com.klaus.iv.stockadmin.db.Guide;
import com.klaus.iv.stockadmin.db.Keys;
import com.klaus.iv.stockadmin.db.tables.records.UserAddressRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserAddress extends TableImpl<UserAddressRecord> {

    private static final long serialVersionUID = -649917236;

    /**
     * The reference instance of <code>guide.user_address</code>
     */
    public static final UserAddress USER_ADDRESS = new UserAddress();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserAddressRecord> getRecordType() {
        return UserAddressRecord.class;
    }

    /**
     * The column <code>guide.user_address.id</code>.
     */
    public final TableField<UserAddressRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>guide.user_address.create_by</code>.
     */
    public final TableField<UserAddressRecord, Long> CREATE_BY = createField(DSL.name("create_by"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>guide.user_address.create_dt</code>.
     */
    public final TableField<UserAddressRecord, LocalDateTime> CREATE_DT = createField(DSL.name("create_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>guide.user_address.is_delete</code>.
     */
    public final TableField<UserAddressRecord, Integer> IS_DELETE = createField(DSL.name("is_delete"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>guide.user_address.update_by</code>.
     */
    public final TableField<UserAddressRecord, Long> UPDATE_BY = createField(DSL.name("update_by"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>guide.user_address.update_dt</code>.
     */
    public final TableField<UserAddressRecord, LocalDateTime> UPDATE_DT = createField(DSL.name("update_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>guide.user_address.address_id</code>.
     */
    public final TableField<UserAddressRecord, Long> ADDRESS_ID = createField(DSL.name("address_id"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>guide.user_address.user_id</code>.
     */
    public final TableField<UserAddressRecord, Long> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>guide.user_address</code> table reference
     */
    public UserAddress() {
        this(DSL.name("user_address"), null);
    }

    /**
     * Create an aliased <code>guide.user_address</code> table reference
     */
    public UserAddress(String alias) {
        this(DSL.name(alias), USER_ADDRESS);
    }

    /**
     * Create an aliased <code>guide.user_address</code> table reference
     */
    public UserAddress(Name alias) {
        this(alias, USER_ADDRESS);
    }

    private UserAddress(Name alias, Table<UserAddressRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserAddress(Name alias, Table<UserAddressRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> UserAddress(Table<O> child, ForeignKey<O, UserAddressRecord> key) {
        super(child, key, USER_ADDRESS);
    }

    @Override
    public Schema getSchema() {
        return Guide.GUIDE;
    }

    @Override
    public Identity<UserAddressRecord, Long> getIdentity() {
        return Keys.IDENTITY_USER_ADDRESS;
    }

    @Override
    public UniqueKey<UserAddressRecord> getPrimaryKey() {
        return Keys.KEY_USER_ADDRESS_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserAddressRecord>> getKeys() {
        return Arrays.<UniqueKey<UserAddressRecord>>asList(Keys.KEY_USER_ADDRESS_PRIMARY);
    }

    @Override
    public UserAddress as(String alias) {
        return new UserAddress(DSL.name(alias), this);
    }

    @Override
    public UserAddress as(Name alias) {
        return new UserAddress(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAddress rename(String name) {
        return new UserAddress(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAddress rename(Name name) {
        return new UserAddress(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, LocalDateTime, Integer, Long, LocalDateTime, Long, Long> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
