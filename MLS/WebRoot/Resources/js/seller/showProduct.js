
onload=function(){
	var retunMessage=document.getElementById("retunMessage").value;
	if(retunMessage=="success"){
		alert("商品删除成功");
	}
	if(retunMessage=="fail"){
		alert("商品删除失败");
	}
};
function cli(Obj){

    var collid = document.getElementById("selectall");
    var coll = document.getElementsByName(Obj);
    if (collid.checked){
     for(var i = 0; i < coll.length; i++)
     coll[i].checked = true;
    }else{
     for(var i = 0; i < coll.length; i++)
     coll[i].checked = false;
    }
}
function todelete() {
    var msg = "确认删除选中商品？";
    if(confirm(msg)==true){
        var chk_value = [];//定义一个数组
        //利用将name等于ids的多选按钮得到
        $("#table_list").find(":input[id='case']:checked").each(function(){
                //获取id值，因为id单元格在复选框单元格的下一个元素
                var val = $(this).parent().next().text();
                //将id值添加到数组
                chk_value.push(val);
            });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            //在浏览器控制台打印信息
            console.log(chk_value);
            location.href = "${ctx}/tec/isdeleteMany.do?chk_value=" + chk_value;
        }
    }

}

//确认删除弹出框,删除商品
function firm() { 
    //利用对话框返回的值 （true 或者 false）
    if (confirm("你确定删除吗？")){
    	//ajax异步，商家删除商品
		var id=document.getElementById("id").value;//商品ID
		var seller_id=doucument.getElementById("seller_id").value;//卖家ID
		var pageNow=document.getElementById("pageNow").value;//当前页数
		var retunMessage=document.getElementById("retunMessage");//返回信息
	    //1.创建ajax对象
	    var xhr = ajaxFunction();
	    var data="";//接收返回数据
	    xhr.onreadystatechange = function() {
	        //处理后台返回的数据
	        if(xhr.readyState == 4) {
	            if(xhr.status == 200) {
	                data= xhr.responseText;
	                retunMessage.innerHtml=data;
	            }
	        }
	    };
	    
	    //规定发送数据的形式（post/get），url，以及传输方式(同步/异步)
	    xhr.open("post","./seller/deleteProduct",true);
	    //post方式提交
	    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    //将页面输入数据发送到后台
	    xhr.send("id="+id);
    	return true;    	
    }  
    return false;
}
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
