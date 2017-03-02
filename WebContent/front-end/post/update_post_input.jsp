<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.post.controller.*"%>>
<%
	PostVO postVO = (PostVO) request.getAttribute("postVO");
	System.out.println("postVO : " + postVO);
	//PostServlet.java (Concroller), 存入req的postVO物件 (包括幫忙取出的postVO, 也包括輸入資料錯誤時的postVO物件)
%>

<jsp:useBean id="postSvc" scope="page" class="com.post.model.PostService" />

<html>
<head>
<title>文章資料修改 - update_post_input.jsp</title>
</head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>文章資料修改 - update_post_input.jsp</h3> <a
				href="<%=request.getContextPath()%>/select_page.jsp"><img
					src="images/back1.gif" width="200" height="32" border="0">回首頁</a>
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
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/post/post.do" name="form1">
<table border="0">
	<tr>
		<td>文章編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="post_Id">
			<c:forEach var="postVO" items="${postSvc.all}">
				<option value="${postVO.post_Id}">${postVO.post_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>會員編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="postVO" items="${postSvc.all}">
				<option value="${postVO.mem_Id}">${postVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>文章分類:<font color=red><b>*</b></font></td>
		<td><select size="1" name="post_class_Id$post_class">
			<option value="1-自介"${(param.post_class_Id$post_class=='1-自介')? 'selected':'' }>自介
			<option value="2-請問"${(param.post_class_Id$post_class=='2-請問')? 'selected':'' }>請問
			<option value="3-資訊"${(param.post_class_Id$post_class=='3-資訊')? 'selected':'' }>資訊
			<option value="4-推薦"${(param.post_class_Id$post_class=='4-推薦')? 'selected':'' }>推薦
			<option value="5-認養"${(param.post_class_Id$post_class=='5-認養')? 'selected':'' }>認養
			<option value="6-協尋"${(param.post_class_Id$post_class=='6-協尋')? 'selected':'' }>協尋
			<option value="7-捨獲"${(param.post_class_Id$post_class=='7-捨獲')? 'selected':'' }>捨獲
			<option value="8-心得"${(param.post_class_Id$post_class=='8-心得')? 'selected':'' }>心得
		</select></td>
	</tr>
	<tr>
		<td>文章標題:</td>
		<td><input type="TEXT" name="post_title" size="45"
			onfocus="if(value =='請輸入標題'){value=''}"
			onblur="if(value ==''){value='請輸入標題'}"
			value="<%=(postVO == null) ? "請輸入標題" : postVO.getPost_title()%>" />
		</td>
	</tr>
	<tr>
		<td>文章內容</td>
		<td><textarea rows="10" name="post_content" class="content"
			value="<%=(postVO == null) ? "" : postVO.getPost_content()%>"></textarea></td>
	</tr>
	
	<tr>
			<%	
				java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());
			%>
		<td style="display:none">發布時間:</td>
			<td>
		    	<input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="hidden" 
		    	name="post_time" value="<%= (postVO==null)? date_SQL :  postVO.getPost_time()%>">
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
		    	name="post_upDate" value="<%= (postVO==null)? date_SQL1 :  postVO.getPost_upDate()%>">
			    <a class="so-BtnLink" href="javascript:calClick();return false;"
			      onmouseover="calSwapImg('BTN_date1', 'img_Date_OVER',true);"
			      onmouseout="calSwapImg('BTN_date1', 'img_Date_UP',true);"
			      onclick="calSwapImg('BTN_date1', 'img_Date_DOWN');showCalendar('form1','post_upDate','BTN_date');return false;">
		       </a>
		 </td>
	</tr>

	<tr>
				<td>回覆數量:</td>
				<td><input type="TEXT" name="post_resNum" size="4"
					value="<%=postVO.getPost_resNum()%>" /></td>
			</tr>

</table>
<br>
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="post_Id" value="${postVO.post_Id}">
	
	<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
	<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--只用於:istAllPost.jsp-->
	<input type="submit" value="送出修改"></FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
   <font color=blue>request.getParameter("whichPage"):</font> <%= request.getParameter("whichPage")%> (此範例目前只用於:istAllEmp.jsp))</b>
	

</body>
</html>