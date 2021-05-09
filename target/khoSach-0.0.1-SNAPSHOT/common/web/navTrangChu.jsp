<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div style="height: 70px; background: #fff;"></div>
<section>
	<div class="container">
		<div class="header__middle">
			<div class="row">
				<div class="col-lg-3 p-0">
					<div class="header__category">
						<a href="" class="header__category-name" data-toggle="collapse"
							data-target="#demo" aria-expanded="false"> <i
							class="fa fa-align-right header__category-icon"></i> Danh mục sản
							phẩm
						</a>

						<ul class="header__category-list show collapse" id="demo">
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
				</div>


				<div class="col-lg-9 p-0">
					<div class="header__menu">
						<div class="">
							<div class="">
								<div class="slider-inner">
									<div id="carouselExampleIndicators" class="carousel slide"
										data-ride="carousel">
										<div class="carousel-inner">

											<div class="carousel-item active animated heartBeat ">
												<img style="height: 451px" src="<c:url value='/image/Banner/888x455px_2.jpg'/>"
													class="d-block w-100" alt="">
											</div>

										</div>
										<a class="carousel-control-prev"
											href="#carouselExampleIndicators" role="button"
											data-slide="prev"> <span class="prev-left"> <i
												class="fa fa-chevron-left"></i>
										</span>
										</a> <a class="carousel-control-next"
											href="#carouselExampleIndicators" role="button"
											data-slide="next"> <span class="prev-left"> <i
												class="fa fa-chevron-right"></i>
										</span>
										</a>
									</div>
								</div>
								<!-- End of slider-inner -->
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</section>