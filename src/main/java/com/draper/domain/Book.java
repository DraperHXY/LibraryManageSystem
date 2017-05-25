package com.draper.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_info")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column
    private int id;

    @Column(nullable = false)
    private String name;//书名

    @Column(nullable = false)
    private String author;//作者

    @Column
    private String publishCom;//出版社

    @Column
    private Date publishDate;//出版日期

    @Column
    private int pages;//页数

    @Column
    private float price;//价格

    @Column(columnDefinition = "VARCHAR(255) default 'http://www.doershow.com/uploads/allimg/101213/1504242026-58.jpg'")
    private String imageUrl;//书的图片的地址

    @Column(unique = true)
    private String isbn;//ISBN


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishCom() {
        return publishCom;
    }

    public void setPublishCom(String publishCom) {
        this.publishCom = publishCom;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " 书名: " + name
                + " 作者: " + author
                + " 出版社: " + publishCom
                + " 出版日期: " + publishDate
                + " 页数: " + pages
                + " 价格: " + price
                + " 图片地址: " + imageUrl
                + " ISBN: " + isbn;
    }
}
