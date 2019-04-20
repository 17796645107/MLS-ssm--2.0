<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <title>美丽说商城</title>
	<link rel="stylesheet" type="text/css" href="Resources/css/index.css">
	<!-- <script type="text/javascript" src="Resources/js/main.js"></script> --><!-- 轮播图js -->
	<link rel="stylesheet" type="text/css" href="Resources/css/header_top.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/footer.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/header.css">
  </head>
  <body>
  	<jsp:include page="header.jsp"></jsp:include>
    <!--广告轮播图-->
   	<!-- <div id="container">
        <div id="list" style="left: -1200px;">
            <img src="Resources/images/banana1.PNG" alt="5"/>
            <img src="Resources/images/banana2.PNG" alt="1"/>
            <img src="Resources/images/banana3.PNG" alt="2"/>
            <img src="Resources/images/banana4.PNG" alt="5"/>
            <img src="Resources/images/banana5.PNG" alt="1"/>
            <img src="Resources/images/banana1.PNG" alt="2"/>
        </div>
        <div id="buttons">
            <span index="1" class="on"></span>
            <span index="2"></span>
            <span index="3"></span>
            <span index="4"></span>
            <span index="5"></span>
        </div>
        <a href="javascript:;" id="prev" class="arrow">&lt;</a>
        <a href="javascript:;" id="next" class="arrow">&gt;</a>
	</div> -->	
    <div class="ad">
    	<div class="inner">
               <img src="Resources/images/banana5.jpg" />
               <img src="Resources/images/banana3.jpg" />
               <img src="Resources/images/banana5.jpg" />
    	</div>
    </div>
     <!--商品展示-->
     	<div class="show">
        	<h2>今日特惠</h2>     	
        	<c:forEach items="${productList}" var="product">
	            <!--商品信息-->
	            <div class="product">
	            	<!--商品信息部分-->
	                <div class="product_main">
	                	<!--商品图片-->
	                	<a href="product/showOneProduct?id=${product.id}">
	                		<img src="Resources/images/products/${product.image}" />
	                	</a>
	                    <!--商品价格-->
	                    <div class="price">￥${product.price}</div>
	                    <!--收藏-->
	                    <div class="collect">
	                    	<i class="lcon_collect"></i>${product.collect}
	                    </div>
	                    <!--商品名称-->
	                    <div class="name">
	                    	<i class="lcon_perferred"></i>${product.title}
	                    </div>
	                </div>
	                <!--空-->
	                <div class="product_none"></div>
	            </div><!-- 商品信息结束 -->
            </c:forEach>
             
	                      
        </div><!-- 商品展示结束 -->
     <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
