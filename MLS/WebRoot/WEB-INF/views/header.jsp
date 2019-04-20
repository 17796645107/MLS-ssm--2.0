<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
    <jsp:include page="header_top.jsp"></jsp:include>

    <!--头部-->
    <div class="head">
    	<!--logo-->
    	<a href="product/shop"><img src="Resources/images/logo.png"/></a>
        <!--搜索框-->
        <div class="search">
        	<span class="span_one"><a href="javascript:void(0);">&nbsp;宝贝</a></span><span class="span_two"><a href="javascript:void(0);">&nbsp;店铺</a></span>
           	<div class="search_main">
           		<form action="user/searchProductByKey"  method="post">
	           		<input type="search"  name="key" class="inputSearch" value="${key}"/>
	           		<input type="submit" class="submit" value="搜索">
           		</form>
           	</div>
            <br />
            <ul>      
            	<li class="color"><a href="/MyShop/searchKeyProduct?key=ssw">秋季套装</a></li>
                <li><a href="/MyShop/searchKeyProduct?key=猩红之月">连衣裙</a></li>
                <li class="color"><a href="/MyShop/searchKeyProduct?key=3">破洞针织</a></li>
                <li><a href="/MyShop/searchKeyProduct?key=猩红之月">薄卫衣</a></li>
                <li><a href="/MyShop/searchKeyProduct?key=猩红之月">薄外套</a></li>
                <li class="color"><a href="/MyShop/searchKeyProduct?key=猩红之月">秋季单鞋</a></li>
                <li><a href="/MyShop/searchKeyProduct?key=2">牛仔外套</a></li>
                <li class="color"><a href="/MyShop/searchKeyProduct?key=猩红之月">阔腿裤</a></li>
                <li><a href="/MyShop/searchKeyProduct?key=猩红之月">小白鞋</a></li>
                <li><a href="/MyShop/searchKeyProduct?key=猩红之月">包包新款</a></li>
            </ul>
        </div><!--搜索框结束-->
        <!--导航-->
        <div class="nav">
        	<ul>
            	<li><a href="product/shop">首页</a></li>
            	<c:forEach items="${menu}" var="menu">
           		<li><a href="user/searchProductByKey?key=${menu.name}">${menu.name}</a></li>
           		<!-- <li><a href="javascript:void(0);">裙子</a></li>
           		<li><a href="javascript:void(0);">裤子</a></li>
           		<li><a href="javascript:void(0);">女鞋</a></li>
           		<li><a href="javascript:void(0);">包包</a></li>
           		<li><a href="javascript:void(0);">配饰</a></li>
           		<li><a href="javascript:void(0);">美妆</a></li>
           		<li><a href="javascript:void(0);">男友</a></li>
           		<li><a href="javascript:void(0);">童装</a></li> -->
            	</c:forEach>
            </ul>
            <hr />
        </div><!--导航结束-->
    </div><!--头部结束-->

