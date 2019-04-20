<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personalAddress.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Resources/css/personal/personalAddress.css">
	
	<script type="text/javascript" src="Resources/js/personal/personalAddress.js"></script>
	<script type="text/javascript" src="Resources/js/personal/area.js"></script>
  </head>
  
  <body>
  	<h2>地址管理</h2>
  	<hr>
  	<input type="button" class="addbutton" id="addbutton" onclick="addAddress()">
  	<div class="address" id="address">
  		<form action="user/addAddress" method="post">
  			<input type="hidden" name="user_id" value="${USER.id }">
  			省：<select id="s_province" name="province"></select>  
			市：<select id="s_city" name="city" ></select>  
			区：<select id="s_county" name="area"></select>
			<script type="text/javascript">_init_area();</script>
  			
	  		<br><br>邮政编码：<input type="text" name="postcode">
	  		<br><br>街道地址：<textarea rows="3" cols="50" name="address"></textarea>
	  		<br><br>收货人姓名：<input type="text" name="name">
	  		<br><br>手机号码：<input type="text" name="telephone"><br><br>
	  		<input type="submit" value="确认地址"><input type="reset" value="重置">
  		</form>
  	</div>
  	<c:forEach items="${addressList}" var="address">
	  	<div class="address_message">
	  		<input type="hidden" value="${address.id}" id="id" />
	  		<table>
	  			<tr>
	  				
	  				<td width="10%">${address.name}</td>
	  				<td width="40%">${address.province}${address.city}${address.area}${address.address}</td>
	  				<td width="10%">${address.postcode}</td>
	  				<td width="10%">${address.telephone}</td>
	  				<td width="10%"><a href="user/setDefalutAddress?id=${address.id}">设为默认</a></td>
	  				<td width="10%"><a onclick="">编辑</a></td>
	  				<td width="10%"><a href="user/deleteAddressById?id=${address.id}&user_id=${address.user_id}">删除</a></td>
	  			</tr>
	  		</table>
	  	</div>
  	</c:forEach>
  </body>
</html>
