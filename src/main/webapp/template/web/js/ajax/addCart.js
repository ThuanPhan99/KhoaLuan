/* check so luong input  */
		  $("#qty_count").change(function(){
			  	 var soLuong = parseInt($('#qty_count').val(),10);
			      if(soLuong==0){
				    	$("#qty_count").val("1");
			     }
			});
		 /*  <!-- Tăng số lượng
		//--> */
		  $("#qty_count_tru").click(function(){
		  	 var soLuong = parseInt($('#qty_count').val(),10);
		      if(soLuong>1){
			    	$("#qty_count").val(soLuong-1);
		     }
			  });
			  $("#qty_count_cong").click(function(){
			     var soLuong = parseInt($('#qty_count').val(),10)+1;
			    $("#qty_count").val(soLuong);
			  });
			  /*  <!-- Thêm vào giỏ hàng//--> */
			$('#btnAddCart').click(function(e) {
					e.preventDefault();
				var productQuantity = parseInt($('#productQuantity').val(),10);
				var quantityAdd = parseInt($('#qty_count').val(),10);
				if (quantityAdd > productQuantity){
					$("#myModalQuantity").modal();
				} else {
					var data = {};
					data["productID"] = $('#productCart').val();
					data["quantity"] = $('#qty_count').val();
					editInfoCart($('#qty_count').val());
					addCart(data);
					getCartAjax();
				}
		    });
			function addCart(data) {
				$.ajax({
					url : '/api/cart/'+data["productID"]+'/'+ data["quantity"],
					type : 'POST',
					success : function(res) {
						
					},
					error : function(res) {
						
					}
				});
			}
			function editInfoCart(quantity) {
			    var totalQuantity = parseInt($('#totalQuantity').text(), 10);
			    var newQuanTity = parseInt(quantity, 10);
			    $('#totalQuantity').text(totalQuantity + newQuanTity);// thay tong so luong
			   
			}