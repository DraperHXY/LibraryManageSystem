package com.draper.dao.impl;

import com.draper.dao.BookDao;
import com.draper.dao.LogDao;
import com.draper.domain.Book;
import com.draper.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private HibernateTemplate hibernateTemplate;
    private LogDao logDao;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
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

    /**
     * @param id
     * @deprecated
     */
    public void delete(int id) {
    }


    /**
     * 通过 ISBN 查询
     *
     * @param isbn 主键
     * @return
     */
    public Book findByIsbn(String isbn) {
        Book book = hibernateTemplate.get(Book.class, isbn);
        Log log = new Log();
        log.setType("INFO");
        log.setDate(new Date());
        log.setDetail("Find Book By ISBN " + book.toString());
        logDao.add(log);
        return book;
    }

    /**
     * 通过 name 书名进行查询
     *
     * @param name
     * @return
     */
    public List<Book> findByName(String name) {
        String hql = "from Book where name = '" + name + "'";
        List<Book> bookList = (List<Book>) hibernateTemplate.find(hql);
        Log log = new Log();
        log.setType("INFO");
        log.setDate(new Date());
        log.setDetail("Find BookList By Name, name = " + name);
        logDao.add(log);
        return bookList;
    }

    public void deleteByIsbn(String isbn) {
        Book book = findByIsbn(isbn);
        hibernateTemplate.delete(book);
        Log log = new Log();
        log.setType("INFO");
        log.setDate(new Date());
        log.setDetail("Delete Book By ISBN, " + book.toString());
        logDao.add(log);
    }

    /**
     * 当且仅当数据库中有这条数据时才可以进行 update 操作
     *
     * @param object
     */
    public boolean update(Object object) {
        Book book = (Book) object;
        hibernateTemplate.update(book);
        return true;
    }
}
