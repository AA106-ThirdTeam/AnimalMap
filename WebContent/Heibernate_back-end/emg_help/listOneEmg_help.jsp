<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.emg_help.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller Emg_helpServlet.java已存入request的Emg_helpVO物件--%>
<%Emg_helpVO emg_helpVO = (Emg_helpVO) request.getAttribute("emg_helpVO");%>
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
<title>緊急求救資料 - listOneEmg_help.jsp</title>
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
        <h3>緊急求救資料 - ListOneEmg_help.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/emg_help/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>求救編號</b></td>		<td><b>發起人</b></td>		<td><b>開始時間</b></td>		<td><b>結束日期</b></td>		<td><b>求救標題</b></td>		<td><b>求救內容</b></td>		<td><b>照片</b></td>		<td><b>照片副檔名</b></td>		<td><b>縣市</b></td>		<td><b>鄉鎮市區</b></td>		<td><b>道路街名村里</b></td>		<td><b>緊急求救經度座標</b></td>		<td><b>緊急求救緯度座標</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${emg_helpVO.emg_H_Id}</td>	
	<td>
		<font color=orange>${emg_helpVO.memVO.mem_Id}</font>
	</td>
			<td>${emg_helpVO.emg_H_start_date}</td>			<td>${emg_helpVO.emg_H_end_date}</td>			<td>${emg_helpVO.emg_H_title}</td>			<td>${emg_helpVO.emg_H_content}</td>			<td>${emg_helpVO.emg_H_Pic}</td>			<td>${emg_helpVO.emg_H_Pic_format}</td>			<td>${emg_helpVO.emg_H_city}</td>			<td>${emg_helpVO.emg_H_town}</td>			<td>${emg_helpVO.emg_H_road}</td>			<td>${emg_helpVO.emg_H_Lon}</td>			<td>${emg_helpVO.emg_H_Lat}</td>
    </tr>
</table>
</body>
</html>        
