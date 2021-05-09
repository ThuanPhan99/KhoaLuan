function clickChiTiet(maHoaDon) {
			$.ajax({
				type : "GET",
						url : '/api/orderdetail/' + maHoaDon, //Tên api
						dataType : "json",
						success : function(result) {
							//	                 Lấy size của list này
							var listSize = Object.keys(result).length;
							if (listSize > 0) {
								$('#tbodyChiTiet_' + maHoaDon).html("");
								table = document.getElementById('tbodyChiTiet_'
									+ maHoaDon);
								for (i = 0; i < listSize; i++) {
									var row = table.insertRow(0);
									var cell = row.insertCell(0);
									var cell1 = row.insertCell(1);
									var cell2 = row.insertCell(2);
									var cell3 = row.insertCell(3);
									var cell4 = row.insertCell(4);
									var cell5 = row.insertCell(5);
									var cell6 = row.insertCell(6);
									var cell7 = row.insertCell(7);
									var cell8 = row.insertCell(8);

									cell.innerHTML = result[i].orderDetailID;
									cell1.innerHTML = result[i].productID;
									cell2.innerHTML = result[i].productName;
									cell3.innerHTML = result[i].statusString;
									cell4.innerHTML = "<img style='width: 60px' src='/image/product/"+result[i].thumbnail+"'>"
									cell5.innerHTML = result[i].quantity;
                                    cell6.innerHTML = result[i].price.toLocaleString("nv-VN", {style: "currency", currency: "VND", minimumFractionDigits: 0});
                                    cell7.innerHTML = result[i].totally.toLocaleString("nv-VN", {style: "currency", currency: "VND", minimumFractionDigits: 0});
                                    if(result[i].status==1){
										cell8.innerHTML ='<a onclick="deleteOrderDetail(this,'+result[i].orderDetailID+')"	style="color: #fff; cursor: pointer;" class="btn btn-sm btn-danger"> <i class="fa fa-trash-o"></i> </a>';
									}else{
										cell8.innerHTML ='';
									}
									
								}

							}

						}
					});

		};
		function deleteOrderDetail(r,orderDetailID) {
				swal({
					  title: "Xác nhận hủy",
					  text: "Bạn có chắc chắn muốn hủy sản phẩm này trong đơn hàng hay không",
					  icon: "warning",
					  buttons: true,
					  dangerMode: true,
					})
					.then((willDelete) => {
					  if (willDelete) {
						  deleteRowOrderDetailAjax(r,orderDetailID);
					  } 
					});
		};
		function deleteRowOrderDetailAjax(r,orderDetailID) {
			$.ajax({
				url : '/api/orderdetail/'+orderDetailID,
				type : 'DELETE',
				success : function(result) {
					swal("Xóa thành công", {
					      icon: "success",
					    });
					 var i = r.parentNode.parentNode.rowIndex;
					 document.getElementById("tableOrderDetail").deleteRow(i);
				},
				error : function(error) {

				}
			});
		};