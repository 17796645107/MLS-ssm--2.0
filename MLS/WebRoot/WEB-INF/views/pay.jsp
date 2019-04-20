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
    <title>确认订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="Resources/css/pay.css" type="text/css" />
	<link rel="stylesheet" href="Resources/css/header_top.css" type="text/css" />
	<script type="text/javascript" src="Resources/js/order.js"></script>
	<script type="text/javascript" src="Resources/js/pay.js"></script>
  </head>
  
  <body>
 	<jsp:include page="header_top.jsp"></jsp:include>
  	<!-- 头部 -->
	<!-- <div class="top">
        <div id="top_body">
        	<div id="top_left">
        		<a href="product/shop"><img src="Resources/images/order/logo.png" /></a>		
        	</div>
        	<div id="top_r">
        		<hr id="HR" />
        	</div>
        </div>
	</div> -->
	<!-- 主体 -->
	<div class="main">
		<h3>确认商品信息</h3>
		<div class="address">
			<h4>选择收货地址</h4>
			<div class="address_message">
				<%-- <c:forEach items="${addressList}" var="address"> --%>
				<ul>
					<li>${orderList[0].user_name}</li>
					<li>${orderList[0].user_province}</li>
					<li>${orderList[0].user_city}</li>
					<li>${orderList[0].user_area}</li>
					<li>${orderList[0].user_address}</li>
					<li>${orderList[0].user_postcode}</li>
					<li>${orderList[0].user_telephone}</li>
				</ul>
				<%-- </c:forEach> --%>
			</div>
			<a href="user/selctAllAddress?user_id=${USER.id}">管理地址</a>
 			<!-- <a href="#">添加新地址 </a> -->
		</div>
		<div class="product">
			<table>
				<tr>
					<th width="10%">商品图片</th>
					<th width="40%">商品名称</th>
					<th width="5%">颜色</th>
					<th width="5%">尺寸</th>
					<th width="5%">单价(元)</th>
					<th width="5%">数量</th>
					<th width="10%">小记(元)</th>
					<th width="10%">操作</th>
					<th>订单状态</th>
				</tr>
			</table>
			<!-- 商品信息 -->
			<c:forEach items="${orderList}" var="order">
				<input type="hidden" value="${order.id}" class="order_id"/>
				<div class="product_message">
					<div class="sellerName">
						店铺：<a>美丽优选 </a>&nbsp;<a>联系客服</a>
					</div>
					<div class="productMessage">
						<table>
							<tr>
								<td width="10%"><img src="Resources/images/products/${order.product_image}"></td>
								<td width="40%">${order.product_title }</td>
								<td width="5%">${order.product_color }</td>
								<td width="5%">${order.product_size }</td>
								<td width="5%"><span class="card_price">${order.product_price}</span></td>
								<td width="5%"><input type="text" class="card_number_value" value="${order.product_number}" readonly="readonly"/></td>
								<td width="10%"><span class="card_subtotal"></span></td>
								<td width="10%">
									<!-- <input type="submit" value="删除" > -->
									<c:if test="${order.status==2}"><a href="order/takeGoods?id=${order.id}">确认收货</a></c:if>
								</td>
								<td>
									<c:choose>
										<c:when test="${order.status==0}">未付款</c:when>
										<c:when test="${order.status==1}">已付款</c:when>
										<c:when test="${order.status==2}">已发货</c:when>
										<c:when test="${order.status==3}">已收货</c:when>
									</c:choose>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</c:forEach>
		
		</div>	
		<hr>
		<a href="cart/toCart?user_id=${USER.id}">返回购物车</a>共: 10件商品，总计<span id="total">78</span>元
		<h1><a onclick="pay()">确认并付款</a></h1>
	</div>
	<!-- 底部 -->	
	<div class="foot">
		<p align="center"><a>美丽说</a>©2017 Meilishuo.com,All Rights Reserved.</p>
	</div>
		
  </body>
</html>
