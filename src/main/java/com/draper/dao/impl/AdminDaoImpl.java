package com.draper.dao.impl;

import com.draper.dao.AdminDao;
import com.draper.dao.LogDao;
import com.draper.domain.Admin;
import com.draper.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class AdminDaoImpl implements AdminDao {

    private HibernateTemplate hibernateTemplate;
    private LogDao logDao;

    public void add(Object object) {
        Admin admin = (Admin) object;
        hibernateTemplate.save(admin);
        Log log = new Log();
        log.setType("INFO");
        log.setDate(new Date());
        log.setDetail("Add admin");
        logDao.add(log);
    }

    public boolean update(Object object) {
        Admin admin = (Admin) object;
            hibernateTemplate.update(admin);
            Log log = new Log();
            log.setType("INFO");
            log.setDate(new Date());
            log.setDetail("Update admin");
            logDao.add(log);

            return true;

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

    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }
}
