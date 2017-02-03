<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.rel_list.model.*"%>
<%
Rel_ListVO rel_listVO = (Rel_ListVO) request.getAttribute("rel_listVO");
%>

<html>
<head>
<title>關係名單新增 - addRel_List.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>關係名單新增 - addRel_List.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/rel_list/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>關係名單:</h3>
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

<FORM METHOD="post" ACTION="rel_list.do" name="form1">
<table border="0">
	<tr>
		<td>是否為黑名單:</td>
		<td><input type="TEXT" name="isBlackList" size="45"
			value="<%= (rel_listVO==null)? "1" : rel_listVO.getIsBlackList()%>" /></td>
	</tr>
	<tr>
		<td>是否已被邀請至揪團:</td>
		<td><input type="TEXT" name="isInvited" size="45"
			value="<%= (rel_listVO==null)? "1" : rel_listVO.getIsInvited()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>
