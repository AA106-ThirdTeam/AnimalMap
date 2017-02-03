 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adoanispo.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller AdoAniSpoServlet.java已存入request的AdoAniSpoVO物件--%>
<%AdoAniSpoVO adoanispoVO = (AdoAniSpoVO) request.getAttribute("adoanispoVO");%>

<html>
<head>
<title>送養動物領養人資料 - listOneAdoAniSpo.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>送養動物領養人資料 - ListOneAdoAniSpo.jsp</h3>
        <a href="<%=request.getContextPath()%>/adoanispo/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>送養動物贊助編號</th>
		<th>送養動物編號</th>
		<th>贊助者會員編號</th>
		<th>贊助送養動物金額</th>
		<th>贊助送養動物物資</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${adoanispoVO.adoAniSpoNo}</td>
			<td>${adoanispoVO.adoAniSpoAniId}</td>
			<td>${adoanispoVO.adoAniSpomem_Id}</td>
			<td>${adoanispoVO.adoAniSpoMoney}</td>
			<td>${adoanispoVO.adoAniSpoMat}</td>
    
    </tr>
</table>

</body>
</html>        
