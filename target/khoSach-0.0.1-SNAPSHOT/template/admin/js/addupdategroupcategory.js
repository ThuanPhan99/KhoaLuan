
	$('#submitGroupCategory').click(function (e) {
		e.preventDefault();
	    var dataArray = {};
	    var files = $('#picture')[0].files[0];
	    if (files != undefined) {
            var reader = new FileReader();
            reader.onload = function(e) {
                dataArray["base64"] = e.target.result;
                dataArray["picture"] = files.name;
                alert(files.name);
                dataArray["groupCategoriesName"] = $('#groupCategoriesName').val();
                uploadFile(dataArray);
            };
            reader.readAsDataURL(files);
		}
    });

	function uploadFile(data) {
		 
	    $.ajax({
	        url: '${uploadURL}',
			type: 'POST',
			data: JSON.stringify(data),
			contentType: 'application/json',
			success: function (res) {
				alert("lol");
                console.log("thanh cong");
            },
			error: function (res) {
	            console.log(res);
            }
		});
    }