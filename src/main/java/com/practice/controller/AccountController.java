package com.practice.controller;

import com.practice.bean.Flag;
import com.practice.bean.KeshiBean;
import com.practice.bean.Userbean;
import com.practice.bean.accountbean.aUserbean;
import com.practice.bean.accountbean.accountBean;
import com.practice.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Y-GH on 2017/5/14.
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    //    注入UserDao
    @Autowired
    private UserDao userDao;

    /**
     * 登录
     * @param cellphone
     * @param pwd
     * @return
     */
    @RequestMapping(value="/login", method= RequestMethod.POST)
    public aUserbean findUsersByNameAndPsd(@RequestParam(value = "cellphone", required = true) String cellphone,
                                          @RequestParam(value = "pwd", required = true) String pwd) {
        System.out.println("===>>"+cellphone+"--->>"+pwd);
        aUserbean user = userDao.getLogin_account(cellphone,pwd);
        System.out.println("===>>"+user.getName());

        return user;
    }

    /**
     * 注册
     * @param cellphone
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping(value="/resign", method= RequestMethod.POST)
    public Flag resignAccount(@RequestParam(value = "cellphone", required = true) String cellphone,
                       @RequestParam(value = "name", required = true) String name,
                       @RequestParam(value = "pwd", required = true) String pwd) {
        System.out.println("注册===>>"+cellphone+"--->>"+pwd);
        int flag = userDao.resign_account(cellphone,name,pwd);
        System.out.println("===>>"+flag);
        Flag f1=new Flag();
        if(flag>0){
            f1.setStatus("success");
        }else {
            f1.setStatus("failed");
        }
        return f1;
    }


    @RequestMapping(value="/getaccount", method= RequestMethod.POST)
    public List<accountBean>  findAccount(@RequestParam(value = "cellphone", required = true) String cellphone) {
        System.out.println("===>>"+cellphone+"--->>获取列表");
        List<accountBean> list = userDao.get_account(cellphone);
        return list;
    }

    @RequestMapping(value="/setaccount", method= RequestMethod.POST)
    public Flag insertAccount(@RequestParam(value = "cellphone", required = true) String cellphone,
                              @RequestParam(value = "title", required = true) String title,
                              @RequestParam(value = "year", required = true) int year,
                              @RequestParam(value = "monthday", required = true) int monthday,
                              @RequestParam(value = "time", required = true) String time,
                              @RequestParam(value = "description", required = true) String description,
                              @RequestParam(value = "img_id", required = true) String img_id) {
        System.out.println("存===>>"+cellphone+"--->>");
        int flag = userDao.set_account(cellphone,title,year,monthday,time,description,img_id);
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
