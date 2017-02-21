package com.pmz.model.sys;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.pmz.model.base.proxy.DataEntity;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

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

    private List<Identity> identityList = new ArrayList<>();


    public User(){
        super();
    }
    public User(String id, String loginName){
        super(id);
        this.loginName = loginName;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equal(getLoginName(), user.getLoginName()) &&
                Objects.equal(getPwd(), user.getPwd()) &&
                Objects.equal(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLoginName(), getPwd(), getName());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("loginName", loginName)
                .add("pwd", pwd)
                .add("name", name)
                .add("loginDate", loginDate)
                .add("loginIp", loginIp)
                .add("identityList", identityList)
                .toString();
    }
}
