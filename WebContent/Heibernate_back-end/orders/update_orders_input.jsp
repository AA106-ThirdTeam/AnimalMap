<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.orders.model.*"%>
<%
    OrdersVO ordersVO = (OrdersVO) request.getAttribute("ordersVO"); //OrdersServlet.java (Concroller), 存入req的ordersVO物件 (包括幫忙取出的ordersVO, 也包括輸入資料錯誤時的ordersVO物件)
%>
<!--  -->
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
<html>
<head>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<title>訂單資料修改 - update_orders_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>訂單資料 - ListOneOrders.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/orders/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="orders.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>訂單編號編號:<font color=red><b>*</b></font></td>
        <td><%=ordersVO.getOrders_no()%></td>
    </tr>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>會員編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(ordersVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
${memVO.mem_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
    <tr>
        <td>收件人:</td>
        <td><input type="TEXT" name="orders_receiver" size="45" value="<%=ordersVO.getOrders_receiver()%>" /></td>
    </tr>
    <tr>
        <td>郵遞區號:</td>
        <td><input type="TEXT" name="post_no" size="45" value="<%=ordersVO.getPost_no()%>" /></td>
    </tr>
    <tr>
        <td>縣市:</td>
        <td><input type="TEXT" name="post_adp_city" size="45" value="<%=ordersVO.getPost_adp_city()%>" /></td>
    </tr>
    <tr>
        <td>鄉鎮:</td>
        <td><input type="TEXT" name="post_town" size="45" value="<%=ordersVO.getPost_town()%>" /></td>
    </tr>
    <tr>
        <td>路:</td>
        <td><input type="TEXT" name="post_road" size="45" value="<%=ordersVO.getPost_road()%>" /></td>
    </tr>
    <tr>
        <td>收件人電話:</td>
        <td><input type="TEXT" name="orders_phone" size="45" value="<%=ordersVO.getOrders_phone()%>" /></td>
    </tr>	
    <tr>
        <td>付款方式:</td>
        <td><input type="TEXT" name="collect_mode_no" size="45" value="<%=ordersVO.getCollect_mode_no()%>" /></td>
    </tr>	
	<tr>
		<td>下單日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="orders_date" value="<%=ordersVO.getOrders_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','orders_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="下單日期"></a>
		</td>
	</tr>
	<tr>
		<td>出貨日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="orders_ship_date" value="<%=ordersVO.getOrders_ship_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','orders_ship_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="出貨日期"></a>
		</td>
	</tr>
    <tr>
        <td>總金額:</td>
        <td><input type="TEXT" name="orders_total" size="45" value="<%=ordersVO.getOrders_total()%>" /></td>
    </tr>	
    <tr>
        <td>處理狀態:</td>
        <td><input type="TEXT" name="orders_status" size="45" value="<%=ordersVO.getOrders_status()%>" /></td>
    </tr>	
    <tr>
        <td>信用卡卡號:</td>
        <td><input type="TEXT" name="orders_credit" size="45" value="<%=ordersVO.getOrders_credit()%>" /></td>
    </tr>	
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="orders_no" value="<%=ordersVO.getOrders_no()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllOrders.jsp 與 複合查詢 listOrderss_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
