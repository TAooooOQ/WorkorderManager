package com.ash.workorder.dao.po;


import java.util.Date;

/**
 * @Created by Ash on 2019/6/9 11:30
 */
public class UserPo {

    private Integer id;
    private String username;
    private String password;
    private String realname;
    private Boolean activate;
    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserPo{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", activate='").append(activate).append('\'');
        sb.append(",lastLoginTime'").append(lastLoginTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
