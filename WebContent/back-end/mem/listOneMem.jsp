<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.mem.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller MemServlet.java已存入request的MemVO物件--%>
<%MemVO memVO = (MemVO) request.getAttribute("memVO");%>
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
<title>一般會員資料 - listOneMem.jsp</title>
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
        <h3>一般會員資料 - ListOneMem.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/mem/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>會員編號</b></td>		<td><b>帳號</b></td>		<td><b>信箱</b></td>		<td><b>密碼</b></td>		<td><b>會員暱稱</b></td>		<td><b>姓名</b></td>		<td><b>性別</b></td>		<td><b>身份證字號</b></td>		<td><b>出生年月日</b></td>		<td><b>手機</b></td>		<td><b>個人簡介</b></td>		<td><b>大頭照</b></td>		<td><b>黑名單</b></td>		<td><b>權限</b></td>		<td><b>偏好設定</b></td>		<td><b>餘額</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${memVO.mem_Id}</td>			<td>${memVO.mem_account}</td>			<td>${memVO.mem_email}</td>			<td>${memVO.mem_Psw}</td>			<td>${memVO.mem_nick_name}</td>			<td>${memVO.mem_name}</td>			<td>${memVO.mem_gender}</td>			<td>${memVO.mem_Tw_Id}</td>			<td>${memVO.mem_birth_date}</td>			<td>${memVO.mem_phone}</td>			<td>${memVO.mem_Intro}</td>			<td>${memVO.mem_profile}</td>			<td>${memVO.mem_black_list}</td>			<td>${memVO.mem_permission}</td>			<td>${memVO.mem_setting}</td>			<td>${memVO.mem_balance}</td>
    </tr>
</table>
</body>
</html>        
