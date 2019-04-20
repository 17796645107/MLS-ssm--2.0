onload=function(){
	//商品数量计数器
	var jia=document.getElementById("jia");
	var jian=document.getElementById("jian");
	var number=document.getElementById("number");
	
	jia.onclick=function(){
		number.value++;
		if(number.value<1){
			number.value=1;
		}
	};
	jian.onclick=function(){
		number.value--;
	};	
	
	//仿淘宝商品信息局部放大插件
	var imgc=document.getElementById("photo");
	var divc=document.getElementById("preview");
	var closec=document.getElementById("closec");
	imgc.onmouseover=function(){
		divc.className='buy_float_change';
	};
	//关闭按钮
	closec.onclick=function(){
		divc.className='buy_float';
	};
	var color_button=document.getElementById("color");
	var size_button=document.getElementById("size");
	color_button.onclick=check();
	size_button.onclick=check();
};	
	
// 显示库存
function check(){
	var color=document.getElementById("color").value;
	var size=document.getElementById("size").value;
	var product_id=document.getElementById("product_id").value;
	var product_num=document.getElementById("product_num");
	if(color.value!="" && size.value!=""){
		//1.创建ajax对象
	    var xhr = ajaxFunction();
	    var data="";//接收返回数据
	    xhr.onreadystatechange = function() {
	        //处理后台返回的数据
	        if(xhr.readyState == 4) {
	            if(xhr.status == 200) {
	                data= xhr.responseText;
	                product_num.innerHTML=data;
	            }
	        }
	    };
	    
	    //规定发送数据的形式（post/get），url，以及传输方式(同步/异步)
	    xhr.open("post","./product/shouProductNum",true);
	    //post方式提交
	    xhr.setRequestHeader("Content-type","application/json");
	    //将页面输入数据发送到后台
	    xhr.send(JSON.stringify({product_id:product_id,color:color,size:size}));
	   	    	    
		//创建ajax对象
		function ajaxFunction() {
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
		};
	}
};


//选择颜色
function setColor(id){
	var color=document.getElementById("color");
	color.value=id.value;
	var select=id.id;//选中按钮ID
	var colorArr=new Array();
	colorArr=document.getElementById("product_color").getElementsByTagName("input");//按钮数组
	for(var i=0;i<colorArr.length;i++){
		if(i+1!=select){
			colorArr[i].style.background="";//清除没有选中的按钮的样式
		}
	}
	//改变背景
	id.style.background="url(http://s7.mogucdn.com/pic/140804/eeee_ieygcmbsmuywcnzxmiytambqgiyde_11x11.png) 100% 100% no-repeat";
}
//选择尺寸
function setSize(id){
	var size=document.getElementById("size");
	size.value=id.value;
	var select=id.id;//选中按钮ID
	var colorArr=new Array();
	colorArr=document.getElementById("product_size").getElementsByTagName("input");//按钮数组
	for(var i=0;i<colorArr.length;i++){
		if(i+1!=select){
			colorArr[i].style.background="";//清除没有选中的按钮的样式
		}
	}
	//改变背景
	id.style.background="url(http://s7.mogucdn.com/pic/140804/eeee_ieygcmbsmuywcnzxmiytambqgiyde_11x11.png) 100% 100% no-repeat";
}

//用户添加商品
function addCart(){
	//首先，判断用户是否登陆，未登陆则跳转到登陆页面
	var user=document.getElementById("user_id");
	//用户未登陆
	if(user.value==""){
		alert("请先登陆");
		window.location.href='./user/loginFrom';
	}
	//用户已经登陆
	else{
		//ajax异步，用户添加商品
		var userId=document.getElementById("user_id").value;//用户ID
		var productId = document.getElementById("product_id").value;//商品编号
	    var productNumber=document.getElementById("number").value;//商品数量
	    /*if(productNumber==0){
	    	productNumber=1;
	    }*/
	    var color=document.getElementById("color").value;
	    var size=document.getElementById("size").value;
	    
	    //1.创建ajax对象
	    var xhr = ajaxFunction();
	    var data="";//接收返回数据
	    xhr.onreadystatechange = function() {
	        //处理后台返回的数据
	        if(xhr.readyState == 4) {
	            if(xhr.status == 200) {
	                data= xhr.responseText;
	                //弹出层显示
	                if(data=="success"){//添加成功
	        			var gobuy=document.getElementById("gobuy");//弹出层
	        			var close=document.getElementById("close");//弹出层关闭按钮
	        			//显示弹出层
	        			gobuy.className="go_buy_change";
	        			//关闭按钮
	        			close.onclick=function(){
	        				gobuy.className="go_buy";
	        			};		
	        		}
	                else if(date="error"){
	                	alert("请选择颜色或尺寸");
	                }
	        		//添加失败 
	        		else{
	        			alert("商品添加失败,请重试");		
	        		}
	            }
	        }
	    };
	    
	    //规定发送数据的形式（post/get），url，以及传输方式(同步/异步)
	    xhr.open("post","./product/addProductToCart",true);
	    //post方式提交
	    xhr.setRequestHeader("Content-type","application/json");
	    //将页面输入数据发送到后台
	    xhr.send(JSON.stringify({user_id:userId,product_id:productId,product_number:productNumber,product_color:color,product_size:size}));
	   	    	    
		//创建ajax对象
		function ajaxFunction() {
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
		};
	}
};
//收藏
function collectProduct(){
	
}
