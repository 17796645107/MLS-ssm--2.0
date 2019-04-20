onload=checkpassword;
function checkpassword(){
	var check=true;
	var passsword=document.getElementById("password");
	var oldpassword=document.getElementById("oldpassword");
	var newpassword=document.getElementById("newpassword");
	var pwd=document.getElementById("pwd");
	
	oldpassword.onblur=function(){
		if(password.value!=oldpassword.value){
			check=false;
			alert("密码错误");
		}
	};
	pwd.onblue=function(){
		if(newpassword.value!=pwd.value){
			check=false;
			alert("两次密码不一致");
		}
	};
	newpassword.onblur=function(){
		if(newpassword.value==oldpassword.value){
			check=false;
			alert("新密码不能和旧密码相同");
		}
	};
	return check;
}