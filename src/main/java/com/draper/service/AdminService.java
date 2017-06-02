package com.draper.service;

import com.draper.dao.AdminDao;
import com.draper.dao.LogDao;
import com.draper.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminDao adminDao;
    private LogDao logDao;

    public void create(Admin admin){
        adminDao.add(admin);
    }

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }
}
