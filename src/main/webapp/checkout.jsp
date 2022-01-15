<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/checkout.css">

<title>Trang thanh toán</title>
</head>
<body>
<jsp:include page = "include/header.jsp" flush = "true" />	


<div class=" container-fluid my-5 " >
    <div class="row justify-content-center " style="margin-top:5%">
        <div class="col-xl-10">
            <div class="card shadow-lg ">
                <c:if test="${sessionScope.username == null }">

                	<p style="margin-left:2%">Bạn phải đăng nhập mới có thể thanh toán giỏ hàng</p>
                	
                </c:if>

                <c:if test="${sessionScope.username != null}">    
                                
                <div class="row mx-auto justify-content-center text-center">
                    <div class="col-12 mt-3 ">
                        <nav aria-label="breadcrumb" class="second ">
                            <ol class="breadcrumb indigo lighten-6 first ">
                                <li class="breadcrumb-item font-weight-bold "><a class="black-text text-uppercase " href="#"><span class="mr-md-3 mr-1">Quay trở lại shop</span></a><i class="fa fa-angle-double-right " aria-hidden="true"></i></li>
                                <li class="breadcrumb-item font-weight-bold"><a class="black-text text-uppercase" href="#"><span class="mr-md-3 mr-1">Giỏ hàng</span></a><i class="fa fa-angle-double-right text-uppercase " aria-hidden="true"></i></li>
                                <li class="breadcrumb-item font-weight-bold"><a class="black-text text-uppercase active-2" href="#"><span class="mr-md-3 mr-1">Thanh toán</span></a></li>
                            </ol>
                        </nav>
                    </div>
                </div>       


                <form method="POST" action="${pageContext.request.contextPath}/checkout">
                <div class="row justify-content-around">
                    <div class="col-md-5">
                        <div class="card border-0">
                            <div class="card-header pb-0">
                                <h2 class="card-title space ">Thanh toán</h2>
                                <p class="card-text text-muted mt-4 space">Chi tiết trang vận chuyển</p>
                                <hr class="my-0">
                            </div>
                            <div class="card-body">
                                <div class="row mt-4">
                                    <div class="col">
                                        <p class="text-muted mb-2">Thông tin vận chuyển</p>
                                        <hr class="mt-0">
                                    </div>
                                </div>
                                <div class="form-group"> <label for="NAME" class="small text-muted mb-1">Email</label> <input type="text" class="form-control form-control-sm" name="email"  placeholder="Email" value="${user.email }"> </div>                              
                                <div class="row no-gutters">
                                    <div class="col-sm-6 pr-sm-2">
                                        <div class="form-group"> <label for="NAME" class="small text-muted mb-1">Địa chỉ</label> <input type="text" class="form-control form-control-sm" name="address" " placeholder="Ghi rõ địa chỉ nhân hàng của bạn"> </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group"> <label for="NAME" class="small text-muted mb-1">Số điện thoại</label> <input type="text" class="form-control form-control-sm" name="phone" placeholder="+84" value="${user.phone }"> </div>
                                        <input type="text" value="${username }" name="username" style="display:none;"/>
                                    </div>
                                </div>
                                <div class="form-group"> <label for="NAME" class="small text-muted mb-1">Lời nhắn</label> <input type="text" class="form-control form-control-sm" name="message"  placeholder="Để lại lời nhắn tại đây"> </div>
                                <div class="row mb-md-5">
                                    <div class="col"> <input type="submit" class="btn btn-lg btn-block " value="Thanh toán"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="card border-0 ">
                            <div class="card-header pb-0">
                                <p class="card-text text-muted mt-md-4 mb-2 space">Giỏ hàng của bạn</p>
                                <hr class="my-2">
                            </div>
                            <div class="card-body pt-0">
                            	<c:forEach items="${listCart }" var="x">
                                <div class="row justify-content-between">
                                    <div class="col-auto col-md-7">
                                        <div class="media flex-column flex-sm-row"> <img class=" img-fluid" src="assets/images/${x.image_link }" width="62" height="62">
                                            <div class="media-body my-auto">
                                                <div class="row ">
                                                    <div class="col-auto" style="margin-left:15%">
                                                        <p class="mb-0"><b>${x.name }</b></p>
                                                        <input type="text" value="${x.id_product }" style="display:none;"  name="id_product"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class=" pl-0 flex-sm-col col-auto my-auto">
                                        <p class="boxed-1">${x.qty }</p>
                                        <input type="text" name="soluong" value="${x.qty }" style="display:none;"/>
                                    </div>
                                    <div class=" pl-0 flex-sm-col col-auto my-auto ">
                                        <p>
	                                        <b>
	                                        	<fmt:formatNumber pattern="#,##0" value="${x.price}" /> VNĐ
	                                        	<input type="text" name="price" value="${x.price}" style="display:none;"/>
	                                        </b>
                                        </p>
                                    </div>
                                </div>
                                <hr class="my-2">
                                </c:forEach>

                                <div class="row ">
                                    <div class="col">
                                        <div class="row justify-content-between">
                                            <div class="col-4">
                                                <p class="mb-1"><b>Tổng tiền sản phẩm</b></p>
                                            </div>
                                            <div class="flex-sm-col col-auto">
                                                <p class="mb-1">
	                                                <b>
	                                                	<fmt:formatNumber pattern="#,##0" value="${sumPrice}" /> VNĐ
	                                                </b>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="row justify-content-between">
                                            <div class="col">
                                                <p class="mb-1"><b>Phí ship</b></p>
                                            </div>
                                            <div class="flex-sm-col col-auto">
                                                <p class="mb-1"><b>30.000 VNĐ</b></p>
                                            </div>
                                        </div>
                                        <div class="row justify-content-between">
                                            <div class="col-4">
                                                <p><b>Tổng tiền</b></p>
                                            </div>
                                            <div class="flex-sm-col col-auto">
                                                <p class="mb-1"><b><fmt:formatNumber pattern="#,##0" value="${tongtien}" /> VNĐ</b></p>
                                                <input type="text" name="sumAmount" value="${tongtien}" style="display:none;"/>
                                            </div>
                                        </div>
                                        <hr class="my-0">
                                        <div class="flex-sm-col col-auto" style="margin-top:5%">
	                                        <c:if test="${not empty success}">
											    <div class="alert alert-success" role="alert">
											                  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
											                  <strong style="margin-top:20px">${success}</strong>
											    </div>
										    </c:if>  
									    </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </form>
                </c:if>
            </div>
        </div>
    </div>
</div>

</body>    
<!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


    <!-- Additional Scripts -->
    <script src="assets/js/custom.js"></script>
    <script src="assets/js/owl.js"></script>
    <script src="assets/js/isotope.js"></script>
    <script src="assets/js/flex-slider.js"></script>
</html>