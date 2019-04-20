<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>My JSP 'goodscard.jsp' starting page</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Resources/css/goodCart.css">
	<script type="text/javascript" src="Resources/js/goodCart.js"></script>
	<link rel="stylesheet" type="text/css" href="Resources/css/header_top.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/footer.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/header.css">
  </head>
  
  <body>
  	<jsp:include page="header_top.jsp"></jsp:include>
    <div class="card">
    	<div class="card_top">
    		<input type="button" value="全部商品">
    	</div>
    	<br>
    	<div class="card_main">
    		<table>
    			<tr height="40px">
	    			<td width="50px"><input type="checkbox">全选</td>
	    			<th width="450px" colspan="2">商品</th>
	    			<td width="100px">商品信息</td>
	    			<td width="100px">单价（元）</td>
	    			<td width="200px">数量</td>
	    			<td width="100px">小计（元）</td>
	    			<td width="100px">操作</td>
    			</tr>
    			<tr>
    				<td colspan="8"><hr></td>    			
    			</tr>
    			<tr height="60px">
    				<td colspan="8">店铺：美丽优选</td>    			
    			</tr>
    			<tr>
    				<td colspan="8"><hr></td>    			
    			</tr>
   				<c:forEach items="${cartList}" var="cart">
    				<tr height="100px">
	    				<td>
	    					<input type="checkbox">
	    				</td>
	    				<td>
	    					<img src="Resources/images/products/${cart.product_image}" style="width:80px;height:80px;">
	    				</td>
	    				<td>${cart.product_title}</td>
	    				<td>颜色：${cart.product_color}<br>尺码：${cart.product_size}</td>
	    				<td>
	    					<span class="card_price">${cart.product_price}</span>
	    				</td>
	    				<td>
	    					<input type="button" value="-" class="card_number" >
	    					<input type="text" value="${cart.product_number}" class="card_number_value">
	    					<input type="button" value="+" class="card_number">
	    				</td>
	    				<td>	
	    					<span class="card_subtotal">${cart.product_price }</span>
	    				</td>
	    				<td>
	    					<form action="cart/deleteProductFromCart" method="post">
	    						<input type="hidden" value="${cart.id}" name="id" class="cart_id"/>
	    						<input type="hidden" value="${USER.id}" name="user_id" />
	    						<input type="submit" value="删除" />
	    					</form>
	    					<input type="button" value="修改" onclick="modifyProductNumberToCart()"/>
	    				</td>	
    				</tr>
    			</c:forEach>		
    			<!-- 横线 -->
    			<tr>
    				<td colspan="8"><hr></td>    			
    			</tr>
   				<!-- 双横线 -->
    			<tr>
    				<td colspan="8"><hr></td>    			
    			</tr>
    			<tr height="50px">
    				<td colspan="6"><input type="button" onclick="javascript:history.back(-1);" value="返回">&nbsp;<a href="">删除</a></td>
    				<td colspan="2">总计：￥<span id="total">555</span><a onclick="toPay()">去付款</a></td>
    			</tr>
   			</table>
    	</div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
