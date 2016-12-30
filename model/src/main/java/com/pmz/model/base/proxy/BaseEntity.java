package com.pmz.model.base.proxy;

import com.pmz.model.sys.User;

import java.io.Serializable;

/**
 * Created by pmz on 16-12-25.
 */
public abstract class BaseEntity<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";

    protected String id;
    protected User currentUser;
    public BaseEntity(){

    }

    public BaseEntity(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
