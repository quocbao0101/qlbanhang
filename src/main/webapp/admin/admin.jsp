	<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
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

<div class="modal fade">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Thêm tài khoản khách hàng</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>


        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Thoát</button>
            <input type="submit" name="btn_them" class="btn btn-primary" value="Thêm tài khoản">
        </div>
        </form>
    </div>
  </div>
</div>





<div class="container-fluid">

<!-- DataTales Example -->
<div class="card shadow mb-4">
  <div class="card-header py-3">

    <h1 class="m-0 font-weight-bold text-primary">Quản Lý Admin </h1>

    

    <a class="btn btn-primary" href="addadmin.jsp" style="float: right;">
              Thêm mới admin
            </a>

     
  </div>
  <div class="card-body">

    <div class="table-responsive">

      <table class="table table-bordered" id="dataTable">
        <thead>
          <tr>
            <th class="font-weight-bold text-primary text-center">ID</th>
            <th class="font-weight-bold text-primary text-center">Tên đăng nhập</th>
            <th class="font-weight-bold text-primary text-center">Mật khẩu</th>
            <th class="font-weight-bold text-primary text-center">Tên admin</th>
            <th class="font-weight-bold text-primary text-center">Hành động</th>

          </tr>
        </thead>
        <tbody>
     
			<c:forEach items="${adminlist}" var="admin"> 
                <tr>
                    <td>${admin.id}</td>
                    <td>${admin.username}</td>
                    <td>${admin.password}</td>
					<td>${admin.name}</td>
                    <td class="text-center">
                        <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/edit?id=${admin.id}">Sửa</a>
                        <a class="btn btn-info" href="#" onclick="showMess(${admin.id})">Xóa</a>
                    </td>

                </tr>
			</c:forEach> 

        </tbody>
      </table>
      <script>
      	function showMess (id){
      		var option = confirm('Bạn có chắc muốn xóa tài khoản admin này?');
      		if(option === true){
      			window.location.href ='${pageContext.request.contextPath}/admin/delete?id='+id;
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

</div>
  
<jsp:include page = "./assets/includes/scripts.jsp" flush = "true" />