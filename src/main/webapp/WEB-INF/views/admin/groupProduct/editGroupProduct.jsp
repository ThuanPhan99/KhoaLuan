<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="groupProductURL" value="/api/groupproduct" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook- Thêm nhóm thể loại</title>
</head>
<body>
	<div class="container">
		<div class="row shadow">
			<div class="col-sm-12">

				<div class="px-2">
					<h4 class="title mt-4 mb-5 text-center text-uppercase text-danger">Nhóm thể loại</h4>
					<div id="infoAlert">
					</div>
					
					<form:form modelAttribute="model" id="formSubmit">
						<form:hidden path="groupProductID" id="idModel" />
						<div class="row">
							<div class="form-group col-sm-8">
								<label class="">Tên nhóm sản phẩm</label>
								<form:input path="groupProductName" id="groupProductName" 
									cssClass="text form-control required" />
								<p class="text-danger" id="resultGroupProductName"></p>
							</div>
							<div class="form-group col-sm-4">
							  <label for="categoryID" class=" control-label no-padding-right">Thể loại:</label>
							  <div class="col-sm-9">
							  	 <form:select path="categoryID" cssClass="text form-control required"  id="categoryID">
							  	 	<form:option value="" label="-- Chọn thể loại --"/>
							  	 	<form:options items="${groupProducts}"/>
							  	 </form:select>
							  </div>
						</div>
						</div>
						<div class="form-group">
						<c:if test="${not empty model.groupProductID}">
							<button type="submit" value="them" class="btn btn-success mb-3"
								onclick="return submitEdit('${groupProductURL}')" name="btnThem">Cập nhật</button>
						</c:if>
						<c:if test="${empty model.groupProductID}">
							<button type="submit" value="them" class="btn btn-success mb-3"
								onclick="return submitEdit('${groupProductURL}')" name="btnThem">Thêm</button>
						</c:if>
							<a class="btn btn-danger ml-3 mb-3" href="<c:url value='/quan-tri/nhom-san-pham'/>">
								Hủy</a>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<c:url value='/template/admin/js/ajax/edit.js' />"></script>
</body>
</html>