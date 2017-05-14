package com.practice.bean.accountbean;

/**
 * Created by Y-GH on 2017/5/14.
 */
public class accountBean {
    private String cellphone;
    private String title;
    private int year;
    private int monthday;
    private String time;
    private String description;
    private String img_id;

    public accountBean(String cellphone, String title, int year, int monthday, String time, String description, String img_id) {
        this.cellphone = cellphone;
        this.title = title;
        this.year = year;
        this.monthday = monthday;
        this.time = time;
        this.description = description;
        this.img_id = img_id;
    }

    public accountBean() {
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getMonthday() {
        return monthday;
    }

    public String getTime() {
        return time;
    }

    public String getDesc() {
        return description;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonthday(int monthday) {
        this.monthday = monthday;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }
}
