 
 function deleteCheck(id,url) {
	 swal({
		  title: "Xác nhận xóa",
		  text: "Bạn có chắc chắn muốn xóa hay không",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  deleteGCP(id,url);
		    
		  } 
		});
	 };
	 function deleteGCP(id, url) {
	        $.ajax({
	            url: url,
	            type: 'DELETE',
	        	contentType : 'application/json',
	    		data : JSON.stringify(id),
	            dataType : "json",
	            success: function (result) {
	            	var listSize = Object.keys(result).length;
					 if(result==0){
						 swal("Không thể xóa ( Đã tồn tại trường con)");
					 }else{
							swal("Xóa thành công!", "nhấn ok để thoát!", "success");
						 $('#trGC_' + id).remove();
					 }
	            	
	            },
	            error: function (error) {
	            	
	            }
	        });
	 };