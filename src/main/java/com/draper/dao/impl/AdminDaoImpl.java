package com.draper.dao.impl;

import com.draper.dao.AdminDao;
import com.draper.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao {

    private HibernateTemplate hibernateTemplate;

    public void add(Object object) {
        Admin admin = (Admin) object;
        hibernateTemplate.save(admin);
    }

    public void update(Object object) {
        Admin admin = (Admin) object;
        hibernateTemplate.update(admin);
    }

    public boolean isSuccess(Admin admin) {
        Admin adm = hibernateTemplate.get(Admin.class, admin.getAccount());
        String account = admin.getAccount();
        String psd = admin.getPassword();
        if (adm.getAccount().equals(account) && adm.getPassword().equals(psd)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Admin admin) {
        return false;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
