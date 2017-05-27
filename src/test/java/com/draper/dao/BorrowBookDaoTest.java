package com.draper.dao;

import com.draper.domain.BorrowBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:Application-Context-*.xml")
public class BorrowBookDaoTest {

    @Autowired
    BorrowBookDao borrowBookDao;

    @Test
    public void testAdd(){
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setAccount("Draper");
        borrowBook.setFrist("192-156dsfa");
        borrowBookDao.add(borrowBook);
    }

}
