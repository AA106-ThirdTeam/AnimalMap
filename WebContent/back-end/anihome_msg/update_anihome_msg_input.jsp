<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.anihome_msg.model.*"%>
<%
    AniHome_MsgVO anihome_msgVO = (AniHome_MsgVO) request.getAttribute("anihome_msgVO"); //AniHome_MsgServlet.java (Concroller), 存入req的anihome_msgVO物件 (包括幫忙取出的anihome_msgVO, 也包括輸入資料錯誤時的anihome_msgVO物件)
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
	<title>動物之家留言資料修改 - update_anihome_msg_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
	<%@include file="/back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>動物之家留言資料 - ListOneAniHome_Msg.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/anihome_msg/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="anihome_msg.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>動物之家留言編號編號:<font color=red><b>*</b></font></td>
        <td><%=anihome_msgVO.getAniHome_Msg_Id()%></td>
    </tr>
<jsp:useBean id="aniHomeSvc" scope="page" class="heibernate_com.anihome.model.AniHomeService" />
	<tr>
		<td>動物之家編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="aniHome_Id">
	         <c:forEach var="aniHomeVO" items="${aniHomeSvc.all}" > 
				<option value="${aniHomeVO.aniHome_Id}" ${(anihome_msgVO.aniHomeVO.aniHome_Id==aniHomeVO.aniHome_Id)?'selected':'' } >
<font color=orange>${aniHomeVO.aniHome_title}</font>				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>留言會員編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(anihome_msgVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
<font color=orange>${memVO.mem_name}</font>-<font color=black>${memVO.mem_nick_name}</font>				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
    <tr>
        <td>動物之家留言:</td>
        <td><input type="TEXT" name="aniHome_Msg" size="45" value="<%=anihome_msgVO.getAniHome_Msg()%>" /></td>
    </tr>
	<tr>
		<td>留言發布日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="adp_start_date" value="<%=anihome_msgVO.getAdp_start_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','adp_start_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/back-end/images/btn_date_up.gif" width="22" height="17" alt="留言發布日期"></a>
		</td>
	</tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="aniHome_Msg_Id" value="<%=anihome_msgVO.getAniHome_Msg_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllAniHome_Msg.jsp 與 複合查詢 listAniHome_Msgs_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
