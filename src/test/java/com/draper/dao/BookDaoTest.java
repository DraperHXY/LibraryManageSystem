package com.draper.dao;

import com.draper.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:Application-Context-*.xml")
public class BookDaoTest {

    @Autowired
    BookDao bookDao;

    @Test
    public void add() throws Exception {
        Book book = new Book();
        book.setName("坏孩子的天空");
        book.setAuthor("坏孩子FFF");
        bookDao.add(book);
    }

    @Test
    public void get() throws Exception {
        Book book = bookDao.get(4);
        Assert.assertEquals(true, book.getName().equals("坏孩子的天空"));

    }

    @Test
    public void delete() throws Exception {
        bookDao.delete(4);
    }

}