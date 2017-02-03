 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.anihome_msg.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller AniHome_MsgServlet.java已存入request的AniHome_MsgVO物件--%>
<%AniHome_MsgVO anihome_msgVO = (AniHome_MsgVO) request.getAttribute("anihome_msgVO");%>

<html>
<head>
<title>動物之家留言資料 - listOneAniHome_Msg.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>動物之家留言資料 - ListOneAniHome_Msg.jsp</h3>
        <a href="<%=request.getContextPath()%>/anihome_msg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>動物之家留言編號</th>
		<th>動物之家編號</th>
		<th>留言會員編號</th>
		<th>動物之家留言</th>
		<th>留言發布日期</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${anihome_msgVO.aniHome_Msg_Id}</td>
			<td>${anihome_msgVO.aniHome_Id}</td>
			<td>${anihome_msgVO.mem_Id}</td>
			<td>${anihome_msgVO.aniHome_Msg}</td>
			<td>${anihome_msgVO.adp_start_date}</td>
    
    </tr>
</table>

</body>
</html>        
