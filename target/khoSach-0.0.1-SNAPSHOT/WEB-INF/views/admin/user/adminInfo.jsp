<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userURL" value="/api/admin/user" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>3Tbook - Admin Information</title>
</head>
<body>
<div class="container">
    <div style="width: 80%; margin-right: auto; margin-left: auto;"
         class="content content-fixed content-auth">
        <div class="container">
            <div
                    class="media align-items-stretch justify-content-center ht-100p">
                <div style="width: 100%" class="sign-wrapper mg-lg-r-50 mg-xl-r-60">
                    <div class="pd-t-20 wd-100p">
                        <h1 class="h3 mb-2 text-gray-800">Tạo tài khoản Admin.</h1>
                        <div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory"></div>
                        <form action="" id="formSubmit">
                            <div class="row">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label>Tên đăng nhập</label> <input type="text"
                                                                            name="userName" id="userName" class="form-control required"
                                                                            placeholder="Tên đăng nhập" required>
                                        <p class="text-danger" id="resultUserName"></p>
                                    </div>
                                    <div class="form-group">
                                        <div class="d-flex justify-content-between mg-b-5">
                                            <label class="mg-b-0-f">Mật khẩu</label>
                                        </div>
                                        <input type="password" class="form-control required" name="password"  required
                                               id="password" placeholder="Mật khẩu">

                                    </div>
                                    <div class="form-group">
                                        <label>Số điện thoại</label> <input type="number" required
                                                                            name="numberPhone" id="numberPhone" class="form-control required"
                                                                            placeholder="Số điện thoại">
                                        <p class="text-danger" id="resultNumberPhone"></p>
                                    </div>
                                    <div class="form-group">
                                        <label>Địa chỉ</label> <input type="text" class="form-control required" required
                                                                     name="address" id="address" placeholder="Địa chỉ">
                                    </div>

                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label>Họ tên</label> <input type="text" path="fullName" class="text form-control required" required
                                                                     name="fullName" id="fullName" placeholder="Họ và tên">
                                        <p class="text-danger" id="resultGroupProductName"></p>
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label> <input type="email" class="form-control required" required
                                                                    name="email" id="email" placeholder="Địa chỉ email">
                                        <p class="text-danger" id="resultEmail"></p>
                                    </div>
                                    <div class="row">
                                        <div class="col-8">
                                            <div class="form-group">
                                                <label>Ngày sinh</label> <input type="date" required
                                                                                name="dateOfBirth" id="dateOfBirth" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="form-group">
                                                <label>Giới tinh</label> <select class="form-control required"
                                                                                 name="gender" id="gender">
                                                <option value="1">Nam</option>
                                                <option value="0">Nữ</option>
                                            </select>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <button type="submit"
                                        onclick="return submitRegister()" class="btn btn-success btn-brand-02 btn-block">Tạo Tài khoản</button>
                            </div>

                        </form>
                    </div>
                </div>
                <!-- sign-wrapper -->
            </div>
            <!-- media -->
        </div>
        <!-- container -->
    </div>
    <!-- content -->
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="<c:url value='/template/admin/js/ajax/register.js' />"></script>

</body>
</html>