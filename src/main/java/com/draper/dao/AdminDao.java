package com.draper.dao;

import com.draper.domain.Admin;

public interface AdminDao extends BaseDao {

    boolean isSuccess(Admin admin);

    boolean delete(Admin admin);
}
