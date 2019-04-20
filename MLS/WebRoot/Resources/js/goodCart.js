window.onload = function() {
	var spanEle = document.getElementsByClassName("card_number");
	var input = document.getElementsByClassName("card_number_value");

	var price = document.getElementsByClassName("card_price");
	var sub = document.getElementsByClassName("card_subtotal");

	var t = 0;
	for(var i = 0; i < sub.length; i++) {
		sub[i].innerText = price[i].innerText * input[i].value;
		t += parseInt(sub[i].innerText);
	}
	var total = document.getElementById("total");
	if(total){
	    total.innerText =  t;
    }
	
	for(var i = 0; i < spanEle.length; i++) {
		spanEle[i].act = i;
		spanEle[i].onclick = function() {
			var put = input[parseInt(this.act / 2)];
			if(this.act % 2 == 0) {
				if(put.value <= 0) {
					return;
				} else {
					put.value = parseInt(put.value) - 1;
				}
			} else {
				put.value = parseInt(put.value) + 1;
			}
			
			if(sub) {
				sub[parseInt(this.act / 2)].innerText = price[parseInt(this.act / 2)].innerText * put.value;

				var t = 0;
				for(var i = 0; i < price.length; i++) {
					sub[i].innerText = price[i].innerText * input[i].value;
					t += parseInt(sub[i].innerText);
				}
				total.innerText =  t;
			}
		};
	};
};

//更新商品数量到购物车
function deleteProductFromCart(){
	//1.创建ajax对象
    var xhr = ajaxFunction();
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
   
    //规定发送数据的形式（post/get），url，以及传输方式(同步/异步)
    xhr.open("post","./cart/deleteProductFromCart",true);
    //post方式提交
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    //将页面输入数据发送到后台
    var cart_id=document.getElementById("cart_id").value;
    xhr.send("id="+cart_id);

	//接收返回数据
    var data="";
    xhr.onreadystatechange = function() {
        //处理后台返回的数据
        if(xhr.readyState == 4) {
            if(xhr.status == 200) {
                data= xhr.responseText;
                if(data=="success"){
            		alert("删除商品成功");
            	}
            	if(data=="fail"){
            		alert("删除商品失败");
            	}
            }
        }
    };
};
//生成订单
function toPay(){
	var idArr=new Array();//创建数组对象
	var arr=new Array();
	idArr=document.getElementsByClassName("cart_id");//获取购物车商品ID
	for(var i=0;i<idArr.length;i++){
		arr[i]=idArr[i].value;
	}
	location.href = "./order/toPay?idList="+arr;
	/*//1.创建ajax对象
    var xhr = ajaxFunction();
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
   
    //规定发送数据的形式（post/get），url，以及传输方式(同步/异步)
    xhr.open("post","./order/toPay",true);
    //post方式提交
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    //将页面输入数据发送到后台
    xhr.send("idList="+arr);*/

	//接收返回数据
    /*var data="";
    xhr.onreadystatechange = function() {
        //处理后台返回的数据
        if(xhr.readyState == 4) {
            if(xhr.status == 200) {
                data= xhr.responseText;
                if(data=="success"){
            		alert("删除商品成功");
            	}
            	if(data=="fail"){
            		alert("删除商品失败");
            	}
            }
        }
    };*/
}