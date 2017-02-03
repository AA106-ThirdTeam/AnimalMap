<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Orders_item: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>表格 Orders_item: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for Orders_item: Home</p>

<hr>

<h3>訂單明細資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/orders_item/listAllOrders_item.jsp'>List</a> all Orders_items. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/orders_item/orders_item.do" >
        <b>輸入訂單明細編號 (如7001):</b>
        <input type="text" name="{PK英文名稱}">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="orders_itemSvc" scope="page" class="com.orders_item.model.Orders_itemService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/orders_item/orders_item.do" >
       <b>選擇訂單明細編號:</b>
       <select size="1" name="{PK英文名稱}">
         <c:forEach var="orders_itemVO" items="${orders_itemSvc.all}" > 
          <option value="${orders_itemVO.{PK英文名稱}}">${orders_itemVO.{PK英文名稱}}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>

<hr>

<!--  -->
<h3>訂單明細管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/orders_item/addOrders_item.jsp'>Add</a> a new Orders_item.</li>
</ul>

<!--  -->

</body>

</html>
