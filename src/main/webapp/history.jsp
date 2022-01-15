<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="assets/css/history.css">
<head>
<title>Lịch sử mua hàng</title>
</head>
<body>
<jsp:include page = "include/header.jsp" flush = "true" />	
<div class="container" style="margin-top:5%">
    <div class="row">
        <div class="col-xl-12">
            <div class="card">
                <div class="card-body">
                    <h5 class="header-title pb-3 mt-0">Lịch sử mua hàng</h5>
                    <div class="table-responsive">
                        <table class="table table-hover mb-0">
                            <thead>
                                <tr class="align-self-center">
                                    <th>Mã hóa đơn</th>
                                    <th>Tổng tiền</th>
                                    <th>Trạng thái đơn hàng</th>
                                    <th>Thời gian đặt hàng</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${historyList }" var="x">
                                <tr>
                                    <td>HD${x.id }</td>	
                                    
                                    <td>${x.amount }</td>
                                    <c:if test="${x.status == 1}">
                                    	<td><span class="badge badge-boxed badge-success">Thành công</span></td>
                                    </c:if>
                                    <c:if test="${x.status == 0}">
                                    	<td><span class="badge badge-boxed badge-warning">Chưa thành công</span></td>
                                    </c:if>
                                    <td>${x.created }</td>

                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

    


 


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>