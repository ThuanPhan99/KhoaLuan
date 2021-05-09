<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="productURL" value="/api/product"/>
<c:url var="authorUrl" value="/api/author" />
<c:url var="publisherUrl" value="/api/publisher" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>3Tbook</title>
</head>
<body>
<div class="container">
    <div class="row shadow">
        <div class="col-sm-12">

            <div class="px-2">
                <h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Sản
                    phẩm</h4>
                <div id="infoAlert">
                </div>
                <form:form modelAttribute="model" id="formSubmit">
                    <form:hidden path="productID" id="productID"/>
                    <%-- 	<form:hidden path="dateAdded" id="dateAdded" /> --%>
                    <form:hidden path="delete" id="delete"/>
                    <div class="row">
                        <div class="form-group col-sm-7">
                            <label class="">Tên sản phẩm</label>
                            <form:input path="productName" id="productName"
                                        cssClass="text form-control required"/>
                            <p class="text-danger" id="resultGroupProductName"></p>
                        </div>
                        <div class="form-group col-sm-5">
                            <label for="groupProductID"
                                   class=" control-label no-padding-right">Nhóm sản phẩm:</label>
                            <div class="col-sm-9">
                                <form:select path="groupProductID" cssClass="text form-control required"
                                             id="categoryID">
                                    <form:option value="" label="-- Chọn nhóm sản phẩm --"/>
                                    <form:options items="${groupProducts}"/>
                                </form:select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                            <%--<div class="form-group col-sm-4">
                                <label class="">Tác giả</label>
                                <form:input path="author" id="author"
                                    cssClass="text form-control required" />
                                <p class="text-danger" id="resultGroupProductName"></p>
                            </div>--%>

                        <div class="form-group col-sm-3">
                            <label for="authorId"
                                   class=" control-label no-padding-right">Tác giả:</label>
                            <div class="col-sm-11" style="padding-left: 0PX;">
                                <form:select path="authorId" cssClass="text form-control required"
                                             id="categoryID">
                                    <form:option value="" label="-- Chọn tác giả --"/>
                                    <form:options items="${authors}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group col-sm-1">
                            <button type="button" style="position: absolute; top: 31px; left: -35px;" id="addAuthor" value="them"
                                    class="btn btn-success" name="btnThemAuthor">Thêm
                            </button>
                        </div>
                            <%--<div class="form-group col-sm-4">
                                <label class="">Nhà xuất bản</label>
                                <form:input path="publisher" id="publisher"
                                    cssClass="text form-control required" />
                                <p class="text-danger" id="resultGroupProductName"></p>
                            </div>--%>

                        <div class="form-group col-sm-3">
                            <label for="publisherId"
                                   class=" control-label no-padding-right">Nhà xuất bản:</label>
                            <div class="col-sm-11" style="padding-left: 0PX;">
                                <form:select path="publisherId" cssClass="text form-control required"
                                             id="categoryID">
                                    <form:option value="" label="-- Chọn nhà xuất bản --"/>
                                    <form:options items="${publishers}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group col-sm-1">
                            <button type="button" style="position: absolute; top: 31px; left: -35px;" value="them" id="addPublisher"
                                    class="btn btn-success" name="btnThemPublisher">Thêm
                            </button>
                        </div>

                        <div class="form-group col-sm-4">
                            <label class="">Năm xuất bản</label>
                            <div class="col-sm-11" style="padding-left: 0PX;">
                                <form:input path="yearOfPublication" id="yearOfPublication"
                                            cssClass="text form-control typeNumber required"/>
                                <p class="text-danger" id="resultGroupProductName"></p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-4">
                            <label class="">Ảnh sản phẩm</label> <input type="file"
                                                                        name="thumbnail" id="thumbnail"
                                                                        class="text form-control col-sm-8"/>
                            <c:if test="${not empty model.productID}">
                                <img style="" class="col-sm-2" alt=""
                                     src="<c:url value="/image/product/${model.thumbnail}"/>">
                            </c:if>
                            <p class="text-danger" id="resultPicture"></p>
                        </div>
                        <div class="form-group col-sm-2">
                            <label for="genreId"
                                   class=" control-label no-padding-right">Tái bản</label>
                            <div class="col-sm-11" style="padding-left: 0PX;">
                                <form:select path="genreId" cssClass="text form-control"
                                             id="genreId">
                                    <form:option value="" label="-- Chọn lần tái bản --"/>
                                    <form:options items="${productGenre}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group col-sm-2">
                            <label class="">Số trang</label>
                            <form:input path="numberOfPages" id="numberOfPages"
                                        cssClass="text form-control typeNumber required"/>
                        </div>
                        <c:if test="${not empty model.productID}">
                            <div class="form-group col-sm-4">
                                <label for="status"
                                       class=" control-label no-padding-right">Trạng thái</label>
                                <div class="col-sm-9">
                                    <form:select path="status" cssClass="text form-control"
                                                 id="status">
                                        <form:options items="${listStatus}"/>
                                    </form:select>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${empty model.productID}">
                            <div class="form-group col-sm-4">
                                <label class="">Giá nhập</label>
                                <form:input path="priceAdd" id="priceAdd"
                                            cssClass="text form-control typeNumber required"/>
                            </div>
                        </c:if>


                    </div>
                    <div class="row">
                        <div class="form-group col-sm-4">
                            <label class="">Số lượng</label>
                            <form:input path="quantity" id="quantity"
                                        cssClass="text form-control typeNumber required"/>
                            <p class="text-danger" id="resultGroupProductName"></p>
                        </div>
                        <div class="form-group col-sm-4">
                            <label class="">Giá bán</label>
                            <form:input path="price" id="price"
                                        cssClass="text form-control typeNumber required"/>
                            <p class="text-danger" id="resultGroupProductName"></p>
                        </div>
                        <div class="form-group col-sm-4">
                            <label class="">Phần trăm khuyến mãi</label>
                            <form:input path="salePrice" id="salePrice"
                                        cssClass="text form-control typeNumber"/>
                            <p class="text-danger" id="resultGroupProductName"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Mô tả:</label>
                        <form:textarea path="description" id="description" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <c:if test="${not empty model.productID}">
                            <button type="submit" value="them" class="btn btn-success mb-3"
                                    onclick="return editProduct('${productURL}')" name="btnThem">Cập nhật
                            </button>
                        </c:if>
                        <c:if test="${empty model.productID}">
                            <button onclick="return editProduct('${productURL}')" type="submit" value="them"
                                    class="btn btn-success mb-3"
                                    name="btnThem">Thêm
                            </button>
                        </c:if>
                        <a class="btn btn-danger ml-3 mb-3" href="<c:url value='/quan-tri/san-pham'/>"> Hủy</a>

                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<div class="container mt-3">
    <div class="modal fade" id="addAuthorModal">
        <div class="modal-dialog">
            <div class="modal-content" style="width: 700px">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Thêm mới tác giả</h4>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategoryAuthor">

                    </div>
                    <form:form modelAttribute="authorNew" id="authorNew">
                        <div class="row">
                            <div class="col-sm-5">
                                <div class="form-group">
                                    <label>Họ</label>
                                    <form:input path="firstName" id="firstName"
                                                cssClass="text form-control required" />
                                    <p class="text-danger" id="resultGroupProductName"></p>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label>Tên</label>
                                    <form:input path="lastName" id="lastName"
                                                cssClass="text form-control required" />
                                    <p class="text-danger" id="resultGroupProductName"></p>
                                </div>
                            </div>
                        </div>
                        <div class="row p-2 pt-3">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label>Tên khác</label>
                                    <form:input path="otherNames" id="otherNames"
                                                cssClass="text form-control " />
                                </div>
                            </div>
                            <div class="col-sm-5">
                                <div class="form-group">
                                    <label>Ngày sinh</label> <input type="date"
                                                                    cssClass="text form-control required"
                                                                    value='<fmt:formatDate pattern = "yyyy-MM-dd"  value = "${authorNew.birthDate}" />'
                                                                    placeholder="Ngày sinh" required name="birthDate">
                                </div>
                            </div>
                        </div>
                        <div class="row p-2 pt-3">
                            <div class="col-sm-10">
                                <label>Mô tả </label>
                                <form:textarea path="history" id="history"
                                            cssClass="text form-control " />
                            </div>
                        </div>
                        <h1 style="text-align: right; margin-top: 10px;">
                            <button style="font-size: 14px;" type="submit" onclick="return submitAuthor('${authorUrl}')"
                                    class="btn btn-success mb-3">Thêm</button>
                            <a  style="font-size: 14px; color: #fff"
                                class="btn btn-danger ml-3 mb-3" style="color: #fff"
                                data-dismiss="modal">Hủy</a>
                        </h1>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container mt-3">
    <div class="modal fade" id="addPublisherModal">
        <div class="modal-dialog">
            <div class="modal-content" style="width: 700px">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Thêm mới nhà sản xuất</h4>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategoryPublisher">

                    </div>
                    <form:form modelAttribute="publisherNew" id="publisherNew">
                        <div class="row">
                            <div class="col-sm-5">
                                <div class="form-group">
                                    <label>Tên</label>
                                    <form:input path="name" id="name"
                                                cssClass="text form-control required" />
                                    <p class="text-danger" id="resultGroupProductName"></p>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label>Thành Phố</label>
                                    <form:input path="city" id="city"
                                                cssClass="text form-control required" />
                                    <p class="text-danger" id="resultGroupProductName"></p>
                                </div>
                            </div>
                        </div>
                        <div class="row p-2 pt-3">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label>Quốc Gia</label>
                                    <form:input path="country" id="country"
                                                cssClass="text form-control required" />
                                    <p class="text-danger" id="resultGroupProductName"></p>
                                </div>
                            </div>
                        </div>
                        <h1 style="text-align: right; margin-top: 10px;">
                            <button style="font-size: 14px;" type="submit" onclick="return submitPublisher('${publisherUrl}')"
                                    class="btn btn-success mb-3">Thêm</button>
                            <a  style="font-size: 14px; color: #fff"
                                class="btn btn-danger ml-3 mb-3" style="color: #fff"
                                data-dismiss="modal">Hủy</a>
                        </h1>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="<c:url value='/template/admin/js/ajax/edit-upload-p.js' />"></script>
</body>
</html>