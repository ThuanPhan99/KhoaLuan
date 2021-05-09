<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="productURL" value="/api/product" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Quản trị - Sản phẩm - Danh sách sản phẩm</title>
</head>
<body>
	<div class="container-fluid">
		<h2 style="text-align: right;">
			<a class="text-white btn btn-success mr-3" href="<c:url value='/quan-tri/san-pham/chinh-sua'/>">
				Thêm sản phẩm</a>
		</h2>
		<h1 class="h3 mb-2 text-gray-800">Danh sách sản phẩm</h1>
		<div  style="background: #fff" class="mb-4">
			<div class="card-body">
				<div class="table-responsive table-hover">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th style="display: block; height: 72px;width: 89px !important;">
								<label style="padding: 8px;padding-bottom: 7px;border: 1px solid #000;margin-bottom: 0px;"><input type="checkbox" id="allcheckbox" /></label>
								<button id="refresh" style="margin-left: -5px;padding: 6px 8px 6px 6px;margin-top: -7px;border-radius: 0px;" type="button" class="btn btn-outline-dark"><i class="fa fa-sync"></i></button>
								<button onclick="clickDelete('${productURL}')" style="margin-left: -5px;padding: 6px 9px 6px 6px;border-left: none;margin-top: -7px;border-radius: 0px;" type="button" class="btn btn-outline-dark"><i class="fa fa-times"></i></button>
								</th>
								<th>Mã sản phẩm</th>
								<th>Tên sản phẩm</th>
								<th>Ảnh</th>
								<th>Số lượng</th>
								<th>Tác giả</th>
								<th>Nhà xuất bản</th>
								<th>Giá trung bình</th>
								<th>Phầm trăm KM</th>
								<th>Ngày nhập gần nhất</th>
								<th>Trạng thái</th>
								<th>Năm xuất bản</th>
								<th>Nhóm sản phẩm</th>
								<th>Cập nhật</th>
								

							</tr>
						</thead>
						<tbody>
							<c:forEach  items="${listProduct}" var="product">
						
							<tr id="trGC_${product.productID}">
								<td style="padding-left: 20px;"><input id="checkbox_${product.productID}" value="${product.productID}" type="checkbox" /></td>
								<td>${product.productID}</td>
								<td>${product.productName}</td>
								<td><img style="width: 40px" alt="" src="<c:url value="/image/product/${product.thumbnail}" />"></td>
								<td>${product.quantity}</td>
								<td>${product.author}</td>
								<td>${product.publisher}</td>
								<td><fmt:formatNumber type = "CURRENCY" value = "${product.price}" /></td>
								<td>${product.salePrice}</td>
								<td><fmt:formatDate pattern = "yyyy-MM-dd"  value = "${product.dateAdded}" /></td>
								<c:if test="${product.status==1}">
								<td>Còn hàng</td>
								</c:if>
								<c:if test="${product.status==0}">
								<td>Hết hàng</td>
								</c:if>
								<td>${product.yearOfPublication}</td>
								<td>${product.groupProductName}</td>
								<td>
								<c:url var="updateGroupProductURL" value="/quan-tri/san-pham/chinh-sua">
										<c:param name="id" value="${product.productID}"/>															
								</c:url>	
								<a href="${updateGroupProductURL}"
									class="icon_Edit"> <i class="fa fa-edit"></i>
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