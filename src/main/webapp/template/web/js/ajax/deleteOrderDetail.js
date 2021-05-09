function clickDeleteOrderDetail(orderDetailID) {
		swal({
			  title: "Xác nhận hủy",
			  text: "Bạn có chắc chắn muốn hủy sản phẩm này trong đơn hàng không ?",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  deleteOrderDetai(orderDetailID)
			  } 
			});
};
function deleteOrderDetai(data) {
	$.ajax({
		url : '/api/orderdetailweb/'+data,
		type : 'DELETE',
		success : function(result) {
			swal("Đã hủy sản phẩm thành công", {
			      icon: "success",
			    });
			$('#orderDetailStatus_'+data).html("");
			$('#orderDetailStatus_'+data).html("<p>Đã hủy đơn</p>");
			$('#info-content-button-cancel_'+data).html("");
		},
		error : function(error) {

		}
	});
};