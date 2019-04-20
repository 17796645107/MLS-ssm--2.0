<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sellerOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		img{
			width: 100px;
			height: 100px;
		}
	</style>
  </head>
  
  <body>
    <table width="1000px">
		<tr>
			<th width="10%">商品图片</th>
			<th width="40%">商品名称</th>
			<th width="5%">颜色</th>
			<th width="5%">尺寸</th>
			<th width="5%">单价(元)</th>
			<th width="5%">数量</th>
			<th width="10%">操作</th>
			<th width="10%">订单状态</th>
		</tr>
		<!-- 商品信息 -->
		<c:forEach items="${sellerOrder}" var="order">
				
			<tr>
				<td width="10%"><img src="Resources/images/products/${order.product_image}"></td>
				<td width="40%">${order.product_title }</td>
				<td width="5%">${order.product_color }</td>
				<td width="5%">${order.product_size }</td>
				<td width="5%">${order.product_price}</td>
				<td width="5%">${order.product_number}</td>
				<td width="10%">
					<c:choose>
						<c:when test="${order.status==1}">
							<a href="order/toGoods?id=${order.id}">发货</a>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</td>
				<td width="10%">
					<c:choose>
						<c:when test="${order.status==0}">未付款</c:when>
						<c:when test="${order.status==1}">已付款</c:when>
						<c:when test="${order.status==2}">已发货</c:when>
						<c:when test="${order.status==3}">已收货</c:when>
					</c:choose>
				</td>
			</tr>			
		</c:forEach>
	</table>
  </body>
</html>
