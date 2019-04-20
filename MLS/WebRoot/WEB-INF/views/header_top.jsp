<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--顶部-->
<div class="mls_top">
	<a href="product/shop" class="index">美丽说首页</a>
   	<ul class="top_ul">
   		<c:choose>
   			<c:when test="${!empty USER }">
   				<li class="li_3">
   					<a href="javascript:void(0);" id="mouserover"><span>${ USER.nickname }</span></a>    				
   					<ul>
						<li><a href="user/personal">个人信息</a></li>
						<li><a href="user/logout">&nbsp;注销</a></li>
   					</ul>
   				</li>
   			</c:when>
   			<c:otherwise>
   				<li class="li_1"><img src="Resources/images/weiXinlcon.png" /><a href="javascript:void(0);">微信登陆</a></li>
	            <li class="li_2"><img src="Resources/images/qqLcon.png" /><a href="javascript:void(0);">QQ登陆</a></li>
	            <li class="li_3"><a href="user/loginFrom">登陆</a></li>
	            <li class="li_3"><a href="user/registerFrom">注册</a></li>
   			</c:otherwise>
   		</c:choose>       	
           <li class="li_1"><img src="Resources/images/collect.png" /><a href="javascript:void(0);">我的收藏</a></li>
           <li class="li_6"><img src="Resources/images/gwcIcon.png" /><a href="cart/toCart?user_id=${USER.id }">我的购物车</a></li>
           <li class="li_1"><img src="Resources/images/orderIcon.png" /><a href="order/lookOrder">我的订单</a></li>
           <li class="li_8"><a href="javascript:void(0);">帮助中心</a></li>
           <li class="li_1"><a href="seller/loginFrom">商家后台</a></li>
	</ul>
</div>

