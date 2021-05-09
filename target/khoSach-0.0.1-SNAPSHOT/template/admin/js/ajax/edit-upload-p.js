function checkRequired() {
	var flag = true;
	$("#formSubmit .required").each(function() {
		var check = $(this).val();
		if (check == '') {
			flag = false;
		}
	})
	return flag;
}

function checkRequiredPublisher() {
	var flag = true;
	$("#publisherNew .required").each(function() {
		var check = $(this).val();
		if (check == '') {
			flag = false;
		}
	})
	return flag;
}

function submitPublisher(url) {
	var data = {};
	if (checkRequiredPublisher() == true) {
		var formData = $('#publisherNew').serializeArray();
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});
		var id = $('#idModel').val();
		addPublisher(data, url);
		return false;
	}
};

function addPublisher(data,url) {
	$.ajax({
		url : url,
		type : 'POST',
		data : JSON.stringify(data),
		contentType : 'application/json',
		success : function(res) {
			$('#alertCategoryPublisher').html("");
			$('#alertCategoryPublisher').addClass("alert alert-success");
			$('#alertCategoryPublisher').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
			$('#alertCategoryPublisher').append('Thêm thành công');
			location.reload();
		},
		error : function(res) {
			$('#alertCategoryPublisher').html("");
			$('#alertCategoryPublisher').addClass("alert alert-success");
			$('#alertCategoryPublisher').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
			$('#alertCategoryPublisher').append('Lỗi hệ thống');
		}
	});
}

function checkRequiredAuthor() {
	var flag = true;
	$("#authorNew .required").each(function() {
		var check = $(this).val();
		if (check == '') {
			flag = false;
		}
	})
	return flag;
}

function submitAuthor(url) {
	var data = {};
	if (checkRequiredAuthor() == true) {
		var formData = $('#authorNew').serializeArray();
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});
		var id = $('#idModel').val();
		addAuthor(data, url);
		return false;
	}
};

function addAuthor(data,url) {
	$.ajax({
		url : url,
		type : 'POST',
		data : JSON.stringify(data),
		contentType : 'application/json',
		success : function(res) {
			$('#alertCategoryAuthor').html("");
			$('#alertCategoryAuthor').addClass("alert alert-success");
			$('#alertCategoryAuthor').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
			$('#alertCategoryAuthor').append('Thêm thành công');
			location.reload();
		},
		error : function(res) {
			$('#alertCategoryAuthor').html("");
			$('#alertCategoryAuthor').addClass("alert alert-success");
			$('#alertCategoryAuthor').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
			$('#alertCategoryAuthor').append('Lỗi hệ thống');
		}
	});
}

function editProduct(url) {
	if (checkRequired() == true) {

		var priceAdd = $('#priceAdd').val();
		var price = $('#price').val();
		if(parseInt(priceAdd) >= parseInt(price)){

			$('#infoAlert').html("");
			$('#infoAlert')	.append('<div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory"></div>');
			$('#alertCategory').addClass("alert alert-danger");
			$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
			$('#alertCategory').append('Giá bán phải cao hơn giá nhập.');

		} else {
			var dataArray = {};
			var files = $('#thumbnail')[0].files[0];
			var productID = $('#productID').val();
			if (productID.length == 0) {
				if (files != undefined) {
					var reader = new FileReader();
					reader.onload = function(e) {
						dataArray["base64"] = e.target.result;
						dataArray["thumbnail"] = files.name;
						var formData = $('#formSubmit').serializeArray();
						$.each(formData, function(i, v) {
							dataArray["" + v.name + ""] = v.value;
						});
						dataArray["description"] = CKEDITOR.instances['description'].getData();
						addProduct(dataArray, url);
					};
					reader.readAsDataURL(files);
				} else {
					$('#resultPicture')
						.html(
							'<i class="fa fa-exclamation-circle"></i> Vui lòng chọn file ảnh!')
				}
			} else {
				if ($("#thumbnail").val().length == 0) {
					var formData = $('#formSubmit').serializeArray();
					$.each(formData, function(i, v) {
						dataArray["" + v.name + ""] = v.value;
					});
					dataArray["description"] = CKEDITOR.instances['description']
						.getData();
					updateProduct(dataArray, url);
				} else {
					var reader = new FileReader();
					reader.onload = function(e) {
						dataArray["base64"] = e.target.result;
						dataArray["thumbnail"] = files.name;
						var formData = $('#formSubmit').serializeArray();
						$.each(formData, function(i, v) {
							dataArray["" + v.name + ""] = v.value;
						});
						dataArray["description"] = CKEDITOR.instances['description']
							.getData();
						addProduct(dataArray, url);
					};
					reader.readAsDataURL(files);
				}

			}

		}
		return false;
	}
};

function addProduct(data, url) {
	$
			.ajax({
				url : url,
				type : 'POST',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(res) {
					$('#infoAlert').html("");
					$('#infoAlert')	.append('<div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory"></div>');
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Thêm thành công');
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
function updateProduct(data, url) {
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

$(document).ready(function(){

	$("#addAuthor").click(function(){
		document.getElementById("authorNew").reset();
		$("#addAuthorModal").modal();
	});

	$("#addPublisher").click(function(){
		document.getElementById("publisherNew").reset();
		$("#addPublisherModal").modal();
	});
});
