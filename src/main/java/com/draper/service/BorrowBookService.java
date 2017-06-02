package com.draper.service;

import com.draper.dao.AdminDao;
import com.draper.dao.BookDao;
import com.draper.dao.BorrowBookDao;
import com.draper.dao.UserDao;
import com.draper.domain.Admin;
import com.draper.domain.Book;
import com.draper.domain.BorrowBook;
import com.draper.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowBookService {

    private AdminDao adminDao;
    private UserDao userDao;
    private BookDao bookDao;
    private BorrowBookDao borrowBookDao;

    public BorrowBook borrowBook(Admin admin, User user, Book book) throws Exception {
        checkSecurity(admin, user, book);
        BorrowBook info = borrowBookDao.find(user.getAccount());
        if(info.getFrist() != null){
            info.setFrist(book.getIsbn());
        } else if (info.getSecond() != null){
            info.setSecond(book.getIsbn());
        } else if(info.getThird() != null){
            info.setThird(book.getIsbn());
        } else {
            throw new Exception("借书太多错误");
        }
        borrowBookDao.update(info);
        return info;
    }

    private void checkSecurity(Admin admin,User user, Book book){
        if (!isSuccessAdmin(admin)) {
            throw new SecurityException("管理员错误");
        } else if (!isSuccessUser(user)) {
            throw new SecurityException("用户错误");
        } else if (null == (findBookByIsbn(book.getIsbn()))) {
            throw new SecurityException("书籍错误");
        }
    }

    private boolean isSuccessAdmin(Admin admin) {
        return adminDao.isSecurity(admin);
    }

    private boolean isSuccessUser(User user) {
        return userDao.isSecurity(user);
    }

    private Book findBookByIsbn(String isbn) {
        Book book = bookDao.findByIsbn(isbn);
        return book;
    }

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Autowired
    public void setBorrowBookDao(BorrowBookDao borrowBookDao){
        this.borrowBookDao = borrowBookDao;
    }
}
