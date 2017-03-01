<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani_message.model.*"%>
<%@ page import="com.chung.tools.Tools"%>

<%
	Tools tools = new Tools();
%>
<%=session.getAttribute("adoptaniMessageVO") %>
 <br>
<%=request.getAttribute("adoptaniMessageVO") %>
<jsp:useBean id="adoptaniMessageVO" scope="request"	class="com.adoptani_message.model.AdoptaniMessageVO" />
<%-- <% --%>
// 	AdoptaniMessageVO adoptaniMessageVO = null;
// 	if(session.getAttribute("adoptaniMessageVO") != null){
// 		adoptaniMessageVO = (AdoptaniMessageVO) session.getAttribute("adoptaniMessageVO");
// 	}else{
// 		adoptaniMessageVO = (AdoptaniMessageVO) request.getAttribute("adoptaniMessageVO");
// 	}

<%-- %> --%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<title>送養動物留言 - listOneAdoptaniMessage.jsp</title>
</head>
<body bgcolor='white'>
	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>單筆送養動物留言 - listOneAdoptaniMessage.jsp</h3> <a
				href="select_page.jsp"><img src="images/back1.gif" width="100"
					height="32" border="0">回首頁</a>
			</td>
		</tr>
	</table>





	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
			<th>送養動物留言編號</th>
			<th>送養動物編號</th>
			<th>發布者會員編號</th>
			<th>送養動物動物留言時間</th>
			<th>送養動物留言內容</th>

		</tr>
		<tr align='center' valign='middle'>
			<td>${adoptaniMessageVO.ado_Ani_Mes_No}</td>
			<td>${adoptaniMessageVO.adopt_Ani_Id}</td>
			<td>${adoptaniMessageVO.mem_Id}</td>
			<td>${adoptaniMessageVO.ado_Ani_Mes_time}</td>
			<td>${adoptaniMessageVO.ado_Ani_Mes}</td>
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_message/AdoptaniMessageServlet.do">
					<input type="submit" value="修改"> 
					<input type="hidden" name="ado_Ani_Mes_No" value="<%=adoptaniMessageVO.getAdo_Ani_Mes_No()%>"> 
						<input type="hidden" name="adopt_Ani_Id" value="<%=adoptaniMessageVO.getAdopt_Ani_Id()%>"> 
						<input type="hidden" name="mem_Id" value="<%=adoptaniMessageVO.getMem_Id()%>"> 
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
						<input type="hidden" name="action" value="getOne_For_Update">
				</FORM>
			</td>
			<td>
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/front-end/adoptani_message/AdoptaniMessageServlet.do">
					<input type="submit" value="刪除"> 
					<input type="hidden" name="adopt_Ani_Id" value="${adoptaniVO.adopt_Ani_Id}"> 
					<input type="hidden" name="action" value="delete">
				</FORM>
			</td>

		</tr>

	</table>









	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>



