<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <jsp:include page = "./assets/includes/header.jsp" flush = "true" />
      <jsp:include page = "./assets/includes/navbar.jsp" flush = "true" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa danh mục</title>
</head>
<body>
<form action="editcategory" method="post">
<div class="modal-body">
<div class="form-group">
<a href="listCategory">Thoát</a>
	<h3>Chỉnh sửa danh mục</h3>
</div>
<div class="form-group">
	<label>ID</label>
	<input class="form-control" type="text" name="id" value="${ctg.id}" readonly></input>
</div>
<div class="form-group">
	<label>Tên danh mục</label>
	<input class="form-control" type="text" name="name" value="${ctg.name_category}"></input>
</div>
<div class="form-group">
	
	<input class="btn-edit" type="submit" name="name" value="Sửa"></input>
</div>
</div>
</form>
</body>
</html>