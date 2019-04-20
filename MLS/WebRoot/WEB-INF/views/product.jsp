<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
    <title>商品详情页</title>
    <link rel="stylesheet" type="text/css" href="Resources/css/header_top.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/footer.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/header.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/product.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/test/css/imgareaselect-animated.css" /><!-- 放大镜CSS -->
	<script type="text/javascript" src="Resources/js/product.js"></script>
	<script type="text/javascript" src="Resources/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="Resources/js/test/jquery.imgareaselect.pack.js"></script><!-- 放大镜JS -->
	<script type="text/javascript" src="Resources/js/test/test.js"></script><!-- 放大镜JS -->
	<script type="text/javascript" src="Resources/js/json2.js"></script><!-- json -->
  </head>
  
  <body>
  	<jsp:include page="header.jsp"></jsp:include>
    <div class="buyProduct">
    	<!-- 左边商品图片 -->
    	<div class="buy_productImg">
    		<img src="Resources/images/products/${productOne[0].image}" id="photo"/>
    		<div id="preview" class="buy_float">
    			<a href="javascript:void(0);" id="closec"></a>
				<img src="Resources/images/products/${productOne[0].image}" />
			</div>
    	</div>
    	<!-- 中间商品信息 -->
    	<div class="buy_productMessage">
    		<h2>${productOne[0].title }</h2>
    		<img src="Resources/images/p_m_img.png" />
    		<div class="product_price">
    			&nbsp;价格：<span>￥${productOne[0].price }</span>
    		</div>
    		<br>
    		<p>&nbsp;客服: <span><a href="">联系客服</a></span></p>
    		<br>
    		<!-- 表单,添加商品到购物车 -->
    		<form action="order/addOrder" method="post">
    			<input type="hidden" name="product_size" value="" id="size"/>
    			<input type="hidden" name="product_color" value="" id="color"/>
    			<input type="hidden" value="${productOne[0].id }" name="product_id" id="product_id">
    			<input type="hidden" value="${USER.id}" id="user_id" name="user_id"><!--检测用户是否登陆-->
    		<div class="product_color" id="product_color">
    			&nbsp;颜色：

    			<c:forEach items="${productOne}" var="color" begin="0" end="9">
    				<input type="button" value="${color.color }" id="" onclick="setColor(this)">
    			</c:forEach>
    		</div>
    		<br>
    		<div class="product_size" id="product_size">
    			&nbsp;尺码： 			
    			<c:forEach items="${productOne}" var="size" begin="6" step="9">
    				<input type="button" value="${size.size}" id="" onclick="setSize(this)">
    			</c:forEach>
    		</div>
    		<div class="product_number">
   				<div class="number_number">
   					&nbsp;数量：
   				</div>
    			<div class="number_input1">
    				<input type="button" value="-" id="jian">
    			</div>
    			<div class="number_input2">
    				<input type="text" value="1" id="number" name="product_number">
    			</div>
    			<div class="number_input3">
    				<input type="button" value="+" id="jia">
    			</div>
    			<div id="product_num">
    				
    			</div>
    		</div>
    		<div class="product_collect">
    			<a href="javascript:void(0);" onclick="collectProduct()">&nbsp;<img src="Resources/images/collect.jpg">${productOne[0].collect}</a>
    		</div>
    		<div class="buy">
    			<input type="submit" value="立即购买" class="buy_input1">
    			<input type="button" value="加入购物车" class="buy_input2" id="go" onclick="addCart();">
    			<div class="go_buy" id="gobuy">
    				<a href="javascript:void(0);" style="float:right;" id="close"><img src="Resources/images/close.png"></a>
    				<br><br>
    				<p>已将商品添加到购物车</p>
    				<a href="cart/toCart?user_id=${USER.id }">去购物车结算</a>
    			</div>
    		</div>
    		</form>
    		<div class="service_commit">
    			&nbsp;服务承诺：
    			<ul>
    				<li><img src="Resources/images/thlcon.png" style="width:24px;heght:24px;" />退货补运费</li>
    				<li><img src="Resources/images/bylcon.png" style="width:24px;heght:24px;" />全国包邮</li>
    				<li><img src="Resources/images/wlythlcon.png" style="width:24px;heght:24px;" />7天无理由退货</li>
    				<li><img src="Resources/images/fhlcon.png" style="width:24px;heght:24px;" />72小时发货</li>
    			</ul>
    		</div>
    		<div class="pay_type">
    			&nbsp;支付方式：
    			<ul>
    				<li><img src="Resources/images/pay1lcon.jpg"></li>
    				<li><img src="Resources/images/pay2lcon.jpg"></li>
    				<li><img src="Resources/images/pay3lcon.jpg"></li>
    				<li><img src="Resources/images/pay4lcon.jpg"></li>
    			</ul>
    		</div>
    	</div>
    	
    	<!-- 右边商品推荐 -->
    	<div class="buy_recommend">
    		<hr style="size:500px;">
    		<div class="recommend_product">
    			-热卖推荐-   			
    			<ul>
    				<c:forEach items="${hotProductList}" var="hotProduct">
    					<li>
    						<a href="product/showOneProduct?id=${hotProduct.id}">
    							<img src="Resources/images/products/${hotProduct.image}">
    						</a>
    						<span style="color:red;">￥${hotProduct.price}</span>
    					</li>
    				</c:forEach>
    			</ul>  			
    		</div>
    	</div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
