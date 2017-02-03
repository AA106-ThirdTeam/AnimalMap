 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adpmsg.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller AdpMsgServlet.java已存入request的AdpMsgVO物件--%>
<%AdpMsgVO adpmsgVO = (AdpMsgVO) request.getAttribute("adpmsgVO");%>

<html>
<head>
<title>領養活動留言資料 - listOneAdpMsg.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>領養活動留言資料 - ListOneAdpMsg.jsp</h3>
        <a href="<%=request.getContextPath()%>/adpmsg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>領養活動留言編號</th>
		<th>領養活動編號</th>
		<th>留言會員編號</th>
		<th>領養活動留言</th>
		<th>留言發布日期</th>
		<th>留言更新日期</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${adpmsgVO.adpMsg_Id}</td>
			<td>${adpmsgVO.adp_Id}</td>
			<td>${adpmsgVO.mem_Id}</td>
			<td>${adpmsgVO.msg}</td>
			<td>${adpmsgVO.adpMsgDate}</td>
			<td>${adpmsgVO.adpMsgadp_upDate}</td>
    
    </tr>
</table>

</body>
</html>        
