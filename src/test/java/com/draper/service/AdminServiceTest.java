package com.draper.service;

import com.draper.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:Application-Context-*.xml")
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    public void test(){
        Admin admin  = new Admin();
        admin.setAccount("GOU");
        admin.setPassword("Admin");
        adminService.create(admin);
    }


}
