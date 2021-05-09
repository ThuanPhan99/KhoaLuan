<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userURL" value="/api/admin/user" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Quản Trị - Khách hàng -Danh sách khách hàng</title>
</head>
<body>
	<div class="container-fluid">
		<h1 class="h3 mb-2 text-gray-800">Danh sách khách hàng</h1>
		<div class="card shadow mb-4">
			<div class="card-body">
				<div class="table-responsive table-hover">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th style="width: 89px">
								<label style="padding: 8px;padding-bottom: 7px;border: 1px solid #000;margin-bottom: 0px;"><input type="checkbox" id="allcheckbox" /></label>
								<button id="refresh" style="margin-left: -5px;padding: 6px 8px 6px 6px;margin-top: -7px;border-radius: 0px;" type="button" class="btn btn-outline-dark"><i class="fa fa-sync"></i></button>
								<button onclick="clickDelete('${userURL}')" style="margin-left: -5px;padding: 6px 9px 6px 6px;border-left: none;margin-top: -7px;border-radius: 0px;" type="button" class="btn btn-outline-dark"><i class="fa fa-times"></i></button>
								</th>
								<th>Mã khách hàng</th>
								<th>Tên khách hàng</th>
								<th>Địa chỉ</th>
								<th>Số điện thoại</th>
								<th>Email</th>
								<th>Giới tính</th>
								<th>Ngày sinh</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach  items="${listUser}" var="user">
						
							<tr id="trGC_${user.id}">
								<td style="padding-left: 20px;"><input id="checkbox_${user.id}" value="${user.id}" type="checkbox" /></td>
								<td>${user.id}</td>
								<td>${user.fullName}</td>
								<td>${user.address}</td>
								<td>${user.getNumberPhone()}</td>
								<td>${user.email}</td>
								<c:if test="${user.gender==1}">
								<td>Nam</td>
								</c:if>
								<c:if test="${user.gender==0}">
								<td>Nữ</td>
								</c:if>
								<td><fmt:formatDate pattern = "yyyy-MM-dd"  value = "${user.dateOfBirth}" /></td>
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