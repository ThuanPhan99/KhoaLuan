<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Trang danh sách sản phẩm</title>
</head>
<body>
	<div class="container chitiet-baner">
		<a href="/trang-chu">Trang chủ </a>/ <a href="">Danh mục sản phẩm</a>
	</div>
	<div class="container">

		<h2 class="title-section"></h2>
		<div class="row">
			<div class="col-lg-3 d-none d-lg-block pr-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="d-flex">
					<div>
						<div class="ty-product-filters__wrapper" style="background: #fff">
							<div class="ty-product-filters__block">
								<div
									class="ty-product-filters__switch cm-save-state cm-ss-reverse">
									<span>Nhà Xuất Bản</span>
								</div>
								<ul class="ty-product-filters" id="content_32_29">
									<li>
										<ul id="ranges_32_29" class="ty-product-filters-sub">

											<li><label class="check">oo <input
													type="checkbox"> <span class="checkmark"></span>
											</label></li>

										</ul>
									</li>
								</ul>
							</div>
							<div class="ty-product-filters__block">
								<div class="ty-product-filters__switch cm-save-state ">
									<span class="ty-product-filters__title">Tác giả</span>
								</div>
								<div class="ty-product-filters__search">
									<input type="text" class="form-control" placeholder="Tìm kiếm"
										class="cm-autocomplete-off ty-input-text-medium" name="q"
										id="elm_search_32_32" value="" autocomplete="off"> <i
										class="ty-product-filters__search-icon ty-icon-cancel-circle hidden"
										id="elm_search_clear_32_32" title="Xóa"></i>
								</div>
								<div class="tacGiaScroll">
									<ul class="ty-product-filters" id="content_32_29">

										<li>
											<ul id="ranges_32_29" class="ty-product-filters-sub">

												<li><label class="check">000<input
														type="checkbox"> <span class="checkmark"></span>
												</label></li>

											</ul>

										</li>
									</ul>

								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-9 pl-0"
				style="padding-left: 0; padding-right: 0px;">
				<div class="product-list-dm " style="background: #fff">
					<c:forEach items="${listProduct}" var="product">
						<a href='<c:url value='chi-tiet-san-pham?id=${product.productID }' />'
							style="margin: 10px;">
							<div class="product-single text-center">
								<div class="product-img">
									<img style="padding-top: 20px"
										 src='<c:url value='/image/product/${product.thumbnail}'/>'
										 alt="">

									<c:if test="${not empty product.salePrice and product.salePrice != 0}">
										<div class="sale">
												${product.salePrice}%
										</div>
									</c:if>
								</div>
								<div class="product-desc">
									<div class="product-title" style="padding: 10px;">
										<h4 style="color: #000">${product.productName}</h4>
									</div>
								</div>
								<div class="product-desc ">
									<div class="product-price" style="padding-left: 10px">

										<fmt:parseNumber var = "i" type="number" pattern="###"
														  value = "${((product.price*(100-product.salePrice))/100)}" />

										<ins><fmt:formatNumber type = "CURRENCY" value = "${i}" /></ins>
										<c:if test="${not empty product.salePrice and product.salePrice != 0}">
											<del>
												<fmt:formatNumber type = "CURRENCY" value = "${product.price}" />
											</del>
										</c:if>
									</div>
								</div>

							</div>
						</a>
					</c:forEach>
					<!-- End of single-product  -->
					
				</div>
				<input type="hidden" id="page" value="${page}">
				<input type="hidden" id="limit" value="${limit}">
				<input type="hidden" id="searchPaging" value="${search}">
				<input type="hidden" id="url" value="${url}">
				<input type="hidden" id="totalProduct" value="${totalProduct}">
				<!-- End of product-list -->
				
			</div>
			<!-- End of col-lg-7 -->
		</div>
		 <ul id="pagination" class="d-flex justify-content-end align-items-center pt-3" style="margin-right: -13px;"></ul>
	</div>

</body>
</html>