<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.product.model.*"%>
<%
    ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //ProductServlet.java (Concroller), 存入req的productVO物件 (包括幫忙取出的productVO, 也包括輸入資料錯誤時的productVO物件)
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
	<title>商品資料修改 - update_product_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>商品資料 - ListOneProduct.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/product/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="product.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>商品編號編號:<font color=red><b>*</b></font></td>
        <td><%=productVO.getProduct_no()%></td>
    </tr>
    <tr>
        <td>商品名稱:</td>
        <td><input type="TEXT" name="product_name" size="45" value="<%=productVO.getProduct_name()%>" /></td>
    </tr>
    <tr>
        <td>商品簡介:</td>
        <td><input type="TEXT" name="product_introduction" size="45" value="<%=productVO.getProduct_introduction()%>" /></td>
    </tr>
    <tr>
        <td>商品價格:</td>
        <td><input type="TEXT" name="product_price" size="45" value="<%=productVO.getProduct_price()%>" /></td>
    </tr>	
    <tr>
        <td>商品庫存量:</td>
        <td><input type="TEXT" name="product_stock" size="45" value="<%=productVO.getProduct_stock()%>" /></td>
    </tr>	
    <tr>
        <td>商品圖片:</td>
        <td><input type="TEXT" name="product_picture_large" size="45" value="<%=productVO.getProduct_picture_large()%>" /></td>
    </tr>
    <tr>
        <td>商品圖片（縮圖）:</td>
        <td><input type="TEXT" name="product_picture_small" size="45" value="<%=productVO.getProduct_picture_small()%>" /></td>
    </tr>
    <tr>
        <td>商品上下架狀態:</td>
        <td><input type="TEXT" name="product_status" size="45" value="<%=productVO.getProduct_status()%>" /></td>
    </tr>	
	<tr>
		<td>商品建立日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="product_create_date" value="<%=productVO.getProduct_create_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','product_create_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="商品建立日期"></a>
		</td>
	</tr>
    <tr>
        <td>商品資訊:</td>
        <td><input type="TEXT" name="product_info" size="45" value="<%=productVO.getProduct_info()%>" /></td>
    </tr>
    <tr>
        <td>商品類別編號:</td>
        <td><input type="TEXT" name="product_kind_no" size="45" value="<%=productVO.getProduct_kind_no()%>" /></td>
    </tr>	
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="product_no" value="<%=productVO.getProduct_no()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllProduct.jsp 與 複合查詢 listProducts_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
