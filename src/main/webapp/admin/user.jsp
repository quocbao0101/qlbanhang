
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma" , "no-cache");
  response.setHeader("Expires" , "0");
  
  
  if (session.getAttribute("admin_username") == null){
	  response.sendRedirect(request.getContextPath() + "/admin/login"); 
  }
  %>
      <jsp:include page = "./assets/includes/header.jsp" flush = "true" />
      <jsp:include page = "./assets/includes/navbar.jsp" flush = "true" />
<!-- Begin Page Content -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>



<div class="container-fluid">

<!-- DataTales Example -->

<div class="card shadow mb-4">
  <div class="card-header py-3">

    <h1 class="m-0 font-weight-bold text-primary">Quản Lý User </h1>

    

   <a href="adduser.jsp">Thêm user</a>

     
  </div>
  <div class="card-body">

    <div class="table-responsive">

      <table class="table table-bordered" id="dataTable">
        <thead>
          <tr>
            <th class="font-weight-bold text-primary text-center">ID</th>
          
            <th class="font-weight-bold text-primary text-center">Họ tên</th>
           	<th class="font-weight-bold text-primary text-center">Email</th>
           	<th class="font-weight-bold text-primary text-center">Số điện thoại</th>
           	<th class="font-weight-bold text-primary text-center">Tài khoản</th>
           	<th class="font-weight-bold text-primary text-center">Mật khẩu</th>
           	<th class="font-weight-bold text-primary text-center">Created</th>
           	<th class="font-weight-bold text-primary text-center">Hành động</th>
          </tr>
        </thead>
        <tbody>
     
			<c:forEach items="${userList}" var="x"> 
               <tr>
                    <td>${x.id}</td>
                    <td>${x.name}</td>
                    <td>${x.email}</td>
                    <td>${x.phone}</td>
                    <td>${x.username}</td>
                    <td>${x.password}</td>
                    <td>${x.created}</td>
                    <td class="text-center">
                        <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/edituser?id=${x.id}">Sửa</a>
                    </td>
                    <td >
                       <a class="btn btn-info" href="#" onclick="showMess(${x.id})">Xóa</a>
                    </td>
                </tr>
			</c:forEach> 

        </tbody>
      </table>
      <script>
      	function showMess (id){
      		var option = confirm('Bạn có chắc muốn xóa danh mục này?');
      		if(option === true){
      			window.location.href ='${pageContext.request.contextPath}/admin/deleteuser?id='+id;
      		}
      	}
      </script>

        <div style="margin-left: 50%;">
                <div class="pagination">
                    <ul class="pagination font-weight-bold text-primary">
						<li class='page-item'><a  class='page-link' href=''>1</a></li>
                    </ul>
                </div>
        </div>
    </div>
  </div>
</div>

</div>
<jsp:include page = "./assets/includes/scripts.jsp" flush = "true" />