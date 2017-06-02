package com.draper.service;

import com.draper.domain.Admin;
import com.draper.domain.Book;
import com.draper.domain.BorrowBook;
import com.draper.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:Application-Context-*.xml")
public class BorrowBookServiceTest {

    @Autowired
    BorrowBookService borrowBookService;

    @Test
    public void testBorrowBook() throws Exception {
        Admin admin = new Admin();
        admin.setAccount("Draper");
        admin.setPassword("ddddd");

        User user = new User();
        user.setAccount("user");
        user.setPassword("admin");

        Book book = new Book();
        book.setIsbn("192-156dsfa");
        BorrowBook info = borrowBookService.borrowBook(admin,user,book);
        Assert.assertEquals("192-156dsfa",info.getFrist());
    }


}
