package com.draper.dao.impl;

import com.draper.dao.BorrowBookDao;
import com.draper.domain.BorrowBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class BorrowBookDaoImpl implements BorrowBookDao {

    private HibernateTemplate hibernateTemplate;

    public void add(Object object) {
        BorrowBook borrowBook = (BorrowBook) object;
        hibernateTemplate.save(borrowBook);
    }

    public void update(Object object) {
        BorrowBook borrowBook = (BorrowBook) object;
        hibernateTemplate.update(borrowBook);
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
