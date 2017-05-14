package com.practice.controller;

import com.practice.bean.*;
import com.practice.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Y-GH on 2017/5/10.
 */
@RestController
@RequestMapping("/xiaoyu")
public class LoginController {
    //    注入UserDao
    @Autowired
    private UserDao userDao;

    /**
     * 登录
     * @param userid
     * @param userpassword
     * @return
     */
    @RequestMapping(value="/login", method= RequestMethod.POST)
    public Userbean findUsersByNameAndPsd(@RequestParam(value = "userid", required = true) String userid,
                                          @RequestParam(value = "password", required = true) String userpassword) {
        System.out.println("===>>"+userid+"--->>"+userpassword);
        Userbean user = userDao.getLogin(userid,userpassword);
        System.out.println("===>>"+user.getusername());

        return user;
    }

    /**
     * 注册
     * @param userid
     * @param userpassword
     * @return
     */
    @RequestMapping(value="/resign", method= RequestMethod.POST)
    public Flag insert(@RequestParam(value = "userid", required = true) String userid,
                           @RequestParam(value = "password", required = true) String userpassword,
                           @RequestParam(value = "username", required = true) String username,
                           @RequestParam(value = "sex", required = true) String sex,
                           @RequestParam(value = "idcard", required = true) String idcard) {
        System.out.println("===>>"+userid+"--->>"+userpassword);
//        if(sex.equals("0"))
//            sex="男";
//        else
//            sex="女";
        int flag = userDao.resign(userid,userpassword,username,sex,idcard);
        System.out.println("===>>"+flag);
        Flag f1=new Flag();
        if(flag>0){
            f1.setStatus("success");
        }else {
            f1.setStatus("failed");
        }
        return f1;
    }

    /**
     * 科室
     * @param userid
     * @return
     */
    @RequestMapping(value="/keshi", method= RequestMethod.POST)
    public List<KeshiBean> keshiSelect(@RequestParam(value = "userid", required = true) String userid) {
        System.out.println("===>>"+userid+"--->>");
        List<KeshiBean> list = userDao.getKeshi();
        return list;
    }

    /**
     * 科室首页
     * @param userid
     * @return
     */
    @RequestMapping(value="/keshifirst", method= RequestMethod.POST)
    public List<KeshiBean> keshiSelectFirst(@RequestParam(value = "userid", required = true) String userid) {
        System.out.println("===>>"+userid+"--->>");
        List<KeshiBean> list = userDao.getKeshiFirst();
        return list;
    }

    /**
     * 医生列表
     * @param keshiname
     * @return
     */
    @RequestMapping(value="/doctorlist", method= RequestMethod.POST)
    public List<DoctorBean> DoctorSelect(@RequestParam(value = "keshiname", required = true) String keshiname) {
        System.out.println("===>>"+keshiname+"--->>");
        List<DoctorBean> list = userDao.getDoctor(keshiname);
        return list;
    }

    /**
     * 普通列表
     * @param keshiname
     * @return
     */
    @RequestMapping(value="/ordinarylist", method= RequestMethod.POST)
    public List<OrdinaryBean> OrdinarySelect(@RequestParam(value = "keshiname", required = true) String keshiname) {
        System.out.println("===>>"+keshiname+"--->>");
        List<OrdinaryBean> list = userDao.getOrdinary(keshiname);
        return list;
    }




    public String currentTime() {
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String retStrFormatNowDate = sdFormatter.format(nowTime);
        Random rand = new Random();
        int randNum = rand.nextInt(1000);
        retStrFormatNowDate = retStrFormatNowDate + randNum;
        return retStrFormatNowDate;
    }
    /**
     * 挂号订单提交
     * @param userid
     * @param category
     * @param time
     * @param idcard
     * @param price
     * @param sort
     * @return
     */
    @RequestMapping(value="/setorder", method= RequestMethod.POST)
    public Flag setorder(@RequestParam(value = "userid", required = true) String userid,
                       @RequestParam(value = "category", required = true) String category,
                       @RequestParam(value = "time", required = true) String time,
                       @RequestParam(value = "idcard", required = true) String idcard,
                       @RequestParam(value = "price", required = true) String price,
                         @RequestParam(value = "sort", required = true) String sort,
                         @RequestParam(value = "repert", required = true) String repert,
                         @RequestParam(value = "keshi", required = true) String keshi,
                         @RequestParam(value = "paystatus", required = true) String paystatus) {
        System.out.println("===>>"+userid);
        String orderid = currentTime();
        int flag = userDao.setOrder(orderid,userid,category,time,idcard,price,sort,repert,keshi,paystatus);
        System.out.println("===>>"+flag);
        Flag f1=new Flag();
        if(flag>0){
            f1.setStatus("success");
        }else {
            f1.setStatus("failed");
        }
        return f1;
    }

    /**
     * 获取订单
     * @param userid
     * @return
     */
    @RequestMapping(value="/orderlist", method= RequestMethod.POST)
    public List<OrderBean> getorder(@RequestParam(value = "userid", required = true) String userid) {
        System.out.println("===>>"+userid+"--->>获取订单");
        List<OrderBean> list = userDao.getOrder(userid);
        return list;
    }

    @RequestMapping(value="/orderpay", method= RequestMethod.POST)
    public Flag insert(@RequestParam(value = "orderid", required = true) String orderid,
                       @RequestParam(value = "paystatus", required = true) String paystatus) {
        System.out.println("===>>"+orderid+"--->>"+paystatus);
        int flag = userDao.updatePay(paystatus,orderid);
        System.out.println("===>>"+flag);
        Flag f1=new Flag();
        if(flag>0){
            f1.setStatus("success");
        }else {
            f1.setStatus("failed");
        }
        return f1;
    }
}
