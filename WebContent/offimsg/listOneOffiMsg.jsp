 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.offimsg.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller OffiMsgServlet.java已存入request的OffiMsgVO物件--%>
<%OffiMsgVO offimsgVO = (OffiMsgVO) request.getAttribute("offimsgVO");%>

<html>
<head>
<title>公告訊息資料 - listOneOffiMsg.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>公告訊息資料 - ListOneOffiMsg.jsp</h3>
        <a href="<%=request.getContextPath()%>/offimsg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>訊息編號</th>
		<th>發布員工編號</th>
		<th>訊息標題</th>
		<th>訊息內容</th>
		<th>訊息發布時間</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${offimsgVO.offiMsg_Id}</td>
			<td>${offimsgVO.offiMsg_empId}</td>
			<td>${offimsgVO.offiMsg_Title}</td>
			<td>${offimsgVO.offiMsg_Content}</td>
			<td>${offimsgVO.offiMsg_Date}</td>
    
    </tr>
</table>

</body>
</html>        
