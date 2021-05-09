$('#allcheckbox').click(function() {
	if ($(this).prop("checked") == true) {
		$("input").prop("checked", true);
	} else if ($(this).prop("checked") == false) {
		$("input").prop("checked", false);
	}
});
$('#refresh').click(function() {
	$("input").prop("checked", false);
});
function clickDelete(url) {
	var ids = $('tbody input[type=checkbox]:checked').map(function() {
		return $(this).val();
	}).get();
	if (ids.length == 0) {
		swal("Vui lòng chọn ít nhất 1 trường");
	} else {
		swal({
			  title: "Xác nhận xóa",
			  text: "Bạn có chắc chắn muốn xóa hay không",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  deleteRow(ids, url);
			    
			  } 
			});
	}
};
function deleteRow(data, url) {
	$.ajax({
		url : url,
		type : 'DELETE',
		contentType : 'application/json',
		data : JSON.stringify(data),
		success : function(result) {
			swal("Xóa thành công", {
			      icon: "success",
			    });
			for (var i = 0; i < data.length; i++) {
				$('#trGC_' + data[i]).remove();
			}
		},
		error : function(error) {

		}
	});
};