<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'addStudentManager.jsp' starting page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
	<style>
		div{
			width:50%;
			margin:0px auto;
			margin-top:30px;
			text-align: center;
		}
		input{
			width:150px;
			height:30px;
		}
	</style>
	<!-- <script type="text/javascript" src="Resources/js/admin/addProduct.js"></script> -->
  </head>
 
  <body>
    <div>
    	<h1>添加商品</h1>
    	<form action="seller/addProduct" method="post" enctype="multipart/form-data">
    		<input type="hidden" value="${returnMessage}" id="message"/>
    		<input type="hidden" value="${SELLER.id }" name="seller_id"/>
			<input type="file" name="image" accept="image/*"/><br><br>
			<input type="text"  name="title" placeholder="商品名称"/>	<br><br>
			<!-- <input type="text" name="num" placeholder="商品库存"/><br><br> -->
			<input type="text"  name="price" placeholder="商品价格"/><br><br>		
			商品分类:
			<select name="mid">
				<c:forEach items="${menuList }" var="menu">
					<option value="${menu.id }">${menu.name}</option>
				</c:forEach>
			</select><br><br>
			<input type="submit" value="提交"/> 				
    	</form>	
    </div>
  </body>
</html>
