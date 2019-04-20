<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
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
    <title>美丽说商家后台</title>
	<link rel="stylesheet" type="text/css" href="Resources/css/seller/loginFrom.css" />
	<link href="Resources/images/seller/favicon.ico" rel="SHORTCUT ICON" />
  </head>
  
  <body>
  	<div id="top">
    	<div id="top-1">
			<div id="tr-1">
				<img id="img-1" src="Resources/images/seller/logo.png">
			</div>   				
    		<div id="tr-2">
    			<a id="a-1" href="index.html">服务中心</a>
    		</div>
    	</div>
	</div>
    	
   	<div id="mid">
   		<div id="mid-2">
	   		<div id="left">
	   			<div id="20">
	   				<img src="Resources/images/seller/main.png" />
	   			</div>
	   		</div>
   			<div id="right">
   				<div id="30">
   					<div id="301">
   						<h2> 欢迎回来</h2>
	   					<div id="F">
   							<form action="seller/login" method="post">
   								<input type="text" name="username" placeholder="请输入账号" /><br><br>
   								<input type="password" name="password" placeholder="请输入密码" /><br><br>
   								<div><span style="color:red;font-size:13px;">${errorMessage }</span></div>
   								<input type="submit" value="登录"/>
   							</form>
	   					</div>
   					</div>	
   				</div>   			
   			</div>
   		</div>
   	</div>
   	
   	<div id="foot">
   		<div id="foot-2">
	   		<p>  
		   		<span>Copyright ©2016 Meilishuo.com</span>
		   		<span>电信与信息服务业务经营许可证100798号</span>
		   		<span>京ICP备11031139号</span>
		   		<span>京公网安备110108006045</span>
	   		</p>
	   		<p>
	   			<span>客服邮箱：kefu@meilishuo.com</span>
				<span>文明办网文明上网举报电话：010-82615762</span>
				<span>企业法人营业执照</span>
				<span>违法不良信息举报中心</span>
	   		</p>	
   		</div>
   	</div>  	   	
  </body>
</html>
