<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.strayani_message.model.*"%>
<%@ page import="com.chung.tools.Tools"%>

<%
	Tools tools = new Tools();
%>
<%=session.getAttribute("strayaniMessageVO") %>
 <br>
<%=request.getAttribute("strayaniMessageVO") %>
<jsp:useBean id="strayaniMessageVO" scope="request"	class="com.strayani_message.model.StrayaniMessageVO" />
<%-- <% --%>
// 	StrayaniMessageVO strayaniMessageVO = null;
// 	if(session.getAttribute("strayaniMessageVO") != null){
// 		strayaniMessageVO = (StrayaniMessageVO) session.getAttribute("strayaniMessageVO");
// 	}else{
// 		strayaniMessageVO = (StrayaniMessageVO) request.getAttribute("strayaniMessageVO");
// 	}

<%-- %> --%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<title>送養動物留言 - listOneStrayaniMessage.jsp</title>
</head>
<body bgcolor='white'>
	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>單筆送養動物留言 - listOneStrayaniMessage.jsp</h3> <a
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
			<td>${strayaniMessageVO.str_Ani_Mes_No}</td>
			<td>${strayaniMessageVO.stray_Ani_Id}</td>
			<td>${strayaniMessageVO.mem_Id}</td>
			<td>${strayaniMessageVO.str_Ani_Mes_time}</td>
			<td>${strayaniMessageVO.str_Ani_Mes}</td>
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/strayani_message/StrayaniMessageServlet.do">
					<input type="submit" value="修改"> 
					<input type="hidden" name="str_Ani_Mes_No" value="<%=strayaniMessageVO.getStr_Ani_Mes_No()%>"> 
						<input type="hidden" name="stray_Ani_Id" value="<%=strayaniMessageVO.getStray_Ani_Id()%>"> 
						<input type="hidden" name="mem_Id" value="<%=strayaniMessageVO.getMem_Id()%>"> 
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
						<input type="hidden" name="action" value="getOne_For_Update">
				</FORM>
			</td>
			<td>
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/front-end/strayani_message/StrayaniMessageServlet.do">
					<input type="submit" value="刪除"> 
					<input type="hidden" name="stray_Ani_Id" value="${strayaniVO.stray_Ani_Id}"> 
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



