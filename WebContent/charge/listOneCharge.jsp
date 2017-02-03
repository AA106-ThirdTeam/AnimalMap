 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.charge.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller ChargeServlet.java已存入request的ChargeVO物件--%>
<%ChargeVO chargeVO = (ChargeVO) request.getAttribute("chargeVO");%>

<html>
<head>
<title>儲值資料 - listOneCharge.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>儲值資料 - ListOneCharge.jsp</h3>
        <a href="<%=request.getContextPath()%>/charge/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>儲值編號</th>
		<th>會員編號</th>
		<th>儲值金額</th>
		<th>付款方式</th>
		<th>儲值時間</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${chargeVO.charge_no}</td>
			<td>${chargeVO.mem_Id}</td>
			<td>${chargeVO.charge_NUMBER}</td>
			<td>${chargeVO.pay}</td>
			<td>${chargeVO.applytime}</td>
    
    </tr>
</table>

</body>
</html>        
