	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.park.model.*"%>
<%
    ParkVO parkVO = (ParkVO) request.getAttribute("parkVO"); //ParkServlet.java (Concroller), 存入req的parkVO物件 (包括幫忙取出的parkVO, 也包括輸入資料錯誤時的parkVO物件)
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

	<title>公園資料修改 - update_park_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
	<%@include file="/back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>公園資料 - ListOnePark.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/park/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<h3>資料修改:</h3>

<FORM METHOD="post" ACTION="park.do" name="form1">
    <table border="0">

    <!--  -->
	
    <tr>
        <td>公園編號編號:<font color=red><b>*</b></font></td>
        <td><%=parkVO.getPark_Id()%></td>
    </tr>
	
    <tr>
        <td>員工編號:</td>
        <td><input type="TEXT" name="emp_Id" size="45" value="<%=parkVO.getEmp_Id()%>" /></td>
    </tr>
	
    <tr>
        <td>公園標題:</td>
        <td><input type="TEXT" name="park_title" size="45" value="<%=parkVO.getPark_title()%>" /></td>
    </tr>
	
    <tr>
        <td>公園內容:</td>
        <td><input type="TEXT" name="park_content" size="45" value="<%=parkVO.getPark_content()%>" /></td>
    </tr>

	<tr>
		<td>公園照片:</td>
		<td><input type="file" name="park_pic" size=45></td>
	</tr>	
	
	<tr>
		<td>公園發布時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="adp_start_date" value="<%=parkVO.getAdp_start_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','adp_start_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/back-end/images/btn_date_up.gif" width="22" height="17" alt="公園發布時間"></a>
		</td>
	</tr>
	
	<tr>
		<td>公園更新時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="adp_upDate" value="<%=parkVO.getAdp_upDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','adp_upDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/back-end/images/btn_date_up.gif" width="22" height="17" alt="公園更新時間"></a>
		</td>
	</tr>
	
    <tr>
        <td>縣市:</td>
        <td><input type="TEXT" name="adp_city" size="45" value="<%=parkVO.getAdp_city()%>" /></td>
    </tr>
	
    <tr>
        <td>鄉鎮市區:</td>
        <td><input type="TEXT" name="park_town" size="45" value="<%=parkVO.getPark_town()%>" /></td>
    </tr>
	
    <tr>
        <td>道路街名村里:</td>
        <td><input type="TEXT" name="park_road" size="45" value="<%=parkVO.getPark_road()%>" /></td>
    </tr>
	
    <tr>
        <td>公園經度座標:</td>
        <td><input type="TEXT" name="park_lon" size="45" value="<%=parkVO.getPark_lon()%>" /></td>
    </tr>
	
    <tr>
        <td>緯度座標緯度座標:</td>
        <td><input type="TEXT" name="park_lat" size="45" value="<%=parkVO.getPark_lat()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="park_Id" value="<%=parkVO.getPark_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllPark.jsp 與 複合查詢 listParks_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
