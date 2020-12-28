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
public class User implements Serializable {

    private static final long serialVersionUID = 1695763007;

    private Long          id;
    private Long          createBy;
    private LocalDateTime createDt;
    private Integer       isDelete;
    private Long          updateBy;
    private LocalDateTime updateDt;
    private String        email;
    private String        mobile;
    private String        openid;
    private String        password;
    private Integer       userType;
    private String        username;

    public User() {}

    public User(User value) {
        this.id = value.id;
        this.createBy = value.createBy;
        this.createDt = value.createDt;
        this.isDelete = value.isDelete;
        this.updateBy = value.updateBy;
        this.updateDt = value.updateDt;
        this.email = value.email;
        this.mobile = value.mobile;
        this.openid = value.openid;
        this.password = value.password;
        this.userType = value.userType;
        this.username = value.username;
    }

    public User(
        Long          id,
        Long          createBy,
        LocalDateTime createDt,
        Integer       isDelete,
        Long          updateBy,
        LocalDateTime updateDt,
        String        email,
        String        mobile,
        String        openid,
        String        password,
        Integer       userType,
        String        username
    ) {
        this.id = id;
        this.createBy = createBy;
        this.createDt = createDt;
        this.isDelete = isDelete;
        this.updateBy = updateBy;
        this.updateDt = updateDt;
        this.email = email;
        this.mobile = mobile;
        this.openid = openid;
        this.password = password;
        this.userType = userType;
        this.username = username;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return this.userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(id);
        sb.append(", ").append(createBy);
        sb.append(", ").append(createDt);
        sb.append(", ").append(isDelete);
        sb.append(", ").append(updateBy);
        sb.append(", ").append(updateDt);
        sb.append(", ").append(email);
        sb.append(", ").append(mobile);
        sb.append(", ").append(openid);
        sb.append(", ").append(password);
        sb.append(", ").append(userType);
        sb.append(", ").append(username);

        sb.append(")");
        return sb.toString();
    }
}