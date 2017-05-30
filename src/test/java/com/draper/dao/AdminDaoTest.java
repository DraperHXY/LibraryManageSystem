package com.draper.dao;

import com.draper.domain.Admin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:Application-Context-*.xml")
public class AdminDaoTest {

    @Autowired
    AdminDao adminDao;

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin();
        admin.setAccount("Draper");
        admin.setPassword("123456");
        adminDao.add(admin);
    }

    @Test
    public void testCheck() {
        Admin admin = new Admin();
        admin.setAccount("Draper");
        admin.setPassword("ddd");
        Assert.assertEquals(true, adminDao.isSuccess(admin));
    }

    @Test
    public void testUpdate() {
        Admin admin = new Admin();
        admin.setAccount("Draper");
        admin.setPassword("ddddd");
        BaseDao<Admin> baseDao = adminDao;
        baseDao.update(admin);
    }


}
