package com.pmz.model.sys;

import com.pmz.model.base.proxy.DataEntity;
import org.apache.ibatis.type.Alias;

/**
 * Created by XueSong on 2016/10/2.
 */
@Alias("user")
public class User extends DataEntity<User>{

    private static final long serialVersionUID = 1L;
    private String id;		//用户id
    private String loginName;	//用户名
    private String pwd; 	//密码
    private String name;		//姓名
    private String loginDate;	//最后登录时间
    private String loginIp;		//用户登录ip地址

    public User(){
        super();
    }
    public User(String id, String loginName){
        super(id);
        this.loginName = loginName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

}
