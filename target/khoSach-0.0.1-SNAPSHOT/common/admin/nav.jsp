<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="wrapper">
	<ul class="sidebar navbar-nav">
		<li class="nav-item active"><a class="nav-link" href="<c:url value='/quan-tri/don-hang/tat-ca'/>">
				<i class="fas fa-home"></i> <span>Trang chủ</span>
		</a></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-fw fa-folder"></i> <span>Thể loại</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
<%--				<h6 class="dropdown-header">Quản lý thể loại</h6>--%>
				<a class="dropdown-item" href="<c:url value='/quan-tri/the-loai/chinh-sua'/>">Thêm thể loại</a>
				<a class="dropdown-item" href="<c:url value='/quan-tri/the-loai'/>">Danh sách thể loại</a>

			</div>
		</li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-fw fa-folder"></i> <span> Nhóm sản phẩm</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
<%--				<h6 class="dropdown-header">Quản lý nhóm sản phẩm</h6>--%>
				<a class="dropdown-item" href="<c:url value='/quan-tri/nhom-san-pham/chinh-sua'/>">Thêm nhóm sản phẩm</a>
				<a class="dropdown-item" href="<c:url value='/quan-tri/nhom-san-pham'/>">Danh sách nhóm <br> sản phẩm</a>

			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-book"></i> <span> Sản phẩm</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
<%--				<h6 class="dropdown-header">Quản lý sản phẩm</h6>--%>
				<a class="dropdown-item" href="<c:url value='/quan-tri/san-pham/chinh-sua'/>">Thêm sản phẩm</a> <a
					class="dropdown-item" href="<c:url value='/quan-tri/san-pham'/>">Danh sách sản phẩm</a>

			</div>
		</li>
		<%--<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-book"></i> <span> Sản phẩm KM</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-header">Quản lý sản phẩm KM</h6>
				<a class="dropdown-item" href="<c:url value='/quan-tri/san-pham-khuyen-mai/chinh-sua'/>">Thêm sản phẩm <br> khuyến mãi</a> <a
					class="dropdown-item" href="<c:url value='/quan-tri/san-pham-khuyen-mai'/>">Danh sách sản phẩm <br> khuyến mãi</a>

			</div>
		</li>--%>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-file-alt"></i> <span> Đơn hàng</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
<%--				<h6 class="dropdown-header">Quản lý đơn hàng</h6>--%>
				<a class="dropdown-item" href="<c:url value='/quan-tri/don-hang/tat-ca'/>">Danh sách đơn hàng</a>

			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-users"></i> <span> Khách hàng</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
<%--				<h6 class="dropdown-header">Quản lý khách hàng</h6>--%>
				<a class="dropdown-item" href="<c:url value='/quan-tri/khach-hang'/>">Danh sách khách hàng</a>

			</div></li>
		
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-user-alt"></i> <span> Admin</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
<%--				<h6 class="dropdown-header">Quản lý admin</h6>--%>
				<a class="dropdown-item" href="<c:url value='/quan-tri/admin-info'/>">Thêm admin</a> <a
					class="dropdown-item" href="<c:url value='/quan-tri/danh-sach-admin'/>">Danh sách admin</a>
			</div></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-paste"></i> <span> Thống kê</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
<%--				<h6 class="dropdown-header">Thông kế</h6>--%>
				<a class="dropdown-item" href="<c:url value='/quan-tri/thong-ke/products'/>">Thông kê sản phẩm</a>
				<a class="dropdown-item" href="<c:url value='/quan-tri/thong-ke/revenue'/>">Thông kê doanh thu</a>
				<a class="dropdown-item" href="<c:url value='/quan-tri/thong-ke/productLike'/>">Thông kê yêu thích</a>
				<a class="dropdown-item" href="<c:url value='/quan-tri/Thong-ke/Bieu-do-doanh-thu'/>">Biểu đồ doanh thu</a>
			</div></li>
<%--		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"--%>
<%--			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"--%>
<%--			aria-haspopup="true" aria-expanded="false"><i class="fa fa-comment" aria-hidden="true"></i> <span> Bình luận</span>--%>
<%--		</a>--%>
<%--			<div class="dropdown-menu" aria-labelledby="pagesDropdown">--%>
<%--				<h6 class="dropdown-header">Quản lý Bình luận</h6>--%>
<%--				 <a class="dropdown-item" href="DanhSachSachBinhLuanServlet">Danh sách bình luận</a>--%>
<%--			</div></li>--%>
	</ul>

	<div id="content-wrapper"style="background: #f1f1f1; margin-bottom: 40px;">

		<div class="container-fluid">