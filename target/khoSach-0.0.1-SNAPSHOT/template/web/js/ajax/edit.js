	function submitEdit(url) {
					var data = {};
				    var formData = $('#formSubmit').serializeArray();
				    $.each(formData, function (i, v) {
			            data[""+v.name+""] = v.value;
			        });
				    var id = $('#idModel').val();
				    if (id == "") {
				    	add(data,url);
				    } else {
				    	update(data,url);
				    }
				};

		function add(data,url) {
			$.ajax({
				url : url,
				type : 'POST',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(res) {
					$('#alertCategory').html("");
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Thêm thành công');	
				},
				error : function(res) {
					$('#alertCategory').html("");
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Lỗi hệ thống');
				}
			});
		}
		function update(data,url) {

			$.ajax({
				url : url,
				type : 'PUT',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(res) {
					$('#alertCategory').html("");
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Cập nhật thành công');
					location.reload();
				},
				error : function(res) {
					$('#alertCategory').html("");
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Lỗi hệ thống up');
				}
			});
		}
		function updatePassword(url) {
			if($('#passwordNew').val()==$('#passwordConfirm').val()){
				var data = {};
				data["passwordOld"] = $('#passwordOld').val();
				data["passwordNew"] = $('#passwordNew').val();
				updatePasswordAjax(data,url)
			}else{
				$('#resultPasswordConfirm').html( '<i class="fa fa-exclamation-circle"></i> Mật khẩu xác nhận không trùng mật khẩu mới');
			}
		}
		function updatePasswordAjax(data,url) {

			$.ajax({
				url : url,
				type : 'PUT',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(result) {
					var listSize = Object.keys(result).length;
		            if (listSize > 0) {
						$('#alertCategory').html("");
						$('#alertCategory').addClass("alert alert-success");
						$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
						$('#alertCategory').append('Cập nhật thành công');	
						$('#resultPasswordConfirm').text("");
						$('#passwordOld').val();
						$('#passwordConfirm').val();
						$('#passwordNew').val();
		            }else{
		            	$('#resultPasswordOld').html( '<i class="fa fa-exclamation-circle"></i> Sai mật khẩu cũ');
		            }
				},
				error : function(res) {
					$('#alertCategory').html("");
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Lỗi hệ thống up');
				}
			});
		}
		$('#passwordConfirm').change(function(){
			if($('#passwordNew').val()==$('#passwordConfirm').val()){
				$('#resultPasswordConfirm').text("");
			}else{
				$('#resultPasswordConfirm').html('<i class="fa fa-exclamation-circle"></i> Mật khẩu xác nhận không trùng mật khẩu cũ');
			}
		});
		