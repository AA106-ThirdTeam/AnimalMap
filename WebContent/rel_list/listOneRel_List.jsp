 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rel_list.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Rel_ListServlet.java已存入request的Rel_ListVO物件--%>
<%Rel_ListVO rel_listVO = (Rel_ListVO) request.getAttribute("rel_listVO");%>

<html>
<head>
<title>關係名單資料 - listOneRel_List.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>關係名單資料 - ListOneRel_List.jsp</h3>
        <a href="<%=request.getContextPath()%>/rel_list/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>會員編號</th>
		<th>被加會員編號</th>
		<th>是否為黑名單</th>
		<th>是否已被邀請至揪團</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${rel_listVO.rel_MemId}</td>
			<td>${rel_listVO.added_MemId}</td>
			<td>${rel_listVO.isBlackList}</td>
			<td>${rel_listVO.isInvited}</td>
    
    </tr>
</table>

</body>
</html>        
