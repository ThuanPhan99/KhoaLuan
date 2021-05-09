function clickDeleteOrder(orderID) {
		swal({
			  title: "Xác nhận hủy",
			  text: "Bạn có chắc chắn muốn hủy đơn hàng này không ?",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  deleteOrder(orderID)
			  } 
			});
};
function deleteOrder(data) {
	$.ajax({
		url : '/api/order/'+data,
		type : 'DELETE',
		success : function(result) {
			swal("Đã hủy đơn thành công", {
			      icon: "success",
			    });
			$('#orderDelete_'+data).remove();
		},
		error : function(error) {

		}
	});
};