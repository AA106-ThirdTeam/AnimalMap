	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hosphoto.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller HosPhotoServlet.java已存入request的HosPhotoVO物件--%>
<%HosPhotoVO hosphotoVO = (HosPhotoVO) request.getAttribute("hosphotoVO");%>


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
<title>診所相片資料 - listOneHosPhoto.jsp</title>

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
        <h3>診所相片資料 - ListOneHosPhoto.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/hosphoto/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>相片編號</th>		<th>診所編號(相片擁有診所)</th>		<th>相片</th>		<th>是否為大頭貼相片</th>		<th>相片名稱</th>		<th>相片副檔名</th>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${hosphotoVO.hosPhoto_Id}</td>			<td>${hosphotoVO.hosPhoto_HosId}</td>			<td>${hosphotoVO.hosPhoto_photo}</td>			<td>${hosphotoVO.isDisp_HosPhoto}</td>			<td>${hosphotoVO.hosPhoto_name}</td>			<td>${hosphotoVO.hosPhoto_extent}</td> 
    </tr>
</table>

</body>
</html>        
