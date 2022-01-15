<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <jsp:include page = "./assets/includes/header.jsp" flush = "true" />
      <jsp:include page = "./assets/includes/navbar.jsp" flush = "true" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>thêm danh mục</title>
</head>
<body>




      <div class="modal-header">
      
            
      </div>
		
        <form action="addcategory" method="post">
       		<table>
       		<tr>
       		<td><a href="listCategory">Thoát</a>
        <h2 class="modal-title" id="exampleModalLabel">Thêm danh mục</h2></td>
        </tr>
        <tr>
        	<td>Tên danh mục</td>
        	</tr>
        <tr>
        <td><input type="text" name="name1"></td>
      </tr>
      <tr>
        <td><input type="submit" name="btn_them" class="btn btn-primary" value="Thêm"></td>
			</tr>
        </table>
   </form>
   
</body>

</html>
