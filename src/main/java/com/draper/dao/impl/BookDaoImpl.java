package com.draper.dao.impl;

import com.draper.dao.BookDao;
import com.draper.dao.LogDao;
import com.draper.domain.Book;
import com.draper.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class BookDaoImpl implements BookDao {

    private HibernateTemplate hibernateTemplate;

    private LogDao logDao;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void add(Object object) {
        Book book = (Book) object;

        Log bookLog = new Log();
        bookLog.setType("INFO");
        bookLog.setDate(new Date());
        bookLog.setDetail("Add Book");
        bookLog.setDetail(book.toString());
        hibernateTemplate.save(book);
        logDao.add(bookLog);

    }

    public void delete(int id) {
        Book book = get(id);
        hibernateTemplate.delete(book);
    }

    public Book get(int id){
        Book book = hibernateTemplate.get(Book.class,id);
        return book;
    }

    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }
}
