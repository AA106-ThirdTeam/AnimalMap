<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.stray_ani_loc.model.*"%>
<%
Stray_Ani_LocVO stray_ani_locVO = (Stray_Ani_LocVO) request.getAttribute("stray_ani_locVO");
%>
<html>
<head>
<title>社區流浪動物出沒範圍新增 - addStray_Ani_Loc.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
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
		<h3>社區流浪動物出沒範圍新增 - addStray_Ani_Loc.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_loc/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>社區流浪動物出沒範圍:</h3>
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
<FORM METHOD="post" ACTION="stray_ani_loc.do" name="form1">
<table border="0">
	<jsp:useBean id="stray_aniSvc" scope="page" class="heibernate_com.stray_ani.model.Stray_AniService" />
	<tr>
		<td>社區動物編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="stray_Ani_Id">
			<c:forEach var="stray_aniVO" items="${stray_aniSvc.all}">
				<option value="${stray_aniVO.stray_Ani_Id}" ${(stray_ani_locVO.stray_aniVO.stray_Ani_Id==stray_aniVO.stray_Ani_Id)? 'selected':'' } >${stray_aniVO.stray_Ani_Id}
			</c:forEach>
		</select></td>
	</tr>
	<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>發布者會員編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="memVO" items="${memSvc.all}">
				<option value="${memVO.mem_Id}" ${(stray_ani_locVO.memVO.mem_Id==memVO.mem_Id)? 'selected':'' } >${memVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>送養地點經度:</td>
		<td><input type="TEXT" name="str_Ani_LocLat" size="45"
			value="<%= (stray_ani_locVO==null)? "1" : stray_ani_locVO.getStr_Ani_LocLat()%>" /></td>
	</tr>	
	<tr>
		<td>送養地點緯度:</td>
		<td><input type="TEXT" name="str_Ani_LocLon" size="45"
			value="<%= (stray_ani_locVO==null)? "1" : stray_ani_locVO.getStr_Ani_LocLon()%>" /></td>
	</tr>	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
