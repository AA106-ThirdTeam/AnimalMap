	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.second_prodphotos.model.*"%>
<%
    Second_ProdPhotosVO second_prodphotosVO = (Second_ProdPhotosVO) request.getAttribute("second_prodphotosVO"); //Second_ProdPhotosServlet.java (Concroller), 存入req的second_prodphotosVO物件 (包括幫忙取出的second_prodphotosVO, 也包括輸入資料錯誤時的second_prodphotosVO物件)
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

	<title>二手商品相簿資料修改 - update_second_prodphotos_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
	<%@include file="/back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>二手商品相簿資料 - ListOneSecond_ProdPhotos.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/second_prodphotos/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<h3>資料修改:</h3>

<FORM METHOD="post" ACTION="second_prodphotos.do" name="form1">
    <table border="0">

    <!--  -->
	
    <tr>
        <td>二手商品相簿編號編號:<font color=red><b>*</b></font></td>
        <td><%=second_prodphotosVO.getSecond_ProdPhotos_Id()%></td>
    </tr>
	
    <tr>
        <td>二手商品編號:</td>
        <td><input type="TEXT" name="second_Prod_Id" size="45" value="<%=second_prodphotosVO.getSecond_Prod_Id()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="second_ProdPhotos_Id" value="<%=second_prodphotosVO.getSecond_ProdPhotos_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllSecond_ProdPhotos.jsp 與 複合查詢 listSecond_ProdPhotoss_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
