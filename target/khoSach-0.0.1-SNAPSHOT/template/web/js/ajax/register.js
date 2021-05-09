	   function submitRegister() {
					var data = {};
				    var formData = $('#formSubmit').serializeArray();
				    $.each(formData, function (i, v) {
			            data[""+v.name+""] = v.value;
			        });
				    register(data);
				};
		function register(data) {
			$.ajax({
				url : '/api/user' ,
				type : 'POST',
				data : JSON.stringify(data),
				contentType : 'application/json',
				dataType : "json",
				success : function(res) {
					$('#resultUserName').html("");
					$('#resultNumberPhone').html("");
					$('#resultEmail').html("");
					if(res==0){
						$('#resultUserName').html('<i class="fa fa-exclamation-circle"></i> Tên đăng nhập đã tồn tại');
					}else{
						if(res==1){
							$('#resultNumberPhone').html('<i class="fa fa-exclamation-circle"></i> Số điện thoại đã tồn tại');
						}else{
							if(res==2){
								$('#resultEmail').html('<i class="fa fa-exclamation-circle"></i> Email đã tồn tại');
							}else{
								$('#alertCategory').html("");
								$('#alertCategory').addClass("alert alert-success");
								$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
								$('#alertCategory').append('Đăng ký thành công. Đăng nhập ngay nào');
								$('#resultUserName').html("");
								$('#resultNumberPhone').html("");
								$('#resultEmail').html("");
							}
						}
					}
					
				},
				error : function(res) {
					$('#alertCategory').html("");
					$('#alertCategory').addClass("alert alert-success");
					$('#alertCategory').append('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$('#alertCategory').append('Lỗi hệ thống');
				}
			});
		}
		
		