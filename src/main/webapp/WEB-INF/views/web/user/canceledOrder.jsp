<%@page import="com.khosach.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container information">
	<div class="row ">
		<div class="information-left col-2">
			<nav class="menu-left-info">
				<label>Xin chào <%=SecurityUtils.getPrincipal().getFullName()%></label>
				<ul>
					<li><a href="">Quản lý tài khoản</a>
						<ul class="sub-menu-left-info">
							<li><a href="<c:url value='thong-tin-tai-khoan'/>">Thông
									tin tài khoản</a></li>
							<li><a href="<c:url value='thay-doi-mat-khau'/>">Thay đổi mật khẩu</a></li>
						</ul></li>
					<li><a
						style="border-radius: 2px; padding: 5px; background: #026e36; color: #fff;"
						href="">Quản lý đơn hàng</a>
						<ul class="sub-menu-left-info">
							<li><a href="<c:url value='quan-ly-don-hang'/>">Tất cả
									đơn hàng</a></li>
							<li><a style="color: #026e36"
								href="<c:url value='quan-ly-don-hang-huy'/>">Đơn hàng hủy</a></li>
						</ul></li>
					<li><a href="<c:url value='/thoat'/>">Đăng xuất</a></li>
				</ul>
			</nav>
		</div>
		<div class="information-right clo-10 tab-content">
			<div style="background: #f1f1f1;"
				class="information-right-content tab-pane fade in show active"
				id="thongTinKhachHang">
				<div class="information-right-content-title">
					<h4>ĐƠN HÀNG ĐÃ HỦY</h4>
				</div>
				<hr>
				<div id="hrorder-context">
				<c:if test="${listOrder.size()==0}">
					<h1 class="order-tilte-null">Không có sản phẩm nào </h1>
				</c:if>
					<c:forEach items="${listOrder}" var="order">
						<div class="info-content">
							<div class="info-content-top">
							<c:url var="orderDtailURL" value="/chi-tiet-don-hang">
								<c:param name="id" value="${order.orderID}"/>															
							</c:url>
								<div class="info-content-top-left">
									<div class="info-content-top-order">
										Đơn hàng<a href="${orderDtailURL}">#${order.orderID}</a>
									</div>
									<p>Ngày đặt : ${order.dateOfIssue}</p>
								</div>
								<div class="info-content-top-right">
									<a href="${orderDtailURL}">QUẢN LÝ</a>
								</div>
							</div>
							<hr>
							<c:forEach items="${order.listOrDerDetail}" var="orderDetail">
								<div class="info-content-bottom">
									<div class="info-content-bottom-img">
										<a href=""> <img
											src='<c:url value="/image/product/${orderDetail.thumbnail}" />'></a>
									</div>
									<div class="info-content-bottom-name">
										<p>${orderDetail.productName}</p>
									</div>

									<div class="info-content-bottom-qty">
										<span>Số lượng : ${orderDetail.quantity}</span>
									</div>
									<div class="info-content-bottom-dev">
										<p>Đã hủy đơn</p>
									</div>
								</div>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value='/template/web/js/ajax/hrorder.js' />"></script>
