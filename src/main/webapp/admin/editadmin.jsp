<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Website ban hang</title>
<%
											  if (session.getAttribute("admin_username") == null){
												  response.sendRedirect(request.getContextPath() + "/admin/login"); 
											  }
											  %>
      <jsp:include page = "./assets/includes/header.jsp" flush = "true" />
      <jsp:include page = "./assets/includes/navbar.jsp" flush = "true" />
</head>
<body>
        <form action="${pageContext.request.contextPath}/admin/edit" method="POST">
        <div class="modal-body">
        			<div class ="form-group">
        				<h3>Sửa admin</h3>
        			</div>
                    <div class="form-group">
                        <label>ID</label>
                        <input class="form-control" type="text" required name="id" value="${edit_admin.id}">
                    </div>
                    <div class="form-group">
                        <label>Tài khoản</label>
                        <input class="form-control" type="text" required name="username" value="${edit_admin.username}">
                    </div>
                    <div class="form-group">
                        <label>Mật khẩu</label>
                        <input class="form-control" type="password" required name="password" value="${edit_admin.password}">
                    </div>
                    <div class="form-group">
                        <label>Họ tên</label>
                        <input class="form-control" type="text" required name="name" value="${edit_admin.name}">
                    </div>

                    <div class="form-group">
                    	<input type="submit" class="btn btn-success" value="Sửa"/>
                    </div>
        
        </div>
        </form>
</body>
</html>
<jsp:include page = "./assets/includes/scripts.jsp" flush = "true" />