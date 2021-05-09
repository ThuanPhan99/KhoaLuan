<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="productSaleURL" value="/api/productsale" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row shadow">
			<div class="col-sm-12">

				<div class="px-2">
					<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Sản phẩm khuyến mãi</h4>
					<div id="infoAlert">
					</div>
					<form:form modelAttribute="model" id="formSubmit">
						<form:hidden path="productSaleID" id="idModel" />
						<div class="row">
							<div class="form-group col-sm-8">
								<label class="">Mã sản phẩm</label>
								<form:input path="productID" id="productID" 
									cssClass="text form-control typeNumber required" />
								<p class="text-danger" id="resultProductID"></p>
							</div>
							<div class="form-group col-sm-4">
								<label class="">Phần trăm khuyến mãi</label>
								<form:input path="sale" id="sale" 
									cssClass="text form-control typeNumber required" />
								<p class="text-danger" id="resultGroupProductName"></p>
							</div>
						</div>
						<div class="form-group">
						<c:if test="${not empty model.productSaleID}">
							<button type="submit" value="them" class="btn btn-success mb-3"
								onclick="return submitEdit('${productSaleURL}')" name="btnThem">Cập nhật</button>
						</c:if>
						<c:if test="${empty model.productSaleID}">
							<button type="submit" value="them" class="btn btn-success mb-3"
								onclick="return submitEdit('${productSaleURL}')" name="btnThem">Thêm</button>
						</c:if>
							<a class="btn btn-danger ml-3 mb-3" href="<c:url value='/quan-tri/san-pham-khuyen-mai'/>">
								Hủy</a>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<c:url value='/template/admin/js/ajax/edit.js' />"></script>
</body>
</html>