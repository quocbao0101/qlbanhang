
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

    <h1 class="m-0 font-weight-bold text-primary">Quản Lý Đơn Hàng </h1>

    



     
  </div>
  <div class="card-body">

    <div class="table-responsive">

      <table class="table table-bordered" id="dataTable">
        <thead>
          <tr>    
            <th class="font-weight-bold text-primary text-center">Đơn hàng</th>
           	<th class="font-weight-bold text-primary text-center">Tên khách hàng</th>
           	<th class="font-weight-bold text-primary text-center">Địa chỉ</th>
            <th class="font-weight-bold text-primary text-center">Ngày</th>
            <th class="font-weight-bold text-primary text-center">Tình trạng</th>
           	<th class="font-weight-bold text-primary text-center">Action</th>
          </tr>
        </thead>
        <tbody>
     
			<c:forEach items="${listS}" var="x"> 
                <tr>
                    <td class="text-center">HĐ${x.id }</td>
					<td class="text-center">${x.username}</td>	
					<td class="text-center">${x.address}</td>								
					<td class="text-center">${x.created}</td>
					<th class="text-center">
						<c:if test="${x.status == 1 }">
							<p style="color:green">Đã xác nhận đơn hàng</p>
						</c:if>
						<c:if test="${x.status == 0 }">
							<p style="color:red">Chưa xác nhận đơn hàng</p>
						</c:if>
					</th>
                    <td class="text-center">
                        <a class="btn btn-info" href="details?id=${x.id}">Xem chi tiết</a>
                        <c:if test="${x.status == 1 }">
							<a class="btn btn-danger" href="order-id?id=${x.id }">Hủy đơn hàng</a>     
						</c:if>
						<c:if test="${x.status == 0 }">
							<a class="btn btn-success" href="order?id=${x.id }">Xác nhận đơn hàng</a>     
						</c:if>                 
                    </td>
                </tr>
			</c:forEach> 

        </tbody>
      </table>

    </div>
  </div>
</div>

</div>
 
<jsp:include page = "./assets/includes/scripts.jsp" flush = "true" />