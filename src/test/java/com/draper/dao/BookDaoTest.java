package com.draper.dao;

import com.draper.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:Application-Context-*.xml")
public class BookDaoTest {

    @Test
    public void add() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:Application-Context-*.xml");
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        Book book = new Book();
        book.setName("Draper 自传");
        book.setAuthor("Draper");
        bookDao.add(book);
    }

}