<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Quản trị - Thống Kê - Biểu đồ doanh thu</title>
</head>
<body>
<div class="container">
	<h2 id="titleThongKe"
		style="padding-bottom: 37px; font-size: 23px; text-align: center; padding-top: 16px;">
		BIỂU ĐỒ DOANH THU THEO NĂM</h2>
	<div class="card shadow mb-4">
		<div class="card-body">
			<canvas id="line-chart" width="1500" height="450"></canvas>
			<input type="hidden" value="${revenue}" id="revenue">
		</div>
	</div>
</div>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
	<script src="<c:url value='/template/admin/js/revenueChart.js' />"></script>
</body>
</html>