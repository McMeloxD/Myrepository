<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<html>
    <head>
        <title>商品添加</title>
    <script type="text/javascript"
        //注意：jQuery官网引用地址最近国内访问会经常出现打不开的情况，请尽量不要调用官网引用地址！
        //下面为微软地址
       src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    </head>
    <body>
    	<table id="products" border="1" width="60%" >
        <tr align="center"><td>欢迎您： </td><td id="username"></td></tr>
        <tr align="center">
            <td colspan="2" align="center">
                <input type="button" value="添加多个商品"
                    onclick="addProducts()">
            </td>
        </tr>
        <tr align="center"><td>商品id</td><td>商品名称</td>   </tr>
    </table>
<script type="text/javascript">
	//显示当前用户名
	window.onload=function(){
		var url="${pageContext.request.contextPath}/getUser";
		$.get(url,function (response){
			//将处理器返回的用户信息中的用户名显示在表格中
			$("#username").text(response.username);
		})
	}
	//添加商品
	function addProducts(){
		var url="${pageContext.request.contextPath}/addProducts";
		$.get(url,function (products){
			//将处理器返回的商品列表信息添加到表格中
			for (var i = 0;i<products.length;i++){
				$("#products").append("<tr><td>"+products[i].proId+"</td><td>"+products[i].proName+"</td></tr>");
			}
		})
		
	}
</script>
 	</body>
</html>