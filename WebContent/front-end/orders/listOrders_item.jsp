<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.orders_item.model.*"%>

<jsp:useBean id="ordersSvc" scope="page" class="com.orders.model.OrdersService" />
<jsp:useBean id="listOrders_items_ByOrders_no" scope="request" type="java.util.Set" />

<!DOCTYPE html>
<html>
<head>
<title>Checkout.jsp</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css" />
</head>
<body>

<div id="layout">
  <div id="header">
    <div id="logo"><a href="#"><img src="<%=request.getContextPath()%>/front-end/images/1.png" alt="" /></a>
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
	      <li><a href="<%=request.getContextPath()%>/front-end/product/Charge.jsp">Charge</a></li>
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
       <table  style="border:3px #00b9ff double;padding:5px;" rules="all" cellpadding='5'; width='800'> 
		<tr>
		<th>訂單編號</th>
		<th>商品編號</th>
		<th>訂購數量</th>
		<th>商品售價</th>
	</tr>
		<c:forEach var="orders_itemVO" items="${listOrders_items_ByOrders_no}">
		<tr align='center' valign='middle' ${(orders_itemVO.orders_no==ordersVO.orders_no) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>
			<c:forEach var="ordersVO" items="${ordersSvc.all}">
				<c:if test="${orders_itemVO.orders_no==ordersVO.orders_no}">
					${orders_itemVO.orders_no}
				</c:if>
			</c:forEach></td>
			<td>${orders_itemVO.product_no}</td>
			<td>${orders_itemVO.commodities_amount}</td>
			<td>${orders_itemVO.selling_price}</td>

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

