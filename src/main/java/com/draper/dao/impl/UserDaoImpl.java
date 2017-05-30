package com.draper.dao.impl;

import com.draper.dao.UserDao;
import com.draper.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private HibernateTemplate hibernateTemplate;

    public void add(Object object) {
        User user = (User) object;
        hibernateTemplate.save(user);
    }

    public void update(Object object) {
        User user = (User) object;
        hibernateTemplate.update(user);
    }

    public boolean isSuccess(Object object) {
        User user = (User) object;
        String relAccount = user.getAccount();
        String relPassword = user.getPassword();
        User susUser = hibernateTemplate.get(User.class, relAccount);
        if (susUser.getPassword().equals(relPassword)){
            return true;
        } else {
            return false;
        }
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
