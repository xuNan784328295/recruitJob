package com.hanvon.zhaopin.types;

import java.io.Serializable;

/**
 * @author Andy Yin(andy@centframe.com)
 */
public class SessionalUser implements Serializable {
    private Long id;         //主键
    private String userName; //用户帐号，登陆用户名
    private String realName; //真实姓名
    private String employId; //工号
    private String email;    //电子邮箱
    private Integer gender;  //性别，-1:未知,0:女,1:男
    private String permissions; //权限
    private Long loginTime; //登陆时间
    private Boolean hasLevelAuthority = false; //是否达到特定层级权限
    /**
     * 判断是否是管理员
     */
    public boolean isAdmin() {
        return "admin".equalsIgnoreCase(userName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Boolean getHasLevelAuthority() {
        return hasLevelAuthority;
    }

    public void setHasLevelAuthority(Boolean hasLevelAuthority) {
        this.hasLevelAuthority = hasLevelAuthority;
    }
}
