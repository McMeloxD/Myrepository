package com.itheima.dao;

import com.itheima.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/*
* StudentDao实现类接口
* */
public class
StudentDaoImpl implements StudentDao{
    //定义JdbcTemplat属性及其setter方法
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;  }
    public int addStudent(Student student) {
        //定义SQL
        String sql="insert into student(sid,sname,classname) values(?,?,?)";
        //定义数组存放SQL参数
        Object[] obj =new Object[]{
                student.getSid(),
                student.getSname(),
                student.getClassname()
        };
        //执行添加操作
        int num = this.jdbcTemplate.update(sql, obj);
        //返回受影响的记录条数
        return num;
    }

    public int deleteStudent(int id) {
        //定义SQL语句
        String sql = "delete from student where id = ?";
        //执行删除操作
        int num= this.jdbcTemplate.update(sql, id);
        //返回受影响的记录条数
        return num;
    }

    public int updateStudent(Student student) {
        //定义SQL
        String sql="update  student set sid=?,sname=?,classname=? where id=?";
        //定义数组存放SQL参数
        Object[] obj =new Object[]{
                student.getSid(),
                student.getSname(),
                student.getClassname(),
                student.getId()
        };
        //执行添加操作
        int num = this.jdbcTemplate.update(sql, obj);
        //返回受影响的记录条数
        return num;
    }

    //通过id查询学生信息
    public Student findStudentById(int id) {
        //定义SQL语句
        String sql = "select * from student where id = ?";
        //创建一个新的BeanPropertyRowMapper对象
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        //将id绑定到SQL语句中，并通过RowMapper返回单行记录
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
    //所有查询学生信息
    public List<Student> findAllStudent(){
        //定义SQL语句
        String sql = "select * from student";
        //创建一个新的BeanPropertyRowMapper对象
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        //将id绑定到SQL语句中，并通过RowMapper返回单行记录
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
