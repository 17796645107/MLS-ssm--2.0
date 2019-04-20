<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>查询商品</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<style>
		div{
			margin-left:50px;
			margin-top:30px;
		}
		img{
			width:80px;
			height: 80px;
		}
	</style>
  </head>
  
  <body>
   	<h1>查询商品</h1>
   	<div>
    	<form action="seller/queryProductByKey" method="post">
    		<table>
    			<tr>
    				<td>关键词</td>
    				<td>价格</td>
    				<td>收藏</td>
    				<td>分类</td>
    				<td></td>
    			</tr>
    			<tr>
    				<td><input type="text" name="titleKey" value="${titleKey}" /></td>
    				<td>
						<select name="price">
							<option value="">请选择</option>
    						<option value="0~100">0~100</option>
    						<option value="100~500">100~500</option>
    						<option value="500~1000">500~1000</option>
    						<option value="1000~5000">1000~5000</option>
    						<option value="5000~10000">5000~10000</option>
    						<option value="10000~99999">10000+</option>
    					</select>
					</td>
    				<td>
						<select name="collect">
							<option value="">请选择</option>
    						<option value="0~100">0~100</option>
    						<option value="100~500">100~500</option>
    						<option value="500~1000">500~999</option>

    					</select>
					</td>
    				<td>
    					<select name="mid">
    						<option value="">请选择</option>
    						<c:forEach items="${menuList}" var="menu">
    							<option value="${menu.id}">${menu.name }</option>
    						</c:forEach>
    					</select>
    				</td>	    				
    				<td><input type="submit" value="查询"></td>
    			</tr>   			
    		</table>
    	</form>   	
   	</div>
   	<div>
   		<table cellspacing="1">
   			<tr height="40px">
   			<th>编号</th>
   			<th>图片</th>
   			<th width="300px">名称</th>
   			<th>库存</th>
   			<th>标价</th>
   			<th>收藏</th>
   		</tr>
   			<tr>
   				<td colspan="7"><hr></td>
   			</tr>
   			<c:forEach items="${productList}" var="product">
    			<tr height="100px">			
    				<td width="50px"><span >${product.id }</span></td>
    				<td width="100px"><img src="Resources/images/products/${product.image }"/></td>
    				<td>${product.title }</td>
	                <td>${product.num }</td>	
	                <td>${product.price }</td>
	                <td>${product.collect }</td>
    			</tr>
   		</c:forEach> 			
   		</table>
   	</div>
  </body>
</html>
