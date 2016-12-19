package com.pmz.service.sys;

import com.pmz.dao.base.DaoSupport;
import com.pmz.model.sys.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/11/15.
 */
@Service("userService")
public class UserService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /*
    * 保存用户
    */
    @Transactional
    public void save(User user)throws Exception{
        dao.save("UserDao.save", user);
    }
}
