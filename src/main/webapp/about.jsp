<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<jsp:include page = "include/header.jsp" flush = "true" />
    <div class="banner">

    </div>
<head>
<meta charset="UTF-8">
</head>
<body>
<div class="about-section">
  <h1>About us</h1>
  <p>Cùng nhau đi qua quãng thời gian khó khăn ban đầu. Tìm đề tài, tìm hiểu công nghệ, cho đến phân chia công việc.</p>
  <p>Mặc dù chưa hoàn hảo nhưng trang web này rất có ý nghĩa trải nghiệm với nhóm chúng tôi.
 Kết quả ngày hôm nay là do sự chỉ dẫn nhiệt tình của nhóm trưởng, cũng như sự cố gắng của các thành viên trong nhóm.</p>
  <p>Xin cảm ơn!</p>
</div>

<h2 style="text-align:center">THÀNH VIÊN NHÓM</h2>
<table style="margin-left:18%">
<tr>
<td>

    <div class="column">
    <div class="card">
      <img src="https://scontent.fsgn2-4.fna.fbcdn.net/v/t39.30808-6/266254999_3010654565917336_5734765293531113042_n.jpg?_nc_cat=109&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=JD20Agd95DAAX9pCJTl&_nc_ht=scontent.fsgn2-4.fna&oh=00_AT9cHlR5E8jT0XVrY6QfKn-KXhZimBHFOvsDPsbMq2WdXg&oe=61E42704" alt="Bảo" style="width:100%">
      <div class="container">
        <h4>Trần Quốc Bảo</h4>
        <p class="title">Trưởng nhóm</p>
        <p>Là một nhóm trưởng có trách nhiệm với công việc.</p>
        <p>gmail: binspike@gmail.com</p>
        <a href="https://www.facebook.com/bin.spike.35"><button class="button">Contact</button></a>
      </div>
    </div>
  </div>
</td>
<td>
  <div class="column">
    <div class="card">
      <img src="https://scontent.fdad8-1.fna.fbcdn.net/v/t1.6435-9/175159450_1174024773043213_4562901374972186104_n.jpg?_nc_cat=109&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=2esb7zj5sK0AX_HFG0q&_nc_oc=AQnKy_zlwK014j4E_c_tZ9cPwVjE072Zr44KyqqOofNXMaK0iL2h5XQwoTx1JJuWk_wf7loSjBvbyMPV7jGXLuZ0&tn=nEDHOCzw6R4gDYhz&_nc_ht=scontent.fdad8-1.fna&oh=00_AT8i2ovfPBft6P_LiETm-o2FQXNXpP4LLv_fS1ZRsrysBg&oe=61E04723" alt="Trúc" style="width:100%">
      <div class="container">
        <h4>Bùi Thanh Trúc</h4>
        <p class="title">Thành viên</p>
        <p>Luôn vui vẻ, có tinh thần làm viêc tốt.</p>
        <p>gmail: buithanhtruc12a8@gmail.com</p>
        <a href="https://www.facebook.com/profile.php?id=100013071041510"><button class="button">Contact</button></a>
      </div>
    </div>
  </div>

</td>
<td>
  <div class="column">
    <div class="card">
      <img src="https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg" alt="Phúc" style="width:100%">
      <div class="container">
        <h4>Nguyễn Thanh Phúc</h4>
        <p class="title">Thành viên</p>
        <p>Hòa đồng, luôn giúp đỡ bạn bè.</p>
        <p>gmail: thanhphuc@gmail.com</p>
        <a href="https://www.facebook.com/profile.php?id=100026643276140"><button class="button">Contact</button></a>
      </div>
    </div>
  </div>
</td>
<td>
  <div class="column">
    <div class="card">
      <img src="https://scontent.fdad8-1.fna.fbcdn.net/v/t1.6435-9/129013147_2925965274300667_7359822599972031724_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=0jYjMpMTK-4AX_XDNrD&_nc_ht=scontent.fdad8-1.fna&oh=00_AT9sT8Bx3u3rdTHsmKFcbB1hRcBgvj5q5U8c2JszoWbD1A&oe=61E236A5" alt="Hoàng" style="width:100%">
      <div class="container">
        <h4>Nguyễn Hữu Hoàng</h4>
        <p class="title">Thành viên</p>
        <p>Vui tính, luôn hoạt động sôi nổi.</p>
        <p>gmail: huuhoang@gmail.com</p>
        <a href="https://www.facebook.com/profile.php?id=100006616687197"><button class="button">Contact</button></a>
      </div>
    </div>
  </div>
  </td>
  </tr>
</table>
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


    <!-- Additional Scripts -->
    <script src="assets/js/custom.js"></script>
    <script src="assets/js/owl.js"></script>


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
<style>


html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 300px;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
  height:600px;
}

.about-section {
  padding: 50px;
  text-align: center;
  color: black;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}
</style>
</body>
</html>