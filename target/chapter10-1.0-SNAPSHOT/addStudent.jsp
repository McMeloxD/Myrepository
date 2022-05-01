<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <title>查询所有学生信息</title>
    <script type="text/javascript"
        //注意：jQuery官网引用地址最近国内访问会经常出现打不开的情况，请尽量不要调用官网引用地址！
        //下面为微软地址
       src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    </head>
    <body>
    	<table id="students" border="1" width="60%" >
    	<tr align="center"><td>输入id： </td><td><input  name="getid" id="getid"></td></tr>
    	<tr align="center"><td>输入sid： </td><td><input  name="getsid" id="getsid"></td></tr>
    	<tr align="center"><td>输入sname： </td><td><input  name="getsname" id="getsname"></td></tr>
    	<tr align="center"><td>输入classname： </td><td><input  name="getclassname" id="getclassname"></td></tr>
    	<tr align="center">
                    <td colspan="2" align="center">
                        <input type="button" value="添加学生信息"
                            onclick="addstudent()">
                    </td>
                </tr>
    </table>
<script type="text/javascript">
    	//添加信息
    	function addstudent(){
    	    var id= $("#getid").val();
    	    var sid= $("#getsid").val();
    	    var sname= $("#getsname").val();
    	    var classname= $("#getclassname").val();
    	    $.ajax({
                        url: "${pageContext.request.contextPath }/addStudent",
                        type: "post",
                        data: JSON.stringify({id: id,sid: sid,sname: sname,classname: classname}),
                        contentType: "application/json;charset=UTF-8",
                        dataType: "json",
                        success: function (response) {alert(response);}
                    });
}
    </script>
 	</body>
</html>