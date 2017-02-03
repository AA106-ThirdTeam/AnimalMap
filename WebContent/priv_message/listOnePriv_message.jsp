 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.priv_message.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Priv_messageServlet.java已存入request的Priv_messageVO物件--%>
<%Priv_messageVO priv_messageVO = (Priv_messageVO) request.getAttribute("priv_messageVO");%>

<html>
<head>
<title>私人訊息資料 - listOnePriv_message.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>私人訊息資料 - ListOnePriv_message.jsp</h3>
        <a href="<%=request.getContextPath()%>/priv_message/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>訊息編號</th>
		<th>發送會員編號</th>
		<th>接收會員編號</th>
		<th>訊息內容</th>
		<th>發送時間</th>
		<th>訊息類別</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${priv_messageVO.privMes_Id}</td>
			<td>${priv_messageVO.privMesSend_MemId}</td>
			<td>${priv_messageVO.privMesRec_MemId}</td>
			<td>${priv_messageVO.privMes_content}</td>
			<td>${priv_messageVO.privMes_SendTime}</td>
			<td>${priv_messageVO.privMes_type}</td>
    
    </tr>
</table>

</body>
</html>        
