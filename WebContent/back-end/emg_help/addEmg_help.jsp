	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emg_help.model.*"%>
<%
Emg_helpVO emg_helpVO = (Emg_helpVO) request.getAttribute("emg_helpVO");
%>

<html>
<head>
<title>緊急求救新增 - addEmg_help.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
<%@include file="/back-end/js/calendarcode.jsp"%>

	<!-- 共用HEAD -->
	
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>

</head>

<body bgcolor='white'>
<!--  -->
<div id="popupcalendar" class="text"></div>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>緊急求救新增 - addEmg_help.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/back-end/emg_help/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>緊急求救:</h3>
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

<FORM METHOD="post" ACTION="emg_help.do" name="form1">
<table border="0">


	<tr>
		<td>發起人編號:</td>
		<td><input type="TEXT" name="mem_Id" size="45"
			value="<%= (emg_helpVO==null)? "1" : emg_helpVO.getMem_Id()%>" /></td>
	</tr>	

	
	<tr>
		<%java.sql.Date date_emg_H_start_date = new java.sql.Date(System.currentTimeMillis());%>
		<td>開始時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emg_H_start_date" value="<%= (emg_helpVO==null)? date_emg_H_start_date : emg_helpVO.getEmg_H_start_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emg_H_start_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/back-end/images/btn_date_up.gif" width="22" height="17" alt="開始時間"></a>
		</td>
	</tr>

	
	<tr>
		<%java.sql.Date date_emg_H_end_date = new java.sql.Date(System.currentTimeMillis());%>
		<td>結束日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emg_H_end_date" value="<%= (emg_helpVO==null)? date_emg_H_end_date : emg_helpVO.getEmg_H_end_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emg_H_end_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/back-end/images/btn_date_up.gif" width="22" height="17" alt="結束日期"></a>
		</td>
	</tr>


	<tr>
		<td>求救標題:</td>
		<td><input type="TEXT" name="emg_H_title" size="45"
			value="<%= (emg_helpVO==null)? "1" : emg_helpVO.getEmg_H_title()%>" /></td>
	</tr>	


	<tr>
		<td>求救內容:</td>
		<td><input type="TEXT" name="emg_H_content" size="45"
			value="<%= (emg_helpVO==null)? "1" : emg_helpVO.getEmg_H_content()%>" /></td>
	</tr>	

	
	<tr>
		<td>照片:</td>
		<td><input type="file" name="emg_H_Pic" size=45></td>
	</tr>


	<tr>
		<td>照片副檔名:</td>
		<td><input type="TEXT" name="emg_H_Pic_format" size="45"
			value="<%= (emg_helpVO==null)? "1" : emg_helpVO.getEmg_H_Pic_format()%>" /></td>
	</tr>	


	<tr>
		<td>縣市:</td>
		<td><input type="TEXT" name="emg_H_city" size="45"
			value="<%= (emg_helpVO==null)? "1" : emg_helpVO.getEmg_H_city()%>" /></td>
	</tr>	


	<tr>
		<td>鄉鎮市區:</td>
		<td><input type="TEXT" name="emg_H_town" size="45"
			value="<%= (emg_helpVO==null)? "1" : emg_helpVO.getEmg_H_town()%>" /></td>
	</tr>	


	<tr>
		<td>道路街名村里:</td>
		<td><input type="TEXT" name="emg_H_road" size="45"
			value="<%= (emg_helpVO==null)? "1" : emg_helpVO.getEmg_H_road()%>" /></td>
	</tr>	


	<tr>
		<td>緊急求救經度座標:</td>
		<td><input type="TEXT" name="emg_H_Lon" size="45"
			value="<%= (emg_helpVO==null)? "1" : emg_helpVO.getEmg_H_Lon()%>" /></td>
	</tr>	


	<tr>
		<td>緊急求救緯度座標:</td>
		<td><input type="TEXT" name="emg_H_Lat" size="45"
			value="<%= (emg_helpVO==null)? "1" : emg_helpVO.getEmg_H_Lat()%>" /></td>
	</tr>	


</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>
