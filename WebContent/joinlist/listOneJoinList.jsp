 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.joinlist.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller JoinListServlet.java已存入request的JoinListVO物件--%>
<%JoinListVO joinlistVO = (JoinListVO) request.getAttribute("joinlistVO");%>

<html>
<head>
<title>揪團參加名單資料 - listOneJoinList.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>揪團參加名單資料 - ListOneJoinList.jsp</h3>
        <a href="<%=request.getContextPath()%>/joinlist/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>活動編號</th>
		<th>會員編號(參加者)</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${joinlistVO.joinList_GrpId}</td>
			<td>${joinlistVO.joinList_MemId}</td>
    
    </tr>
</table>

</body>
</html>        
