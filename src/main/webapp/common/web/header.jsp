<%@page import="com.khosach.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!-- header -->
<!-- HEADER AREA -->
            <div class="header-area">
                <div class="header-top-bar">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6 col-sm-4 col-xs-12">
                                <div class="header-top-left">
                                    <div class="header-top-menu">
                                        <ul style="display: flex;" class="list-inline">
                                            <li style="color: #9e9e9e" >Phone : 0947208137
                                            </li>
                                            <li style="padding-left: 15px;color: #9e9e9e" >Email : xphanthuan99@gmail.com
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-8 col-xs-12">
                                <div class="header-top-right">
                                    <ul style="display: flex;" class="list-inline">
                                        <li><a href="#"></i>KIỂM TRA ĐƠN HÀNG</a></li>
                                        <security:authorize access = "isAuthenticated()">
                                        <li>
                                           <div class="dropdown dropdown-profile">
                                              <a href="" class="dropdown-link" data-toggle="dropdown" data-display="static">
                                                <div class="avatar avatar-sm"> TÀI KHOẢN : <%=SecurityUtils.getPrincipal().getFullName().toUpperCase()%></div>
                                            </a><!-- dropdown-link -->
                                            <div class="dropdown-menu dropdown-menu-right tx-13">
                                              
                                                <a href="<c:url value='thong-tin-tai-khoan'/>" class="dropdown-item"><i class="fa fa-user"></i> Quản lý tài khoản</a>
                                                <div class="dropdown-divider"></div>
                                                <a href="<c:url value='quan-ly-don-hang'/>" class="dropdown-item"><i class="fas fa-ballot-check"></i> Đơn hàng của tôi</a>
                                                 <div class="dropdown-divider"></div>
                                                <a href="<c:url value='/thoat'/>" class="dropdown-item"><i class="fa fa-sign-out"></i>Đăng xuất</a>
                                                 <div class="dropdown-divider"></div>
                                            </div><!-- dropdown-menu -->
                                        </div><!-- dropdown -->
                                    </li>
                                    </security:authorize>
                                      <security:authorize access = "isAnonymous()">
		                                     <li><a href="<c:url value='/dang-nhap'/>">ĐĂNG NHẬP</a></li>
		                                    <li><a  href="<c:url value='/dang-ky'/>">ĐĂNG KÝ</a></li>
                                  		</security:authorize>

				
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- MAIN MENU AREA -->
         <header class="header__container">
            <div class="header__wrapper  js-container">
                <div class="container">
                    <div class="header__left-right">
                        <div class="header__wrapper-left">
                            <div class="header__logo">
                                <a href="/trang-chu">
                                    <img src="<c:url value="/image/logo/logo.png"/>" alt="">
                                </a>
                            </div>
                            <div class="header__form" style="display: block;">
                                <form action="/tim-kiem" method="GET">
                                    <input type="text" class="header__form-input" name="search" id="search" onkeyup="searchKeyUp()" placeholder="Nhập từ khóa cần tìm..." autocomplete="off">
                                    <button type="submit" class="header__form-submit"><i class="fa fa-search"></i></button>
                                </form>
                            <div  class="resutlSearch">
                                <ul class="menu-search" id="resutlSearch">
                               
                                </ul>
                            </div>
                           
                        </div>
                    </div>
                    <div class="header__wrapper-right">
                      <div class="header-chart">
                        <%@ include file="/common/web/modalCart.jsp"%>
                </div>
   <img style="margin-top: -11px;
    display: block;
    margin-left: 32px;
    width: 50px;
    padding-bottom: 18px;" src="<c:url value="/image/logo/sale.webp"/>" alt="">

            </div>
        </div>
    </div>
</div>