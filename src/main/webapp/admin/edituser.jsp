<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <jsp:include page = "./assets/includes/header.jsp" flush = "true" />
      <jsp:include page = "./assets/includes/navbar.jsp" flush = "true" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa user</title>
</head>
<body>
<form action="edituser" method="post">
<div class="modal-body">
<div class="form-group">
<a href="listuser">Thoát</a>
	<h3>Chỉnh sửa user</h3>
</div>
<div class="form-group">
	<label>ID</label>
	<input class="form-control" type="text" name="id" value="${ctg.id}" readonly></input>
</div>
<div class="form-group">
	<label>Username</label>
	<input class="form-control" type="text" name="user" value="${ctg.username}" readonly></input>
</div>
<div class="form-group">
	<label>Tên</label>
	<input class="form-control" type="text" name="ten" value="${ctg.name}"></input>
</div>
<div class="form-group">
	<label>Email</label>
	<input class="form-control" type="text" name="email" value="${ctg.email}"></input>
</div>
<div class="form-group">
	<label>Phone</label>
	<input class="form-control" type="text" name="phone" value="${ctg.phone}"></input>
</div>

<div class="form-group">
	<label>Password</label>
	<input class="form-control" type="text" name="password" value="${ctg.password}"></input>
</div>
<div class="form-group">
	
	<input class="btn-edit" type="submit" name="name" value="Sửa"></input>
</div>
</div>
</form>
</body>
</html>