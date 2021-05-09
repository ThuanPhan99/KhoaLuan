<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<div class="container">
	<div class="header__middle">
		<div class="header__category" id="headingOne">
			<a href="" class="header__category-name" data-toggle="collapse"
				data-target="#demo" aria-expanded="false"> <i
				class="fa fa-align-right header__category-icon"></i> Danh mục sản
				phẩm
			</a>
			<ul class="header__category-list collapse" id="demo">
							<c:forEach items="${listMenuCategory}" var="category">
								<li class="header__category-item"><a
									href='<c:url value='/san-pham-theo-the-loai?id=${category.categoryID}' />'
									class="header__category-link"> <i class="fa fa-book"></i>${category.categoryName}
								</a>

									<div class="sub__menu">
										<div class="sub__menu-left">
											<c:forEach items="${listMenuGroupProduct}" var="groupProduct">
												<c:if
													test="${category.categoryID == groupProduct.categoryID }">
													<div class="sub__menu-inner">

															<a style="color: #000"
																href='<c:url value='/san-pham-theo-nhom-san-pham?id=${groupProduct.groupProductID}' />'
																class="sub__menu-link">
																<h3 class="sub__menu-title">${groupProduct.groupProductName }</h3>
															</a>
													</div>
												</c:if>

											</c:forEach>
										</div>
										<div class="sub__menu-right" style="margin-left: -70px">
											<img style="width: 300px; height: 430px;"
												src='<c:url value='/image/category/${category.getPicture()}'/>'
												alt="">
										</div>

									</div></li>

							</c:forEach>
						</ul>

		</div>

		<div class="header__menu">
		</div>
	</div>
</div>
</header>