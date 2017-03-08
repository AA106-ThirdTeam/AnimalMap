<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.orders_item.model.*"%>

<jsp:useBean id="ordersSvc" scope="page" class="com.orders.model.OrdersService" />

<!DOCTYPE html>
<html>
<head>
<title>Checkout.jsp</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css" />
<style>
.wrapper {
  text-align: center;
  border-bottom: 3px solid #343436;
  background-color: #333;
}
table{
  margin: auto;
  padding: 10px;
  border-collapse: separate;
  border-spacing: 0;
}
tr{
  border: 1px solid #E0607E;
}
td{

  padding: 10px 20px;
  background-color:#e4edf5;
  color: #000;
}
th{

  padding: 10px 10px;
  background-color:	#d1cbee;
  color: #000;
}
/*第一欄第一列：左上*/
tr:first-child th:first-child{
  border-top-left-radius: 10px;
}
/*第一欄最後列：左下*/
tr:last-child td:first-child{
  border-bottom-left-radius: 10px;
}
/*最後欄第一列：右上*/
tr:first-child th:last-child{
  border-top-right-radius: 10px;
}
/*最後欄第一列：右下*/
tr:last-child td:last-child{
  border-bottom-right-radius: 10px;
}
</style>
</head>
<body>

<div id="layout">
  <div id="header">
    <div id="logo"><a href="<%=request.getContextPath() %>/front-end/homepage/index.jsp"><img src="<%=request.getContextPath()%>/front-end/images/1.png" alt="" /></a>
	</div><!-- End div_logo-->
<!--     <div class="member_login"> -->
<!--       <div class="login_box"> -->
<!--         <form action="" method="get"> -->
<!--           <fieldset> -->
<!--           <div class="column_1"> -->
<!--             <label>username :</label> -->
<!--             <label>password :</label> -->
<!--           </div>End div_column_1 -->
<!--           <div class="column_2"> -->
<!--             <input type="text" name="" value="" /> -->
<!--             <input type="text" name="" value="" /> -->
<!--           </div>End div_column_2 -->
<!--           <div class="column_3"> -->
<%--             <input type="image" src="<%=request.getContextPath()%>/front-end/images/login_btn.gif" class="login"/> --%>
<!--           </div>End div_column_3 -->
<!--           <div class="column_4"> -->
<!--             <label class="password"><a href="#">Forgot <br /> -->
<!--             password</a></label> -->
<!--           </div> -->
<!--           </fieldset> -->
<!--         </form> -->
<!--       </div>End div_login_box -->
<!--     </div>End div_number_login -->
  </div><!-- End div_header-->
  <div id="body_container">
    <div id="body_container_inner">
      <div id="menu">
        <ul>
          <li class="first"><a href="<%=request.getContextPath()%>/front-end/product/Shopindex.jsp">home</a></li>
          <li><a href="<%=request.getContextPath()%>/front-end/product/Shop.jsp">Product</a></li>
          <li><a class="current">Orders</a></li>
	      <li><a href="<%=request.getContextPath()%>/front-end/charge/Charge.jsp">Charge</a></li>
          <li><a href="<%=request.getContextPath()%>/front-end/product/Cart.jsp">ShoppingCart</a></li>
          <li><a href="<%=request.getContextPath()%>/front-end/product/shopQ&A.jsp">Q&A</a></li>
          
        </ul>
      </div>
      <div class="banner"><a href="#">
		  <img src="<%=request.getContextPath()%>/front-end/images/banner2.jpg" /></a>
		</div><!-- End div_banner-->
<!--
      <div class="find_more">
        <p>Shop.jsp<br />
          <span></span></p>
      </div> End div_find_more
-->
      <div class="container_row">
        <div class="welcomezone"><!-- 內容START-->
       <table> 
	<tr>
		<th style="font-family:Microsoft JhengHei ;font-size:large">訂單編號</th>
		<th style="font-family:Microsoft JhengHei ;font-size:large">收件人</th>
		<th style="font-family:Microsoft JhengHei ;font-size:large">縣市</th>
		<th style="font-family:Microsoft JhengHei ;font-size:large">鄉鎮</th>
		<th style="font-family:Microsoft JhengHei ;font-size:large">路</th>
		<th style="font-family:Microsoft JhengHei ;font-size:large">電話</th>
		<th style="font-family:Microsoft JhengHei ;font-size:large">日期</th>
<!-- 		<th>出貨日期</th> -->
		<th  style="font-family:Microsoft JhengHei ;font-size:large">金額 </th>
<!-- 		<th>處理狀態 </th> -->
<!-- 		<th>卡號</th> -->
	</tr>
	<c:forEach var="ordersVO" items="${ordersSvc.all}">
		<tr align='center' valign='middle'>
			<td>${ordersVO.orders_no}</td>
			<td>${ordersVO.orders_receiver}</td>
<%-- 			<td>${ordersVO.post_no}</td> --%>
			<td>${ordersVO.post_adp_city}</td>
			<td>${ordersVO.post_town}</td>
			<td>${ordersVO.post_road}</td>
			<td>${ordersVO.orders_phone}</td>
<%-- 			<td>${ordersVO.collect_mode_no}</td> --%>
			<td>${ordersVO.orders_date}</td>
<%-- 			<td>${ordersVO.orders_ship_date}</td> --%>
			<td>${ordersVO.orders_total}</td>
<%-- 			<td>${ordersVO.orders_status}</td> --%>
<%-- 			<td>${ordersVO.orders_credit}</td> --%>

		</tr>
	</c:forEach>
	</table>
    
        
      </div><!-- 內容END-->
      </div>  
      <div id="footer">
        <div class="footer_link">
        <ul style="color:#FFf;">
          ©2017_AnimalMap
          </ul>
        </div><!-- End div_footer_link-->
      </div><!-- End div_footer-->
    </div><!-- End div_container_row-->
  </div><!-- End div_body_container_inner-->
</div><!-- End div_body_container-->
</body>
</html>

