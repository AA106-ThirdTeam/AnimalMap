<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.pet_photos.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller Pet_PhotosServlet.java已存入request的Pet_PhotosVO物件--%>
<%Pet_PhotosVO pet_photosVO = (Pet_PhotosVO) request.getAttribute("pet_photosVO");%>
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
<title>自家寵物相簿資料 - listOnePet_Photos.jsp</title>
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
        <h3>自家寵物相簿資料 - ListOnePet_Photos.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/pet_photos/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>寵物相片編號</b></td>		<td><b>寵物</b></td>		<td><b>發布者會員</b></td>		<td><b>寵物相片</b></td>		<td><b>寵物相片檔名</b></td>		<td><b>寵物相片副檔名</b></td>		<td><b>發布時間</b></td>		<td><b>相片類型</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${pet_photosVO.pet_Pic_No}</td>	
	<td>
		<font color=orange>${pet_photosVO.petVO.pet_Id}</font>
	</td>
	<td>
		<font color=orange>${pet_photosVO.memVO.mem_Id}</font>
	</td>
			<td>${pet_photosVO.pet_Pic}</td>			<td>${pet_photosVO.pet_Pic_name}</td>			<td>${pet_photosVO.pet_Pic_nameEX}</td>			<td>${pet_photosVO.pet_Pic_time}</td>			<td>${pet_photosVO.pet_Pic_type}</td>
    </tr>
</table>
</body>
</html>        
