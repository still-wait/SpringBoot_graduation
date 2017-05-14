package com.practice.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y-GH on 2017/5/12.
 */
public class KeshiBean {
    private String keshiName;
    private String discription;
    private String mark;

    public String getKeshiName() {
        return keshiName;
    }

    public String getDiscription() {
        return discription;
    }

    public String getMark() {
        return mark;
    }

    public KeshiBean(String keshiName, String discription, String mark) {
        this.keshiName = keshiName;
        this.discription = discription;
        this.mark = mark;
    }

    public void setKeshiName(String keshiName) {
        this.keshiName = keshiName;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
