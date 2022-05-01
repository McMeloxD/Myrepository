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
    	<tr align="center">
                    <td colspan="2" align="center">
                        <input type="button" value="查询所有学生信息"
                            onclick="showallstudent()">
                    </td>
                </tr>
        <tr align="center"><td>id </td><td>学号</td><td>姓名</td><td>班级</td></tr>
    </table>
<script type="text/javascript">
	//添加信息
	function showallstudent(){
		var url="${pageContext.request.contextPath}/showAllStudent";
		$.get(url,function (students){
			//将处理器返回的商品列表信息添加到表格中
			for (var i = 0;i<students.length;i++){
				$("#students").append("<tr><td>"+students[i].id+"</td><td>"+students[i].sid+"</td><td>"+students[i].sname+"</td><td>"+students[i].classname+"</td></tr>");
			}
		})

	}
</script>
 	</body>
</html>