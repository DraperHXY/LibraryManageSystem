package com.draper.dao;

import com.draper.domain.Book;

import java.util.List;

public interface BookDao extends BaseDao {

    Book findByIsbn(String isbn);

    List<Book> findByName(String name);

    void deleteByIsbn(String isbn);

}
