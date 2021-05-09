<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="deleteURL" value="/api/groupproduct" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Quản Trị - Sản Phẩm - Danh sách nhóm sản phẩm</title>
</head>
<body>
	<div class="container-fluid">
		<h2 style="text-align: right;">
			<a class="text-white btn btn-success mr-3" href="<c:url value='/quan-tri/nhom-san-pham/chinh-sua'/>">
				Thêm nhóm sản phẩm</a>
		</h2>
		<h1 class="h3 mb-2 text-gray-800">Danh sách nhóm sản phẩm</h1>
		<div style="background: #fff" class="mb-4">
			<div class="card-body">
				<div class="table-responsive table-hover">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã nhóm sản phẩm</th>
								<th>Tên nhóm sản phẩm</th>
								<th>Tên thể loại</th>
								<th>Cập nhật</th>
								

							</tr>
						</thead>
						<tbody>
							<c:forEach  items="${listGroupProduct}" var="groupProduct">
						
							<tr id="trGC_${groupProduct.groupProductID}">
								<td>${groupProduct.groupProductID}</td>
								<td>${groupProduct.groupProductName}</td>
								<td>${groupProduct.categoryName}</td>
								<td style="display: flex;">
								<c:url var="updateGroupProductURL" value="/quan-tri/nhom-san-pham/chinh-sua">
										<c:param name="id" value="${groupProduct.groupProductID}"/>															
								</c:url>	
								<a href="${updateGroupProductURL}"
									class="icon_Edit_one_row"> <i class="fa fa-edit"></i>
								</a>
								<a onclick="deleteCheck(${groupProduct.groupProductID},'${deleteURL}')"	style="padding-left:10px;color: red; cursor: pointer;" class="icon_Edit_one_row"> <i class="fa fa-trash-o"></i> </a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="<c:url value='/template/admin/js/ajax/delete-gc-c-gp.js' />"></script>
</body>
</html>