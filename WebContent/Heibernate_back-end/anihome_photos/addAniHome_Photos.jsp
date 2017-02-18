<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.anihome_photos.model.*"%>
<%
AniHome_PhotosVO anihome_photosVO = (AniHome_PhotosVO) request.getAttribute("anihome_photosVO");
%>
<html>
<head>
<title>動物之家相簿新增 - addAniHome_Photos.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
</head>
<body bgcolor='white'>
<!--  -->
<div id="popupcalendar" class="text"></div>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>動物之家相簿新增 - addAniHome_Photos.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/anihome_photos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>動物之家相簿:</h3>
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
<FORM METHOD="post" ACTION="anihome_photos.do" name="form1">
<table border="0">
	<jsp:useBean id="anihomeSvc" scope="page" class="heibernate_com.anihome.model.AniHomeService" />
	<tr>
		<td>動物之家編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="aniHome_Id">
			<c:forEach var="anihomeVO" items="${anihomeSvc.all}">
				<option value="${anihomeVO.aniHome_Id}" ${(anihome_photosVO.anihomeVO.aniHome_Id==anihomeVO.aniHome_Id)? 'selected':'' } >${anihomeVO.aniHome_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>動物之家照片:</td>
		<td><input type="file" name="aniHome_Photos_pic" size=45></td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
