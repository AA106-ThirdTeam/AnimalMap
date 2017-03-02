
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.offiMsg.model.*" %>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	OffiMsgService offiMsgSvc = new OffiMsgService();
	List<OffiMsgVO> list = offiMsgSvc.getAll();
	pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有訊息資料 - listAllOffiMsg.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>所有訊息資料 - listAllOffiMsg.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

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

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>訊息編號</th>
		<th>發布員工</th>
		<th>訊息標題</th>
		<th>訊息內容</th>
		<th>訊息時間</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="pages/page1.file" %> 
	<c:forEach var="offiMsgVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle' ${(offiMsgVO.offiMsg_Id==param.offiMsg_Id) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${offiMsgVO.offiMsg_Id }</td>
			<td>${offiMsgVO.offiMsg_empId }</td>
			<td>${offiMsgVO.offiMsg_Title }</td>
			<td>${offiMsgVO.offiMsg_Content }</td>
			<td>${offiMsgVO.offiMsg_Date }</td>
				
		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/offiMsg/offiMsg.do">
			     <input type="submit" value="修改">
			     <input type="hidden" name="offiMsg_Id" value="${offiMsgVO.offiMsg_Id}">
				<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
		</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/offiMsg/offiMsg.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="offiMsg_Id" value="${offiMsgVO.offiMsg_Id}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="pages/page2.file" %>

<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
