package com.draper.dao;

import com.draper.domain.BorrowBook;

public interface BorrowBookDao extends BaseDao{

    BorrowBook find(String userAccount);

}