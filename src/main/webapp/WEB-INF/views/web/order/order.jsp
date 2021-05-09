<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Đặt hàng</title>
</head>
<body>
<div class="container">
<section class="product-detail bg-gray py-5">
	<div class="container">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb text-capitalize bg-white">
				<li class="breadcrumb-item"><a href="index.html"
					class="text-purple font-15pt">trang chủ</a></li>
				<li class="breadcrumb-item active font-15pt">xác nhận</li>
			</ol>
		</nav>
		<div class="row">
			<div class="col-sm-12 col-md-5 col-lg-4">
				<div class="card sticky-top">
					<div class="card-header font-18pt font-title bg-white py-2 px-3">Thông
						tin đơn hàng</div>
					<div class="card-body cart-cofirm-container py-0">
					<c:forEach items="${listCartOrder}" var="cart">
				
						<div class="cart-confirm-item d-flex">
							<div class="cart-confirm-img">
								<img src="<c:url value='/image/product/${cart.product.thumbnail}'/>" class="img-fluid">
							</div>
							<div
								class="cart-confirm-title line-height-one font-14pt text-capitalize">
								${cart.product.productName}
							</div>
							<div class="cart-confirm-quantity line-height-one font-14pt" style="text-align: center;">
								${cart.quantity}
							</div>
							<fmt:parseNumber var = "i" type="number" pattern="###"
											 value = "${((cart.product.price*(100-cart.product.salePrice))/100)}" />

							<div
								class="cart-confirm-price line-height-one text-right font-14pt">
								<fmt:formatNumber type = "CURRENCY" value = "${i}" />
							</div>
						</div>
					</c:forEach>
					</div>
					<div class="card-footer py-2 px-3" style="padding-left: 0px !important; padding-right: 0px !important;">
						<div
								class="cart-confirm-footer d-flex align-items-center justify-content-between" style="padding-left: 15px; padding-right: 15px;">
							<div class="cart-confirm-footer-title font-title">Phí vận chuyển toàn quốc (Viettel Post)</div>
							<div class="cart-confirm-footer-price text-danger font-title">
								<fmt:formatNumber type = "CURRENCY" value = "${shipAmount}" />
							</div>
						</div>
						<i style="font-size: 11px; margin-left: 15px;">(*Free ship cho đơn hàng trên 300.000 VND)</i>
						<hr style="width: 100%;height: 1px;margin-top: 10px;margin-bottom: 10px;border-width: 1px;">
						<div
							class="cart-confirm-footer d-flex align-items-center justify-content-between" style="padding-left: 15px; padding-right: 15px;">
							<div class="cart-confirm-footer-title font-title" style="font-weight: 600;">Thành
								tiền</div>
							<div class="cart-confirm-footer-price text-danger font-title">
								<fmt:formatNumber type = "CURRENCY" value = "${totalPrice}" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-12 col-md-7 col-lg-8">
				<div class="card customer-info">
					<input type="hidden" value="" id="orderId">
					<input type="hidden" value="" id="requestId">
					<input type="hidden" value="${productIDs}" id="productIDs">
                    <input type="hidden" value="${totalPrice}" id="totalMoney">
					<div class="card-header font-title font-18pt bg-white py-2 px-3">Thông
						tin khách hàng</div>
					<div class="card-body py-2 px-3">
					<form:form modelAttribute="model" id="formSubmit">
							<div class="row">
								<div class="col-sm-12 col-md-6 col-lg-6 form-group">
									<label class="d-block w-100 font-15pt font-title">Tên
										khách hàng:<span class="text-danger font-title ml-1">(*)</span>
									</label>
									findReportHeaderByType					<form:input path="fullName" id="fullName"
									cssClass="text form-control " />
								</div>
								<div class="col-sm-12 col-md-6 col-lg-6 form-group">
									<label class="d-block w-100 font-15pt font-title">Số
										điện thoại:<span class="text-danger font-title ml-1">(*)</span>
									</label> <form:input path="numberPhone" id="numberPhone"
									cssClass="text form-control " />
								</div>
								<div class="col-sm-12 col-md-6 col-lg-6 form-group">
									<label class="d-block w-100 font-15pt font-title">Địa
										chỉ:<span class="text-danger font-title ml-1">(*)</span>
									</label><form:input path="address" id="address"
									cssClass="text form-control " />
								</div>
								<div class="col-sm-12 col-md-6 col-lg-6 form-group">
									<label class="d-block w-100 font-15pt font-title">Email:<span
										class="text-danger font-title ml-1">(*)</span></label> 
										<form:input path="email" id="email"
									cssClass="text form-control " />
								</div>
								<div class="col-sm-12 col-md-12 col-lg-12 form-group">
									<label class="d-block w-100 font-15pt font-title">Phương
										thức thanh toán:<span class="text-danger font-title ml-1">(*)</span>
									</label> <select class="form-control " name="paymentMethods">
										<option value="1">Thanh toán khi giao hàng</option>
										<option value="2">Thanh toán qua momo</option>
									</select>
									<div class=" col-sm-12 col-md-12 col-lg-12 text-right">
										<label class="w-100"></label>
										<button type="submit" style="background: #ff5800;" id="submitorder"
											class="btn btn-warning ml mb-5 font-title text-uppercase"
											name="send--customer">xác nhận đặt hàng</button>
									</div>
								</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
</div>
<!-- The Modal -->
<div id="myModalMomo" class="modal" style="padding: 20px 100px 20px 100px;">

	<!-- Modal content -->
	<div class="modal-content" style="height: 100%;">
		<input type="hidden" value="0" id="numLoad">
		<span class="close" data-dismiss="modal">&times;</span>
		<div id="momoData" style="height: 100%">
			<iframe src="" id="iframe_a" name="iframe_a"  height="100%" width="100%" title="Iframe Momo"></iframe>
		</div>
	</div>

</div>

<div id="modalSuccess" class="modal" style="padding: 20px 100px 20px 100px;">

	<!-- Modal content -->
	<div class="modal-content" style="height: 100%;">
		<span class="close" data-dismiss="modal">&times;</span>
		<h2 STYLE="text-align: center">THANH TOÁN THÀNH CÔNG</h2>
	</div>

</div>

<style>
	/* The Modal (background) */
	#myModalMomo .close {
		color: blueviolet;
		float: right;
		font-size: 28px;
		font-weight: bold;
		text-align: right;
		margin-right: 5px;
	}

	.close:hover,
	.close:focus {
		color: #000;
		text-decoration: none;
		cursor: pointer;
	}
</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<c:url value='/template/web/js/ajax/order.js' />"></script>
</body>
</html>