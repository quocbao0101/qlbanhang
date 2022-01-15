<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <jsp:include page = "include/header.jsp" flush = "true" />

    <!-- Page Content -->
    <!-- Items Starts Here -->
    <div class="featured-page">
      <div class="container">
        <div class="row">
          <div class="col-md-4 col-sm-12">
            <div class="section-heading">
              <div class="line-dec"></div>
              <h1>Sản phẩm</h1>
              	<form action="${pageContext.request.contextPath}/search" method="POST">
				<div class="input-group">
				  <div class="form-outline">
				    <input type="text" id="form1" class="form-control" name="search" placeholder="Tên sản phẩm"/>
				  </div>
				  <input type="submit" value="Tìm kiếm" class="btn btn-primary"/>
				</div>
				</form>
            </div>
          </div>
          <div class="col-md-8 col-sm-12">
            <div id="filters" class="button-group">   
              <c:forEach items="${categoryList}" var="y">      
              	<a class="btn btn-primary" href="${pageContext.request.contextPath}/product-id?id=${y.id}">${y.name_category}</a>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>

    <c:if test="${not empty err}">
    <div class="alert alert-${alert}" role="alert">
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <strong style="margin-left: 21%;margin-top:20px">${err}</strong>
    </div>
    </c:if>
    <c:if test="${not empty success}">
    <div class="alert alert-${alert}" role="alert">
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <strong style="margin-left: 21%;margin-top:20px">${success}</strong>
    </div>
    </c:if>



    <div class="featured container no-gutter">
        <div class="row posts">
   			<c:forEach items="${productList}" var="x">  
   			<form action="${pageContext.request.contextPath}/add-to-cart" method="POST">
	            <div  class="item new col-md-4">
	              <a href="${pageContext.request.contextPath}/single-product?product=${x.id}">
	                <div class="featured-item">
	                  <img src="assets/images/${x.image_link}" alt="" style="height:308px;weight:308px"/>
	                  <h4>${x.name}</h4>
	                  <h6><fmt:formatNumber pattern="#,##0" value="${x.price}" /> VNĐ</h6>
	                  <input type="text" value="${x.id}" name="id" style="display:none;" />
	                  <input type="text" value="${x.quantity}" name="qty" style="display:none;" />
	                  <input type="text" value="${x.price}" name="product_price" style="display:none;"/>
	                  <input type="text" name="user" style="display:none" value="<%= session.getAttribute("username") %>" />
					  <input style="margin-left:150px" type="submit" class="btn btn-success" value="Thêm vào giỏ hàng"/>
	                </div>
	              </a>
	            </div>
            </form>
            </c:forEach> 

         </div>    
    </div>









    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


    <!-- Additional Scripts -->
    <script src="assets/js/custom.js"></script>
    <script src="assets/js/owl.js"></script>
    <script src="assets/js/isotope.js"></script>


    <script type="text/javascript">
      window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);
</script>


</html>