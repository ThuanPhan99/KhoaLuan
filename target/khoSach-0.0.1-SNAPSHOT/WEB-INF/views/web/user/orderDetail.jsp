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
							<li><a href="<c:url value='thay-doi-mat-khau'/>">Thay
									đổi mật khẩu</a></li>
						</ul></li>
					<li><a
						style="border-radius: 2px; padding: 5px; background:#24a763; color: #fff;"
						href="">Quản lý đơn hàng</a>
						<ul class="sub-menu-left-info">
							<li><a style="color: #ff5800"
								href="<c:url value='quan-ly-don-hang'/>">Tất cả đơn hàng</a></li>
							<li><a href="<c:url value='quan-ly-don-hang-huy'/>">Đơn
									hàng hủy</a></li>
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
					<h4>CHI TIẾT ĐƠN HÀNG</h4>
				</div>
				<hr>
				<div id="hrorder-context">
					<div id="orderDelete_${order.orderID}" class="info-content">
						<div class="info-content-top">
							<div class="info-content-top-left">
								<div class="info-content-top-order">
									Đơn hàng #${order.orderID}
								</div>
								<p>Ngày đặt : ${order.dateOfIssue}</p>
							</div>
							<div style="width: 190px" class="info-content-top-right">
								Tổng cộng : ${totalPrice} VND 
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
								<c:if test="${orderDetail.status==0}">
									<div class="info-content-bottom-dev">
										<p>Đã hủy đơn</p>
									</div>
								</c:if>
								<c:if test="${orderDetail.status==1}">
									<c:if test="${order.status==1}">
										<div id="orderDetailStatus_${orderDetail.orderDetailID}"
											class="info-content-bottom-dev">
											<p>Đang chờ duyệt</p>
										</div>
									</c:if>
									<c:if test="${order.status==2}">
										<div class="info-content-bottom-dev">
											<p>Đã duyệt đơn</p>
										</div>
									</c:if>
									<c:if test="${order.status == 3}">
										<div class="info-content-bottom-dev">
											<p>Đang giao hàng</p>
										</div>
									</c:if>
									<c:if test="${order.status==4}">
										<div class="info-content-bottom-dev">
											<p>Đã giao hàng</p>
										</div>
									</c:if>
									<c:if test="${orderDetail.status==1}">
										<c:if test="${order.status==1}">
											<div style="display: block; width: 24%;"
												class="info-content-button-cancel">
												<button class="btn-delet-order"
													onclick="clickDeleteOrderDetail(${orderDetail.orderDetailID})">Hủy</button>
											</div>
										</c:if>
									</c:if>
								</c:if>
								<c:if test="${order.status==4}">
									<div class="info-content-bottom-date">
										<span>Ngày giao hàng :<fmt:formatDate
												pattern="yyyy-MM-dd" value="${order.deliveryDate}" />
										</span>
									</div>
								</c:if>
							</div>

						</c:forEach>
						<c:if test="${order.status==1}">
							<div class="info-content-button-cancel">
								<button class="btn-delet-order"
									onclick="clickDeleteOrder(${order.orderID})">Hủy Đơn</button>
							</div>
						</c:if>
					</div>
				</div>
				<div class="hrOrder-info ">
					<div class="hrOrder-info-address ">
						<h4>Địa chỉ giao hàng</h4>
						<h5>${user.fullName }</h5>
						<h5>${user.address}</h5>
						<h5>${user.numberPhone}</h5>
					</div>
					<div class="hrOrder-info-total ">
						<h4>Tổng cộng</h4>
						<h5>Tổng tiền : ${totalPrice} VND</h5>
						<h5>Thanh toán : ${order.getPaymentMethodsString()}</h5>

					</div>
				</div>
			</div>
			<!-- end Lịch sử mua hàng -->
		</div>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value='/template/web/js/ajax/hrorder.js' />"></script>
<script src="<c:url value='/template/web/js/ajax/deleteOrder.js' />"></script>
<script
	src="<c:url value='/template/web/js/ajax/deleteOrderDetail.js' />"></script>
