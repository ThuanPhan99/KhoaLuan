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
	function editCategory(url) {
		if (checkRequired() == true) {
					var dataArray = {};
					var files = $('#picture')[0].files[0];
					var categoryID = $('#categoryID').val();
					if(categoryID.length==0){
						 if (files != undefined) {
							var reader = new FileReader();
							reader.onload = function(e) {
								dataArray["base64"] = e.target.result;
								dataArray["picture"] = files.name;
								dataArray["categoryName"] = $('#categoryName').val();
								uploadFile(dataArray,url);
							};
							reader.readAsDataURL(files);
						}else{
							$('#resultPicture').html('<i class="fa fa-exclamation-circle"></i> Vui lòng chọn file ảnh!')
						} 
					}else{
						if($("#picture").val().length==0){
							dataArray["categoryID"] = categoryID;
							dataArray["categoryName"] = $('#categoryName').val();
							updateFile(dataArray,url);
						}else{
							var reader = new FileReader();
							reader.onload = function(e) {
								dataArray["base64"] = e.target.result;
								dataArray["picture"] = files.name;
								dataArray["categoryID"] = categoryID;
								dataArray["categoryName"] = $('#categoryName').val();
								updateFile(dataArray,url);
							};
							reader.readAsDataURL(files);
						}
						
					}
					return false;
				}
		};

		function uploadFile(data,url) {

			$.ajax({
				url : url,
				type : 'POST',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(res) {
					$('#categoryName').val("");
					$('#picture').val("");
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
		function updateFile(data,url) {

			$.ajax({
				url : url,
				type : 'PUT',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(res) {
					$('#categoryName').val("");
					$('#picture').val("");
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