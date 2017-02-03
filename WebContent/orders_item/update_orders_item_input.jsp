 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.orders_item.model.*"%>
<%
    Orders_itemVO orders_itemVO = (Orders_itemVO) request.getAttribute("orders_itemVO"); //Orders_itemServlet.java (Concroller), 存入req的orders_itemVO物件 (包括幫忙取出的orders_itemVO, 也包括輸入資料錯誤時的orders_itemVO物件)
%>

<!--  -->

<html>
<head>
<title>訂單明細資料修改 - update_orders_item_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>訂單明細資料 - ListOneOrders_item.jsp</h3>
        <a href="<%=request.getContextPath()%>/orders_item/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<h3>資料修改:</h3>
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

<FORM METHOD="post" ACTION="orders_item.do" name="form1">
    <table border="0">

    <!--  -->
        <tr>
        <td>訂單編號編號:<font color=red><b>*</b></font></td>
        <td><%=orders_itemVO.getOrders_no()%></td>
    </tr>
    <tr>
        <td>商品編號編號:<font color=red><b>*</b></font></td>
        <td><%=orders_itemVO.getProduct_no()%></td>
    </tr>
    <tr>
        <td>訂購數量:</td>
        <td><input type="TEXT" name="commodities_amout" size="45" value="<%=orders_itemVO.getCommodities_amout()%>" /></td>
    </tr>
    <tr>
        <td>商品售價:</td>
        <td><input type="TEXT" name="selling_price" size="45" value="<%=orders_itemVO.getSelling_price()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="orders_no" value="<%=orders_itemVO.getOrders_no()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllOrders_item.jsp 與 複合查詢 listOrders_items_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
