package com.practice.bean.accountbean;

/**
 * Created by ygh on 2016/1/26.
 */
public class aUserbean {
    private String cellphone;
    private String name;
    private String pwd;

    public aUserbean(String cellphone, String name, String pwd) {
        this.cellphone = cellphone;
        this.name = name;
        this.pwd = pwd;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
