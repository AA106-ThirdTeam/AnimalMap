<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.hos_comment.model.*"%>
<%
Hos_commentVO hos_commentVO = (Hos_commentVO) request.getAttribute("hos_commentVO");
%>
<html>
<head>
<title>診所留言新增 - addHos_comment.jsp</title>
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
		<h3>診所留言新增 - addHos_comment.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/hos_comment/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>診所留言:</h3>
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
<FORM METHOD="post" ACTION="hos_comment.do" name="form1">
<table border="0">
	<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>發送會員編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="memVO" items="${memSvc.all}">
				<option value="${memVO.mem_Id}" ${(hos_commentVO.memVO.mem_Id==memVO.mem_Id)? 'selected':'' } >${memVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<jsp:useBean id="vet_hospitalSvc" scope="page" class="heibernate_com.vet_hospital.model.Vet_hospitalService" />
	<tr>
		<td>診所編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="hos_Id">
			<c:forEach var="vet_hospitalVO" items="${vet_hospitalSvc.all}">
				<option value="${vet_hospitalVO.hos_Id}" ${(hos_commentVO.vet_hospitalVO.hos_Id==vet_hospitalVO.hos_Id)? 'selected':'' } >${vet_hospitalVO.hos_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>發送內容:</td>
		<td><input type="TEXT" name="hosComment_content" size="45"
			value="<%= (hos_commentVO==null)? "1" : hos_commentVO.getHosComment_content()%>" /></td>
	</tr>	
	<tr>
		<%java.sql.Timestamp date_hosComment_SendTime = new java.sql.Timestamp(System.currentTimeMillis());%>
		<td>發送時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="hosComment_SendTime" value="<%= (hos_commentVO==null)? date_hosComment_SendTime : hos_commentVO.getHosComment_SendTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','hosComment_SendTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="發送時間"></a>
		</td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
