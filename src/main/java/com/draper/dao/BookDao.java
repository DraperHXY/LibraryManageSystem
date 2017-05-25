package com.draper.dao;

import com.draper.domain.Book;

public interface BookDao extends BaseDao {

    Book get(int id);

}
