<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.emg_help.model.*"%>
<%
    Emg_HelpVO emg_helpVO = (Emg_HelpVO) request.getAttribute("emg_helpVO"); //Emg_HelpServlet.java (Concroller), 存入req的emg_helpVO物件 (包括幫忙取出的emg_helpVO, 也包括輸入資料錯誤時的emg_helpVO物件)
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
	<title>緊急求救資料修改 - update_emg_help_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>緊急求救資料 - ListOneEmg_Help.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/emg_help/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="emg_help.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>求救編號編號:<font color=red><b>*</b></font></td>
        <td><%=emg_helpVO.getEmg_H_Id()%></td>
    </tr>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>發起人編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(emg_helpVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
${memVO.mem_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
	<tr>
		<td>開始時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emg_H_start_date" value="<%=emg_helpVO.getEmg_H_start_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emg_H_start_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="開始時間"></a>
		</td>
	</tr>
	<tr>
		<td>結束日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emg_H_end_date" value="<%=emg_helpVO.getEmg_H_end_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emg_H_end_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="結束日期"></a>
		</td>
	</tr>
    <tr>
        <td>求救標題:</td>
        <td><input type="TEXT" name="emg_H_title" size="45" value="<%=emg_helpVO.getEmg_H_title()%>" /></td>
    </tr>
    <tr>
        <td>求救內容:</td>
        <td><input type="TEXT" name="emg_H_content" size="45" value="<%=emg_helpVO.getEmg_H_content()%>" /></td>
    </tr>
	<tr>
		<td>照片:</td>
		<td><input type="file" name="emg_H_Pic" size=45></td>
	</tr>	
    <tr>
        <td>照片副檔名:</td>
        <td><input type="TEXT" name="emg_H_Pic_format" size="45" value="<%=emg_helpVO.getEmg_H_Pic_format()%>" /></td>
    </tr>
    <tr>
        <td>縣市:</td>
        <td><input type="TEXT" name="emg_H_city" size="45" value="<%=emg_helpVO.getEmg_H_city()%>" /></td>
    </tr>
    <tr>
        <td>鄉鎮市區:</td>
        <td><input type="TEXT" name="emg_H_town" size="45" value="<%=emg_helpVO.getEmg_H_town()%>" /></td>
    </tr>
    <tr>
        <td>道路街名村里:</td>
        <td><input type="TEXT" name="emg_H_road" size="45" value="<%=emg_helpVO.getEmg_H_road()%>" /></td>
    </tr>
    <tr>
        <td>緊急求救經度座標:</td>
        <td><input type="TEXT" name="emg_H_Lon" size="45" value="<%=emg_helpVO.getEmg_H_Lon()%>" /></td>
    </tr>
    <tr>
        <td>緊急求救緯度座標:</td>
        <td><input type="TEXT" name="emg_H_Lat" size="45" value="<%=emg_helpVO.getEmg_H_Lat()%>" /></td>
    </tr>
    <tr>
        <td>檢舉狀態:</td>
        <td><input type="TEXT" name="emg_H_status" size="45" value="<%=emg_helpVO.getEmg_H_status()%>" /></td>
    </tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="emg_H_Id" value="<%=emg_helpVO.getEmg_H_Id()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllEmg_Help.jsp 與 複合查詢 listEmg_Helps_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
