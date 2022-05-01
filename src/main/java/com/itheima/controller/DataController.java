package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.Product;
import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {
    @RequestMapping("/showDataByResponse")
    public void showDataByResponse(HttpServletResponse response) throws IOException {
        //选中代码，按alt+ctrl+t选择try。catch语句
        try {
            response.getWriter().println("response");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //将对象数据转换成JSON数据，然后通过HttpServletResponse将JSON数据写入输出流完成回写
    @RequestMapping("/showDataByJSON")
    public void showDataByJSON(HttpServletResponse response) throws IOException {
        //选中代码，按alt+ctrl+t选择try。catch语句
        try {
            ObjectMapper om = new ObjectMapper();
            User user = new User();
            user.setUsername("McMeloxD");
            user.setPassword("123");
            String ujson = om.writeValueAsString(user);
            response.getWriter().print(ujson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //将集合数据转换成JSON数据，然后通过HttpServletResponse将JSON数据写入输出流完成回写
    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setUsername("McMeloxD");
        return user;
    }
    @RequestMapping("addProducts")
    @ResponseBody
    public List<Product> addProducts(){
        Product p1 = new Product();
        p1.setProId("p001");
        p1.setProName("杜康");
        Product p2 = new Product();
        p2.setProId("p002");
        p2.setProName("火鸡面");
        ArrayList<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        return products;
    }
}
