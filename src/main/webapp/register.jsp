<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!------ Include the above in your HEAD tag ---------->
                                    	<%
											String err = "";
											if (request.getAttribute("err") != null) {
												err = (String) request.getAttribute("err");
											}
										%>
<jsp:include page = "include/header.jsp" flush = "true" />									
<div class="container" style ="margin-top:5%;">
<div class="row justify-content-center">
                    <div class="col-md-10">
                        <div class="card">
                            <div class="card-header">Đăng ký tài khoản</div>
                            <div class="card-body">

                                <form class="form-horizontal" method="post" action="RegisterController">

                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">Họ tên</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">

                                                <input type="text" class="form-control" name="name" id="name" placeholder="Điền vào họ tên" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="cols-sm-2 control-label">Email</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">

                                                <input type="text" class="form-control" name="email" id="email" placeholder="Điền vào Email" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="username" class="cols-sm-2 control-label">Tài khoản</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                
                                                <input type="text" class="form-control" name="username" id="username" placeholder="Điền vào tài khoản" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="username" class="cols-sm-2 control-label">Số điện thoại</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                
                                                <input type="text" class="form-control" name="phone" id="phone" placeholder="Điền vào số điện thoại" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="cols-sm-2 control-label">Mật khẩu</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                               
                                                <input type="password" class="form-control" name="password" id="password" placeholder="Điền vào mật khẩu" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm" class="cols-sm-2 control-label">Xác nhận lại mật khẩu</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                       
                                                <input type="password" class="form-control" name="confirm" id="confirm" placeholder="Điền vào xác nhận mật khẩu" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Đăng ký tài khoản">
                                    </div>
                                    <div class ="form-group">
                                    	<p style="color: red"><%=err%></p>
                                    </div>

                                    <div class="login-register">
                                        <a href="view/index.php">->Trang đăng nhập</a>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
</div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


    <!-- Additional Scripts -->
    <script src="assets/js/custom.js"></script>
    <script src="assets/js/owl.js"></script>