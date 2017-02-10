	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.priv_message.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Priv_messageServlet.java已存入request的Priv_messageVO物件--%>
<%Priv_messageVO priv_messageVO = (Priv_messageVO) request.getAttribute("priv_messageVO");%>


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
<title>私人訊息資料 - listOnePriv_message.jsp</title>

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
        <h3>私人訊息資料 - ListOnePriv_message.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/priv_message/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>AdpPhotos</th>		<th>發送會員編號</th>		<th>接收會員編號</th>		<th>訊息內容</th>		<th>發送時間</th>		<th>訊息類別</th>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${priv_messageVO.privMes_Id}</td>			<td>${priv_messageVO.privMesSend_MemId}</td>			<td>${priv_messageVO.privMesRec_MemId}</td>			<td>${priv_messageVO.privMes_content}</td>			<td>${priv_messageVO.privMes_SendTime}</td>			<td>${priv_messageVO.privMes_type}</td> 
    </tr>
</table>

</body>
</html>        
