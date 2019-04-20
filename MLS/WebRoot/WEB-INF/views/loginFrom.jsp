<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
	<link rel="stylesheet" type="text/css" href="Resources/css/login.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/header_top.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/footer.css">
	<!-- <script type="text/javascript" src="Resources/js/login.js"></script> -->
  </head>
  
  <body>
    <div class="login">
    	<div class="login_logo">
    		<img src="Resources/images/logo.png">
    	</div>		
    	<div class="login_main">
    		<a href="index.jsp"><img src="Resources/images/login/index.jpg"></a>
    		<div class="login_form">
    			<div class="login_form_top">
    				<h4>登陆商城</h4>
    				<h5><a href="user/registerFrom">新用户注册</a></h5>
    			</div>    			
    			<hr>
    			<div class="login_form_button">
    				<form action="user/login" method="post">
    					<div><span style="color:gray;font-size:">${ErrorMessage }</span></div>
	    				<input type="text" name="telephone" placeholder="手机号" required="required">
	    				<br><br>
	    				<input type="password" name="password" placeholder="密码" required="required">
	    				<br><br>
	    				<input class="login_form_submit" type="submit" value="立即登陆" >   				
    				</form>
    				<br>
    				<p><a href="">忘记密码</a></p>   					
    			</div>   			   		
    		</div>    	
    	</div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
