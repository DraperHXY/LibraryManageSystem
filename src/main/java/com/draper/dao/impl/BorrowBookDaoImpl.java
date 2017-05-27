package com.draper.dao.impl;

import com.draper.dao.BorrowBookDao;
import com.draper.dao.LogDao;
import com.draper.domain.BorrowBook;
import com.draper.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.Date;

public class BorrowBookDaoImpl implements BorrowBookDao {

    private HibernateTemplate hibernateTemplate;
    private LogDao logDao;


    public void add(Object object) {
        BorrowBook borrowBook = (BorrowBook) object;
        hibernateTemplate.save(borrowBook);
        Log log = new Log();
        log.setType("INFO");
        log.setDate(new Date());
        log.setDetail("Add Borrow");
        logDao.add(log);
    }

    public boolean update(Object object) {
        BorrowBook borrowBook = (BorrowBook) object;
        hibernateTemplate.update(borrowBook);
        Log log = new Log();
        log.setType("INFO");
        log.setDate(new Date());
        log.setDetail("Update Borrow");
        logDao.add(log);
        return true;
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
