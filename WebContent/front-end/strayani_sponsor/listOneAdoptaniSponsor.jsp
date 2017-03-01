<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani_message.model.*"%>
<%@ page import="com.chung.tools.Tools"%>

<%
	Tools tools = new Tools();
%>
<%=session.getAttribute("adoptaniSponsorVO") %>
 <br>
<%=request.getAttribute("adoptaniSponsorVO") %>
<jsp:useBean id="adoptaniSponsorVO" scope="request"	class="com.adoptani_sponsor.model.AdoptaniSponsorVO" />


<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<title>送養動物留言 - listOneAdoptaniSponsor.jsp</title>
</head>
<body bgcolor='white'>
	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>單筆送養動物留言 - listOneAdoptaniSponsor.jsp</h3> <a
				href="select_page.jsp"><img src="images/back1.gif" width="100"
					height="32" border="0">回首頁</a>
			</td>
		</tr>
	</table>





	<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>送養動物贊助編號</th>
		<th>送養動物編號</th>
		<th>贊助者會員編號</th>
		<th>送養動物贊助金額</th>
		<th>送養動物贊助物資</th>
		<th>送養動物動物贊助時間</th>
	</tr>
	
		<tr align='center' valign='middle'>
			<td>${adoptaniSponsorVO.ado_Ani_Spo_No}</td> 
			<td>${adoptaniSponsorVO.adopt_Ani_Id}</td>
			<td>${adoptaniSponsorVO.mem_Id}</td>
			<td>${adoptaniSponsorVO.ado_Ani_Spo_money}</td>
			<td>${adoptaniSponsorVO.ado_Ani_Spo_thing}</td>
			<td>${adoptaniSponsorVO.ado_Ani_Spo_time}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_sponsor/AdoptaniSponsorServlet.do">
			     <input type="submit" value="修改">
			     <input type="hidden" name="ado_Ani_Spo_No" value="${adoptaniSponsorVO.ado_Ani_Spo_No}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_sponsor/AdoptaniSponsorServlet.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="ado_Ani_Spo_No" value="${adoptaniSponsorVO.ado_Ani_Spo_No}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>

		</tr>

	</table>









	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>



