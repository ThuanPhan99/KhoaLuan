<%@page import="com.khosach.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand navbar-dark bg-white static-top"
	style="box-shadow: 0 .15rem 1.75rem 0 rgba(58, 59, 69, .15) !important;">

	<a class="navbar-brand mr-1" href="<c:url value='/quan-tri/don-hang/tat-ca'/>"><img
		src="<c:url value="/image/logo/logo.png"/>" alt="" style="width: 212px;"></a>

<%--	<button class="btn btn-link btn-sm text-white order-1 order-sm-0"--%>
<%--		id="sidebarToggle" href="#" style="background: #000">--%>
<%--&lt;%&ndash;		<i class="fas fa-bars"></i>&ndash;%&gt;--%>
<%--	</button>--%>

	<!-- Navbar Search -->
	<form
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

	</form>

	<!-- Navbar -->
	<ul class="navbar-nav ml-auto ml-md-0">
		<li class="nav-item dropdown no-arrow">
			<div style="display: inline-flex;">
				<h5 style="padding-top: 5px; padding-right: 30px; color: #000;">
					Xin chào <%=SecurityUtils.getPrincipal().getFullName() %> <i class="fas fa-user-circle fa-fw"></i>
				</h5>
				<div>
					<a class="nav-link dropdown-toggle" href="#" id="userDropdown"
						role="button" style="color: #000" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <i
						class="fas fa-cog"></i>
					</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="userDropdown">
						<a class="dropdown-item" href="#">Cài đặt</a> <a
							class="dropdown-item" href="#">Thông tin admin</a>
						<div class="dropdown-divider"></div>
						   <a class="dropdown-item" href="<c:url value='/thoat-quan-tri'/>" >Đăng xuất</a>
					</div>
				</div>

			</div>

		</li>
	</ul>

</nav>
