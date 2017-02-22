<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.post_Response.model.*"%>
<%
Post_ResponseVO post_ResponseVO = (Post_ResponseVO) request.getAttribute("post_ResponseVO");
 //Post_ResponseServlet.java (Concroller), 存入req的post_ResponseVO物件 (包括幫忙取出的post_ResponseVO, 也包括輸入資料錯誤時的post_ResponseVO物件)
%>
<html>
<head>
<title>回覆留言資料修改 - update_post_Response_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>回覆留言資料修改 - update_post_Response_input.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="200" height="32" border="0">回首頁</a></td>
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/post_Response/post_Response.do" name="form1">
<table border="0">
	<tr>
		<td>回覆編號:<font color=red><b>*</b></font></td>
		<td><%=post_ResponseVO.getRes_Id()%></td>
	</tr>
	<tr>
		<td>會員編號:</td>
		<td><input type="TEXT" name="mem_Id" size="45" 
			value="<%= (post_ResponseVO==null)? "7001" : post_ResponseVO.getMem_Id()%>" /></td>
	</tr>
	<tr>
		<td>文章編號:</td>
		<td><input type="TEXT" name="post_Id" size="45"
			value="<%= (post_ResponseVO==null)? "10001" : post_ResponseVO.getPost_Id()%>" /></td>
	</tr>
	<tr>
		<td>文章留言內容:</td>
			<td><textarea rows="10" name="post_Response_content" id="content"
					value="<%=(post_ResponseVO==null) ? "" : post_ResponseVO.getPost_Response_content()%>"></textarea></td>
	</tr>
	
	<tr>
			<%	
				java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());
			%>
		<td style="display:none">發布時間:</td>
			<td >
		    	<input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="hidden" 
		    	name="post_time" value="<%= (post_ResponseVO==null)? date_SQL :  post_ResponseVO.getPost_time()%>">
			    <a class="so-BtnLink" href="javascript:calClick();return false;"
			      onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			      onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			      onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','post_time','BTN_date');return false;">
		        </a>
		 	</td>
	</tr>
	<tr>
			<%
				java.sql.Date date_SQL1 = new java.sql.Date(System.currentTimeMillis());
			%>
		<td>修改時間:</td>
			<td>
		    	<input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="text" 
		    	name="post_Response_upDate" value="<%= (post_ResponseVO==null)? date_SQL1 :  post_ResponseVO.getPost_Response_upDate()%>">
			    <a class="so-BtnLink" href="javascript:calClick();return false;"
			      onmouseover="calSwapImg('BTN_date1', 'img_Date_OVER',true);"
			      onmouseout="calSwapImg('BTN_date1', 'img_Date_UP',true);"
			      onclick="calSwapImg('BTN_date1', 'img_Date_DOWN');showCalendar('form1','post_Response_upDate','BTN_date');return false;">
		        </a>
		    </td>
	</tr>


</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="res_Id" value="<%=post_ResponseVO.getRes_Id()%>">
<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--只用於:istAllEmp.jsp-->
<input type="submit" value="送出修改"></FORM>


<font color=blue>request.getParameter("requestURL"):</font> <%=request.getParameter("requestURL")%><br>
		<font color=blue>request.getParameter("whichPage"): </font> <%=request.getParameter("whichPage")%>
</body>
</html>
