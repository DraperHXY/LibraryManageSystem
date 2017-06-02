package com.draper.dao;

import com.draper.domain.Log;

public interface LogDao extends BaseDao {

    Log get(int id);

}
