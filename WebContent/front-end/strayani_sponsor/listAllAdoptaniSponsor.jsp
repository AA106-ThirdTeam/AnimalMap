<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani_sponsor.model.*"%>
<%@ page import="com.chung.tools.Tools"%>


<%-- 取得Service物件，調用DAO裡面的getAll()，取資料庫此Table的每筆資料。 --%>
<%
	AdoptaniSponsorService adoptaniSponsorSvc = new AdoptaniSponsorService();
    List<AdoptaniSponsorVO> list = adoptaniSponsorSvc.getAllSponsor();
    pageContext.setAttribute("list",list);	//要放到scope裡面才找得到(看得到吃不到之一)。
%>

<html>
<head>
<title>所有送養動物留言資料 - listAllAdoptaniMessage.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>所有送養動物資料 - listAllAdoptaniSponsor.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

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

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>送養動物贊助編號</th>
		<th>送養動物編號</th>
		<th>贊助者會員編號</th>
		<th>送養動物贊助金額</th>
		<th>送養動物贊助物資</th>
		<th>送養動物動物贊助時間</th>
	</tr>
	
	<%@ include file="page1.file" %> 

	<c:forEach var="AdoptaniSponsorVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle' ${(AdoptaniSponsorVO.ado_Ani_Spo_No == param.ado_Ani_Spo_No ) ? 'bgcolor=#CCCCFF':''}>
			<td>${AdoptaniSponsorVO.ado_Ani_Spo_No}</td> 
			<td>${AdoptaniSponsorVO.adopt_Ani_Id}</td>
			<td>${AdoptaniSponsorVO.mem_Id}</td>
			<td>${AdoptaniSponsorVO.ado_Ani_Spo_money}</td>
			<td>${AdoptaniSponsorVO.ado_Ani_Spo_thing}</td>
			<td>${AdoptaniSponsorVO.ado_Ani_Spo_time}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_sponsor/AdoptaniSponsorServlet.do">
			     <input type="submit" value="修改">
			     <input type="hidden" name="ado_Ani_Spo_No" value="${AdoptaniSponsorVO.ado_Ani_Spo_No}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_sponsor/AdoptaniSponsorServlet.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="ado_Ani_Spo_No" value="${AdoptaniSponsorVO.ado_Ani_Spo_No}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
			     
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>


<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
<br>




</body>
</html>