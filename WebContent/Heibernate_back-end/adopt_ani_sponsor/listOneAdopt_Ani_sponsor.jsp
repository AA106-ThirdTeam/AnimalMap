<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.adopt_ani_sponsor.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller Adopt_Ani_sponsorServlet.java已存入request的Adopt_Ani_sponsorVO物件--%>
<%Adopt_Ani_sponsorVO adopt_ani_sponsorVO = (Adopt_Ani_sponsorVO) request.getAttribute("adopt_ani_sponsorVO");%>
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
<title>送養動物贊助資料 - listOneAdopt_Ani_sponsor.jsp</title>
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
        <h3>送養動物贊助資料 - ListOneAdopt_Ani_sponsor.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/adopt_ani_sponsor/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>送養動物贊助編號</b></td>		<td><b>送養動物</b></td>		<td><b>贊助者會員</b></td>		<td><b>贊助送養動物金額</b></td>		<td><b>贊助送養動物物資</b></td>		<td><b>贊助送養動物時間</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${adopt_ani_sponsorVO.ado_Ani_Spo_No}</td>	
	<td>
		<font color=orange>${adopt_ani_sponsorVO.adopt_AniVO.adopt_Ani_Id}</font>
	</td>
	<td>
		<font color=orange>${adopt_ani_sponsorVO.memVO.mem_Id}</font>
	</td>
			<td>${adopt_ani_sponsorVO.ado_Ani_Spo_money}</td>			<td>${adopt_ani_sponsorVO.ado_Ani_Spo_thing}</td>			<td>${adopt_ani_sponsorVO.ado_Ani_Spo_time}</td>
    </tr>
</table>
</body>
</html>        
