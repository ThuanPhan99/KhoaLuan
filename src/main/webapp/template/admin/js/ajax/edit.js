function checkRequired() {
	var flag = true;
	$(".required").each(function() {
		var check = $(this).val();
		if (check == '') {
			flag = false;
		}
	})
	return flag;
}

function submitEdit(url) {
	var data = {};
	if (checkRequired() == true) {
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});
		var id = $('#idModel').val();
		if (id == "") {
			add(data, url);
		} else {
			update(data, url);
		}
		return false;
	}
};

function add(data, url) {
	$
			.ajax({
				url : url,
				type : 'POST',
				data : JSON.stringify(data),
				contentType : 'application/json',
				date:'json',
				success : function(res) {
					if(res==0){
						$('#resultProductID').html('<i class="fa fa-exclamation-circle"></i> Mã sản phẩm không tồn tại');
					}else if(res==1){
						$('#resultProductID').html('<i class="fa fa-exclamation-circle"></i> Mã sản phẩm đã đã tồn tại');
					}else{
						$('#infoAlert').html("");
						$('#infoAlert')	.append('<div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory"></div>');
						$('#alertCategory').addClass("alert alert-success");
						$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
						$('#alertCategory').append('Thêm thành công');
					}
				},
				error : function(res) {
					$('#infoAlert').html("");
					$('#infoAlert')	.append('<div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory"></div>');
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory')	.append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Lỗi hệ thống');
				}
			});
}
function update(data, url) {

	$
			.ajax({
				url : url,
				type : 'PUT',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(res) {
					$('#infoAlert').html("");
					$('#infoAlert')	.append('<div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory"></div>');
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Cập nhật thành công');
				},
				error : function(res) {
					$('#infoAlert').html("");
					$('#infoAlert')	.append('<div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory"></div>');
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory')	.append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Lỗi hệ thống');
				}
			});
}
