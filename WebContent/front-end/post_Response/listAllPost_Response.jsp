<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.post_Response.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>
<!-- pageContext,他提供了jsp頁面資源的封裝,並可設定頁面範圍屬性 -->
<!-- context.setAttribute(key,value); 自動從page request session... 一次查詢,找到了就取值, -->

<%
	Post_ResponseService post_ResponseSvc = new Post_ResponseService();
	List<Post_ResponseVO> list = post_ResponseSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<html>
<head>
<title>所有回覆資料 - listAllPost_Response.jsp</title>
</head>
<body bgcolor='white'>
	<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
	<table border='1' cellpadding='5' cellspacing='0' width='1200'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>所有回覆資料 - listAllPost_Response.jsp</h3> 
				<a href="<%=request.getContextPath()%>/select_page.jsp">
				<img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
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
			<th>留言(回覆)編號</th>
			<th>會員編號(發文者)</th>
			<th>文章編號</th>
			<th>文章留言內容</th>
			<th>發佈時間</th>
			<th>修改時間</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<%@ include file="page/page1.file"%>
		<c:forEach var="Post_ResponseVO" items="${list}"
			begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
			<tr align='center' valign='middle'>
				<td>${Post_ResponseVO.res_Id}</td>
				<td>${Post_ResponseVO.mem_Id}</td>
				<td>${Post_ResponseVO.post_Id}</td>
				<td>${Post_ResponseVO.post_Response_content}</td>
				<td>${Post_ResponseVO.post_time}</td>
				<td>${Post_ResponseVO.post_Response_upDate}</td>

				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/post_Response/post_Response.do">
						<input type="submit" value="修改">
						<input type="hidden" name="res_Id" value="${Post_ResponseVO.res_Id}">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
						<!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
						<input type="hidden" name="whichPage" value="<%=request.getRequestURI()%>">
						<!--只用於:istAllPost_Response.jsp-->
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"ACTION="<%=request.getContextPath()%>/post_Response/post_Response.do">
						<input type="submit" value="刪除"> <input type="hidden" name="res_Id" value="${Post_ResponseVO.res_Id}">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
						<!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
						<input type="hidden" name="whichPage" value="<%=request.getRequestURI()%>">
						<!--只用於:istAllEmp.jsp-->
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page/page2.file"%>

	<br>本網頁的路徑:
	<br>
	<b> <font color=blue>request.getServletPath():</font> <%=request.getServletPath()%><br>
		<font color=blue>request.getRequestURI(): </font> <%=request.getRequestURI()%>
	</b>

</body>
</html>
