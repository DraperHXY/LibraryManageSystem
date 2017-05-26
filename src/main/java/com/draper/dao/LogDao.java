package com.draper.dao;

import com.draper.domain.Log;

public interface LogDao extends BaseDao {

    Log get(int id);

    /**
     * @param object
     * @deprecated 不能修改日志
     */
    boolean update(Object object);
}
