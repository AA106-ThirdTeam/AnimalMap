<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adopt_ani_photos.model.*"%>
<%
Adopt_Ani_photosVO adopt_ani_photosVO = (Adopt_Ani_photosVO) request.getAttribute("adopt_ani_photosVO");
%>

<html>
<head>
<title>送養動物相簿新增 - addAdopt_Ani_photos.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>送養動物相簿新增 - addAdopt_Ani_photos.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/adopt_ani_photos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>送養動物相簿:</h3>
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

<FORM METHOD="post" ACTION="adopt_ani_photos.do" name="form1">
<table border="0">
	<tr>
		<td>送養動物編號:</td>
		<td><input type="TEXT" name="adopt_Ani_Id" size="45"
			value="<%= (adopt_ani_photosVO==null)? "1" : adopt_ani_photosVO.getAdopt_Ani_Id()%>" /></td>
	</tr>
	<tr>
		<td>發布者會員編號:</td>
		<td><input type="TEXT" name="mem_Id" size="45"
			value="<%= (adopt_ani_photosVO==null)? "1" : adopt_ani_photosVO.getMem_Id()%>" /></td>
	</tr>
	<tr>
		<td>送養動物相片:</td>
		<td><input type="file" name="ado_Ani_Pic" size=45></td>
	</tr>
	<tr>
		<td>寵物相片檔名:</td>
		<td><input type="TEXT" name="ado_Pic_name" size="45"
			value="<%= (adopt_ani_photosVO==null)? "1" : adopt_ani_photosVO.getAdo_Pic_name()%>" /></td>
	</tr>
	<tr>
		<td>寵物相片副檔名:</td>
		<td><input type="TEXT" name="ado_Pic_extent" size="45"
			value="<%= (adopt_ani_photosVO==null)? "1" : adopt_ani_photosVO.getAdo_Pic_extent()%>" /></td>
	</tr>
	<tr>
		<%java.sql.Date date_ado_Pic_time = new java.sql.Date(System.currentTimeMillis());%>
		<td>發布時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="ado_Pic_time" value="<%= (adopt_ani_photosVO==null)? date_ado_Pic_time : adopt_ani_photosVO.getAdo_Pic_time()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','ado_Pic_time','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="發布時間"></a>
		</td>
	</tr>
	<tr>
		<td>相片類型:</td>
		<td><input type="TEXT" name="ado_Pic_type" size="45"
			value="<%= (adopt_ani_photosVO==null)? "1" : adopt_ani_photosVO.getAdo_Pic_type()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>