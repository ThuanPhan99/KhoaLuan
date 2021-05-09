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
									if(result[i].status==1){
										var row = table.insertRow(0);
										var cell = row.insertCell(0);
										var cell1 = row.insertCell(1);
										var cell2 = row.insertCell(2);
										var cell3 = row.insertCell(3);
										var cell4 = row.insertCell(4);
										var cell5 = row.insertCell(5);
										var cell6 = row.insertCell(6);
	
										cell.innerHTML = result[i].orderDetailID;
										cell1.innerHTML = result[i].productID;
										cell2.innerHTML = result[i].productName;
										cell3.innerHTML = "<img style='width: 60px' src='/image/product/"+result[i].thumbnail+"'>"
										cell4.innerHTML = result[i].quantity;
                                        cell5.innerHTML = result[i].price.toLocaleString("nv-VN", {style: "currency", currency: "VND", minimumFractionDigits: 0});
                                        cell6.innerHTML = result[i].totally.toLocaleString("nv-VN", {style: "currency", currency: "VND", minimumFractionDigits: 0});

                                    }
								}

							}

						}
					});

		};