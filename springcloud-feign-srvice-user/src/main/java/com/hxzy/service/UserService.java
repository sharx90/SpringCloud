package com.hxzy.service;

import com.hxzy.bean.User;
import com.hxzy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

}
