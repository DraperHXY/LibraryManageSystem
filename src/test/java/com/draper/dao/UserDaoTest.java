package com.draper.dao;

import com.draper.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:Application-Context-*.xml")
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testAdd() {
        User user = new User();
        user.setAccount("user");
        user.setPassword("user");
        userDao.add(user);
    }

    @Test
    public void testIsSuccess() {
        User user = new User();
        user.setAccount("user");
        user.setPassword("user");
        Assert.assertEquals(true, userDao.isSecurity(user));
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setAccount("user");
        user.setPassword("admin");
        userDao.update(user);

    }

}
