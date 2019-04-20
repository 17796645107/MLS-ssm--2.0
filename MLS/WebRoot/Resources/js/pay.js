function pay(){
	var idArr=new Array();//创建数组对象
	var arr=new Array();
	idArr=document.getElementsByClassName("order_id");//获取购物车商品ID
	for(var i=0;i<idArr.length;i++){
		arr[i]=idArr[i].value;
	}
	location.href = "./order/pay?idList="+arr;
}