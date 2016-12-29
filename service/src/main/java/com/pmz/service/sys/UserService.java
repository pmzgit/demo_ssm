package com.pmz.service.sys;

import com.pmz.dao.base.DaoSupport;
import com.pmz.dao.sys.UserDao;
import com.pmz.model.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/11/15.
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserDao userDao;

    /*
    * 保存用户
    */
    @Transactional(readOnly = false)
    public User save(User user)throws Exception{
        userDao.insert(user);
        return user;
    }
}
