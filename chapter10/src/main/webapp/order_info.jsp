<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset-UTF-8">
    <title>订单信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/orderInfo" method="post">
        <table border="!">
            <tr>
                <td colspan="2">
                订单id：<input type="text" name="orderId" value="1">
                </td>
            </tr>
            <tr>
                <td>商品Id</td>
                <td>商品名称</td>
            </tr>
            <tr>
                 <td>
                    <input name="productInfo['生鲜'].proId" value="1" type="text">
                 </td>
                 <td>
                    <input name="productInfo['生鲜'].proName" value="三文鱼" type="text">
                 </td>
            </tr>
            <tr>
                 <td>
                    <input name="productInfo['酒水'].proId" value="2" type="text">
                 </td>
                 <td>
                    <input name="productInfo['酒水'].proName" value="杜康" type="text">
                 </td>
            </tr>
        </table>
        <input type="submit" value="提交"/>
    </from>
</body>
</html>