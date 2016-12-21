package com.pmz.model.sys;

import org.apache.ibatis.type.Alias;

/**
 * Created by XueSong on 2016/10/2.
 */
@Alias("user")
public class User {

    private String id;		//用户id
    private String userName;	//用户名
    private String pwd; 	//密码
    private String name;		//姓名
    private String lastLogin;	//最后登录时间
    private String ip;			//用户登录ip地址
    private Integer status;//状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User() {
    }
}
