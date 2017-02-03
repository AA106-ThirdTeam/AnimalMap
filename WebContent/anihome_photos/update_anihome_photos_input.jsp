 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.anihome_photos.model.*"%>
<%
    AniHome_PhotosVO anihome_photosVO = (AniHome_PhotosVO) request.getAttribute("anihome_photosVO"); //AniHome_PhotosServlet.java (Concroller), 存入req的anihome_photosVO物件 (包括幫忙取出的anihome_photosVO, 也包括輸入資料錯誤時的anihome_photosVO物件)
%>

<!--  -->

<html>
<head>
<title>動物之家相簿資料修改 - update_anihome_photos_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>動物之家相簿資料 - ListOneAniHome_Photos.jsp</h3>
        <a href="<%=request.getContextPath()%>/anihome_photos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<h3>資料修改:</h3>
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

    <!--  -->
        <tr>
        <td>相片編號編號:<font color=red><b>*</b></font></td>
        <td><%=anihome_photosVO.getAniHome_Photos_Id()%></td>
    </tr>
    <tr>
        <td>動物之家編號:</td>
        <td><input type="TEXT" name="aniHome_Id" size="45" value="<%=anihome_photosVO.getAniHome_Id()%>" /></td>
    </tr>
	<tr>
		<td>動物之家照片:</td>
		<td><input type="file" name="aniHome_Photos_pic" size=45></td>
	</tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="aniHome_Photos_Id" value="<%=anihome_photosVO.getAniHome_Photos_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllAniHome_Photos.jsp 與 複合查詢 listAniHome_Photoss_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
