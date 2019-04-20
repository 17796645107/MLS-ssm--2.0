<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personalPassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="Resources/css/personal/personalMessage.css">

	<script type="text/javascript" src="Resources/js/personalPassword.js"></script>
  </head>
  
  <body>
    <form action="user/modifyPersonalPassword" method="post" onsubmit="return checkpassword();">
    	<table>
			<tr>
				<td>旧密码&nbsp;</td>
				<td>
					<input type="password" id="oldpassword">
					<input type="hidden" id="password" value="${USER.password }">
				</td>
				<td><span></span></td>    					
			</tr>
			<tr>
				<td>新密码</td>
				<td><input type="password" name="password" id="newpassword"></td>
				<td><span></span></td>
				
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" id="pwd" ></td>
				<td><span></span></td>
				
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="确认提交" class="personal_message_form_submit"></td>  					
				<td></td>
			</tr>
    	</table>
    </form>
  </body>
</html>
