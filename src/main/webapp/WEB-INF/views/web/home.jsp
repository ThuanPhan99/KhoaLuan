<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Trang chủ</title>
</head>
<body>
<div class="container">
<div style="margin-top: 50px; margin-bottom: 20px">
		<img src="<c:url value='/image/Banner/_Ngang-3.jpg'/>" style="width: 100%;height: 200px">
	</div>

	<section class="product" id="product-1">

		<h2 class="title-section">FLASH SALE</h2>
		<div class="row" style="background: #fff">
			<div class="col-lg-12 pl-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="product-list"
					style="grid-template-columns: repeat(6, 1fr);">
					<c:forEach items="${listProductSale}" var="productSale" >
				  		<a href='<c:url value='chi-tiet-san-pham?id=${productSale.productID }' />' style="margin: 10px;">
						<div class="product-single text-center">
							<div class="product-img">
								<img style="padding-top: 20px"
									 src='<c:url value='/image/product/${productSale.thumbnail}'/>' alt="">

								<c:if test="${not empty productSale.salePrice and product.salePrice != 0}">
									<div class="sale">
											${productSale.salePrice}%
									</div>
								</c:if>
							</div>
							<div class="product-desc">
								<div class="product-title" style="padding: 10px;">
									<h4 style="color: #000" >${productSale.productName}</h4>
								</div>
							</div>
							<div class="product-desc ">
								<div class="product-price" style="padding-left: 10px">
									<fmt:parseNumber var = "i" type="number" pattern="###"
													 value = "${((productSale.price*(100-productSale.salePrice))/100)}" />
									<ins><fmt:formatNumber type = "CURRENCY" value = "${i}" /></ins>
									<c:if test="${not empty productSale.salePrice and product.salePrice != 0}">
										<del>
											<fmt:formatNumber type = "CURRENCY" value = "${productSale.price}" />
										</del>
									</c:if>
								</div>
							</div>

					</div>
					</a>
					</c:forEach>
					<!-- End of single-product  -->
				</div>
				<!-- End of product-list -->
			</div>
			<!-- End of col-lg-7 -->
		</div>

		<div class="product-seemore" style="">
			<p>
				<a type="button" style="color: white; background: cornflowerblue;">Xem Thêm</a>
			</p>
		</div>
	</section>
<%--	<section class="product" id="product-1">--%>
<%--		<h2 class="title-section">HẠT GIỐNG TÂM HỒN</h2>--%>
<%--		<div class="row" style="background: #fff">--%>
<%--			<div class="col-lg-3 d-none d-lg-block pr-0"--%>
<%--				style="padding-left: 0; padding-right: 0px;">--%>
<%--				<div class="d-flex">--%>
<%--					<div class="col-banner">--%>
<%--						<a href=""> <img src="<c:url value='/image/Banner/_doc-1.png'/>" alt=""--%>
<%--							style="width: 100%">--%>
<%--						</a>--%>
<%--					</div>--%>
<%--					<!-- End of col-banner !-->--%>
<%--				</div>--%>
<%--			</div>--%>
<%--			<div class="col-lg-9 pl-0"--%>
<%--				style="padding-left: 0; padding-right: 0px;">--%>
<%--				<div class="product-list"--%>
<%--					style="grid-template-columns: repeat(4, 1fr);">--%>
<%--					<c:forEach items="${listProductSale}" var="productSale" >--%>
<%--				  		<a href='<c:url value='chi-tiet-san-pham?id=${productSale.productID }' />' style="margin: 10px;">--%>
<%--						<div class="product-single text-center">--%>
<%--							<div class="product-img">--%>
<%--								<img style="padding-top: 20px"--%>
<%--									src='<c:url value='/image/product/${productSale.thumbnail}'/>' alt="">--%>

<%--								<c:if test="${not empty productSale.salePrice and product.salePrice != 0}">--%>
<%--									<div class="sale">--%>
<%--											${productSale.salePrice}%--%>
<%--									</div>--%>
<%--								</c:if>--%>
<%--							</div>--%>
<%--							<div class="product-desc">--%>
<%--								<div class="product-title" style="padding: 10px;">--%>
<%--									<h4 style="color: #000" >${productSale.productName}</h4>--%>
<%--								</div>--%>
<%--							</div>--%>
<%--							<div class="product-desc ">--%>
<%--								<div class="product-price" style="padding-left: 10px">--%>
<%--									<fmt:parseNumber var = "i" type="number" pattern="###"--%>
<%--													 value = "${((productSale.price*(100-productSale.salePrice))/100)}" />--%>
<%--									<ins><fmt:formatNumber type = "CURRENCY" value = "${i}" /></ins>--%>
<%--									<c:if test="${not empty productSale.salePrice and product.salePrice != 0}">--%>
<%--										<del>--%>
<%--											<fmt:formatNumber type = "CURRENCY" value = "${productSale.price}" />--%>
<%--										</del>--%>
<%--									</c:if>--%>
<%--								</div>--%>
<%--							</div>--%>

<%--					</div>--%>
<%--					</a>--%>
<%--					</c:forEach>--%>
<%--					<!-- End of single-product  -->--%>
<%--				</div>--%>
<%--				<!-- End of product-list -->--%>
<%--			</div>--%>
<%--			<!-- End of col-lg-7 -->--%>
<%--		</div>--%>
<%--		<div class="product-seemore" style="">--%>
<%--			<p>--%>
<%--				<a type="button" style="color: white; background: cornflowerblue;">Xem Thêm</a>--%>
<%--			</p>--%>
<%--		</div>--%>
<%--	</section>--%>
</div>
</body>
</html> 