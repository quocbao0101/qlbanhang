
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
        <form action="${pageContext.request.contextPath}/admin/addproduct" method="POST" enctype="multipart/form-data">
        <div class="modal-body">
					<div>
						<h3>Thêm Sản Phẩm</h3>
					</div>
                    <div class="form-group mb-2">
                        <label>Danh mục</label>
                        <select class="custom-select custom-select-lg mb-3" name="catalog_id">
						  <option selected>Chọn danh mục</option>
						  <c:forEach items="${categoryList}" var="x"> 
						  	<option value="${x.id }">${x.name_category }</option>
						  </c:forEach>
						</select>
                    </div>
                    <div class="form-group mb-2">
                        <label>Tên</label>
                        <input class="form-control" type="text" required name="name" >
                    </div>
                    <div class="form-group mb-2">
                        <label>Giá</label>
                        <input class="form-control" type="text" required name="price"  >
                    </div>

                    <div class="form-group mb-2">
                        <label>Mô tả</label>
                        <input class="form-control" type="text" required name="description"  >
                    </div>
                    
                    
                    
							                    
                    <div class="form-group mb-2" ">
	                    <label>Hình ảnh</label>
					    <input type="file" name="file" size="60" class="form-control"/> 
                    </div>
                    <div class="form-group mb-2">
                        <label>Số lượng</label>
                        <input class="form-control" type="text" required name="quantity">
                    </div>
                    <div class="form-group mb-2">
                    	<input type="submit" class="btn btn-add" value="Thêm sản phẩm"/>
                    </div>
        
        </div>
        </form>
</body>
</html>
<jsp:include page = "./assets/includes/scripts.jsp" flush = "true" />