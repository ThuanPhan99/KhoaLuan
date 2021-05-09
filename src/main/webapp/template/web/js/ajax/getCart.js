	

	function getCartAjax() {
		$.ajax({
			url : '/api/cart',
			type : 'GET',
			dataType : "json",
			success : function(result) {
				$(".header-chart-dropdown").html("");
				$(".header-chart-dropdown").append('<div class="header-chart-dropdown-list-all"></div>');
				$(".header-chart-dropdown-list-all").append('<label style="width: 100%; font-size: 16px; padding-bottom: 5px; font-weight: 600; border-bottom: 1px solid #ccc;">GIỎ HÀNG</label>');
				var listSize = Object.keys(result).length;
	            if (listSize > 0) {
	            	for (i = 0; i < listSize; i++) {
	            	var total = 0 ;
	            	productInCart ='<div class="header-chart-dropdown-list"><div class="dropdown-chart-left floatleft">	<a href="#"><img src="/image/product/'+result[i].product.thumbnail+'"style="width: 40px;"></a></div>';
	            	productInCart += '<div class="dropdown-chart-right"><h2>'+result[i].product.productName+'</h2><h3>Số lượng :'+result[i].quantity+'</h3>'	;
	            	var price = (result[i].product.price*(100-result[i].product.salePrice))/100;
	            	productInCart +='<h4>'+	price+' VND</h4></div></div>';	
	            	total += price*result[i].quantity;
	            	$(".header-chart-dropdown-list-all").append(productInCart);
	            	}		
	            	$(".header-chart-dropdown").append(	'<div class="chart-checkout"><p>	Tổng tiền<span style="text-transform: uppercase;">'	+total+' VND</span>	</p> <button type="button" class="btn btn-default"><a href="/gio-hang">Xem giỏ hàng</a>	</button></div>');
	            }
	           
			},
			error : function(res) {
			}
		});
	}