<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="deleteURL" value="/api/category" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook -Quản trị - Thể loại - Danh sách thể loại</title>
</head>
<body>
	<div class="container-fluid">
		<h2 style="text-align: right;">
			<a class="text-white btn btn-success mr-3" href="<c:url value='/quan-tri/the-loai/chinh-sua'/>">
				Thêm thể loại</a>
		</h2>
		<h1 class="h3 mb-2 text-gray-800">Danh sách thể loại</h1>
		<div style="background: #fff" class=" mb-4">
			<div class="card-body">
				<div class="table-responsive table-hover">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã thể loại</th>
								<th>Tên thể loại</th>
								<th>Ảnh thể loại</th>
								<th>Thao tác</th>
								

							</tr>
						</thead>
						<tbody>
							<c:forEach  items="${listCategory}" var="category">
							<tr id="trGC_${category.categoryID}">
								<td>${category.getCategoryID()}</td>
								<td>${category.getCategoryName()}</td>
								<td><img style="width: 40px" alt="" src="<c:url value="/image/category/${category.getPicture()}" />"></td>
								<td style="display: flex;">
								<c:url var="updateCategoryURL" value="/quan-tri/the-loai/chinh-sua">
										<c:param name="id" value="${category.getCategoryID()}"/>															
								</c:url>	
								<a href="${updateCategoryURL}"
									class="icon_Edit_one_row"> <i class="fa fa-edit"></i>
								</a>
								<a onclick="deleteCheck(${category.categoryID},'${deleteURL}')"	style="padding-left: 10px;color: red; cursor: pointer;" class="icon_Edit_one_row"> <i class="fa fa-trash-o"></i> </a>
								
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