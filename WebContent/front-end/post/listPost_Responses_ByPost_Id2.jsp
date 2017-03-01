listAllPost.jsp<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.post.model.*" %>
<%@ page import="com.post_Response.model.*" %>
<%@ page import="com.post.controller.*" %>
<%@ page import="com.post_Response.controller.*" %>


<%--  - ${postVO.post_resNum} --%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="listPost_Responses_ByPost_Id" scope="request" type="java.util.Set" />
<jsp:useBean id="postSvc" scope="page" class="com.post.model.PostService" />
<html>
<head>
<title>文章回覆留言 - listPost_Responses_ByPost_Id.jsp</title>
</head>
<body bgcolor='white'>

<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='1200'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>文章回覆留言 - listPost_Responses_ByPost_Id.jsp</h3>
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

<table border='1' bordercolor='#CCCCFF' width='1200'>
	<tr>
		<th>留言(回覆)編號</th>
		<th>會員編號(發文者)</th>
		<th>文章編號</th>
		<th>文章留言內容</th>
		<th>發佈時間</th>
		<th>修改時間</th>
		<th>文章編號 【文章標題】</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	
	<c:forEach var="post_ResponseVO" items="${listPost_Responses_ByPost_Id}" >
		<tr align='center' valign='middle' ${(post_ResponseVO.res_Id==param.res_Id) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${post_ResponseVO.res_Id}</td>
			<td>${post_ResponseVO.mem_Id}</td>
			<td>${post_ResponseVO.post_Id}</td>
			<td>${post_ResponseVO.post_Response_content}</td>
			<td>${post_ResponseVO.post_time}</td>
			<td>${post_ResponseVO.post_Response_upDate}</td>	
			<td>
			<c:forEach var="postVO" items="${postSvc.all}">
                    <c:if test="${post_ResponseVO.post_Id==postVO.post_Id}">
	                    ${postVO.post_Id}【<font color=orange>${postVO.post_title}</font>】
                    </c:if>
                </c:forEach>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/post_Response/post_Response.do">
			    <input type="submit" value="修改"> 
			    <input type="hidden" name="res_Id"value="${post_ResponseVO.res_Id}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/post_Response/post_Response.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="res_Id" value="${post_ResponseVO.res_Id}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>

<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
