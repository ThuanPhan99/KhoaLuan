<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="cartURL" value="/api/cart" />
<c:url var="oderURL" value="/dat-hang" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>3Tbook - giỏ hàng</title>
</head>
<body>
<div class="container">
	<section class="product-detail bg-gray py-5"
			 style="padding-top: 20px !important">
		<div class="container">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb text-capitalize bg-white">
					<li class="breadcrumb-item"><a style="color: #000"
												   href='<c:url value='/trang-chu' />' class="text-purple font-15pt">trang
						chủ</a></li>
					<li style="color: #026e36" class="breadcrumb-item active font-15pt">giỏ
						hàng</li>
				</ol>
			</nav>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<c:if test="${empty listCart}">
						<div class="cart-empty text-center">
							<img src="<c:url value="/image/logo/cart-empty.png"/>" class="img-fluid cart-empty-img">
							<div class="font-title my-2 text-capitalize">giỏ hàng trống</div>
							<a style="background: #026e36;"
							   href="<c:url value='/trang-chu' />"
							   class="btn btn-purple font-title my-2 text-uppercase">mua
								sản phẩm</a>
						</div>
					</c:if>
					<c:if test="${not empty listCart }">
						<div
								class="nav-table-item nav-table-left position-absolute text-center">
							<i class="fa fa-chevron-left fa-2x text-white"></i>
						</div>
						<div
								class="nav-table-item nav-table-right position-absolute text-center">
							<i class="fa fa-chevron-right fa-2x text-white"></i>
						</div>
						<div class="table-scroll position-relative"
							 style="overflow-x: auto;" id="listCart">
							<table id="table"
								   class="table table-hover table-striped bg-white table-bordered table-cart mb-0"
								   id="Cart">
								<thead>
								<th style="font-weight: normal;"><input type="checkbox"
																		id="allcheckbox" /> Chọn tất cả</th>
								<th style="text-align: center">Tên sản phẩm</th>
								<th style="text-align: center">Hình ảnh</th>
								<th style="text-align: center">Số lượng</th>
								<th style="text-align: center">Giá</th>
								<th style="text-align: center">Thành tiền</th>
								<th style="text-align: center">Xóa</th>
								</thead>
								<tbody class="font-15pt">
								<c:forEach items="${listCart}" var="cart">
									<tr id="trCart_${cart.value.product.productID}">
										<td><input
												id="checkbox_${cart.value.product.productID}"
												value="${cart.value.product.productID}" type="checkbox" /></td>
										<td style="text-align: center">${cart.value.product.productName}</td>
										<td style="text-align: center" class="table-product-img"><img
												src='<c:url value="/image/product/${cart.value.product.thumbnail}" />'
												style="width: 40px;"></td>
										<td style="text-align: center">
											<div style="display: inline-flex;" class="cart-plus-minus">
												<a
														onclick="reduceQuantity(${cart.value.product.productID})"
														class="dec qtybutton btn"
														style="cursor: pointer; margin-right: 3px; background: #13c5b5;">-</a>
												<input id="quantityCart_${cart.value.product.productID}"
													   style="width: 40px; padding: 5px;" type="text"
													   onkeypress="editQuantity(${cart.value.product.productID})"
													   value="${cart.value.quantity}"> <input
													id="quantityOld_${cart.value.product.productID}"
													type="hidden" value="${cart.value.quantity}"> <a
													onclick="addQuantity(${cart.value.product.productID})"
													class="dec qtybutton btn"
													style="cursor: pointer; margin-left: 3px; background:#13c5b5;">+</a>
											</div>
										</td>
										<fmt:parseNumber var = "price" type="number" pattern="###"
														 value = "${(cart.value.product.price* (100 - cart.value.product.salePrice))/100}" />

										<td integerOnly = "true"
											type = "number" id="price_${cart.value.product.productID}"
											style="text-align: center" class="nowrap-text"><fmt:formatNumber type = "CURRENCY" value = "${price}" />
										</td>
										<td id="sumPrice_${cart.value.product.productID}" integerOnly = "true"
											type = "number"
											style="text-align: center" class="nowrap-text"><fmt:formatNumber type = "CURRENCY" value = "${price * cart.value.quantity}" />
										</td>
										<td style="text-align: center" class="text-danger font-title">
											<div class="del-product">
												<a onclick="deleteCart(${cart.value.product.productID})"
												   style="color: #fff; cursor: pointer; padding-top: 13px; color: red;">
													<i class="fa fa-trash-o"></i>
												</a>
											</div>
										</td>
									</tr>
								</c:forEach>
								</tbody>
								<tfoot>
								<tr>
									<td colspan="4" class="text-right text-danger font-title">Tổng
										tiền</td>
									<td id="totalPrice" style="text-align: center" integerOnly = "true"
										type = "number"
										class="text-danger font-title">
										<fmt:formatNumber type = "CURRENCY" value = "${totalPrice}" />
									</td>
									<td style="text-align: center"><a onclick="xoaSachAll()"
																	  style="color: #fff; cursor: pointer;" name="deleteAllCart"
																	  class="btn btn-sm btn-danger text-capitalize">Xóa giỏ
										hàng</a></td>
								</tr>
								</tfoot>
							</table>
						</div>
						<div id="mua" class="text-right btn-action-cart"
							 style="padding-top: 12px;">
							<a href="/trang-chu"
							   class="btn btn-warning text-uppercase font-title mr-3 border-0">tiếp
								tục mua hàng</a>
							<security:authorize access="isAnonymous()">
								<a href='<c:url value='/dang-nhap' />'
								   style="background:#229c5d;"
								   class="btn btn-purple text-uppercase font-title border-0 header__wrapper-link">tiến
									hành đặt hàng</a>
							</security:authorize>
							<security:authorize access="isAuthenticated()">
								<a href="" style="background: #229c5d;" id="orderCart"
								   class="btn btn-purple text-uppercase font-title border-0">tiến
									hành đặt hàng</a>
							</security:authorize>

						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
</div>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

	function reduceQuantity(id) {
		var quantityOld =  parseInt($('#quantityCart_'+id).val(), 10);
		var quantity =  quantityOld;
		if(quantity>1){
			quantity = quantity-1;
		}
		var data = {};
		data["productID"] =id;
		data["quantity"] = quantity;
		$('#quantityCart_'+id).val(quantity);
		editInfoCart(id,quantity, quantityOld)
		updateCart(data);
	}
	function addQuantity(id) {
		var quantityOld =  parseInt($('#quantityCart_'+id).val(), 10);
		var quantity =  quantityOld +1;
		var data = {};
		data["productID"] =id;
		data["quantity"] = quantity;
		$('#quantityCart_'+id).val(quantity);
		editInfoCart(id,quantity, quantityOld)
		updateCart(data);

	}
	function editQuantity(id) {
		if($('#quantityCart_'+id).val()>0){
			var quantityOld =  parseInt($('#quantityOld_'+id).val(), 10);
			var quantity =  parseInt($('#quantityCart_'+id).val(), 10);
			$('#quantityOld_'+id).val(quantity);
			var data = {};
			data["productID"] =id;
			data["quantity"] = quantity;
			editInfoCart(id,quantity, quantityOld)
			updateCart(data);
		}


	}
	function updateCart(data) {
		$.ajax({
			url : '${cartURL}/'+data["productID"]+'/'+ data["quantity"],
			type : 'PUT',
			success : function(res) {

			},
			error : function(res) {

			}
		});
	}
	function deleteCart(id) {
		var quantityOld =  $('#quantityOld_'+id).val();
		editInfoCart(id,0, quantityOld);
		$('#trCart_'+id).remove();
		deleteCartAjax(id);
	}
	function deleteCartAjax(data) {
		$.ajax({
			url : '${cartURL}/'+data,
			type : 'DELETE',
			success : function(res) {
				$("#trCart_"+id).remove();
			},
			error : function(res) {

			}
		});
	}

	function xoaSachAll() {
		deleteAllCartAjax();
	}

	function deleteAllCartAjax() {
		$.ajax({
			url : '${cartURL}/'+'deleteAll',
			type : 'DELETE',
			success : function(res) {
				location.reload();
			},
			error : function(res) {

			}
		});
	}
	function editInfoCart(id,quantity, quantityOld) {
		var price = parseInt($('#price_'+id).text().replace(".", ""), 10);// lay gia
		$('#sumPrice_'+id).text(price*quantity +" đ");// thay doi gia
		var totalPrice = parseInt($('#totalPrice').text().replace(".", ""), 10) - (price*quantityOld) + (price*quantity) ;
		$('#totalPrice').text(totalPrice +" đ");// thay tong gia
		var totalQuantity = parseInt($('#totalQuantity').text().replace(".", ""), 10);
		$('#totalQuantity').text(totalQuantity - quantityOld + quantity);// thay tong so luong

	}
	$('#allcheckbox').click(function(){// chọn san pham
		if($(this).prop("checked") == true){
			$( "input" ).prop( "checked", true );
		}
		else if($(this).prop("checked") == false){
			$( "input" ).prop( "checked", false);
		}
	});
	$('#orderCart').click(function(e){// chọn san pham
		e.preventDefault();
		var ids = $('tbody input[type=checkbox]:checked').map(function () {
			return $(this).val();
		}).get();
		if(ids.length==0){
			swal("Vui lòng chọn ít nhất 1 sản phẩm");
		}else{
			replaceOder(ids);
		}
	});
	function replaceOder(data) {
		location.replace("${oderURL}?id="+data);
	}


</script>
</body>
</html>