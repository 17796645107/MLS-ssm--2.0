<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		*{
			margin:0;
			padding:0;
		}
		body{
			background-color:white;
		}
		span{
			color:red;
		}
		h3{
			margin-left:200px;
		}
	</style>

  </head>
  
  <body>
    <div>
    	<img alt="123" src="Resources/images/logo.png">
    	<h3>店铺：<span>${SELLER.name}</span></h3>
    </div>
  </body>
</html>
