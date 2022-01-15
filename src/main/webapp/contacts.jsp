<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="JDBC.DBConnect"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                                        	<%
											String err = "";
											if (request.getAttribute("err") != null) {
												err = (String) request.getAttribute("err");
											}
											String success = "";
											if (request.getAttribute("success") != null) {
												success = (String) request.getAttribute("success");
											}
										%>
<!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Contact</title>
     <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
     <link rel="stylesheet" href="style.css">
 </head>
 <body>
      <jsp:include page = "include/header.jsp" flush = "true" />	
 <section style="margin-top:6%">
   <div class="container">
     <div class="containerinfo">
       <div>
         <h2>Thông tin liên hệ</h2>

       </div>
       <ul class="sci">
         <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
         <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
         <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
         <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
         <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
       </ul>
    </div>
    <div class="containerForm">
           <h2>Gửi lời nhắn</h2>
           <form action="${pageContext.request.contextPath}/contacts" method="POST">
           <div class="formBox">
               <div class="inputBox w50">
                   <input type="text" name="name" required>
                   <span>Họ tên</span>
               </div>
               <div class="inputBox w50">
                   <input type="text" name="email" required>
                   <span>Email</span>
               </div>
               <div class="inputBox w100">
                   <input type="text" name="phone" required>
                   <span>Số điện thoại</span>
               </div>
               <div class="inputBox w100">
                   <textarea name="message" required></textarea>
                   <span>Phản hồi tin nhắn</span>
               </div>
               <div class="inputBox w100">
                   <input type="submit" value="Gửi">
               </div>
               <div class ="form-group">
                   <p style="color: red"><%=err%></p>
                   <p style="color: green"><%=success %></p>
               </div>
									
           </div>
           </form>
       </div>
   </div>
</section>

 <style>
 *{
     margin:0;
     padding: 0;
     font-family: 'Roboto', sans-serif;
     box-sizing: border-box;
 }

section .container{
     position: relative;
     min-width: 1100px;
     min-height: 550px;
     display:flex;
     z-index: 100;
 }
 section .container .containerinfo{
     position: absolute;
     top: 40px;
     width: 350px;
     height: calc(100% - 80px);
     background: #0f3959;
     z-index: 1;
     padding: 40px;
     display: flex;
     flex-direction: column;
     justify-content: space-between;
     box-shadow: 0 20px 20px rgba(0,0,0,0.2);
 }
section .container .containerinfo h2{
     color: #fff;
     font-size: 24px;
     margin: 20px 0;
 }
 section .container .containerinfo li{
     position: relative;
     list-style: none;
     display: flex;
     margin: 20px 0;
     cursor: pointer;
     align-items: flex-start;
 }
section .container .containerinfo li span{
     color: #fff;
     margin-left: 10px;
     font-weight: 300;
     opacity: 0.5;
     font-size: 20px;
 }

 section .container .containerinfo li:hover span{
     opacity: 1;
 }
 section .container .containerinfo .sci{
     position: relative;
     display:flex;
 }
section .container .containerinfo .sci li{
     list-style: none;
     margin-right: 15px;
 }
section .container .containerinfo .sci li a{
     text-decoration: none;
     opacity: 0.5;
     color: #fff;
     font-size: 32px;
 }

 section .container .containerinfo .sci li:hover a{
     opacity: 1;
 }
 section .container .containerForm{
     position: absolute;
     padding: 70px 50px;
     background: #fff;
     margin-left: 150px;
     padding-left: 250px;
     width: calc(100% - 150px);
     height: 100%;
     box-shadow: 0 50px 50px rgba(0,0,0,0.5);
 }
section .container .containerForm h2{
     color: #0f3959;
     font-size: 24px;
     font-weight: 500;
 }
section .container .containerForm .formBox{
     position: relative;
     display: flex;
     justify-content: space-between;
     flex-wrap: wrap;
     padding-top: 30px;
 }
section .container .containerForm .formBox .inputBox{
     position: relative;
     margin: 0 0 35px 0;
 }
section .container .containerForm .formBox .inputBox.w50{
     width: 47%;
 }
section .container .containerForm .formBox .inputBox.w100{
     width: 100%;
 }
 section .container .containerForm .formBox .inputBox input,
 section .container .containerForm .formBox .inputBox textarea{
     width: 100%;
     padding: 5px 0;
     resize: none;
     font-size: 18px;
     font-weight: 400;
     color: #333;
     border: none;
     border-bottom: 1px solid #777;
     outline: none;
 }
section .container .containerForm .formBox .inputBox textarea{
     min-height: 120px;
 }
section .container .containerForm .formBox .inputBox input[type="submit"]{
     position: relative;
     cursor: pointer;
     background: #0f3959;
     color: #fff;
     border: none;
     max-width: 150px;
     padding: 12px;
 }
section .container .containerForm .formBox .inputBox input[type="submit"]:hover{
     background:  #ff568c;
 }
 section .container .containerForm .formBox .inputBox span{
     position: absolute;
     left: 0;
     padding: 5px 0;
     font-size: 18px;
     font-weight: 400;
     color: #333;
     transition: 0.5s;
     pointer-events: none;
 }
section .container .containerForm .formBox .inputBox input:focus ~ span,
 section .container .containerForm .formBox .inputBox textarea:focus ~ span,
 section .container .containerForm .formBox .inputBox input:valid ~ span,
 section .container .containerForm .formBox .inputBox textarea:valid ~ span{
     transform: translateY(-20px);
     font-size: 12px;
     font-weight: 400;
     letter-spacing: 1px;
     color: #ff568c
 }
 </style>
 </body>
 </html>