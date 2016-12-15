package com.pmz.service.auth;

import com.pmz.dao.DaoSupport;
import com.pmz.model.PageData;
import com.pmz.model.auth.User;
import org.springframework.stereotype.Service;

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
    public void saveU(PageData pd)throws Exception{
        dao.save("UserMapper.save", pd);
    }
}
