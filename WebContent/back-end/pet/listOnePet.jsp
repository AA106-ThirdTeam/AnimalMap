	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pet.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller PetServlet.java已存入request的PetVO物件--%>
<%PetVO petVO = (PetVO) request.getAttribute("petVO");%>


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
<title>自家寵物資料 - listOnePet.jsp</title>

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
        <h3>自家寵物資料 - ListOnePet.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/pet/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>寵物編號</th>		<th>主人會員編號</th>		<th>寵物名字</th>		<th>寵物種類</th>		<th>寵物性別</th>		<th>寵物健康狀況</th>		<th>寵物疫苗接踵</th>		<th>寵物毛色</th>		<th>寵物體型</th>		<th>寵物年齡</th>		<th>寵物節育</th>		<th>寵物晶片編號</th>		<th>寵物生日</th>		<th>寵物物件狀態</th>		<th>寵物建立時間</th>		<th>縣市</th>		<th>鄉鎮市區</th>		<th>道路街名村里</th>		<th>送養地點經度</th>		<th>送養地點緯度</th>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${petVO.pet_Id}</td>			<td>${petVO.mem_Id}</td>			<td>${petVO.pet_name}</td>			<td>${petVO.pet_type}</td>			<td>${petVO.pet_gender}</td>			<td>${petVO.pet_heal}</td>			<td>${petVO.pet_Vac}</td>			<td>${petVO.pet_color}</td>			<td>${petVO.pet_body}</td>			<td>${petVO.pet_age}</td>			<td>${petVO.pet_Neu}</td>			<td>${petVO.pet_chip}</td>			<td>${petVO.pet_birth}</td>			<td>${petVO.pet_status}</td>			<td>${petVO.pet_CreDATE}</td>			<td>${petVO.pet_city}</td>			<td>${petVO.pet_town}</td>			<td>${petVO.pet_road}</td>			<td>${petVO.pet_FinLat}</td>			<td>${petVO.pet_FinLon}</td> 
    </tr>
</table>

</body>
</html>        
