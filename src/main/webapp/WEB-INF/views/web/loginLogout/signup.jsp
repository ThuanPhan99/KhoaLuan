<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Tbook - Trang đăng ký tài khoản</title>
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
							<p style="color: #001737; font-size: 21px"
								class="tx-color-03 tx-16 mg-b-40">Tạo tài khoản kho sách.</p>
						<div style="height: 34px; padding: 5px; padding-left: 13px;"  id="alertCategory"></div>
							<form action="" id="formSubmit">
								<div class="row">
									<div class="col-6">
										<div class="form-group">
											<label>Tên đăng nhập</label> <input type="email"
												name="userName" id="userName" class="form-control"
												placeholder="Tên đăng nhập" required>
											<p class="text-danger" id="resultUserName"></p>
										</div>
										<div class="form-group">
											<div class="d-flex justify-content-between mg-b-5">
												<label class="mg-b-0-f">Mật khẩu</label>
											</div>
											<input type="password" class="form-control" name="password"  required
												id="password" placeholder="Mật khẩu">
											
										</div>
										<div class="form-group">
											<label>Số điện thoại</label> <input type="number" required
												name="numberPhone" id="numberPhone" class="form-control"
												placeholder="Số điện thoại">
											<p class="text-danger" id="resultNumberPhone"></p>
										</div>
										<div class="row">
											<div class="col-8">
												<div class="form-group">
													<label>Ngày sinh</label> <input type="date" required
														name="dateOfBirth" id="dateOfBirth" class="form-control">
												</div>
										</div>
											<div class="col-4">
												<div class="form-group">
													<label>Giới tinh</label> <select class="form-control"
														name="gender" id="gender">
														<option value="1">Nam</option>
														<option value="0">Nữ</option>
													</select>
												</div>

											</div>
										</div>
									</div>
									<div class="col-6">
										<div class="form-group">
											<label>Họ tên</label> <input type="text" class="form-control" required
												name="fullName" id="fullName" placeholder="Họ và tên">
										</div>
										<div class="form-group">
											<label>Email</label> <input type="text" class="form-control" required
												name="email" id="email" placeholder="Địa chỉ email">
											<p class="text-danger" id="resultEmail"></p>
										</div>

										<div class="form-group tx-12">
											Bằng cách nhấn nút <strong>Đăng ký</strong> bên dưới, tôi
											đồng ý với các điều khoản và chính sách bảo mật của Kho Sách
										</div>
										<!-- form-group -->

										<button type="button" onclick="submitRegister()" class="btn btn-brand-02 btn-block">ĐĂNG KÝ</button>

										<div class="divider-text">Hoặc</div>
										<button class="btn btn-outline-facebook btn-block">Đăng
											nhập bằng Facebook</button>
										<button class="btn btn-outline-twitter btn-block">Đăng
											nhập bằng Twitter</button>
										<div class="tx-13 mg-t-20 tx-center">
											Bạn đã có tài khoản? <a href="page-signin.html">Đăng nhập
												ngay</a>
										</div>
									</div>

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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<c:url value='/template/web/js/ajax/register.js' />"></script>
</body>
</html>