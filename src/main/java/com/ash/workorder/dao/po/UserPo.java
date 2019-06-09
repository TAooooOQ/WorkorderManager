package com.ash.workorder.dao.po;


import java.util.Date;

/**
 * @Created by Ash on 2019/6/9 11:30
 */
public class UserPo {
    private Integer id;
    private String email;
    private String password;
    private boolean actived;
    private Date last_login_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserPo{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", actived='").append(actived).append('\'');
        sb.append(",last_login_time'").append(last_login_time).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
