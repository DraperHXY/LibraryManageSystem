package com.draper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BorrowBook extends BaseDomain{

    @Id
    @Column
    private String account;

    //借的第一本书
    @Column
    private String frist;

    //借的第二本书
    @Column
    private String second;

    //借的第三本书
    @Column
    private String third;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFrist() {
        return frist;
    }

    public void setFrist(String isbn) {
        this.frist = isbn;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String isbn) {
        this.second = isbn;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String isbn) {
        this.third = isbn;
    }
}
