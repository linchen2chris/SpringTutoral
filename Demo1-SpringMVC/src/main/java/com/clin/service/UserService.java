package com.clin.service;

import com.clin.model.LoginLog;
import com.clin.dao.LoginLogDao;
import com.clin.model.User;
import com.clin.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String username, String password) {
        int matchCount = userDao.getMatchCount(username, password);
        return matchCount > 0;
    }
    public User findUserByUserName(String username) {
        return userDao.findUserByUserName(username);
    }

    @Transactional
    public void loginSuccess(User user) {
        user.setCredit( 5 + user.getCredit());
        LoginLog loginLog = LoginLog.builder()
                .userId(user.getUserId())
                .ip(user.getLastIp())
                .loginDate(user.getLastVisit())
                .build();
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
