	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.anihome.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller AniHomeServlet.java已存入request的AniHomeVO物件--%>
<%AniHomeVO anihomeVO = (AniHomeVO) request.getAttribute("anihomeVO");%>


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
<title>動物之家資料 - listOneAniHome.jsp</title>

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
        <h3>動物之家資料 - ListOneAniHome.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/anihome/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>動物之家編號</th>		<th>會員編號</th>		<th>動物之家標題</th>		<th>動物之家內容</th>		<th>動物之家發布時間</th>		<th>動物之家更新時間</th>		<th>縣市</th>		<th>鄉鎮市區</th>		<th>道路街名村里</th>		<th>動物之家經度座標</th>		<th>緯度座標緯度座標</th>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${anihomeVO.aniHome_Id}</td>			<td>${anihomeVO.mem_Id}</td>			<td>${anihomeVO.aniHome_title}</td>			<td>${anihomeVO.aniHome_content}</td>			<td>${anihomeVO.aniHome_start_date}</td>			<td>${anihomeVO.aniHome_upDate}</td>			<td>${anihomeVO.aniHome_city}</td>			<td>${anihomeVO.aniHome_town}</td>			<td>${anihomeVO.aniHome_road}</td>			<td>${anihomeVO.aniHome_lon}</td>			<td>${anihomeVO.aniHome_lat}</td> 
    </tr>
</table>

</body>
</html>        
