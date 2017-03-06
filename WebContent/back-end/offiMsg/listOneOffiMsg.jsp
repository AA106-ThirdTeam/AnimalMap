<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.offiMsg.model.*" %>

<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%OffiMsgVO offiMsgVO = (OffiMsgVO) request.getAttribute("offiMsgVO");%>

<html>
<head>
<title>訊息資料 - listOneOffiMsg.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>	
		<h3>訊息資料 - ListOneOffiMsg.jsp</h3>
		<a href="<%=request.getContextPath()%>/back-end/offiMsg/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>訊息編號</th>
		<th>發布員工</th>
		<th>訊息標題</th>
		<th>訊息內容</th>
	
	</tr>
	<tr align='center' valign='middle'>
	
		<td><%=offiMsgVO.getOffiMsg_Id()%></td>
		<td><%=offiMsgVO.getOffiMsg_empId()%></td>
		<td><%=offiMsgVO.getOffiMsg_Title()%></td>
		<td><%=offiMsgVO.getOffiMsg_Content()%></td>
		
	</tr>
</table>

</body>
</html>
