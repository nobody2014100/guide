/*
 * This file is generated by jOOQ.
 */
package com.klaus.iv.stockadmin.db.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Address implements Serializable {

    private static final long serialVersionUID = 163296894;

    private Long          id;
    private Long          createBy;
    private LocalDateTime createDt;
    private Integer       isDelete;
    private Long          updateBy;
    private LocalDateTime updateDt;
    private String        city;
    private String        country;
    private String        detail;
    private String        fixTelephone;
    private String        mobile;
    private String        province;
    private String        street;
    private Integer       type;
    private String        zipCode;

    public Address() {}

    public Address(Address value) {
        this.id = value.id;
        this.createBy = value.createBy;
        this.createDt = value.createDt;
        this.isDelete = value.isDelete;
        this.updateBy = value.updateBy;
        this.updateDt = value.updateDt;
        this.city = value.city;
        this.country = value.country;
        this.detail = value.detail;
        this.fixTelephone = value.fixTelephone;
        this.mobile = value.mobile;
        this.province = value.province;
        this.street = value.street;
        this.type = value.type;
        this.zipCode = value.zipCode;
    }

    public Address(
        Long          id,
        Long          createBy,
        LocalDateTime createDt,
        Integer       isDelete,
        Long          updateBy,
        LocalDateTime updateDt,
        String        city,
        String        country,
        String        detail,
        String        fixTelephone,
        String        mobile,
        String        province,
        String        street,
        Integer       type,
        String        zipCode
    ) {
        this.id = id;
        this.createBy = createBy;
        this.createDt = createDt;
        this.isDelete = isDelete;
        this.updateBy = updateBy;
        this.updateDt = updateDt;
        this.city = city;
        this.country = country;
        this.detail = detail;
        this.fixTelephone = fixTelephone;
        this.mobile = mobile;
        this.province = province;
        this.street = street;
        this.type = type;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Long getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateDt() {
        return this.updateDt;
    }

    public void setUpdateDt(LocalDateTime updateDt) {
        this.updateDt = updateDt;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFixTelephone() {
        return this.fixTelephone;
    }

    public void setFixTelephone(String fixTelephone) {
        this.fixTelephone = fixTelephone;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Address (");

        sb.append(id);
        sb.append(", ").append(createBy);
        sb.append(", ").append(createDt);
        sb.append(", ").append(isDelete);
        sb.append(", ").append(updateBy);
        sb.append(", ").append(updateDt);
        sb.append(", ").append(city);
        sb.append(", ").append(country);
        sb.append(", ").append(detail);
        sb.append(", ").append(fixTelephone);
        sb.append(", ").append(mobile);
        sb.append(", ").append(province);
        sb.append(", ").append(street);
        sb.append(", ").append(type);
        sb.append(", ").append(zipCode);

        sb.append(")");
        return sb.toString();
    }
}