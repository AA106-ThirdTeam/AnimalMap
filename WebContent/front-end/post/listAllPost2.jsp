<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.post_Response.model.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.post.controller.*" %>
<%-- 此頁練習採用 EL 的寫法取值 --%>
<!-- 利用list取出泛型資料 item項目 -->
<%  
PostService postSvc = new PostService();
List<PostVO> list = postSvc.getAll();
pageContext.setAttribute("list",list);
%>
<%-- <jsp:useBean id="postSvc" scope="page" class="com.post.model.PostService" /> --%>

<html>
<head>
<title>所有討論區文章 - listAllPost.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='1200'>
	<tr bgcolor='orange' align='center' valign='middle' height='20'>
		<td>
		<h3>所有討論區文章 - listAllPost.jsp</h3>
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
		<th>文章編號</th>
		<th>會員編號</th>
		<th>文章分類</th>
		<th>文章分類編號</th>
		<th>文章標題</th>
		<th>文章內容</th>
		<th>發佈時間</th>
		<th>修改時間</th>
		<th>回覆數量</th>
		<th>修改</th>
		<th>刪除<font color=red>(關聯測試與交易-小心)</font></th>
		<th>查詢留言</th>
	</tr>
	
	<%@ include file="page/page1.file" %> 
	<c:forEach var="postVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr align='center' valign='middle' ${(postVO.post_Id==param.post_Id) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
		<td>${postVO.post_Id}</td>
		<td>${postVO.mem_Id}</td>
		<td>${postVO.post_class}</td>
		<td>${postVO.post_class_Id}</td>
		<td>${postVO.post_title}</td>
		<td>${postVO.post_content}</td>
		<td>${postVO.post_time}</td>
		<td>${postVO.post_upDate}</td>
		<td>${postVO.post_resNum}</td>
					
<%-- 		<td><c:forEach var="postVO" items="${postSvc.all}"> --%>
<%--             <c:if test="${post_ResponseVO.post_Id==postVO.post_Id}"> --%>
<%-- 	            ${postVO.post_Id}【${postVO.post_title}】 --%>
<%--            	</c:if> --%>
<%--             </c:forEach> --%>
<!-- 		</td> -->
		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/post/post.do">
			     <input type="submit" value="修改"> 
			     <input type="hidden" name="post_Id" value="${postVO.post_Id}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    <input type="hidden" name="action"	value="getOne_For_Update">
			</td></FORM>
		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/post/post.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="post_Id" value="${postVO.post_Id}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    <input type="hidden" name="action"value="delete_Post">
			</td></FORM>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/post/post.do">
			    <input type="submit" value="送出查詢"> 
			    <input type="hidden" name="post_Id" value="${postVO.post_Id}">
			    <input type="hidden" name="action" value="listPost_Responses_ByPost_Id_B">
			</td></FORM>
	</tr>
	</c:forEach>
</table>
	<%@ include file="page/page2.file"%>


<%if (request.getAttribute("listPost_Responses_ByPost_Id")!=null){%>
       <jsp:include page="listPost_Responses_ByPost_Id.jsp" />
<%} %>


<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
