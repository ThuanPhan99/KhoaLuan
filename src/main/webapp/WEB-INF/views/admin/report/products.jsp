<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>3Tbook- Quản trị - Thống Kê - Sản Phẩm</title>
</head>
<body>
<div class="container-fluid">
    <h2 style="text-align: right;">
        <a id="reportProduct" class="text-white btn btn-success mr-3" onclick="reportProducts()">
            Xuất report</a>
        <button id="reportProductLoading" class="btn btn-success" style="display: none;" disabled >
            <span class="spinner-border spinner-border-sm"></span>
            Loading...
        </button>
    </h2>
    <h1 class="h3 mb-2 text-gray-800">Danh sách sản phẩm</h1>
    <div style="background: #fff" class="mb-4">
        <div class="card-body">
            <div class="table-responsive table-hover">
                <table class="table table-bordered" id="dataTable" width="100%"
                       cellspacing="0">
                    <thead>
                    <tr>
                        <th>Mã sản phẩm</th>
                        <th>Tên sản phẩm</th>
                        <th>Nhóm sản phẩm</th>
                        <th>Trạng thái</th>
                        <th>Giá trung bình</th>
                        <th>Phầm trăm KM</th>
                        <th>Số lượng</th>
                        <th>Tác giả</th>
                        <th>Nhà xuất bản</th>
                        <th>Ngày nhập gần nhất</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listProduct}" var="product">

                        <tr id="trGC_${product.productID}">
                            <td>${product.productID}</td>
                            <td>${product.productName}</td>
                            <td>${product.groupProductName}</td>
                            <c:if test="${product.status==1}">
                                <td>Còn hàng</td>
                            </c:if>
                            <c:if test="${product.status==0}">
                                <td>Hết hàng</td>
                            </c:if>
                            <td><fmt:formatNumber type = "CURRENCY" value = "${product.price}" /></td>
                            <td>${product.salePrice}</td>
                            <td>${product.quantity}</td>
                            <td>${product.author}</td>
                            <td>${product.publisher}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${product.dateAdded}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="<c:url value='/template/admin/js/ajax/report.js' />"></script>

</body>
</html>