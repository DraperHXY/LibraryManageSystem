package com.draper.dao.impl;

import com.draper.dao.LogDao;
import com.draper.dao.UserDao;
import com.draper.domain.Log;
import com.draper.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class UserDaoImpl implements UserDao {

    private HibernateTemplate hibernateTemplate;
    private LogDao logDao;

    public void add(Object object) {
        User user = (User) object;
        hibernateTemplate.save(user);
        Log log = new Log();
        log.setDate(new Date());
        log.setType("INFO");
        log.setDetail("Add User");
        logDao.add(log);
    }

    public boolean update(Object object) {
        User user = (User) object;
        hibernateTemplate.update(user);
        Log log = new Log();
        log.setDate(new Date());
        log.setType("INFO");
        log.setDetail("Update User");
        logDao.add(log);
        return true;
    }

    public boolean isSuccess(Object object) {
        User user = (User) object;
        String relAccount = user.getAccount();
        String relPassword = user.getPassword();
        User susUser = hibernateTemplate.get(User.class, relAccount);
        Log log = new Log();
        log.setDate(new Date());
        if (susUser.getPassword().equals(relPassword)){
            log.setType("INFO");
            log.setDetail("User Success TRUE");
            logDao.add(log);
            return true;

        }
        log.setType("WARM");
        log.setDetail("User Success FALSE");
        logDao.add(log);
        return false;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public LogDao getLogDao() {
        return logDao;
    }

    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }
}
