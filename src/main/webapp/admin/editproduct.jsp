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
        <form action="${pageContext.request.contextPath}/admin/product-edit" method="POST">
        <div class="modal-body">
        			<div class ="form-group">
        				<h3>Sửa sản phẩm Admin</h3>
        			</div>
        			<div class="form-group">
                        <input style="display:none" class="form-control" type="text" required name="id_product" value="${products.id }" >
                    </div>
                    <div class="form-group">
                        <label>Danh mục</label>
                        <input class="form-control" type="text" required name="catalog_id" value="${products.catalog_id}">
                    </div>
                   <div class="form-group">
                        <label>Tên sản phẩm</label>
                        <input class="form-control" type="text" required name="name" value="${products.name}">
                    </div>
                    <div class="form-group">
                        <label>Giá</label>
                        <input class="form-control" type="text" required name="price" value="${products.price}">
                    </div>
                     
                    <div class="form-group">
                        <label>Trạng thái</label>
                        <input class="form-control" type="text" required name="status" value="${products.status}">
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <input class="form-control" type="text" required name="description" value="${products.description}">
                    </div>
                     <div class="form-group">
                        <label>Hình ảnh</label>
                        <input class="form-control" type="text" required name="image_link" value="${products.image_link}">
                    </div>
                    <div class="form-group">
                        <label>Số lượng</label>
                        <input class="form-control" type="number" required name="quantity" value="${products.quantity}">
                    </div>
                    

                    <div class="form-group">
                    	<input type="submit" class="btn btn-edit" value="Sửa"/>
                    </div>
        
        </div>
        </form>
</body>
</html>
<jsp:include page = "./assets/includes/scripts.jsp" flush = "true" />