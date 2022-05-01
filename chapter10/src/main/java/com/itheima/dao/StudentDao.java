package com.itheima.dao;

import com.itheima.pojo.Student;

import java.util.List;

public interface StudentDao {
    //插入学生信息
    public int addStudent(Student student);
    //删除学生信息
    public int deleteStudent(int id);
    //更新学生信息
    public int updateStudent(Student student);
    //通过id查询学生信息
    public Student findStudentById(int id);
    //查询所有学生信息
    public List<Student> findAllStudent();
}
