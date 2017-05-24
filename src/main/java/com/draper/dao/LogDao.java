//package com.draper.dao;
//
//import com.draper.Base;
//import com.draper.domain.Log;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//
//public class LogDao implements Base{
//
//    private HibernateTemplate hibernateTemplate;
//
//    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
//        this.hibernateTemplate = hibernateTemplate;
//    }
//
//
//    public void add(Object object) {
//        Log log = (Log) object;
//        hibernateTemplate.save(log);
//    }
//}
