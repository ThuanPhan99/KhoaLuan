<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>3Tbook - Quản trị - Thống Kê - Đơn Hàng</title>
</head>
<body>
<div class="container-fluid">
    <h1 style="color: forestgreen;">Thống kê yêu thích</h1>
    <div id="sniperReportProductLike" class="sniper" style="display: none; text-align: center;margin-top: 45px;">
        <div class="spinner-border" style="width: 150px;height: 150px;"></div>
    </div>
    <div id="reportProductLike" class="report-order" style="padding: 26px;">
        <form action="" id="formSubmit">
            <div class="row">
                <div class="col-4">
                    <div class="form-group">
                        <label>From Date</label> <input type="date" required
                                                        name="fromDate" id="fromDate" class="form-control">
                    </div>
                </div>
                <div class="col-4">
                    <div class="form-group">
                        <label>To Date</label> <input type="date" required
                                                      name="toDate" id="toDate" class="form-control">
                    </div>
                </div>
                <div class="col-4">
                    <h2 style="text-align: right; text-align: left; margin-top: 31px;">
                        <a class="text-white btn btn-success" style="width: 125px;" onclick="reportProductLike()">
                            Xuất report</a>
                    </h2>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="<c:url value='/template/admin/js/ajax/report.js' />"></script>

</body>
</html>