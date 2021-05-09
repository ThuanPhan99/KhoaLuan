<%@page import="com.khosach.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="updatePasswordURL" value="/api/userupdatepassword" />
<div class="container information">

	<div class="row ">
		<div class="information-left col-2">
			<nav class="menu-left-info">
				<label>Xin chào <%=SecurityUtils.getPrincipal().getFullName()%></label>
				<ul>
					<li><a
						style="border-radius: 2px; padding: 5px; background: #026e36; color: #fff;"
						href="">Quản lý tài khoản</a>
						<ul class="sub-menu-left-info">
							<li><a  href="<c:url value='thong-tin-tai-khoan'/>">Thông tin tài khoản</a></li>
							<li><a style="color: #026e36" href="">Thay đổi mật khẩu</a></li>
						</ul></li>
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
					<h4>THAY ĐỔI MẬT KHẨU</h4>
				</div>
				<hr>
				<form action="">
					<div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory">
						
					</div>
					<input type="hidden" value="1" id="idModel">
					<div class="form-group">
						<label>Mật khẩu cũ</label> <input type="password"
							class="text form-control" placeholder="Mật khẩu cũ"
							name="passwordOld" id="passwordOld" required>
						<p class="text-danger" id="resultPasswordOld"></p>
					</div>
					<div class="form-group">
						<label>Mật khẩu mới</label> <input type="password" name="passwordNew"
							class="text form-control" placeholder="Mật khẩu mới"
							id="passwordNew" required>
						<p class="text-danger" id="resultPasswordNew"></p>
					</div>
					<div class="form-group">
						<label>Nhật lại mật khẩu mới</label> <input type="password"
							class="text form-control" placeholder="Xác nhận mật khẩu"
							id="passwordConfirm" required>
						<p class="text-danger" id="resultPasswordConfirm"></p>
					</div>
					<h1 style="text-align: right; margin-top: 10px;">
						<button style="font-size: 14px;" type="button" class="btn btn-success mb-3" onclick="updatePassword('${updatePasswordURL}')">Cập
							nhật</button>
					</h1>
				</form>
			</div>
		</div>
	</div>
</div>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value='/template/web/js/ajax/edit.js' />"></script>

