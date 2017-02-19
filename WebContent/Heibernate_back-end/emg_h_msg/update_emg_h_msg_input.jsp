<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.emg_h_msg.model.*"%>
<%
    Emg_H_MsgVO emg_h_msgVO = (Emg_H_MsgVO) request.getAttribute("emg_h_msgVO"); //Emg_H_MsgServlet.java (Concroller), 存入req的emg_h_msgVO物件 (包括幫忙取出的emg_h_msgVO, 也包括輸入資料錯誤時的emg_h_msgVO物件)
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
	<title>緊急求救留言資料修改 - update_emg_h_msg_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>緊急求救留言資料 - ListOneEmg_H_Msg.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="emg_h_msg.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>緊急求救留言編號編號:<font color=red><b>*</b></font></td>
        <td><%=emg_h_msgVO.getEmg_H_Msg_Id()%></td>
    </tr>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>留言會員編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(emg_h_msgVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
${memVO.mem_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
<jsp:useBean id="emg_HSvc" scope="page" class="heibernate_com.emg_h.model.Emg_HService" />
	<tr>
		<td>求救編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="emg_H_Id">
	         <c:forEach var="emg_HVO" items="${emg_HSvc.all}" > 
				<option value="${emg_HVO.emg_H_Id}" ${(emg_h_msgVO.emg_HVO.emg_H_Id==emg_HVO.emg_H_Id)?'selected':'' } >
${emg_HVO.emg_H_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
	<tr>
		<td>發布時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emg_H_Msg_start" value="<%=emg_h_msgVO.getEmg_H_Msg_start()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emg_H_Msg_start','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="發布時間"></a>
		</td>
	</tr>
    <tr>
        <td>留言內容:</td>
        <td><input type="TEXT" name="emg_H_Msg_content" size="45" value="<%=emg_h_msgVO.getEmg_H_Msg_content()%>" /></td>
    </tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="emg_H_Msg_Id" value="<%=emg_h_msgVO.getEmg_H_Msg_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllEmg_H_Msg.jsp 與 複合查詢 listEmg_H_Msgs_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
