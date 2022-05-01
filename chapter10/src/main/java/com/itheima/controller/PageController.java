package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    //返回值为void类型的页面跳转
    @RequestMapping("/register")
    public void showPageByVoid(){
        System.out.println("showPageByVoid Running~~");
    }
    //返回值为String类型的页面跳转
    @RequestMapping("/showPageByString")
    public String showPageByString(){
        System.out.println("showPageByString Running~~");
        return "register-";
    }
    //实现方法执行后转发页面跳转
    @RequestMapping("/showPageByForward")
    public String showPageByForward(){
        System.out.println("showPageByForward Running~~");
        return "forward:orders.jsp";
    }
    //实现方法执行后重定向页面跳转
    @RequestMapping("/showPageByRedirect")
    public String showPageByRedirect(){
        System.out.println("showPageByRedirect Running~~");
        return "redirect:http://www.baidu.com";
    }
    //使用HttpServletRequest传递数据
    @RequestMapping("/showPageByRequest")
    public String showPageByRequest(HttpServletRequest request){
        System.out.println("showPageByRequest Running~~");
        request.setAttribute("username","request");
        return "register";
    }
    //使用Model传递数据
    @RequestMapping("/showPageByModel")
    public String showPageByModel(Model model){
        System.out.println("showPageByModel Running~~");
        model.addAttribute("username","model");
        User user = new User();
        user.setPassword("password");
        model.addAttribute("user",user);
        return "register";
    }
    //使用ModelAndView封装数据和视图,实现页面跳转时传递数据
    @RequestMapping("/showModelAndView")
    public ModelAndView showModelAndView(){
        //创建ModelAndView实例
        ModelAndView modelAndView = new ModelAndView();
        //在ModelAndView实例中添加名称为username的数据
        modelAndView.addObject("username","McMeloxD");
        User user = new User();
        user.setPassword("123456");
        //在ModelAndView实例中添加名称为user的数据
        modelAndView.addObject("user",user);
        //在ModelAndView实例中设置视图名称
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
