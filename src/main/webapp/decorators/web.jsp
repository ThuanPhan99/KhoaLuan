<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><dec:title default="" /></title>
<link rel="shortcut icon" type="image/png" href="<c:url value="/image/logo/favicon.png"/>">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/meanmenu.css' />" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/owl.theme.default.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/web/css/owl.carousel.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/web/css/animate.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/web/css/css.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/web/css/dangnhap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/web/css/style.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/web/css/styleheader2.css' />" />
<!-- Bootstrap CSS
        ============================================ -->

<!-- style CSS
            ============================================ -->
<link rel="stylesheet"
	href="<c:url value='/template/web/style.css' />" />
<!-- DashForge CSS -->
<link rel="stylesheet"
	href="<c:url value='/template/web/assets/css/dashforge.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/web/assets/css/dashforge.dashboard.css' />" />
	<link rel="stylesheet"
	href="<c:url value='/template/web/assets/css/dashforge.auth.css' />" />
</head>

<body data-spy="scroll" data-target="#myScroll" data-offset="50" style="background: #f1f1f1">




	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->
	<%@ include file="/common/web/nav.jsp"%>
	<!-- header -->

	<dec:body />

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src = " https://unpkg.com/sweetalert/dist/sweetalert.min.js " > </script> 
 <script src="<c:url value='/template/web/lib/jquery/jquery.min.js'/>"></script>
    <script src="<c:url value='/template/web/lib/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
    <script src="<c:url value='/template/web/assets/js/dashforge.js'/>"></script>
    <script src="<c:url value='/template/web/assets/js/dashforge.settings.js'/>"></script>
    <script src="<c:url value='/template/web/js/ajax/search.js'/>"></script>
 	   <script src="<c:url value='/template/web/paging/jquery.twbsPagination.js'/>"></script>
 	 <script src="<c:url value='/template/web/js/ajax/paging.js'/>"></script> 
<script type="text/javascript">
/* cập nhập thông tin */
$(document).ready(function(){
    $("#editInfo").click(function(){
      $("#editInfoModal").modal();
  });
});

</script>
</body>

</html>