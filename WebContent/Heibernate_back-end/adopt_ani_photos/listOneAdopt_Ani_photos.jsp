<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.adopt_ani_photos.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller Adopt_Ani_photosServlet.java已存入request的Adopt_Ani_photosVO物件--%>
<%Adopt_Ani_photosVO adopt_ani_photosVO = (Adopt_Ani_photosVO) request.getAttribute("adopt_ani_photosVO");%>
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
<title>送養動物相簿資料 - listOneAdopt_Ani_photos.jsp</title>
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
        <h3>送養動物相簿資料 - ListOneAdopt_Ani_photos.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/adopt_ani_photos/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>送養動物相片編號</b></td>		<td><b>送養動物</b></td>		<td><b>發布者會員</b></td>		<td><b>送養動物相片</b></td>		<td><b>寵物相片檔名</b></td>		<td><b>寵物相片副檔名</b></td>		<td><b>發布時間</b></td>		<td><b>相片類型</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${adopt_ani_photosVO.ado_Ani_Pic_No}</td>	
	<td>
		<font color=orange>${adopt_ani_photosVO.adopt_AniVO.adopt_Ani_Id}</font>
	</td>
	<td>
		<font color=orange>${adopt_ani_photosVO.memVO.mem_Id}</font>
	</td>
			<td>${adopt_ani_photosVO.ado_Ani_Pic}</td>			<td>${adopt_ani_photosVO.ado_Pic_name}</td>			<td>${adopt_ani_photosVO.ado_Pic_nameEX}</td>			<td>${adopt_ani_photosVO.ado_Pic_time}</td>			<td>${adopt_ani_photosVO.ado_Pic_type}</td>
    </tr>
</table>
</body>
</html>        
