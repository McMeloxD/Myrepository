<%--
  Created by IntelliJ IDEA.
  User: McMeloxD
  Date: 2022/4/30
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加学生信息</title>
    <script type="text/javascript"
    //注意：jQuery官网引用地址最近国内访问会经常出现打不开的情况，请尽量不要调用官网引用地址！
    //下面为微软地址
    src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/Student/addStudent" method="post">

    <tr align="center"><td>输入id： </td><td><input  name="id" id="id"></td></tr><br />
    <tr align="center"><td>输入sid： </td><td><input  name="sid" id="sid"></td></tr><br />
    <tr align="center"><td>输入sname： </td><td><input  name="sname" id="sname"></td></tr><br />
    <tr align="center"><td>输入classname： </td><td><input  name="classname" id="classname"></td><br />
    </tr>
    <td>
        <button type="submit" class="btn btn-primary">登录</button>
    </td>
</form>
</body>
</html>