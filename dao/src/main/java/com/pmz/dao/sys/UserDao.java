package com.pmz.dao.sys;

import com.pmz.dao.base.proxy.CrudDao;
import com.pmz.model.sys.User;

/**
 * Created by Administrator on 2016/12/23.
 */
public interface UserDao extends CrudDao<User> {

    public User getByLoginName(User user);

}
