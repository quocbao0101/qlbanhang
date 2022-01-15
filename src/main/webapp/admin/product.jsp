
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
<div class="container-fluid">







<div class="container-fluid">

<!-- DataTales Example -->
<div class="card shadow mb-4">
  <div class="card-header py-3">

    <h1 class="m-0 font-weight-bold text-primary">Quản Lý Sản Phẩm </h1>

    

    <a class="btn btn-primary" href="addproduct" style="float: right;">
              Thêm mới sản phẩm
            </a>

     
  </div>
  <div class="card-body">      
      
    <div class="table-responsive">

      <table class="table table-bordered" id="dataTable">
        <thead>
          <tr>
            <th class="font-weight-bold text-primary text-center">ID</th>
            <th class="font-weight-bold text-primary text-center">Danh mục</th>
            <th class="font-weight-bold text-primary text-center">Tên sản phẩm</th>
            <th class="font-weight-bold text-primary text-center">Số lượng</th>            
            <th class="font-weight-bold text-primary text-center">Giá</th>
            <th class="font-weight-bold text-primary text-center">Trạng thái</th>
            <th class="font-weight-bold text-primary text-center">Mô tả</th>
            <th class="font-weight-bold text-primary text-center">Hình ảnh</th>
            <th class="font-weight-bold text-primary text-center">Thời gian tạo</th>
          </tr>
        </thead>
        <tbody>
        
     
			<c:forEach items="${productlist}" var="product"> 
                <tr>
                    <td>${product.id}</td>
                    <td>${product.catalog_id}</td>
                    <td>${product.name}</td>
                    <td>${product.quantity}</td>
                    <td>${product.price}</td>
					<td>${product.status}</td>
					<td>${product.description}</td>
					<td>${product.image_link}</td>
					<td>${product.created }</td>
					
                    <td class="text-center">
                        <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/product-edit?id=${product.id}">Sửa</a>
                    </td>
                    <td >
                       <a class="btn btn-delete" href="${pageContext.request.contextPath}/admin/product/delete?id=${product.id}">Xóa</a>
                    </td>
                </tr>
			</c:forEach> 

        </tbody>
      </table>

        <div style="margin-left: 50%;">
                <div class="pagination">
                    <ul class="pagination font-weight-bold text-primary">
						<li class='page-item'><a  class='page-link' href=''>1</a></li>
                    </ul>
                </div>
        </div>
    </div>
    <jsp:include page = "./assets/includes/scripts.jsp" flush = "true" />