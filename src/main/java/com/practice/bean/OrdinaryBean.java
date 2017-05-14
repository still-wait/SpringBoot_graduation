package com.practice.bean;

/**
 * Created by Y-GH on 2017/5/12.
 */
public class OrdinaryBean {
    private String keshiname;
    private String keshiriqi;
    private String keshizhuangtai;
    private String keshihaoyue;

    public OrdinaryBean(String keshiname, String keshiriqi, String keshizhuangtai, String keshihaoyue) {
        this.keshiname = keshiname;
        this.keshiriqi = keshiriqi;
        this.keshizhuangtai = keshizhuangtai;
        this.keshihaoyue = keshihaoyue;
    }

    public String getKeshiname() {
        return keshiname;
    }

    public String getKeshiriqi() {
        return keshiriqi;
    }

    public String getKeshizhuangtai() {
        return keshizhuangtai;
    }

    public String getKeshihaoyue() {
        return keshihaoyue;
    }

    public void setKeshiname(String keshiname) {
        this.keshiname = keshiname;
    }

    public void setKeshiriqi(String keshiriqi) {
        this.keshiriqi = keshiriqi;
    }

    public void setKeshizhuangtai(String keshizhuangtai) {
        this.keshizhuangtai = keshizhuangtai;
    }

    public void setKeshihaoyue(String keshihaoyue) {
        this.keshihaoyue = keshihaoyue;
    }
}
