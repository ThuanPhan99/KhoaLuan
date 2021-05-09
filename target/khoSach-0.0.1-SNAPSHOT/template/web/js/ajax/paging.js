	var totalPages = $("#totalProduct").val();
	var currentPage =$("#page").val();
	var search = $("#searchPaging").val();
	var url = $("#url").val();
	$(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 5,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
            		searchAjax(page,2,search,url);
					$('#page').val(page);
				}
            }
        });
    });
	function searchAjax(page,limit,search,url) {
		$.ajax({
			url : url+'/'+search+'/'+page+'/'+limit,
			type : 'GET',
			dataType : "json",
			success : function(result) {
				$('.product-list-dm ').html("");
				var listSize = Object.keys(result).length;
	            if (listSize > 0) {
	            	for (i = 0; i < listSize; i++) {
	            		var product ='<a href="/chi-tiet-san-pham?id='+result[i].productID+'"style="margin: 10px;">';
	            		product +='<div class="product-single text-center"><div class="product-img"><img style="padding-top: 20px" src="/image/product/'+result[i].thumbnail+'">';
	            		product +='<div class="sale">'+result[i].salePrice+'%</div></div>';
						product +='<div class="product-desc"><div class="product-title" style="padding: 10px;"><h4 style="color: #000">'+result[i].productName+'</h4></div></div>';
						var price = (result[i].price*(100-result[i].salePrice))/100;
						product +='<div class="product-desc ">	<div class="product-price" style="padding-left: 10px"><ins>'+price+' VND</ins><del>'+result[i].price+' VND</del></div></div></div>	</a>';
						$('.product-list-dm ').append(product);
	            	}
	            }
			},
			error : function(res) {
			}
		});
	}