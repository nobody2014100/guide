/*
 * This file is generated by jOOQ.
 */
package com.klaus.iv.stockadmin.db.tables;


import com.klaus.iv.stockadmin.db.Guide;
import com.klaus.iv.stockadmin.db.Keys;
import com.klaus.iv.stockadmin.db.tables.records.RoleResourceRecord;

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
public class RoleResource extends TableImpl<RoleResourceRecord> {

    private static final long serialVersionUID = -901218635;

    /**
     * The reference instance of <code>guide.role_resource</code>
     */
    public static final RoleResource ROLE_RESOURCE = new RoleResource();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoleResourceRecord> getRecordType() {
        return RoleResourceRecord.class;
    }

    /**
     * The column <code>guide.role_resource.id</code>.
     */
    public final TableField<RoleResourceRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>guide.role_resource.create_by</code>.
     */
    public final TableField<RoleResourceRecord, Long> CREATE_BY = createField(DSL.name("create_by"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>guide.role_resource.create_dt</code>.
     */
    public final TableField<RoleResourceRecord, LocalDateTime> CREATE_DT = createField(DSL.name("create_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>guide.role_resource.is_delete</code>.
     */
    public final TableField<RoleResourceRecord, Integer> IS_DELETE = createField(DSL.name("is_delete"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>guide.role_resource.update_by</code>.
     */
    public final TableField<RoleResourceRecord, Long> UPDATE_BY = createField(DSL.name("update_by"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>guide.role_resource.update_dt</code>.
     */
    public final TableField<RoleResourceRecord, LocalDateTime> UPDATE_DT = createField(DSL.name("update_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>guide.role_resource.resource_id</code>.
     */
    public final TableField<RoleResourceRecord, Long> RESOURCE_ID = createField(DSL.name("resource_id"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>guide.role_resource.role_id</code>.
     */
    public final TableField<RoleResourceRecord, Long> ROLE_ID = createField(DSL.name("role_id"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>guide.role_resource</code> table reference
     */
    public RoleResource() {
        this(DSL.name("role_resource"), null);
    }

    /**
     * Create an aliased <code>guide.role_resource</code> table reference
     */
    public RoleResource(String alias) {
        this(DSL.name(alias), ROLE_RESOURCE);
    }

    /**
     * Create an aliased <code>guide.role_resource</code> table reference
     */
    public RoleResource(Name alias) {
        this(alias, ROLE_RESOURCE);
    }

    private RoleResource(Name alias, Table<RoleResourceRecord> aliased) {
        this(alias, aliased, null);
    }

    private RoleResource(Name alias, Table<RoleResourceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> RoleResource(Table<O> child, ForeignKey<O, RoleResourceRecord> key) {
        super(child, key, ROLE_RESOURCE);
    }

    @Override
    public Schema getSchema() {
        return Guide.GUIDE;
    }

    @Override
    public Identity<RoleResourceRecord, Long> getIdentity() {
        return Keys.IDENTITY_ROLE_RESOURCE;
    }

    @Override
    public UniqueKey<RoleResourceRecord> getPrimaryKey() {
        return Keys.KEY_ROLE_RESOURCE_PRIMARY;
    }

    @Override
    public List<UniqueKey<RoleResourceRecord>> getKeys() {
        return Arrays.<UniqueKey<RoleResourceRecord>>asList(Keys.KEY_ROLE_RESOURCE_PRIMARY);
    }

    @Override
    public RoleResource as(String alias) {
        return new RoleResource(DSL.name(alias), this);
    }

    @Override
    public RoleResource as(Name alias) {
        return new RoleResource(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RoleResource rename(String name) {
        return new RoleResource(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RoleResource rename(Name name) {
        return new RoleResource(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, LocalDateTime, Integer, Long, LocalDateTime, Long, Long> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
