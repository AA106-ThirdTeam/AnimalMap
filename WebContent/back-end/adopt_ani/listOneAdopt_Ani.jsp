	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adopt_ani.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Adopt_AniServlet.java已存入request的Adopt_AniVO物件--%>
<%Adopt_AniVO adopt_aniVO = (Adopt_AniVO) request.getAttribute("adopt_aniVO");%>


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
<title>送養動物資料 - listOneAdopt_Ani.jsp</title>

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
        <h3>送養動物資料 - ListOneAdopt_Ani.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/adopt_ani/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>送養動物編號</th>		<th>發布者會員編號</th>		<th>送養動物名字</th>		<th>送養動物動物種類</th>		<th>送養動物性別</th>		<th>送養動物健康狀況</th>		<th>送養動物疫苗接踵</th>		<th>送養動物毛色</th>		<th>送養動物體型</th>		<th>送養動物年齡</th>		<th>送養動物節育</th>		<th>送養動物晶片編號</th>		<th>送養時間</th>		<th>送養動物物件狀態</th>		<th>送養動物建立時間</th>		<th>送養地點經度</th>		<th>送養地點緯度</th>		<th>縣/市</th>		<th>鄉鎮市區</th>		<th>道路街名村里</th>		<th>喜歡數</th>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${adopt_aniVO.adopt_Ani_Id}</td>			<td>${adopt_aniVO.mem_Id}</td>			<td>${adopt_aniVO.adopt_Ani_name}</td>			<td>${adopt_aniVO.adopt_Ani_type}</td>			<td>${adopt_aniVO.adopt_Ani_gender}</td>			<td>${adopt_aniVO.adopt_Ani_heal}</td>			<td>${adopt_aniVO.adopt_Ani_Vac}</td>			<td>${adopt_aniVO.adopt_Ani_color}</td>			<td>${adopt_aniVO.adopt_Ani_body}</td>			<td>${adopt_aniVO.adopt_Ani_age}</td>			<td>${adopt_aniVO.adopt_Ani_Neu}</td>			<td>${adopt_aniVO.adopt_Ani_chip}</td>			<td>${adopt_aniVO.adopt_Ani_date}</td>			<td>${adopt_aniVO.adopt_Ani_status}</td>			<td>${adopt_aniVO.adopt_Ani_CreDate}</td>			<td>${adopt_aniVO.adopt_Ani_FinLat}</td>			<td>${adopt_aniVO.adopt_Ani_FinLon}</td>			<td>${adopt_aniVO.adopt_Ani_city}</td>			<td>${adopt_aniVO.adopt_Ani_town}</td>			<td>${adopt_aniVO.adopt_Ani_road}</td>			<td>${adopt_aniVO.adopt_Ani_like}</td> 
    </tr>
</table>

</body>
</html>        
