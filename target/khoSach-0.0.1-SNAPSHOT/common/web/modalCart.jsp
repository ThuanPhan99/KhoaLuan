<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<ul class="list-inline">
	<li class="chart-li"><a href="<c:url value='/gio-hang' />"
		class="header__wrapper-link shopping__cart-icon"> <i
			class="fa fa-shopping-cart"></i> <span id="totalQuantity"
			class="number__cart"> ${totalQuantity} </span>
	</a>
		<ul>
			<li><c:if test="${totalQuantity==0}">
					<div
						style="text-align: center; font-size: 14px;width:250px; padding: 0px; padding-top: 11px; box-shadow: 0px 2px 10px 0px rgba(0, 0, 0, 0.1);"
						class="header-chart-dropdown">
						<label>Giỏ hàng trống</label>
					</div>

				</c:if> <c:if test="${totalQuantity!=0}">
					<div class="header-chart-dropdown">
						<label
							style="width: 100%; font-size: 16px; padding-bottom: 5px; font-weight: 600; border-bottom: 1px solid #ccc;">GIỎ
							HÀNG</label>
						<c:set var="total" value="${0}" />
						<div class="header-chart-dropdown-list-all">
						<c:forEach items="${listModalCart}" var="cart">
						
							<div class="header-chart-dropdown-list">
								<div class="dropdown-chart-left floatleft">
									<a href="#"><img
										src='<c:url value="/image/product/${cart.value.product.thumbnail}" />'
										style="width: 40px;"></a>
								</div>
								<div class="dropdown-chart-right">
									<h2>${cart.value.product.productName}</h2>
									<h3>Số lượng : ${cart.value.quantity}</h3>
									<fmt:parseNumber var = "price" type="number" pattern="###"
													 value = "${((cart.value.product.price*(100-cart.value.product.salePrice))/100)}" />

									<h4 integerOnly = "true"
										type = "number">
										<fmt:formatNumber type = "CURRENCY" value = "${price * cart.value.quantity}" />
									</h4>
								</div>
								<c:set var="total"
									value="${total + price * cart.value.quantity}" />
							</div>
						</c:forEach>
						</div>
						<div class="chart-checkout">
							<p integerOnly = "true"
							   type = "number">
								Tổng tiền<span style="text-transform: uppercase;"><fmt:formatNumber type = "CURRENCY" value = "${total}" /></span>
							</p>
							<button type="button" class="btn btn-default">
								<a href="<c:url value='/gio-hang' />">Xem giỏ hàng</a>
							</button>
						</div>
					</div>
				</c:if></li>
		</ul></li>
</ul>