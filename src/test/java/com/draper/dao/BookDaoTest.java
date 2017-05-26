package com.draper.dao;

import com.draper.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        book.setIsbn("192-156dsfa");
        bookDao.add(book);
    }

    @Test
    public void testFindByName() throws Exception{
        List<Book> bookList = bookDao.findByName("坏孩子的天空");
        for (Book book : bookList) {
            Assert.assertEquals("192-156dsfa",book.getIsbn());
        }
    }

    @Test
    public void testUpdate(){
        List<Book> bookList = bookDao.findByName("坏孩子的天空");
        Book book = bookList.get(0);
        book.setAuthor("坏孩子的大哥de dage");
        bookDao.update(book);
    }

    @Test
    public void testDeleteByIsbn(){
        bookDao.deleteByIsbn("192-156dsfa");
    }

}