<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.orders.model.*" %>
<%
	OrdersVO ordersVO = (OrdersVO) request.getAttribute("ordersVO");
	heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)session.getAttribute("account");
	String mem_Id = account.getMem_Id();
%>

<!DOCTYPE html>
<html>
<head>
<title>Checkout.jsp</title>
<%-- <link rel='stylesheet' href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/> --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css" />
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Checkout.css" /> --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/sweetalert.css" />
<script src="<%=request.getContextPath()%>/front-end/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/front-end/js/sweetalert.min.js"></script> 	
<script src="<%=request.getContextPath()%>/front-end/js/address.js"></script>
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
	    background-color: #4c94c1;
	    color: white;
	    padding: 14px 20px;
	    margin: 8px 0;
	    border: none;
	    border-radius: 4px;
	    cursor: pointer;
	}
	input[type=button]:hover {
	    background-color: #194f80;
	}
		.button {
	    background-color: #4CAF50; /* Green */
	    border: none;
	    color: white;
	    padding: 16px 32px;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    font-size: 16px;
	    margin: 4px 2px;
	    -webkit-transition-duration: 0.4s; /* Safari */
	    transition-duration: 0.4s;
	    cursor: pointer;
	    border-radius: 10px;
	}
	
	
	.button {
	    background-color: white; 
	    color: black; 
	    border: 2px solid #008CBA;
	}
	
	.button:hover {
	    background-color: #008CBA;
	    color: white;
	}
</style>
</head>
<body onload ="init_address();">
<div id="layout">
	<div id="header">
	    <div id="logo"><a href="<%=request.getContextPath() %>/front-end/homepage/index.jsp"><img src="<%=request.getContextPath()%>/front-end/images/1.png" alt="" /></a>
		</div><!-- End div_logo-->
<!--     	<div class="member_login"> -->
<!--       		<div class="login_box"> -->
<!--         	<form action="" method="get"> -->
<!--           		<fieldset> -->
<!--           		<div class="column_1"> -->
<!--             		<label>username :</label> -->
<!--             		<label>password :</label> -->
<!--           		</div>End div_column_1 -->
<!-- 				<div class="column_2"> -->
<!-- 		            <input type="text1" name="" value="" /> -->
<!-- 		            <input type="text1" name="" value="" /> -->
<!-- 				</div>End div_column_2 -->
<!--           		<div class="column_3"> -->
<%--             		<input type="image" src="<%=request.getContextPath()%>/front-end/images/login_btn.gif" class="login"/> --%>
<!--           		</div>End div_column_3 -->
<!--           		<div class="column_4"> -->
<!--             		<label class="password"><a href="#">Forgot <br /> -->
<!--            			 password</a></label> -->
<!--           		</div>End div_column_4 -->
<!--           		</fieldset> -->
<!--         	</form> -->
<!--       		</div>End div_login_box -->
<!--     	</div>End div_number_login -->
	</div><!-- End div_header-->
<div id="body_container">
	<div id="body_container_inner">
		<div id="menu">
	        <ul>
	          <li class="first"><a href="<%=request.getContextPath()%>/front-end/product/Shopindex.jsp">home</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/Shop.jsp">Product</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/orders/listMyOrders.jsp">Orders</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/charge/Charge.jsp">Charge</a></li>
	          <li><a class="current">ShoppingCart</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/shopQ&A.jsp">Q&A</a></li>
	        </ul>
      	</div>
		<div class="banner"><a href="#">
			<img src="<%=request.getContextPath()%>/front-end/images/banner_cart.jpg" /></a>
		</div><!-- End div_banner-->
		<div class="container_row">
			<div class="welcomezone"><!-- 內容START-->
			<div class="container">
				<h2>購物清單：</h2><br/>
				<table border="1" width="820" style="border:3px #cdecff dashed;" cellpadding="10" border='1'>
					<tr>
						<td colspan="5" align="center"><font size="4" face="DFKai-sb">購物清單</font></td>
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
					<tr><td colspan="5" align="right" height="50px"><font color="red" size="4" face="DFKai-sb"><b>總金額：$ ${amount}</b></font>
						</td>
					</tr>
				</table>
				<hr style="border: 1px solid" size="1" width="100%">
			</div><!-- End div_container -->
			<div class="product">
				<div class="container">
					<h2>出貨</h2>
					
					<%-- 錯誤表列 --%>
					<c:if test="${not empty errorMsgs}">
							<font color='red'>請修正以下錯誤:
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
										<li>${message}</li>
									</c:forEach>
								</ul>
							</font>
					</c:if>

					<form METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/orders/orders.do" name="orders">
						<div>
							<input type="hidden" name="mem_id" size="45"
							value="<%=mem_Id %>"/>
						</div>			
						<div>姓名：
							<input type="TEXT" name="orders_receiver" size="45"
							value="<%=(ordersVO == null) ? "": ordersVO.getOrders_receiver()%>"/>
						</div>
						<div>地址：
							<input type="text" id="zipcode"  name="post_no"  class="form-control" style="width: 70px;">  <!-- 郵遞區號 -->
							<select id="zone1" name="post_adp_city" class="form-control" style="width: 200px;"></select>  <!-- 縣市 -->
							<select id="zone2" name="post_town" class="form-control" style="width: 200px;"></select>  <!-- 鄉鎮市區 -->
							<input type="text" name="post_road" placeholder="請輸入地址" class="form-control" style="width: 285px;"><P>   <!-- 地址 -->
						</div>
						<div>電話號碼：
							<input type="TEXT" name="orders_phone" size="45"
							value="<%=(ordersVO == null) ? "" : ordersVO.getOrders_phone()%>"/>
						</div>
						<div>付款方式：
							<select name="collect_mode_no">
								<option value="<%=(ordersVO == null) ? "1" :ordersVO.getCollect_mode_no()%>">VISA</option>
								<option value="<%=(ordersVO == null) ? "2" :ordersVO.getCollect_mode_no()%>">ATM</option>						
							</select>
						</div>
						<div>
					 		<input type="hidden" name="orders_date" value="<%=new java.sql.Date(System.currentTimeMillis())%>">
						</div>
						<div>
					 		<input type="hidden" name="orders_ship_date" value="<%=new java.sql.Date(System.currentTimeMillis())%>">
						</div>
						<div>
							<input type="hidden" name="orders_total" value="${amount}">	
						</div>
						<div>
							<input type="hidden" name="orders_status" value="1">
						</div>
						<div>信用卡號：
							<input type="TEXT" name="orders_credit" size="45"
							value="<%=(ordersVO == null) ? "" : ordersVO.getOrders_credit()%>"/>
						</div>
						<div>
							<input type="hidden" name="action" value="insertNewOrd">
						</div>
						
						<!-- 假資料 -->
						<div>信用卡到期日：
							<input type="text" name="aaa" size="45" placeholder="請輸入年+月ex:10612">
						</div>
						<div>卡片背面三碼：
							<input type="text" name="bbb" size="45">
						</div>
						<div>
							<button class="button" style="font-size:24px; font-family:微軟正黑體;">送出</button>
							
						</div>
						<img src="<%=request.getContextPath()%>/front-end/images/dog.png" width="20" onClick="magical()">
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
</div><!-- End layout-->
</body>
</html>
<script>
	function magical(){
		orders.orders_receiver.value="吳小志";
 		orders.post_road.value="忠孝西路1段49號";
 		orders.orders_phone.value="0912-345678";
 		orders.orders_credit.value="0000000014523785";
 		orders.aaa.value="10712";
 		orders.bbb.value="bbb";
	}
</script>