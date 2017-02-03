 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.post.model.*"%>
<%
    PostVO postVO = (PostVO) request.getAttribute("postVO"); //PostServlet.java (Concroller), 存入req的postVO物件 (包括幫忙取出的postVO, 也包括輸入資料錯誤時的postVO物件)
%>

<!--  -->

<html>
<head>
<title>討論區資料修改 - update_post_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>討論區資料 - ListOnePost.jsp</h3>
        <a href="<%=request.getContextPath()%>/post/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
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

<FORM METHOD="post" ACTION="post.do" name="form1">
    <table border="0">

    <!--  -->
        <tr>
        <td>文章編號編號:<font color=red><b>*</b></font></td>
        <td><%=postVO.getPost_Id()%></td>
    </tr>
    <tr>
        <td>會員編號(發文者):</td>
        <td><input type="TEXT" name="mem_Id" size="45" value="<%=postVO.getMem_Id()%>" /></td>
    </tr>
    <tr>
        <td>文章分類:</td>
        <td><input type="TEXT" name="post_class" size="45" value="<%=postVO.getPost_class()%>" /></td>
    </tr>
    <tr>
        <td>文章分類編號:</td>
        <td><input type="TEXT" name="post_class_Id" size="45" value="<%=postVO.getPost_class_Id()%>" /></td>
    </tr>
    <tr>
        <td>文章標題:</td>
        <td><input type="TEXT" name="post_title" size="45" value="<%=postVO.getPost_title()%>" /></td>
    </tr>
    <tr>
        <td>文章內容:</td>
        <td><input type="TEXT" name="post_content" size="45" value="<%=postVO.getPost_content()%>" /></td>
    </tr>
	<tr>
		<td>發佈時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="post_time" value="<%=postVO.getPost_time()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','post_time','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="發佈時間"></a>
		</td>
	</tr>
	<tr>
		<td>修改時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="post_upDate" value="<%=postVO.getPost_upDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','post_upDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="修改時間"></a>
		</td>
	</tr>
    <tr>
        <td>回覆數量:</td>
        <td><input type="TEXT" name="post_resNum" size="45" value="<%=postVO.getPost_resNum()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="post_Id" value="<%=postVO.getPost_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllPost.jsp 與 複合查詢 listPosts_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
