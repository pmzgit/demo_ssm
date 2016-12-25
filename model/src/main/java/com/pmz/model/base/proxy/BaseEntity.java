package com.pmz.model.base.proxy;

import com.pmz.model.sys.User;

import java.io.Serializable;

/**
 * Created by pmz on 16-12-25.
 */
public abstract class BaseEntity<T> implements Serializable{
    private static final long serialVersionUID = 1L;


    protected String id;

    protected User currentUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
