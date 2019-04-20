function addAddress(){
	var addButton=document.getElementById("addbutton");
	var address=document.getElementById("address");
	addButton.onclick=function(){
		address.className='address_change';
	};
}
