	function clickButtonOrder(button,status) {
		$("button").removeClass("buttonOrderActive");
		$(button).addClass("buttonOrderActive");
		updatePasswordAjax(status);
	}
	function updatePasswordAjax(data) {
		$.ajax({
			url : '/api/order/'+data,
			type : 'GET',
			dataType : "json",
			success : function(result) {
				$('#hrorder-context').html("");
				var listSize = Object.keys(result).length;
	            if (listSize > 0) {
	            	for (i = 0; i < listSize; i++) {
	            		var infoRow=' <div id="orderDelete_'+result[i].orderID+'" class="info-content"><div class="info-content-top"><div class="info-content-top-left"><div class="info-content-top-order">';
	            		infoRow +='Đơn hàng<a href="/chi-tiet-don-hang?id='+result[i].orderID+'">#'+result[i].orderID+'</a></div>'+'<p>Ngày đặt :'+result[i].dateOfIssueString+'</p></div><div class="info-content-top-right"><a href="/khoSach/chi-tiet-don-hang?id='+result[i].orderID+'">QUẢN LÝ</a></div></div><hr>';
	            		var orderDetailSize = result[i].listOrDerDetail.length;		
	            		for (j = 0; j < orderDetailSize; j++) {	
	            			infoRow += '<div class="info-content-bottom"><div class="info-content-bottom-img"><a href=""><img src="/image/product/'+result[i].listOrDerDetail[j].thumbnail+'"></a></div>';
	            			infoRow += '<div class="info-content-bottom-name"><p>'+result[i].listOrDerDetail[j].productName+'</p></div>';
	            			infoRow +='<div class="info-content-bottom-qty"><span>Số lượng :'+result[i].listOrDerDetail[j].quantity+'</span></div>';
	            			if(result[i].listOrDerDetail[j].status==0){
	            				infoRow +='<div class="info-content-bottom-dev"><p>Đã hủy đơn</p></div>';
	            			}else{
	            				if(result[i].status==1){
	            					infoRow +='<div id="orderDetailStatus_'+result[i].listOrDerDetail[j].orderDetailID+'" class="info-content-bottom-dev"><p>Đang chờ duyệt</p></div>';
	            				}else if(result[i].status==2 ){
	            					infoRow +='<div class="info-content-bottom-dev"><p>Đã duyệt đơn</p></div>';
	            				}else if( result[i].status==3){
	            					infoRow +='<div class="info-content-bottom-dev"><p>Đang giao hàng</p></div>';
	            				}else{
	            					infoRow +='<div class="info-content-bottom-dev"><p>Đã giao hàng</p></div>';
	            				}
	            			}
	            			if(result[i].status==4){
	            				infoRow +='<div class="info-content-bottom-date"> <span>Ngày giao hàng :'+result[i].deliveryDateString+'</span></div>';
	            			}
	            			if(result[i].listOrDerDetail[j].status==1 && result[i].status==1){
	            				infoRow +='<div style="display: block;  width: 24%;" class="info-content-button-cancel"><button class="btn-delet-order" onclick="clickDeleteOrderDetail('+result[i].listOrDerDetail[j].orderDetailID+'") >Hủy</button></div>';
	            			}
	            			infoRow +='</div>';	
	            		}
	            		if(result[i].status==1){
	            			infoRow +='<div class="info-content-button-cancel"><button class="btn-delet-order" onclick="clickDeleteOrder('+result[i].orderID+'")>Hủy Đơn</button></div>';
	            		}
	            		$('#hrorder-context').append(infoRow);	
	            	}
	            }else{
	            	$('#hrorder-context').append('<h1 class="order-tilte-null">Không có sản phẩm nào </h1>');
	            }
			},
			error : function(res) {
			}
		});
	}