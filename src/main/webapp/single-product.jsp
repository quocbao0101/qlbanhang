<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Website ban hang</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="assets/css/flex-slider.css">

  </head>

  <body>
  <jsp:include page = "include/header.jsp" flush = "true" />
    <!-- Single Starts Here -->
    <div class="single-product">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <div class="line-dec"></div>
              <h1>Chi tiết sản phẩm</h1>
            </div>
          </div>
          <div class="col-md-6">
            <div class="product-slider">
              <div id="slider" class="flexslider">
                <ul class="slides">
                  <li>
                    <img src="assets/images/${product1.image_link }" />
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="right-content">
              <h4>${product1.name}</h4>
              <h6><fmt:formatNumber pattern="#,##0" value="${product1.price}" /> VNĐ</h6>
              <p>Chi tiết sản phẩm. </p>
              <span>
	              <c:choose>
				    <c:when test="${product1.quantity=='0'}">
	              		Hết hàng
				    </c:when>    
				    <c:otherwise>
						${product1.quantity} sản phẩm có sẵn
				    </c:otherwise>
				 </c:choose>
			 </span>
              <p>${product1.description}</p>
              <form action="${pageContext.request.contextPath}/single-product" method="POST">
                <label for="quantity">Số lượng:</label>
                <input name="quantity" type="quantity" class="quantity-text" id="quantity" 
                	onfocus="if(this.value == '1') { this.value = ''; }" 
                    onBlur="if(this.value == '') { this.value = '1';}"
                    value="1">
                <input type="text" value="${product1.price}" name="product_price" style="display:none;"/>
                <input name="id_product" value="${product1.id}" style="display:none;"/>
                <input name="qty" value="${product1.quantity}" style="display:none;"/>
                <input type="text" name="user" style="display:none" value="<%= session.getAttribute("username") %>" />
                <input type="submit" class="button" value="Thêm vào giỏ hàng!">
              </form>
              <div class="down-content">
                <div class="categories">
                  <h6>Danh mục: <span><a href="#">${product1.name_category }</a></span></h6>
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
      </div>
    </div>
    <!-- Single Page Ends Here -->




    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


    <!-- Additional Scripts -->
    <script src="assets/js/custom.js"></script>
    <script src="assets/js/owl.js"></script>
    <script src="assets/js/isotope.js"></script>
    <script src="assets/js/flex-slider.js"></script>


    <script language = "text/Javascript"> 
      cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
      function clearField(t){                   //declaring the array outside of the
      if(! cleared[t.id]){                      // function makes it static and global
          cleared[t.id] = 1;  // you could use true and false, but that's more typing
          t.value='';         // with more chance of typos
          t.style.color='#fff';
          }
      }
    </script>


  </body>

</html>
