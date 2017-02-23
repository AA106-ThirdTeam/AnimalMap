<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Orders_item: Home</title>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
</head>
<body bgcolor='white'>
<div id="popupcalendar" class="text"></div>
<table class="table"  border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Orders_item: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>訂單明細資料查詢:</h2>
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
<!--  -->
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/orders_item/listAllOrders_item.jsp'>List</a> all Orders_items. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/orders_item/orders_item.do" >
        <b>輸入訂單明細編號 (如7001):</b>
        <input type="text" name="orders_no">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="orders_itemSvc" scope="page" class="heibernate_com.orders_item.model.Orders_itemService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/orders_item/orders_item.do" >
       <b>選擇訂單明細編號:</b>
       <select size="1" name="orders_no">
         <c:forEach var="orders_itemVO" items="${orders_itemSvc.all}" > 
          <option value="${orders_itemVO.orders_no}">${orders_itemVO.orders_no}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="ordersSvc" scope="page" class="heibernate_com.orders.model.OrdersService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/orders_item/orders_item.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇訂單編號:</font></b>
	       <select size="1" name="orders_no">
	         <c:forEach var="ordersVO" items="${ordersSvc.all}" > 
	          <option value="${ordersVO.orders_no}">${ordersVO.orders_no}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listOrders_items_ByOrders_no_A">
       	</div>
     </FORM>
  </li>
   <jsp:useBean id="productSvc" scope="page" class="heibernate_com.product.model.ProductService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/orders_item/orders_item.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇商品編號:</font></b>
	       <select size="1" name="product_no">
	         <c:forEach var="productVO" items="${productSvc.all}" > 
	          <option value="${productVO.product_no}">${productVO.product_no}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listOrders_items_ByProduct_no_A">
       	</div>
     </FORM>
  </li>
</ul>
<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/orders_item/orders_item.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
       <b>選擇訂單明細編號編號:</b>
       <select size="1" name="orders_item_no">
            <option value=""/>
         <c:forEach var="orders_itemVO" items="${orders_itemSvc.all}" > 
          <option value="${orders_itemVO.orders_item_no}">${orders_itemVO.orders_item_no}
         </c:forEach>   
       </select>   
       <br>  
       <b>選擇訂單編號編號:</b>
       <select size="1" name="orders_no">
         <c:forEach var="ordersVO" items="${ordersSvc.all}" > 
          <option value="${ordersVO.orders_no}">${ordersVO.orders_no}
         </c:forEach>   
       </select>
       <br> 
       <b>選擇商品編號編號:</b>
       <select size="1" name="product_no">
         <c:forEach var="productVO" items="${productSvc.all}" > 
          <option value="${productVO.product_no}">${productVO.product_no}
         </c:forEach>   
       </select>
       <br> 
      <input type="submit" value="送出">
      <input type="hidden" name="action" value="list_ByCompositeQuery">
    </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>訂單明細管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/orders_item/addOrders_item.jsp'>Add</a> a new Orders_item.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Orders管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/orders/listAllOrders.jsp'>List</a> all Orderss. </li>
	    </ul>
	    <hr>
	    <h3><font color=orange>Product管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/product/listAllProduct.jsp'>List</a> all Products. </li>
	    </ul>
<!--  -->
</body>
</html>
