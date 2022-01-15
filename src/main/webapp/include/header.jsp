<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Website ban hang</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">


  </head>


  <body>


    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
      <div class="container">
        <a class="navbar-brand" style="color:black;font-weight:300px;font-size:25px" href="index">TIKA</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="index">Trang Chủ
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="product">Sản phẩm</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about.jsp">Về chúng tôi</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="contacts.jsp">Liên hệ</a>
            </li>
            <li class="nav-item">
             	<a class="nav-link" href="${pageContext.request.contextPath}/cart">Giỏ hàng</a>
            </li>
            <c:if test="${sessionScope.username != null}">           
            <li class="nav-item">
              <div class="dropdown">
              
                <a  class="nav-link dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  ${username }
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                  <a class="dropdown-item" href="history">Lịch sử mua hàng</a>
                  <a class="dropdown-item" href="LogoutController">Đăng xuất</a>
                </div>
				</div>
               </li>
             </c:if>
            <c:if test="${sessionScope.username == null}">           
            <li class="nav-item">
              <div class="dropdown">
              
                <a  class="nav-link dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Đăng nhập / Đăng ký
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                  <a class="dropdown-item" href="login.jsp">Đăng nhập</a>
                  <a class="dropdown-item" href="register.jsp">Đăng ký</a>
                </div>
               </div>
               </li>
             </c:if>
          </ul>
        </div>
      </div>
    </nav>