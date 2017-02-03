 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adopt_ani_sponsor.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Adopt_Ani_sponsorServlet.java已存入request的Adopt_Ani_sponsorVO物件--%>
<%Adopt_Ani_sponsorVO adopt_ani_sponsorVO = (Adopt_Ani_sponsorVO) request.getAttribute("adopt_ani_sponsorVO");%>

<html>
<head>
<title>送養動物贊助資料 - listOneAdopt_Ani_sponsor.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>送養動物贊助資料 - ListOneAdopt_Ani_sponsor.jsp</h3>
        <a href="<%=request.getContextPath()%>/adopt_ani_sponsor/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
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
			<td>${adopt_ani_sponsorVO.ado_Ani_Spo_No}</td>
			<td>${adopt_ani_sponsorVO.adopt_Ani_Id}</td>
			<td>${adopt_ani_sponsorVO.mem_Id}</td>
			<td>${adopt_ani_sponsorVO.ado_Ani_Spo_money}</td>
			<td>${adopt_ani_sponsorVO.adoAniSpoMat}</td>
    
    </tr>
</table>

</body>
</html>        
