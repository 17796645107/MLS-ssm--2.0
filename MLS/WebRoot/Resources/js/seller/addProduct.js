onload=function(){
	var obj=document.getElementById("message");

	if(obj.value=="true"){
		alert("商品添加成功");
	};
	if(obj.value=="false"){
		alert("商品添加失败，请重新添加");
	};
};