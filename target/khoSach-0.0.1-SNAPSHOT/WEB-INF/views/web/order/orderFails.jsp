<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>3Tbook - cảm ơn bạn tin tưởng chúng tôi</title>
</head>
<body>
<div class="container">
    <div  class="order-finish">
        <div class="order-finish-content">
            <h1>Đặt hàng không thành công</h1>
            <h2>Xảy ra lỗi trong khi thanh toán.</h2>
        </div>
        <div class="order-finish-button">
            <button><a href="<c:url value='/trang-chu' />">Tiếp tục mua hàng</a></button>
        </div>
    </div>
</div>
</body>
</html>