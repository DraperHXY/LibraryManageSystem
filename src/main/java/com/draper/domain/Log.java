package com.draper.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Draper_HXY on 2017/4/24 18:01.
 * Email: Draper_HXY@163.com.
 */
@Entity
@Table(name = "log")
public class Log {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //日志类别，一般起到不可否认性
    //操作日志，安全日志，事件日志
    @Column
    private String type;

    @Column
    private String detail;

    @Column
    private Date date;


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String detail() {
        return detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
