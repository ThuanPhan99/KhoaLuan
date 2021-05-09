<%@page import="com.khosach.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kho sách - Đơn hàng của tôi</title>
</head>
<body>
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
							<li><a style="color: #026e36"
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
					<h4>ĐƠN HÀNG CỦA BẠN</h4>
				</div>
				<hr>
				<div class="tab ">
					<button onclick="clickButtonOrder(this,0)" type="button"
						class="tablinkOrder buttonOrderActive">Tất cả</button>
					<button onclick="clickButtonOrder(this,1)" type="button"
						class="tablinkOrder">Đang chờ duyệt</button>
					<button style="width: 200px" onclick="clickButtonOrder(this,2)" type="button"
						class="tablinkOrder">Đã duyệt chờ vận chuyển</button>
					<button onclick="clickButtonOrder(this,3)" type="button"
						class="tablinkOrder">Đang giao</button>
					<button onclick="clickButtonOrder(this,4)" type="button"
						class="tablinkOrder">Đã giao</button>

				</div>
				<div class="border-tab-order"></div>
				<div id="hrorder-context">
				<c:if test="${listOrder.size()==0}">
					<h1 class="order-tilte-null">Không có sản phẩm nào </h1>
				</c:if>
					<c:forEach items="${listOrder}" var="order">
						<div id="orderDelete_${order.orderID}" class="info-content">
						<c:url var="orderDtailURL" value="/chi-tiet-don-hang">
								<c:param name="id" value="${order.orderID}"/>															
						</c:url>
							<div class="info-content-top">
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
									<c:if test="${orderDetail.status==0}">
										<div class="info-content-bottom-dev">
											<p>Đã hủy đơn</p>
										</div>
									</c:if>
									<c:if test="${orderDetail.status==1}">
										<c:if test="${order.status==1}">
											<div id="orderDetailStatus_${orderDetail.orderDetailID}" class="info-content-bottom-dev">
												<p>Đang chờ duyệt</p>
											</div>
										</c:if>
										<c:if test="${order.status==2 || order.status == 3}">
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
												<div style="display: block;  width: 24%;" id="info-content-button-cancel_${orderDetail.orderDetailID}" class="info-content-button-cancel">
													<button class="btn-delet-order" onclick="clickDeleteOrderDetail(${orderDetail.orderDetailID})" >Hủy</button>
												</div>
											</c:if>
										</c:if>
									</c:if>
									<c:if test="${order.status==4 && orderDetail.status==1}">
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
									<button class="btn-delet-order" onclick="clickDeleteOrder(${order.orderID})" >Hủy Đơn</button>
								</div>
							</c:if>
						</div>
					</c:forEach>
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
<script src="<c:url value='/template/web/js/ajax/deleteOrderDetail.js' />"></script>
</body>
</html>
