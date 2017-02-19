<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.emg_h_msg.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller Emg_H_MsgServlet.java已存入request的Emg_H_MsgVO物件--%>
<%Emg_H_MsgVO emg_h_msgVO = (Emg_H_MsgVO) request.getAttribute("emg_h_msgVO");%>
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
<title>緊急求救留言資料 - listOneEmg_H_Msg.jsp</title>
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
        <h3>緊急求救留言資料 - ListOneEmg_H_Msg.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>緊急求救留言編號</b></td>		<td><b>留言會員</b></td>		<td><b>求救</b></td>		<td><b>發布時間</b></td>		<td><b>留言內容</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${emg_h_msgVO.emg_H_Msg_Id}</td>	
	<td>
		<font color=orange>${emg_h_msgVO.memVO.mem_Id}</font>
	</td>
	<td>
		<font color=orange>${emg_h_msgVO.emg_HVO.emg_H_Id}</font>
	</td>
			<td>${emg_h_msgVO.emg_H_Msg_start}</td>			<td>${emg_h_msgVO.emg_H_Msg_content}</td>
    </tr>
</table>
</body>
</html>        
