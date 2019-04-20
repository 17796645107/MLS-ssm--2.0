<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>My JSP 'iframe.jsp' starting page</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="Resources/css/personal/personalMessage.css">
	<script type="text/javascript" src="Resources/js/Calendar3.js"></script>
  </head>
  
  <body>
    <div class="personal_message">
    	<div class="personal_message_head">
    		我的信息    		
    	</div>
    	<div class="personal_message_main">
    		<form action="user/modifyPersonalMessage" method="post">
    			<input type="hidden" name="id" value="${USER.id }">
    			<input type="hidden" id="modifyResult" value="${modifyResult}">
    			<table>
    				<tr>
    					<td>注册邮箱&nbsp;</td>
    					<td><input type="text" name="email" value="${UserMessage.email }"></td>   					
    				</tr>
    				<tr>
    					<td>手机号码</td>
    					<td><input type="text" name="telephone" value="${UserMessage.telephone }" readonly="readonly"></td>
    				</tr>
    				<tr>
    					<td align="right">昵称&nbsp;</td>
    					<td><input type="text" name="nickname" value="${UserMessage.nickname }"></td>
    				</tr>
    				<tr>
    					<td align="right">性别&nbsp;</td>
    					<td><input type="text" name="sex" value="${UserMessage.sex }"></td>    					
    				</tr>
    				<tr>
    					<td align="right">生日&nbsp;</td>
    					<td><input type="text" name="birthday" id="control_date" class="inputstyle"  onclick="new Calendar().show(this);" value="${UserMessage.birthday }" readonly="readonly"/></td>   					
    				</tr>
    				<tr>
    					<td></td>
    					<td><input type="submit" value="确认提交" class="personal_message_form_submit" onclick="init()"></td>  					
    				</tr>
    			</table>  			
    		</form>
    	</div>
    </div>
  </body>
</html>
