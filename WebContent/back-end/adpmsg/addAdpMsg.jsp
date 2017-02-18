<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.adpmsg.model.*"%>
<%
AdpMsgVO adpmsgVO = (AdpMsgVO) request.getAttribute("adpmsgVO");
%>
<html>
<head>
<title>領養活動留言新增 - addAdpMsg.jsp</title>
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
		<h3>領養活動留言新增 - addAdpMsg.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/back-end/adpmsg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>領養活動留言:</h3>
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
<FORM METHOD="post" ACTION="adpmsg.do" name="form1">
<table border="0">
	<jsp:useBean id="adpSvc" scope="page" class="heibernate_com.adp.model.AdpService" />
	<tr>
		<td>領養活動編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="adp_Id">
			<c:forEach var="adpVO" items="${adpSvc.all}">
				<option value="${adpVO.adp_Id}" ${(adpmsgVO.adpVO.adp_Id==adpVO.adp_Id)? 'selected':'' } >${adpVO.adp_Id}
			</c:forEach>
		</select></td>
	</tr>
	<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>留言會員編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="memVO" items="${memSvc.all}">
				<option value="${memVO.mem_Id}" ${(adpmsgVO.memVO.mem_Id==memVO.mem_Id)? 'selected':'' } >${memVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>領養活動留言:</td>
		<td><input type="TEXT" name="msg" size="45"
			value="<%= (adpmsgVO==null)? "1" : adpmsgVO.getMsg()%>" /></td>
	</tr>	
	<tr>
		<%java.sql.Date date_adpMsgDate = new java.sql.Date(System.currentTimeMillis());%>
		<td>留言發布日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="adpMsgDate" value="<%= (adpmsgVO==null)? date_adpMsgDate : adpmsgVO.getAdpMsgDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','adpMsgDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/back-end/images/btn_date_up.gif" width="22" height="17" alt="留言發布日期"></a>
		</td>
	</tr>
	<tr>
		<%java.sql.Date date_adpMsgadp_upDate = new java.sql.Date(System.currentTimeMillis());%>
		<td>留言更新日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="adpMsgadp_upDate" value="<%= (adpmsgVO==null)? date_adpMsgadp_upDate : adpmsgVO.getAdpMsgadp_upDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','adpMsgadp_upDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/back-end/images/btn_date_up.gif" width="22" height="17" alt="留言更新日期"></a>
		</td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
