package com.pmz.dao.base.proxy;


/**
 * Created by Administrator on 2016/12/23.
 */
public interface CrudDao<T> extends BaseDao{

    public T get(String id);

    public T get(T entity);

    public int insert(T entity);

    public T insertBack(T entity);


}
