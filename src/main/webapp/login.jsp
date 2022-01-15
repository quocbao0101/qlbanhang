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
                            <div class="card-header">Đăng nhập tài khoản</div>
                            <div class="card-body">

                                <form class="form-horizontal" method="post" action="LoginController">
                                    <div class="form-group">
                                        <label for="username" class="cols-sm-2 control-label">Tài khoản</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">                                            
                                                <input type="text" class="form-control" name="username" id="username" placeholder="Điền vào tên tài khoản" />
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
                                    <div class="form-group ">
                                        <input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Đăng nhập">
                                    </div>
                                    <div class ="form-group">
                                    	<p style="color: red"><%=err%></p>
                                    </div>

                                    <div class="login-register">
                                        <a href="register.jsp">-> Trang đăng ký</a>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
</div>