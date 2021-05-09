<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="orderURL" value="/api/orderadmin" />
<c:url var="orderDetailtURL" value="/api/orderdetail" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>3Tbook - Quản trị - Đơn hàng - Danh sách đơn hàng đã giao</title>
</head>
<body>
<div class="container-fluid">
    <h1 style="margin-top: -8px; color: #000"
        class="h3 mb-2 text-gray-800">Danh sách đơn hàng đã giao</h1>
    <div class="tab ">
        <button  class="tablinkOrder"  id="defaultOpen">
            <a href='<c:url value='/quan-tri/don-hang/tat-ca'/>'>Tất cả</a>
        </button>
        <button  class="tablinkOrder" >
            <a href='<c:url value='/quan-tri/don-hang/chua-duyet'/>'>Chưa
                duyệt</a>
        </button>
        <button  class="tablinkOrder" >
            <a href="<c:url value='/quan-tri/don-hang/da-duyet'/>">Đã duyệt</a>
        </button>
        <button class="tablinkOrder" >
            <a href="<c:url value='/quan-tri/don-hang/dang-giao-hang'/>">Đang giao</a>
        </button>
        <button  class="tablinkOrder">
            <a href="<c:url value='/quan-tri/don-hang/da-thanh-toan'/>">Đã thanh toán</a>
        </button>
        <button  class="tablinkOrder" style="border-bottom: 3px solid #ff5800;">
            <a style="width: 100px;" href="<c:url value='/quan-tri/don-hang/da-hoan-thanh'/>">Đã hoàn thành</a>
        </button>
        <button class="tablinkOrder">
            <a href="<c:url value='/quan-tri/don-hang/da-huy'/>">Đã hủy</a>
        </button>
    </div>
    <div class="border-tab-order"></div>
    <div  class="tabcontentOrder" style="display: block;">
        <div class="mb-4">
            <div class="card-body">
                <div class="table-responsive table-hover">
                    <table class="table table-bordered" id="dataTable" width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th >Mã đơn hàng</th>
                            <th >Mã khách hàng</th>
                            <th>Trạng thái</th>
                            <th>Ngày lập</th>
                            <th>Ngày thanh toán</th>
                            <th >Phương thức thanh toán</th>
                            <th >Thao tác</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listOrder}" var="order">

                            <tr id="trGC_${order.orderID}">
                                <td>${order.orderID}</td>
                                <td>${order.userid}</td>
                                <td>${order.getStatusString()}</td>
                                <td>${order.dateOfIssue}</td>
                                <td><fmt:formatDate pattern = "yyyy-MM-dd"  value = "${order.deliveryDate}" /></td>
                                <td>${order.getPaymentMethodsString()}</td>
                                <td ><a style="margin-right: 3px;" class="btn btn-info"
                                        onclick="clickChiTiet(${order.orderID})" data-toggle="modal"
                                        data-target="#chiTiet_${order.orderID}"><i
                                        class="fas fa-info-circle"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <c:forEach items="${listOrder}" var="order">
        <div class="modal fade" id="chiTiet_${order.orderID}" tabindex="-1"
             role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Chi tiết đơn hàng</h4>
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>Mã chi tiết đơn hàng</th>
                                <th>Mã sản phẩm</th>
                                <th>Tên sản phẩm</th>
                                <th>Ảnh</th>
                                <th>Số lượng</th>
                                <th>Giá</th>
                                <th>Tổng tiền</th>
                            </tr>
                            </thead>
                            <tbody id="tbodyChiTiet_${order.orderID}">
                            </tbody>
                        </table>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
        src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="<c:url value='/template/admin/js/ajax/order.js' />"></script>
<script src="<c:url value='/template/admin/js/ajax/orderDetail.js' />"></script>
</body>
</html>