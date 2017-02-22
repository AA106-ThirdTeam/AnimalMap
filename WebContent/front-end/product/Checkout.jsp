<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Checkout.jsp</title>
<%-- <link rel='stylesheet' href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/> --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css" />
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Checkout.css" /> --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/sweetalert.css" />
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sweetalert.min.js"></script> 	
<script src="<%=request.getContextPath()%>/resources/js/address.js"></script>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=button] {
    width: 50%;
    background-color: #3096BB;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
input[type=button]:hover {
    background-color: #184B5D;
}
</style>
</head>
<body onload ="init_address();">


<div id="layout">
  <div id="header">
    <div id="logo"><a href="#"><img src="<%=request.getContextPath()%>/front-end/images/logo_2.gif" alt="" /></a>
	</div><!-- End div_logo-->
    <div class="member_login">
      <div class="login_box">
        <form action="" method="get">
          <fieldset>
          <div class="column_1">
            <label>username :</label>
            <label>password :</label>
          </div><!-- End div_column_1-->
          <div class="column_2">
            <input type="text1" name="" value="" />
            <input type="text1" name="" value="" />
          </div><!-- End div_column_2-->
          <div class="column_3">
            <input type="image" src="<%=request.getContextPath()%>/front-end/images/login_btn.gif" class="login"/>
          </div><!-- End div_column_3-->
          <div class="column_4">
            <label class="password"><a href="#">Forgot <br />
            password</a></label>
          </div>
          </fieldset>
        </form>
      </div><!-- End div_login_box-->
    </div><!-- End div_number_login-->
  </div><!-- End div_header-->
  <div id="body_container">
    <div id="body_container_inner">
      <div id="menu">
        <ul>
          <li class="first"><a href="index.html">home</a></li>
          <li><a href="<%=request.getContextPath()%>/front-end/product/Shop.jsp">Product</a></li>
          <li><a href="#">Orders</a></li>
          <li><a href="#">Charge</a></li>
          <li><a class="current">ShoppingCart</a></li>
          <li><a href="#">Q&A</a></li>
        </ul>
      </div>
      <div class="banner"><a href="#">
		  <img src="<%=request.getContextPath()%>/front-end/images/banner_Ani.gif" /></a>
		</div><!-- End div_banner-->
      <div class="container_row">
        <div class="welcomezone"><!-- 內容START-->
			<div class="container">
		<h2>購物清單：</h2>
		<br>
			<table border="1" width="820" style="border:3px #cdecff dashed;" cellpadding="10" border='1'>
				<tr>
				<td colspan="5" align="center">購物清單</td>
				</tr>
				<tr>
				<td width="30">#</td>
				<td>商品編號</td>
				<td>商品名稱</td>
				<td>價格</td>
				<td>數量</td>
				</tr>
				<c:forEach var="cartVO" items="${shoppingcart}" varStatus="s">
					<tr>
						<td width="30"><div><b>${s.count}</b></div></td>
						<td><div align="left"><b>${cartVO.product_no}</b></div></td>
						<td><div align="left"><b>${cartVO.product_name}</b></div></td>
						<td><div align="left"><b>${cartVO.product_price}</b></div></td>
						<td><div align="left"><b>${cartVO.quantity}</b></div></td>
					</tr>
				</c:forEach>
				<tr><td colspan="5" align="right" height="50px"><font color="red" size="2" face="DFKai-sb"><b>總金額：$ ${amount}</b></font></td></tr>
			</table>
		
		
			<hr style="border: 1px solid" size="1" width="100%">
	</div>
			<div class="product">
		<div class="container">
			<h2>出貨資料：</h2>
			<br>
			<form method="post" class="form-horizontal" id="myForm" name="myForm" action="<%=request.getContextPath()%>/ord/ord.do">
				<label for="fname">收件人</label>
				<input type="text" id="fname" name="firstname" placeholder="Your name..">

    			<label for="country">地址</label>
  				 <div class="form-group">
					<div class="col-sm-10">
                         <select id="zone1" name="zone1" class="form-control" style="width: 150px;"></select>  <!-- 縣市 -->
                         <select id="zone2" name="zone2" class="form-control" style="width: 150px;"></select>  <!-- 鄉鎮市區 -->
                         <input type="text" id="zipcode"  name="zipcode"  class="form-control" style="width: 100px;">  <!-- 郵遞區號 -->
                         <input type="text" name="subaddress" placeholder="請輸入地址" class="form-control" style="width: 395px;"><P>   <!-- 地址 -->
					</div>
				</div>
    			<label for="lname">電話</label>
    			<input type="text" id="lname" name="lastname" placeholder="Your phone num...">
    			
    			<label for="country">PAY</label>
			    <select id="country" name="country">
				      <option value="1">ATM繳費</option>
				      <option value="2">VISA</option>
				      <option value="3">銀行匯款</option>
			    </select>
			    <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
					     <button type="button" onclick="getMemberData()" id="mbutton" class="btn btn-success">導入會員資料</button>
				         <input type="button" class="order" onclick="return check(document.myForm)" value="送出訂單" style="display: inline-block;">
	                </div>
				</div>
				<input type="hidden" name="orders_date" value="<%=new java.sql.Date(System.currentTimeMillis())%>">
				<input type="hidden" name="mem_Id" value="${memberVO.mem_no}">
				
				<%-- 			    <input type="hidden" name="ord_date" value="<%=new java.sql.Date(System.currentTimeMillis())%>"> --%>
<%-- 			    <input type="hidden" name="mem_no" value="${memberVO.mem_no}"> --%>
<%-- 			    <input type="hidden" name="ord_total" value="${amount}">	 --%>
<!-- 			    <input type="hidden" name="rec_zip" id="rec_zip" value=""> -->
<!-- 			    <input type="hidden" name="rec_address" id="rec_address" value=""> -->
<!-- 			    <input type="hidden" name="action" value="insertNewOrd"> -->
			
<%-- 			     <c:forEach var="cartVO" items="${shoppingcart}" varStatus="s"> --%>
<%-- 			        <input type="hidden" name="product_no" value="${cartVO.product_no}">	 --%>
<%-- 			        <input type="hidden" name="quantity" value="${cartVO.quantity}">	 --%>
<%-- 			     </c:forEach>	 --%>
				

				
				
				
				
				
				
			</form>
		</div>
	</div>
      </div>
      <div id="footer">
        <div class="footer_link">
        <ul style="color:#FFf;">
          <p>SSSSSSSSSSSSSS</p>
          </ul>
        </div><!-- End div_footer_link-->
      </div><!-- End div_footer-->
    </div><!-- End div_container_row-->
  </div><!-- End div_body_container_inner-->
</div><!-- End div_body_container-->
</body>
</html>