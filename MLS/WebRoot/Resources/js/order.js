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

