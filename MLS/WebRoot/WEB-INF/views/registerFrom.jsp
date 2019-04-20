<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
    <title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="Resources/css/register.css">
	<link rel="stylesheet" type="text/css" href="Resources/css/footer.css">
	<script type="text/javascript" src="Resources/js/registerFrom.js"></script>
  </head>
  <body>
    <div class="register">
    	<div class="register_logo">
    	   	<img src="Resources/images/logo.png">
    	</div>
    	<div class="register_main">
    		<a href="index.jsp"><img src="Resources/images/login/index.jpg"></a>
    		<div class="register_form">
    			<div class="register_form_top">
    				<h4>新用户注册</h4>
    				<h5><a href="user/loginFrom">已有账号</a></h5>
    			</div>
    			<hr>
    			<div class="register_form_button">
    				<form action="user/register" method="post" onsubmit='return regs("click")'>
    					<div id="telephoneError"></div>									<!-- onblur="checkTelephone();" -->
    					<input type="text" name="telephone" placeholder="手机号" required="required" id="telephone" ><br/>
    					<div id="codeError"></div>
    					<input type="text" class="code_text" placeholder="验证码" required="required" id="code">
    					<input type="button" value="发送验证码" class="register_code"><br>
    					<div id="passwordError"></div>
    					<input type="password" name="password" placeholder="密码" required="required" id="password"><br>
    					<div id="pwdError"></div>
    					<input type="password" placeholder="重复密码" required="required" id="pwd"><br>
    					<div id="nameError"></div>
    					<input type="text" name="nickname" placeholder="昵称" required="required" id="name"><br>
    					<input type="submit" value="注册" class="register_submit">
    				</form>
    			</div>
    		</div>
    	</div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
