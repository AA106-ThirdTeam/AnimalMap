 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pet_photos.model.*"%>
<%
    Pet_PhotosVO pet_photosVO = (Pet_PhotosVO) request.getAttribute("pet_photosVO"); //Pet_PhotosServlet.java (Concroller), 存入req的pet_photosVO物件 (包括幫忙取出的pet_photosVO, 也包括輸入資料錯誤時的pet_photosVO物件)
%>

<!--  -->

<html>
<head>
<title>自家寵物相簿資料修改 - update_pet_photos_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>自家寵物相簿資料 - ListOnePet_Photos.jsp</h3>
        <a href="<%=request.getContextPath()%>/pet_photos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
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

<FORM METHOD="post" ACTION="pet_photos.do" name="form1">
    <table border="0">

    <!--  -->
        <tr>
        <td>寵物相片編號編號:<font color=red><b>*</b></font></td>
        <td><%=pet_photosVO.getPet_Pic_No()%></td>
    </tr>
    <tr>
        <td>寵物編號:</td>
        <td><input type="TEXT" name="pet_Id" size="45" value="<%=pet_photosVO.getPet_Id()%>" /></td>
    </tr>
    <tr>
        <td>發布者會員編號:</td>
        <td><input type="TEXT" name="mem_Id" size="45" value="<%=pet_photosVO.getMem_Id()%>" /></td>
    </tr>
	<tr>
		<td>寵物相片:</td>
		<td><input type="file" name="pet_Pic" size=45></td>
	</tr>
    <tr>
        <td>寵物相片檔名:</td>
        <td><input type="TEXT" name="pet_Pic_name" size="45" value="<%=pet_photosVO.getPet_Pic_name()%>" /></td>
    </tr>
    <tr>
        <td>寵物相片副檔名:</td>
        <td><input type="TEXT" name="pet_Pic_extent" size="45" value="<%=pet_photosVO.getPet_Pic_extent()%>" /></td>
    </tr>
	<tr>
		<td>發布時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="pet_Pic_time" value="<%=pet_photosVO.getPet_Pic_time()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','pet_Pic_time','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="發布時間"></a>
		</td>
	</tr>
    <tr>
        <td>相片類型:</td>
        <td><input type="TEXT" name="pet_Pic_type" size="45" value="<%=pet_photosVO.getPet_Pic_type()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="pet_Pic_No" value="<%=pet_photosVO.getPet_Pic_No()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllPet_Photos.jsp 與 複合查詢 listPet_Photoss_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
