package com.practice.dao;

import com.practice.bean.*;
import com.practice.bean.accountbean.aUserbean;
import com.practice.bean.accountbean.accountBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库的增删查改等操作在这里执行
 * MyBatis MapperScan 会扫描到这里，完成sql语句与相关操作语句的映射
 * Created by ygh on 2016/1/26.
 */
@Repository
public interface UserDao {
    @Select("select * from userinfo where userid=#{userid} limit 1")
    Userbean getOneUser(String userid);

    @Select("select * from userinfo where userid=#{userid} and password=#{password} limit 1")
    Userbean getLogin(@Param("userid") String userid,@Param("password") String password);

    @Select("select * from userinfo where userid=#{userid} and password=\"123456\" limit 1")
    Userbean test(String userid);


    @Insert("insert into userinfo (userid, password,username,sex,idcard) values(#{userid}, #{password},#{username},#{sex},#{idcard})")
    int resign(@Param("userid") String userid,@Param("password") String password,@Param("username") String username,@Param("sex") String sex,@Param("idcard") String idcard);

    @Select("select * from keshi ")
    List<KeshiBean> getKeshi();

    @Select("select * from keshi where zhongdiankemark=\"1\"")
    List<KeshiBean> getKeshiFirst();

    @Select("select * from yisheng where keshiname=#{keshiname}")
    List<DoctorBean> getDoctor(String keshiname);

    @Select("select * from keshixinxi where keshiname=#{keshiname}")
    List<OrdinaryBean> getOrdinary(String keshiname);

    @Insert("insert into yuyuejilu (orderid,userid, category,time,idcard,price,sort,repert,keshi,paystatus) values(#{orderid},#{userid},#{category},#{time},#{idcard},#{price},#{sort},#{repert},#{keshi},#{paystatus})")
    int setOrder(@Param("orderid") String orderid,@Param("userid") String userid,@Param("category") String category,@Param("time") String time,@Param("idcard") String idcard,@Param("price") String price,@Param("sort") String sort,@Param("repert") String repert,@Param("keshi") String keshi,@Param("paystatus") String paystatus);

    @Select("select * from yuyuejilu where userid=#{userid}")
    List<OrderBean> getOrder(String userid);

    @Update("update yuyuejilu set paystatus=#{paystatus} where orderid=#{orderid}")
    int updatePay(@Param("paystatus") String paystatus,@Param("orderid") String orderid);

    //******************************分割线********************************

    @Insert("insert into account_userinfo (cellphone,name,pwd) values(#{cellphone}, #{name},#{pwd})")
    int resign_account(@Param("cellphone") String cellphone,@Param("name") String name,@Param("pwd") String pwd);

    @Select("select * from account_userinfo where cellphone=#{cellphone} and pwd=#{pwd} limit 1")
    aUserbean getLogin_account(@Param("cellphone") String cellphone, @Param("pwd") String pwd);

    @Insert("insert into account_detail (cellphone,title,year,monthday,time,description,img_id) values(#{cellphone}, #{title},#{year},#{monthday},#{time},#{description},#{img_id})")
    int set_account(@Param("cellphone") String cellphone,@Param("title") String title,@Param("year") int year,@Param("monthday") int monthday,@Param("time") String time,@Param("description") String description,@Param("img_id") String img_id);

    @Select("select * from account_detail where cellphone=#{cellphone}")
    List<accountBean> get_account(@Param("cellphone") String cellphone);
}
