package com.itheima.controller;

import com.itheima.dao.StudentDao;
import com.itheima.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Student")
public class StudentController {
    @RequestMapping("/showAllStudent")
    @ResponseBody
    public List<Student> showAllStudent(){
        //加载配置文件
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //获取StudentDao实例
        StudentDao studentDao =
                (StudentDao) applicationContext.getBean("studentDao");
        List<Student> students = studentDao.findAllStudent();
        for (Student st:students){
            System.out.println(st);
        }
        return students;
    }
    @RequestMapping("/showStudentInfo")
    public String showStudentInfo(Integer id){
        //加载配置文件
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //获取StudentDao实例
        StudentDao studentDao =
                (StudentDao) applicationContext.getBean("studentDao");
        Student student = studentDao.findStudentById(id);
        return "student";
    }
    @RequestMapping("/deleteStudent")
    public String deleteStudent(
            @RequestBody Student student){

        //加载配置文件
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //获取StudentDao实例
        StudentDao studentDao =
                (StudentDao) applicationContext.getBean("studentDao");
       int id = student.getId();
       int num=studentDao.deleteStudent(id);
       System.out.println(num);
        if(num>0) {
            System.out.println("删除数据成功");
        }else {
            System.out.println("删除数据失败");
        }
        return "redirect:dt.jsp";
    }
//    通过表单insertStudent获取pojo对象封装，然后处理器的addStuden添加学生操作

    @RequestMapping("/addStudent")
    public String addStudent(Student student) {

        //加载配置文件
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //获取StudentDao实例
        StudentDao studentDao =
                (StudentDao) applicationContext.getBean("studentDao");
        int num = studentDao.addStudent(student);
       if(num >0){
           return "student/success";
       }
        return "student/fail";
    }
    @RequestMapping("/updateStudent")
    public String updateStudent(
            @RequestBody Student student) {

        //加载配置文件
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //获取StudentDao实例
        StudentDao studentDao =
                (StudentDao) applicationContext.getBean("studentDao");
        Student st1 = new Student();
        st1.setId(student.getId());
        st1.setSid(student.getSid());
        st1.setSname(student.getSname());
        st1.setClassname(student.getClassname());
        int num = studentDao.updateStudent(st1);
        System.out.println(num);
        if (num > 0) {
            System.out.println("更新数据成功");
        } else {
            System.out.println("更新数据失败");
        }
        return "dt.jsp";
    }
    @RequestMapping("/studentinsert")
    public String insert(){
        return "student/insert";
    }
}
