			function searchKeyUp() {
						var key = $("#search").val();
						if($('#search').val().length != 0){
						$.ajax({
							type : "GET",
							url : "/api/search/"+key, //Tên api
							dataType : "json",
							async : true,
							cache : false,
							success : function(result) {
								var listSize = Object.keys(result).length;
								if (listSize == 0) {
									$('#resutlSearch').html("");
									$('#resutlSearch').append("<label class='labelSearch' ><a>Không tìm thấy...</a></label>");
									return;
								}
								//Nếu list tồn tại thì reset thông điệp cảnh báo về rỗng và loop dữ liệu hiển thị ra table
								if (listSize > 0) {
									$('#resutlSearch').html("");
									//Khai báo table kiểu global để sử dụng ngoài fuction này
									var size = 10;
									if (listSize < 10) {
										size = listSize;
									}
									for (i = 0; i < size; i++) {
										$('#resutlSearch').append("<li class='liSearch' > <a href='/tim-kiem?search="+result[i]+"'> " + result[i]+ "</a></li>"
										)
									}
								}

							}
						
						});
						}else{
							$('#resutlSearch').html("");
						}
				}

		window.onclick = function(event) {
			  if (!event.target.matches('#search')) {
			     $("#resutlSearch").html("");
			}
		}
		$(document).ready(
				function() {
					$('#search').click(
							function() {
								searchKeyUp()
						});
	
				});
		