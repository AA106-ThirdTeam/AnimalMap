<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.second_prodmsg.model.*"%>
<%
Second_ProdMsgVO second_prodmsgVO = (Second_ProdMsgVO) request.getAttribute("second_prodmsgVO");
%>
<html>
<head>
<title>二手商品留言新增 - addSecond_ProdMsg.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
</head>
<body bgcolor='white'>
<!--  -->
<div id="popupcalendar" class="text"></div>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>二手商品留言新增 - addSecond_ProdMsg.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/second_prodmsg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>二手商品留言:</h3>
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
<FORM METHOD="post" ACTION="second_prodmsg.do" name="form1">
<table border="0">
	<jsp:useBean id="second_prodSvc" scope="page" class="heibernate_com.second_prod.model.Second_ProdService" />
	<tr>
		<td>二手商品編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="second_Prod_Id">
			<c:forEach var="second_prodVO" items="${second_prodSvc.all}">
				<option value="${second_prodVO.second_Prod_Id}" ${(second_prodmsgVO.second_prodVO.second_Prod_Id==second_prodVO.second_Prod_Id)? 'selected':'' } >${second_prodVO.second_Prod_Id}
			</c:forEach>
		</select></td>
	</tr>
	<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>留言會員編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="memVO" items="${memSvc.all}">
				<option value="${memVO.mem_Id}" ${(second_prodmsgVO.memVO.mem_Id==memVO.mem_Id)? 'selected':'' } >${memVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>二手商品留言:</td>
		<td><input type="TEXT" name="second_ProdMsg_Msg" size="45"
			value="<%= (second_prodmsgVO==null)? "1" : second_prodmsgVO.getSecond_ProdMsg_Msg()%>" /></td>
	</tr>	
	<tr>
		<%java.sql.Date date_second_ProdMsg_DATE = new java.sql.Date(System.currentTimeMillis());%>
		<td>留言發布日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="second_ProdMsg_DATE" value="<%= (second_prodmsgVO==null)? date_second_ProdMsg_DATE : second_prodmsgVO.getSecond_ProdMsg_DATE()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','second_ProdMsg_DATE','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="留言發布日期"></a>
		</td>
	</tr>
	<tr>
		<%java.sql.Date date_second_ProdMsg_adp_upDate = new java.sql.Date(System.currentTimeMillis());%>
		<td>留言更新日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="second_ProdMsg_adp_upDate" value="<%= (second_prodmsgVO==null)? date_second_ProdMsg_adp_upDate : second_prodmsgVO.getSecond_ProdMsg_adp_upDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','second_ProdMsg_adp_upDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="留言更新日期"></a>
		</td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
