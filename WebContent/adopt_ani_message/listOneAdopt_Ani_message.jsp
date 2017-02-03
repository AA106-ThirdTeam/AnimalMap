 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adopt_ani_message.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Adopt_Ani_messageServlet.java已存入request的Adopt_Ani_messageVO物件--%>
<%Adopt_Ani_messageVO adopt_ani_messageVO = (Adopt_Ani_messageVO) request.getAttribute("adopt_ani_messageVO");%>

<html>
<head>
<title>送養動物留言資料 - listOneAdopt_Ani_message.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>送養動物留言資料 - ListOneAdopt_Ani_message.jsp</h3>
        <a href="<%=request.getContextPath()%>/adopt_ani_message/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>送養動物留言編號</th>
		<th>社區動物編號</th>
		<th>送養動物會員編號</th>
		<th>送養動物留言</th>
		<th>發布時間</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${adopt_ani_messageVO.ado_Ani_Mes_No}</td>
			<td>${adopt_ani_messageVO.adopt_Ani_Id}</td>
			<td>${adopt_ani_messageVO.mem_Id}</td>
			<td>${adopt_ani_messageVO.ado_Ani_Mes}</td>
			<td>${adopt_ani_messageVO.ado_Ani_Mes_time}</td>
    
    </tr>
</table>

</body>
</html>        
