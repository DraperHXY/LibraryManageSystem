package com.draper.dao;

public interface UserDao extends BaseDao{

    void add(Object object);

    boolean update(Object object);

    boolean isSuccess(Object object);
}
