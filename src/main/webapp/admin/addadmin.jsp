<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
                                    	<%
											String err = "";
											if (request.getAttribute("err") != null) {
												err = (String) request.getAttribute("err");
											}
											String success = "";
											if (request.getAttribute("success") != null) {
												success = (String) request.getAttribute("success");
											}
											  if (session.getAttribute("admin_username") == null){
												  response.sendRedirect(request.getContextPath() + "/admin/login"); 
											  }
											  %>
      <jsp:include page = "./assets/includes/header.jsp" flush = "true" />
      <jsp:include page = "./assets/includes/navbar.jsp" flush = "true" />
</head>
<body>
        <form action="${pageContext.request.contextPath}/admin/addadmin" method="POST">
        <div class="modal-body">
					<div>
						<h3>Thêm admin</h3>
					</div>
                    <div class="form-group mb-2">
                        <label>Tài khoản</label>
                        <input class="form-control" type="text" required name="username">
                    </div>
                    <div class="form-group mb-2">
                        <label>Mật khẩu</label>
                        <input class="form-control" type="password" required name="password">
                    </div>
                    <div class="form-group mb-2">
                        <label>Họ tên</label>
                        <input class="form-control" type="text" required name="name">
                    </div>
                    <div class ="form-group mb-2">
                                    	<p style="color: red"><%=err%></p>
                    </div>
                    <div class ="form-group mb-2">
                         <p style="color: green"><%=success%></p>
                    </div>
                    <div class="form-group mb-2">
                    	<input type="submit" class="btn btn-success" value="Thêm tài khoản"/>
                    </div>
        
        </div>
        </form>
</body>
</html>
<jsp:include page = "./assets/includes/scripts.jsp" flush = "true" />