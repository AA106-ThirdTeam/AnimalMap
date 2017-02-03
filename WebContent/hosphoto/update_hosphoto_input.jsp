 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hosphoto.model.*"%>
<%
    HosPhotoVO hosphotoVO = (HosPhotoVO) request.getAttribute("hosphotoVO"); //HosPhotoServlet.java (Concroller), 存入req的hosphotoVO物件 (包括幫忙取出的hosphotoVO, 也包括輸入資料錯誤時的hosphotoVO物件)
%>

<!--  -->

<html>
<head>
<title>診所相片資料修改 - update_hosphoto_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>診所相片資料 - ListOneHosPhoto.jsp</h3>
        <a href="<%=request.getContextPath()%>/hosphoto/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
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

<FORM METHOD="post" ACTION="hosphoto.do" name="form1">
    <table border="0">

    <!--  -->
        <tr>
        <td>相片編號編號:<font color=red><b>*</b></font></td>
        <td><%=hosphotoVO.getHosPhoto_Id()%></td>
    </tr>
    <tr>
        <td>診所編號(相片擁有診所):</td>
        <td><input type="TEXT" name="hosPhoto_HosId" size="45" value="<%=hosphotoVO.getHosPhoto_HosId()%>" /></td>
    </tr>
	<tr>
		<td>相片:</td>
		<td><input type="file" name="hosPhoto_photo" size=45></td>
	</tr>
    <tr>
        <td>是否為大頭貼相片:</td>
        <td><input type="TEXT" name="isDisp_HosPhoto" size="45" value="<%=hosphotoVO.getIsDisp_HosPhoto()%>" /></td>
    </tr>
    <tr>
        <td>相片名稱:</td>
        <td><input type="TEXT" name="hosPhoto_name" size="45" value="<%=hosphotoVO.getHosPhoto_name()%>" /></td>
    </tr>
    <tr>
        <td>相片副檔名:</td>
        <td><input type="TEXT" name="hosPhoto_extent" size="45" value="<%=hosphotoVO.getHosPhoto_extent()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="hosPhoto_Id" value="<%=hosphotoVO.getHosPhoto_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllHosPhoto.jsp 與 複合查詢 listHosPhotos_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
