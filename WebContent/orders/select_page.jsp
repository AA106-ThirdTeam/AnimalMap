<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Orders: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>表格 Orders: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for Orders: Home</p>

<hr>

<h3>訂單資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/orders/listAllOrders.jsp'>List</a> all Orderss. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/orders/orders.do" >
        <b>輸入訂單編號 (如7001):</b>
        <input type="text" name="orders_no">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="ordersSvc" scope="page" class="com.orders.model.OrdersService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/orders/orders.do" >
       <b>選擇訂單編號:</b>
       <select size="1" name="orders_no">
         <c:forEach var="ordersVO" items="${ordersSvc.all}" > 
          <option value="${ordersVO.orders_no}">${ordersVO.orders_no}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>

<hr>

<!--  -->
<h3>訂單管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/orders/addOrders.jsp'>Add</a> a new Orders.</li>
</ul>

<!--  -->

</body>

</html>
