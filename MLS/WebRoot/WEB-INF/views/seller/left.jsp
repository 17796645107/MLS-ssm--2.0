<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		a{
			text-decoration: none;
			color:black;
		}
		a:HOVER {
			color:red;
		}
		div{
			margin-left:35px;
			
		}
		body{
			background-color: rgb(250,250,255);
		}
	</style>
  </head>
  
  <body>
  	<div>
  		<table>
  			<tr>
  				<td><a href="seller/pageSelectAllProduct?pageNow=1&seller_id=${SELLER.id}" target="link">查看商品</a></td>
  			</tr>
  			<tr>
  				<td><a href="seller/forwardAddProduct" target="link">添加商品</a></td>
  			</tr>
  			<tr>
  				<td><a href="seller/forwardQueryProduct" target="link">查询商品</a></td>
  			</tr>
  			<tr>
  				<td><a href="order/queryOrderFromSeller?seller_id=${SELLER.id}" target="link">查看交易</a></td>
  			</tr>
  			<tr>
  				<td><a href="product/shop" target="_top">返回首页</a></td>
  			</tr>
  		</table>
  	</div>
  </body>
</html>
