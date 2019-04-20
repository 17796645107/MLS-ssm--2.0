<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>个人中心</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="Resources/css/personal/personal.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/header_top.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/footer.css">

  </head>
  
  <body>
  	<jsp:include page="../header_top.jsp"></jsp:include>
    <div class="personal">
    	<div class="iframe_nav">
    		<img alt="头像" src="Resources/images/headLogo.png">
    		<br><br>${ USER.nickname }
    		<hr>
    		<ul>
    			<li><h4>我的订单</h4></li>
    			<li><a href="">全部订单</a></li>
    			<li></li>
    			<li><h4>收货地址</h4></li>
    			<li><a href="user/selctAllAddress?user_id=${USER.id }" target="link">添加收货地址</a></li>
    			<li></li>   			
    			<li><h4>账号管理</h4></li>
    			<li><a href="user/personalMessage?id=${USER.id }" target="link">我的信息</a></li>
    			<li><a href="">个人头像</a></li>
    			<li></li>   			
    			<li><h4>安全中心</h4></li>
    			<li><a href="user/personalPassword" target="link">用户密码</a></li>
    			<li><a href="">支付密码</a></li>
    			<li><a href="">手机绑定</a></li>
    			<li><a href="">登陆设备</a></li>
    		</ul>
    	</div>
    	<div class="iframe_main">
    		<iframe src="user/personalMessage?id=${USER.id }" name="link"></iframe>
    	</div>	
    </div>
 	<jsp:include page="../footer.jsp"></jsp:include>   
  </body>
</html>
