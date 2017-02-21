<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.post.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller PostServlet.java已存入request的PostVO物件--%>
<%PostVO postVO = (PostVO) request.getAttribute("postVO");%>
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
<html>
<head>
<title>討論區資料 - listOnePost.jsp</title>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>討論區資料 - ListOnePost.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/post/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>文章編號</b></td>		<td><b>會員(發文者)</b></td>		<td><b>文章分類</b></td>		<td><b>文章分類編號</b></td>		<td><b>文章標題</b></td>		<td><b>文章內容</b></td>		<td><b>發佈時間</b></td>		<td><b>修改時間</b></td>		<td><b>回覆數量</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${postVO.post_Id}</td>	
	<td>
		<font color=orange>${postVO.memVO.mem_Id}</font>
	</td>
			<td>${postVO.post_class}</td>			<td>${postVO.post_class_Id}</td>			<td>${postVO.post_title}</td>			<td>${postVO.post_content}</td>			<td>${postVO.post_time}</td>			<td>${postVO.post_upDate}</td>			<td>${postVO.post_resNum}</td>
    </tr>
</table>
</body>
</html>        
