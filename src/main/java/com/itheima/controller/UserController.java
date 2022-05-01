package com.itheima.controller;
import com.itheima.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserController {
    @RequestMapping("/getUserId")
    public void getUserId(HttpServletRequest request){
        String userid = request.getParameter("userid");
        System.out.println("userid=" + userid);
    }
    @RequestMapping("/getUserNameAndId")
    public void getUserNameAndId(String username, Integer id){
        System.out.println("username=" + username +",id=" + id);
    }
    @RequestMapping("/getUserName")
    public void getUserName(@RequestParam(value = "name", required = false,defaultValue = "itheima") String username){
        System.out.println("username=" + username);
    }
    @RequestMapping("/user/{name}")
    public void getPathVariable(@PathVariable(value = "name") String username){
        System.out.println("username=" + username);
    }
    /**
     * 接受表单用户信息
     */
    @RequestMapping("/registerUser")
    public void registerUser(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("username=" + username +",password=" + password);
    }
    /**
     * 使用自定义类型数据绑定日期数据
     */
    @RequestMapping("/getBirthday")
    public void getBirthday(Date birthday){
        System.out.println("birthday=" + birthday);
    }
    /*
    * 使用@DataTimeFormat注解绑定日期数据
    * */
    @RequestMapping("/getBirthday2")
    public void getBirthday2(@DateTimeFormat(pattern = "yyyy-MM-dd")Date birthday2){
        System.out.println("birthday2=" + birthday2);
    }
    /*
     * 使用@DataTimeFormat注解绑定日期数据第二种形式,
     * getBirthday（）方法的形参是User类型，且birthday3是User类的属性，
     * 将形参上的@DataTimeFormat注解写在birthday属性上面
     * */
    @RequestMapping("/getBirthday3")
    public void getBirthday2(User user){
        Date birthday = user.getBirthday3();
        System.out.println("birthday3=" + birthday);
    }
    /*
    * 包含时分秒格式  YYYY-MM-DD HH:MM:SS
    * */
    @RequestMapping("/getBirthday4")
    public void getBirthday4(@DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss")Date birthday){
        System.out.println("包含时分秒格式  YYYY-MM-DD HH:MM:SS为" + birthday);
    }
    /*
     * 只包含年月日 时分格式  YYYY-MM-DD HH:MM
     * */
    @RequestMapping("/getBirthday5")
    public void getBirthday5(@DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm")Date birthday){
        System.out.println("只包含年月日 时分格式  YYYY-MM-DD HH:MM" + birthday);
    }
    @RequestMapping("/findOrderWithUser")
    public void findOrderWithUser(User user){
        String username =user.getUsername();
        String orderId = user.getOrder().getOrderId();
        System.out.println("username=" + username +",orderId=" + orderId);
    }
}
