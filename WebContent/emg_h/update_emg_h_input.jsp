 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emg_h.model.*"%>
<%
    Emg_HVO emg_hVO = (Emg_HVO) request.getAttribute("emg_hVO"); //Emg_HServlet.java (Concroller), 存入req的emg_hVO物件 (包括幫忙取出的emg_hVO, 也包括輸入資料錯誤時的emg_hVO物件)
%>

<!--  -->

<html>
<head>
<title>緊急求救資料修改 - update_emg_h_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>緊急求救資料 - ListOneEmg_H.jsp</h3>
        <a href="<%=request.getContextPath()%>/emg_h/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
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

<FORM METHOD="post" ACTION="emg_h.do" name="form1">
    <table border="0">

    <!--  -->
        <tr>
        <td>求救編號編號:<font color=red><b>*</b></font></td>
        <td><%=emg_hVO.getEmg_H_Id()%></td>
    </tr>
    <tr>
        <td>發起人編號:</td>
        <td><input type="TEXT" name="mem_Id" size="45" value="<%=emg_hVO.getMem_Id()%>" /></td>
    </tr>
	<tr>
		<td>開始時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emg_H_start_date" value="<%=emg_hVO.getEmg_H_start_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emg_H_start_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="開始時間"></a>
		</td>
	</tr>
	<tr>
		<td>結束日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emg_H_end_date" value="<%=emg_hVO.getEmg_H_end_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emg_H_end_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="結束日期"></a>
		</td>
	</tr>
    <tr>
        <td>求救標題:</td>
        <td><input type="TEXT" name="emg_H_title" size="45" value="<%=emg_hVO.getEmg_H_title()%>" /></td>
    </tr>
    <tr>
        <td>求救內容:</td>
        <td><input type="TEXT" name="emg_H_content" size="45" value="<%=emg_hVO.getEmg_H_content()%>" /></td>
    </tr>
	<tr>
		<td>照片:</td>
		<td><input type="file" name="emg_H_Pic" size=45></td>
	</tr>
    <tr>
        <td>照片副檔名:</td>
        <td><input type="TEXT" name="emg_H_Pic_format" size="45" value="<%=emg_hVO.getEmg_H_Pic_format()%>" /></td>
    </tr>
    <tr>
        <td>縣市:</td>
        <td><input type="TEXT" name="emg_H_city" size="45" value="<%=emg_hVO.getEmg_H_city()%>" /></td>
    </tr>
    <tr>
        <td>鄉鎮市區:</td>
        <td><input type="TEXT" name="emg_H_town" size="45" value="<%=emg_hVO.getEmg_H_town()%>" /></td>
    </tr>
    <tr>
        <td>道路街名村里:</td>
        <td><input type="TEXT" name="emg_H_road" size="45" value="<%=emg_hVO.getEmg_H_road()%>" /></td>
    </tr>
    <tr>
        <td>緊急求救經度座標:</td>
        <td><input type="TEXT" name="emg_H_Lon" size="45" value="<%=emg_hVO.getEmg_H_Lon()%>" /></td>
    </tr>
    <tr>
        <td>緊急求救緯度座標:</td>
        <td><input type="TEXT" name="emg_H_Lat" size="45" value="<%=emg_hVO.getEmg_H_Lat()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="emg_H_Id" value="<%=emg_hVO.getEmg_H_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllEmg_H.jsp 與 複合查詢 listEmg_Hs_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
