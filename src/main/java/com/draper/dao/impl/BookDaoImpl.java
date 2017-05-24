package com.draper.dao.impl;

import com.draper.dao.BookDao;
import com.draper.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    private HibernateTemplate hibernateTemplate;

//    private LogDao logDao;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void add(Object object) {
        Book book = (Book) object;
        hibernateTemplate.save(book);

    }

//    @Autowired
//    public void setLogDao(LogDao logDao) {
//        this.logDao = logDao;
//    }
}
