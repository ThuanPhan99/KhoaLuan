<%@page import="com.khosach.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userURL" value="/api/user" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kho sách - Thông tin cá nhân</title>
</head>
<body>
<div class="container information">

	<div class="row ">
		<div class="information-left col-2">
			<nav class="menu-left-info">
				<label>Xin chào <%=SecurityUtils.getPrincipal().getFullName()%></label>
				<ul>
					<li><a style="border-radius: 2px; padding: 5px; background: #026e36; color: #fff;" href="">Quản lý tài khoản</a>
						<ul class="sub-menu-left-info">
							<li><a style="color:#026e36" href='<c:url value='thong-tin-tai-khoan'/>'>Thông tin tài khoản</a></li>
							<li><a href="<c:url value='thay-doi-mat-khau'/>">Thay đổi mật khẩu</a></li>
						</ul>
					</li>
					<li><a href="">Quản lý đơn hàng</a>
						<ul class="sub-menu-left-info">
							<li><a href="<c:url value='quan-ly-don-hang'/>">Tất cả đơn hàng</a></li>
							<li><a href="<c:url value='quan-ly-don-hang-huy'/>">Đơn hàng hủy</a></li>
						</ul></li>
					<li><a href="<c:url value='/thoat'/>">Đăng xuất</a></li>
				</ul>
			</nav>
		</div>
		<div class="information-right clo-10 tab-content">
			<div class="information-right-content tab-pane fade in show active"
				id="thongTinKhachHang">
				<div class="information-right-content-title">
					<h4>THÔNG TIN TÀI KHOẢN</h4>
					<label id="editInfo"><i class="fa fa-edit"></i></label>
				</div>
				<hr>

				<div class="information-right-content-sub">
					<div class="information-right-content-sub-line">
						<label>Tên khách hàng : </label>
						<p>${user.fullName}</p>
					</div>

					<div class="information-content-text"></div>
					<div class="information-right-content-sub-line">
						<label>Tên đăng nhập : </label>
						<p>${user.userName}</p>
					</div>
					<div class="information-content-text"></div>
					<div class="information-right-content-sub-line">
						<label>Ngày sinh : </label>
						<p>
							<fmt:formatDate pattern="yyyy-MM-dd" value="${user.dateOfBirth}" />
						</p>
					</div>
					<div class="information-content-text"></div>
					<div class="information-right-content-sub-line">
						<label>Giới tính : </label>
						<c:if test="${user.gender==1 }">
							<p>Nam</p>
						</c:if>
						<c:if test="${user.gender==0 }">
							<p>Nữ</p>
						</c:if>
						<p></p>
					</div>
					<div class="information-content-text"></div>
					<div class="information-right-content-sub-line">
						<label>Địa chỉ : </label>
						<p>${user.address}</p>
					</div>
					<div class="information-content-text"></div>
					<div class="information-right-content-sub-line">
						<label>Email : </label>
						<p>${user.email}</p>
					</div>
					<div class="information-content-text"></div>
					<div class="information-right-content-sub-line">
						<label>Số điện thoại : </label>
						<p>${user.numberPhone}</p>
					</div>
					<div class="information-content-text"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container mt-3">
	<div class="modal fade" id="editInfoModal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 700px">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Cập nhật thông tin cá nhân</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory">

					</div>
					<form:form modelAttribute="user" id="formSubmit">
						<div class="row">
							<div class="col-sm-3">
								<div class="form-group">
									<label>Mã khách hàng</label>
									<form:input path="id" id="idModel" cssClass="text form-control" readonly="true"/>
								</div>
							</div>
							<div class="col-sm-5">
								<div class="form-group">
									<label>Tên khách hàng</label>
									<form:input path="fullName" id="fullName"
												cssClass="text form-control " />
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label>Tên đăng nhập</label>
									<form:input path="userName" id="userName"  readonly="true"
												cssClass="text form-control " />
								</div>
							</div>
						</div>
						<div class="row p-2 pt-3">
							<div class="col-sm-5">
								<div class="form-group">
									<label>Ngày sinh</label> <input type="date"
																	class="text form-control"
																	value='<fmt:formatDate pattern = "yyyy-MM-dd"  value = "${user.dateOfBirth}" />'
																	placeholder="Ngày sinh" required name="dateOfBirth">
								</div>
							</div>
							<div class="col-sm-5">
								<div class="form-group">
									<label style="width: 100%;">Giới tính</label>
									<form:radiobutton path="gender" value="1"
													  style="margin-right: 10px;" />
									Nam
									<form:radiobutton path="gender" value="0" />
									Nữ

								</div>
							</div>
						</div>
						<div class="row p-2 pt-3">
							<div class="col-sm-10">
								<label>Địa chỉ </label>
								<form:input path="address" id="address"
											cssClass="text form-control " />
							</div>
						</div>
						<div class="row p-2 pt-3">
							<div class="col-sm-5">
								<label>Email </label>
								<form:input path="email" id="email"
											cssClass="text form-control " />
							</div>
							<div class="col-sm-5">
								<label>Số điện thoại </label>
								<form:input path="numberPhone" id="numberPhone"
											cssClass="text form-control " />
							</div>
						</div>
						<h1 style="text-align: right; margin-top: 10px;">
							<button style="font-size: 14px;"type="button" onclick="submitEdit('${userURL}')"
									class="btn btn-success mb-3">Cập nhật</button>
							<a  style="font-size: 14px; color: #fff"
								class="btn btn-danger ml-3 mb-3" style="color: #fff"
								data-dismiss="modal">Hủy</a>
						</h1>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value='/template/web/js/ajax/edit.js' />"></script>
</body>

</html>
<!-- cập nhậtthông tin -->

<!-- end cập nhậtthông tin -->

