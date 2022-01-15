<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
    <link rel="stylesheet" href="assets/css/main.css">	

<jsp:include page = "include/header.jsp" flush = "true" />

<div class="container-fluid">
    <div class="row">
        <aside class="col-lg-9">
            <div class="card">
                <div class="table-responsive">
                    <table class="table table-borderless table-shopping-cart">
                       	<c:if test="${sessionScope.username == null}">   
							<p>Bạn phải đăng nhập mới có thể xem giỏ hàng</p>
                        </c:if>                      
                    	<c:if test="${sessionScope.username != null}">
                    			<c:if test="${not empty err}">
								    <div class="alert alert-${alert}" role="alert">
								                  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								                  <strong style="margin-top:20px">${err}</strong>
								    </div>
							    </c:if>
							    <c:if test="${not empty success}">
								    <div class="alert alert-${alert}" role="alert">
								                  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								                  <strong style="margin-top:20px">${success}</strong>
								    </div>
							    </c:if>  
                        <thead class="text-muted">
                            <tr class="small text-uppercase">
                                <th scope="col">Sản phẩm</th>
                                <th scope="col" width="120">Số lượng</th>
                                <th scope="col" width="120">Giá tiền</th>
                                <th scope="col" class="text-right d-none d-md-block" width="200"></th>
                            </tr>
                        </thead>
                        <tbody>
							<c:forEach items="${listCart}" var="x">
							<form action="${pageContext.request.contextPath}/update-cart" method="POST">	
                            <tr>        	                                    
		                                <td>
		                                    <figure class="itemside align-items-center">
		                                        <div class="aside"><img src="assets/images/${x.image_link }" class="img-sm"></div>
		                                        <figcaption class="info"> 
		                                        	<a href="#" class="title text-dark" data-abc="true">${x.name }</a>
		                                        </figcaption>
		                                    </figure>
		                                </td>
		                                <td><input class="form-control" type="text" name="qty" value="${x.qty }"/></td>
		                                <td>
		                                    <div class="price-wrap"> <var class="price" >${x.price }</var> <small class="text-muted">VNĐ</small> </div>
		                                </td>
										<td><input style="display:none" type="text" name="id" value="${x.id_product }"/></td>
		                                <td class="text-right d-none d-md-block">  <a href=""  class="btn btn-danger btn-round" onclick="showMess(${x.id_product})" data-abc="true">Xóa</a> </td>
		                                <td ><input type="submit"  class="btn btn-success btn-round" value="Cập nhật giỏ hàng"/></td>	                                      	
                            </tr>  
                            </form>                           
		                    </c:forEach> 



                        </tbody>
                        
                        </c:if>
                    </table>
                </div>
            </div>
        </aside>
              <script>
	      	function showMess (id){
	      		var option = confirm('Bạn có chắc muốn xóa sản phẩm này?');
	      		if(option === true){
	      			window.location.href ='${pageContext.request.contextPath}/deletecart?id='+id;
	      		}
	      	}
     	 </script>
        <aside class="col-lg-3">

            <div class="card">
                <div class="card-body">
                    <dl class="dlist-align">
                        <dt>Tổng tiền:</dt>
                        <dd class="text-right ml-3"><fmt:formatNumber pattern="#,##0" value="${sumPrice}" /> VNĐ</dd>
                    </dl>

                    <hr> 
	                    <a href="${pageContext.request.contextPath}/checkout" class="btn btn-primary btn-square btn-main mt-2" data-abc="true"> Thanh toán </a> 
	                    <a href="${pageContext.request.contextPath}/product" class="btn btn-success btn-square btn-main mt-2" data-abc="true">Tiếp tục mua hàng</a>
                </div>
            </div>
        </aside>
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