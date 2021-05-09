 function updateStatusOrder(orderID, status) {
	 $.ajax({
			url :'/api/orderadmin/'+orderID+'/'+status,
			type : 'PUT',
			contentType : 'application/json',
			dataType : "json",
			success : function(result) {
				 var listSize = Object.keys(result).length;
				 if(listSize>0){
					 var productIDs =result[0];
					 for (i = 1; i < listSize; i++) {
						 productIDs += "," + result[i];
					 }
					 swal("Sản phẩm có mã "+productIDs+ " không đủ số lượng trong kho", "nhấn ok để thoát!", "warning");
				 }else{
					 $('#trGC_' + orderID).remove();
				 }
					
			},
			error : function(error) {

			}
		});
    }
