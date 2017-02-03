 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.emp_purview.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Emp_purviewServlet.java已存入request的Emp_purviewVO物件--%>
<%Emp_purviewVO emp_purviewVO = (Emp_purviewVO) request.getAttribute("emp_purviewVO");%>

<html>
<head>
<title>員工權限資料 - listOneEmp_purview.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>員工權限資料 - ListOneEmp_purview.jsp</h3>
        <a href="<%=request.getContextPath()%>/emp_purview/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>員工編號</th>
		<th>權限編號</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${emp_purviewVO.emp_No}</td>
			<td>${emp_purviewVO.purview_No}</td>
    
    </tr>
</table>

</body>
</html>        
