package com.draper.dao.impl;

import com.draper.dao.BookDao;
import com.draper.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private HibernateTemplate hibernateTemplate;

    public void add(Object object) {
        Book book = (Book) object;
        hibernateTemplate.save(book);
    }

    /**
     * 通过 ISBN 查询
     *
     * @param isbn 主键
     * @return
     */
    public Book findByIsbn(String isbn) {
        Book book = hibernateTemplate.get(Book.class, isbn);
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
        return bookList;
    }

    public void deleteByIsbn(String isbn) {
        Book book = findByIsbn(isbn);
        hibernateTemplate.delete(book);
    }

    /**
     * 当且仅当数据库中有这条数据时才可以进行 update 操作
     *
     * @param object
     */
    public void  update(Object object) {
        Book book = (Book) object;
        hibernateTemplate.update(book);
    }

    /**
     * @deprecated
     * @param object
     */
    public void delete(Object object) {

    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
