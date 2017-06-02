package com.draper.dao.impl;

import com.draper.dao.LogDao;
import com.draper.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogDaoImpl implements LogDao {

    private HibernateTemplate hibernateTemplate;

    public void add(Object object) {
        Log log = (Log) object;
        hibernateTemplate.save(log);
    }

    public Log get(int id) {
        Log log = hibernateTemplate.get(Log.class, id);
        return log;
    }

    /**
     * @param object
     * @deprecated
     */
    public void update(Object object) {
    }

    /**
     * @param object
     * @deprecated
     */
    public void delete(Object object) {
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
