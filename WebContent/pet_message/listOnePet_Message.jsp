 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.pet_message.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Pet_MessageServlet.java已存入request的Pet_MessageVO物件--%>
<%Pet_MessageVO pet_messageVO = (Pet_MessageVO) request.getAttribute("pet_messageVO");%>

<html>
<head>
<title>自家寵物留言資料 - listOnePet_Message.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>自家寵物留言資料 - ListOnePet_Message.jsp</h3>
        <a href="<%=request.getContextPath()%>/pet_message/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>寵物留言編號</th>
		<th>寵物編號</th>
		<th>發布者會員編號</th>
		<th>寵物留言</th>
		<th>發布時間</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${pet_messageVO.pet_Mes_No}</td>
			<td>${pet_messageVO.pet_Id}</td>
			<td>${pet_messageVO.mem_Id}</td>
			<td>${pet_messageVO.pet_Mes}</td>
			<td>${pet_messageVO.pet_Mes_time}</td>
    
    </tr>
</table>

</body>
</html>        
