 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.purview.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller PurviewServlet.java已存入request的PurviewVO物件--%>
<%PurviewVO purviewVO = (PurviewVO) request.getAttribute("purviewVO");%>

<html>
<head>
<title>權限資料 - listOnePurview.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>權限資料 - ListOnePurview.jsp</h3>
        <a href="<%=request.getContextPath()%>/purview/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>權限編號</th>
		<th>權限名稱</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${purviewVO.purview_No}</td>
			<td>${purviewVO.pruview_name}</td>
    
    </tr>
</table>

</body>
</html>        
