<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Trang đăng nhập</title>
</head>
<body>
	
	<div class="container">
   <div class="content content-fixed content-auth">
      <div class="container">
        <div class="media align-items-stretch justify-content-center ht-100p pos-relative">
          <div class="media-body align-items-center d-none d-lg-flex">
            <div>
              <img style="max-width: 100%; height: auto; width: 650px; margin-top: -40px; margin-right: 0px;"  src="/image/Banner/khosach-banner.png.jpg" class="img-fluid" alt="">
            </div>
            <div class="pos-absolute b-0 l-0 tx-12 tx-center">
            </div>
          </div><!-- media-body -->
          <div class="sign-wrapper mg-lg-l-50 mg-xl-l-60">
            <div class="wd-100p">
             
              <p style="color:#026e36" class="tx-color-03 tx-18 mg-b-40">Chào mừng đến với nhà sách 3Tbook. Đăng nhập ngay! </p>
			<form action="j_spring_security_check" method="post">
              <div class="form-group">
                <label>Email/TenDangNhap</label>
                <input name="j_username"  class="form-control" placeholder="Email/TenDangNhap">
              </div>
              <div class="form-group">
                <div class="d-flex justify-content-between mg-b-5">
                  <label class="mg-b-0-f">Mật khẩu</label>
                  <a href="" class="tx-13">Quên mật khẩu?</a>
                </div>
                <input type="password" name="j_password" class="form-control" placeholder="Enter your password">
              </div>
              <button class="btn btn-brand-02 btn-block">Đăng Nhập</button>
              <div class="divider-text">Hoặc</div>
              <button class="btn btn-outline-facebook btn-block">Đăng Nhập Bằng Facebook</button>
              <button class="btn btn-outline-twitter btn-block">Đăng Nhập Bằng Twitter</button>
              <div class="tx-13 mg-t-20 tx-center">Quên tài khoản? <a href="page-signup.html">Đăng ký</a></div>
            </form>
            </div>
          </div><!-- sign-wrapper -->
        </div><!-- media -->
      </div><!-- container -->
    </div><!-- content -->
</div>

</body>
</html>