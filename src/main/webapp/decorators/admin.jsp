<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><dec:title default="Admin" /></title>
<link rel="shortcut icon" type="image/png" href='<c:url value="/image/logo/favicon.png"/>'>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Custom fonts for this template-->
<link rel="stylesheet" href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" />
<!-- Page level plugin CSS-->
<link rel="stylesheet" href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css' />" />
<link rel="stylesheet" href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" />
<!-- Custom styles for this template-->
<link rel="stylesheet" href="<c:url value='/template/admin/css/sb-admin.css' />" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value='/template/admin/css/style.css' />" />

</head>

<body id="page-top">

       <%@ include file="/common/admin/header.jsp" %>

		<!-- header -->
    	<%@ include file="/common/admin/nav.jsp" %>
    	<!-- header -->
		
		<dec:body/>
		
		<!-- footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
    	<!-- footer -->

<!-- Bootstrap core JavaScript-->

	<script src="<c:url value='/template/admin/js/ajax/delete.js' />"></script>
	<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
	<script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<!-- Core plugin JavaScript-->
	<script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js' />"></script>

<!-- Page level plugin JavaScript-->
	<script src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.js' />"></script>
	<script src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.js' />"></script>

<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/admin/js/sb-admin.min.js' />"></script>
<!-- Demo scripts for this page-->
	<script src="<c:url value='/template/admin/js/demo/datatables-demo.js' />"></script>
	<script src = " https://unpkg.com/sweetalert/dist/sweetalert.min.js " > </script> 
	
	<script src="<c:url value='/template/admin/js/common.js' />"></script>
	
	<script type="text/javascript" src="<c:url value='/template/admin/ckeditor/ckeditor.js'/>"
	charset="utf-8"></script>

<script type="text/javascript">
    config ={};
    config.entities = false;
    config.basicEntities = false;
    config.entities_latin=false;
    config.language='vi';
    CKEDITOR.replace('description',{
      filebrowserUploadUrl: 'ckeditor/ck_upload.php',
      filebrowserUploadMethod: 'form'
    },config);
  </script>
  </body>
</html>