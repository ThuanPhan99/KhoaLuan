<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="productSaleURL" value="/api/productsale" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Quản Trị - Sản Phẩm Khuyến Mãi - Danh sách sản phẩm khuyến mãi</title>
</head>
<body>
	<div class="container-fluid">
		<h2 style="text-align: right;">
			<a class="text-white btn btn-success mr-3" href="<c:url value='/quan-tri/san-pham-khuyen-mai/chinh-sua'/>">
				Thêm sản phẩm khuyến mãi</a>
		</h2>
		<h1 class="h3 mb-2 text-gray-800">Danh sách sản phẩm khuyến mãi</h1>
		<div style="background: #fff" class="mb-4">
			<div class="card-body">
				<div class="table-responsive table-hover">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th style="width: 89px">
								<label style="padding: 8px;padding-bottom: 7px;border: 1px solid #000;margin-bottom: 0px;"><input type="checkbox" id="allcheckbox" /></label>
								<button id="refresh" style="margin-left: -5px;padding: 6px 8px 6px 6px;margin-top: -7px;border-radius: 0px;" type="button" class="btn btn-outline-dark"><i class="fa fa-sync"></i></button>
								<button onclick="clickDelete('${productSaleURL}')" style="margin-left: -5px;padding: 6px 9px 6px 6px;border-left: none;margin-top: -7px;border-radius: 0px;" type="button" class="btn btn-outline-dark"><i class="fa fa-times"></i></button>
								</th>
								<th>Mã sản phẩm KM</th>
								<th>Khuyến mãi</th>
								<th>Mã sản phẩm</th>
								<th>Tên sản phẩm</th>
								<th>Ảnh sản phẩm</th>
								<th>Trạng thái</th>
								<th>Cập nhật</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach  items="${listProductSale}" var="productSale">
						
							<tr id="trGC_${productSale.productSaleID}">
								<td style="padding-left: 20px;"><input id="checkbox_${productSale.productSaleID}" value="${productSale.productSaleID}" type="checkbox" /></td>
								<td>${productSale.productSaleID}</td>
								<td>${productSale.sale}%</td>
								<td>${productSale.productID}</td>
								<td>${productSale.productName}</td>
								<td><img style="width: 40px" alt="" src="<c:url value="/image/product/${productSale.thumbnail}" />"></td>
								<c:if test="${productSale.status==1}">
								<td>Còn hàng</td>
								</c:if>
								<c:if test="${productSale.status==0}">
								<td>Hết hàng</td>
								</c:if>
								<td>
								<c:url var="updateProducSaletURL" value="/quan-tri/san-pham-khuyen-mai/chinh-sua">
										<c:param name="id" value="${productSale.productSaleID}"/>															
								</c:url>	
								<a href="${updateProducSaletURL}"
									class="icon_Edit_one_row"> <i class="fa fa-edit"></i>
								</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>