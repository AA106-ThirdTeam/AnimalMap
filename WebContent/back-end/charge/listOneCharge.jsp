<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.charge.model.*" %>
<%@ page import="com.mem_hua.model.*" %>


<%ChargeVO chargeVO = (ChargeVO) request.getAttribute("chargeVO"); %>

<%--取出對應product_kind物件 --%>
<%
	MemService memSvc = new MemService();
	MemVO memVO = memSvc.getOneMem(chargeVO.getMem_Id());
%>
<html>
<head>
<title>listOneCharge.jsp</title>
</head>
<body>
	<h1>listOneCharge.jsp</h1>
	
	<table border='1' cellpadding='5' cellspacing='0' width='1200'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
			<h3>儲值資料-listOneCharge</h3>
				<a href="<%=request.getContextPath()%>/back-end/select_page.jsp">
				<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">回首頁</a>
			</td>
		</tr>
	</table>
	<table border='1' bordercolor='#ccccff' width='1200'>
		<tr>
			<th>儲值編號</th>
			<th>會員編號</th>
			<th>儲值金額</th>
			<th>付款方式</th>
			<th>儲值日期</th>

		</tr>
		<tr align='center' valign='middle'>
			<td><%=chargeVO.getCharge_no()%></td>
			<td><%=chargeVO.getMem_Id()%></td>
			<td><%=chargeVO.getCharge_number()%></td>
			<td><%=chargeVO.getPay()%></td>
			<td><%=chargeVO.getApplytime()%></td>
			
		</tr>
	</table>
</body>
</html>