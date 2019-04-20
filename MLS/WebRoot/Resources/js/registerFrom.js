//创建ajax对象
function ajaxFunction(){
    var xmlHttp;
    try {
        xmlHttp = new XMLHttpRequest();
    } catch(e) {
        try {
            xmlHttp = new ActiveXObject("Msxm12.XMLHTTP");
        } catch(e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch(e) {}
        }
    }
    return xmlHttp;
}
function getObj(id){
	var obj=document.getElementById(id);
	return obj;
}
//表单验证
onload=regs;
function regs(click){
	var stat=true;
	//获取表单对象
	var telephone = getObj("telephone");//手机号
	var code=getObj("code");
	var password=getObj("password");
	var pwd=getObj("pwd");
	var name=getObj("name");
	//获取提示错误信息对象
	var telephoneMessage=getObj("telephoneError");//提示信息
	var codeError=getObj("codeError");
	var passwordError=getObj("passwordError");
	var pwdError=getObj("pwdError");
	var nameError=getObj("nameError");
	
	//手机号
	telephone.onfocus=function(){
		telephoneMessage.innerHTML=="请输入手机号码";
	};
	telephone.onblur=function(){
		//正则表达式判断是否为手机号
	    if(telephone.value.match(/^1[3|5|7|8][0-9]{9}$/)){
	    	 //1.创建ajax对象
	        var xhr = ajaxFunction();
	        var pathName = window.location.pathname.substring(1);  
	        var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
	        //规定发送数据的形式（post/get），url，以及传输方式(同步/异步)
	        xhr.open("post","./user/cheackUsername",true);
	        //post方式需要加下边这句，get方式不需要
	        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        //将页面输入数据发送到后台
	        xhr.send("telephone="+telephone.value);
	        //接收返回数据
	        var data="";
	        xhr.onreadystatechange = function() {
	            //处理后台返回的数据
	            if(xhr.readyState == 4) {
	                if(xhr.status == 200) {
	                    data= xhr.responseText;
	                    //设置返回数据到前台页面
	                    if(data=="手机号可以使用"){
	                    	telephoneMessage.innerHTML = "手机号可以使用";
	                    }
	                    else{
	                    	stat=false;
	                    	telephoneMessage.innerHTML = "手机号已被注册";
	                    	return false;
	                    };
	                };
	            };
	        };
		}
	    else{
	    	stat=false;
	    	telephoneMessage.innerHTML="请输入正确的手机号";
	    	return false;
	    };  
	};
	/*if(click="click"){
		telephone.onblur();
	}*/
	//验证码
	code.onfocus=function(){
		codeError.innerHTML="请输入4位验证码";
	};
	code.onblur=function(){
		if(code.value.match(/^\S+$/) && code.value.match(/^[0-9]*$/) && code.value.length==4 ){
			codeError.innerHTML="";
		}
		else{
			stat=false;
			codeError.innerHTML="验证码错误";
			return false;
		}
	};
	if(click=="click"){
		code.onblur();
	}
	
	//密码
	password.onfocus=function(){
		passwordError.innerHTML="请输入6-12位密码";
	};
	password.onblur=function(){
		if(password.value.match(/^\S+$/) && password.value.length >=6 && password.value.length <=12){
			passwordError.innerHTML="";
		}
		else{
			stat=false;
			passwordError.innerHTML="密码长度错误";			
			return false;
		}
	};
	if(click=="click"){
		password.onblur();
	}
	
	//确认密码
	pwd.onfocus=function(){
		pwdError.innerHTML="请再次确认密码";
	};
	pwd.onblur=function(){
		if(pwd.value.match(/^\S+$/) && pwd.value.length >=6 && pwd.value.length <=12 && pwd.value==password.value){
			pwdError.innerHTML="";
		}
		else{
			stat=false;
			pwdError.innerHTML="两次密码输入不同";			
			return false;
		}
	};
	if(click=="click"){
		pwd.onblur();
	}
	 
	//真实姓名
	name.onfocus=function(){
		nameError.innerHTML="请输入2-6位昵称";
	};
	name.onblur=function(){
		if(name.value.match(/^\S+$/) && name.value.match(/^.{2,6}$/) && name.value.match(/[^\u0000-\u00FF]/)){
			nameError.innerHTML="";
		}
		else{
			stat=false;
			nameError.innerHTML="昵称长度错误";		
			return false;
		}
	};
	if(click=="click"){
		name.onblur();
	}
	
	return stat;
}


