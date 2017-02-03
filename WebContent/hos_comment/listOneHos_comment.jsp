 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hos_comment.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Hos_commentServlet.java已存入request的Hos_commentVO物件--%>
<%Hos_commentVO hos_commentVO = (Hos_commentVO) request.getAttribute("hos_commentVO");%>

<html>
<head>
<title>診所留言資料 - listOneHos_comment.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>診所留言資料 - ListOneHos_comment.jsp</h3>
        <a href="<%=request.getContextPath()%>/hos_comment/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>診所留言編號</th>
		<th>發送會員編號</th>
		<th>診所編號</th>
		<th>發送內容</th>
		<th>發送時間</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${hos_commentVO.hosComm_Id}</td>
			<td>${hos_commentVO.hosComm_MemId}</td>
			<td>${hos_commentVO.hosComm_HosId}</td>
			<td>${hos_commentVO.hosComm_content}</td>
			<td>${hos_commentVO.hosComm_SendTime}</td>
    
    </tr>
</table>

</body>
</html>        
