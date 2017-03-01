<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.animal_index.model.*"%>
<%
    Animal_indexVO animal_indexVO = (Animal_indexVO) request.getAttribute("animal_indexVO"); //Animal_indexServlet.java (Concroller), 存入req的animal_indexVO物件 (包括幫忙取出的animal_indexVO, 也包括輸入資料錯誤時的animal_indexVO物件)
%>
<!--  -->
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
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<title>動物圖鑑資料修改 - update_animal_index_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>動物圖鑑資料 - ListOneAnimal_index.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/animal_index/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="animal_index.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>圖鑑編號編號:<font color=red><b>*</b></font></td>
        <td><%=animal_indexVO.getAnimal_No()%></td>
    </tr>
    <tr>
        <td>圖鑑敘述:</td>
        <td><input type="TEXT" name="animal_detail" size="45" value="<%=animal_indexVO.getAnimal_detail()%>" /></td>
    </tr>
    <tr>
        <td>圖鑑類別:</td>
        <td><input type="TEXT" name="animal_class" size="45" value="<%=animal_indexVO.getAnimal_class()%>" /></td>
    </tr>
    <tr>
        <td>圖鑑類別照片編號:</td>
        <td><input type="TEXT" name="animal_class_No" size="45" value="<%=animal_indexVO.getAnimal_class_No()%>" /></td>
    </tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="animal_No" value="<%=animal_indexVO.getAnimal_No()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllAnimal_index.jsp 與 複合查詢 listAnimal_indexs_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
