<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Resources/css/index.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/header_top.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/footer.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/header.css">

  </head>
  
  <body>
    <jsp:include page="header.jsp"></jsp:include>
    <!--商品展示-->
     	<div class="show">
        	<h2>查询结果</h2>
        	<c:choose>
        		<c:when test="${!empty productList}">
        			<c:forEach items="${productList}" var="product">
	            <!--商品信息-->
	            <div class="product">
	            	<!--商品信息部分-->
	                <div class="product_main">
	                	<!--商品图片-->
	                	<a href="product/showOneProduct?id=${product.id}"><img src="Resources/images/products/${product.image}" /></a>
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
        		</c:when>
        		<c:otherwise>
        			<h2>对不起，没有搜索到结果</h2>
        			<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        		</c:otherwise>
        	</c:choose>    	
        	           
        </div><!-- 商品展示结束 -->
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
