<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Chi tiết đơn hàng</title>
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
</head>
<body>


         
<!-- Begin Page Content -->
<div class="container-fluid">




<!-- DataTales Example -->
<div class="card shadow mb-4">
  <div class="card-header py-3">

    <h1 class="m-0 font-weight-bold text-primary">Chi tiết đơn hàng </h1>

    

     
  </div>
  <div class="card-body">      
      
    <div class="table-responsive">

                   <h4>Thông tin người nhận</h4>

            
                
               <table  class="table-sm table-bordered" id="dataTable" >
                        <tr>
                        <th>Thông tin</th>
                        <th>Nội dung</th>
                        </tr>
                        <tr>
                            <td>Tên khách hàng</td>
                            <td>${dt.username}</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>${dt.email}</td>
                        </tr>
                        <tr>
                            <td>Số điện thoại</td>
                            <td>${dt.phone}</td>
                        </tr>
                        <tr>
                            <td>Địa chỉ</td>
                            <td>${dt.address}</td>
                        </tr>
                        <tr>
                            <td>Lời nhắn</td>
                            <td>${dt.message}</td>
                        </tr>
                        <tr>
                            <td>Tổng hóa đơn</td>
                            <td>${dt.amount}</td>
                        </tr>
                        <tr>
                            <td>Ngày đặt hàng</td>
                            <td>${dt.created}</td>
                        </tr>
                    </table>
      <hr>   

      <h4>Thông tin người nhận</h4>

                  
      <table class="table table-bordered table-dark" id="dataTable">
        <thead>
          <tr>
            <th class="font-weight-bold text-primary text-center">Tên sản phẩm</th>
           	<th class="font-weight-bold text-primary text-center">Số lượng</th>
           	<th class="font-weight-bold text-primary text-center">Đơn giá</th>

          </tr>
        </thead>
        <tbody>
     
			<c:forEach items="${pro }" var="x">
                <tr>
                    <td>${x.name}</td>
					<td>${x.qty}</td>
                    <td>${x.price}</td>
   
                </tr>
            </c:forEach> 
            <tr>
            	<td>Phí ship</td>
            	<td></td>
            	<td>30000</td>
            </tr>
            <tr>
            	<td colspan="2">Thành tiền</td>
            	<td>${dt.amount }</td>
            </tr>



        </tbody>
      </table>
      </div>
   </div>
</div>
</div>  

</body>
</html>

<jsp:include page = "./assets/includes/scripts.jsp" flush = "true" />