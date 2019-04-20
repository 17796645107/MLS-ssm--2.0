onload=function(){
	var mouse=document.getElementById("mouserover");
	var ceng=document.getElementById("top_ceng_none");
	mouse.onmouseover=function(){
		ceng.className='top_ceng';
	};
	ceng.onmouseout=function(){
		ceng.className='top_ceng_none';
	};
};