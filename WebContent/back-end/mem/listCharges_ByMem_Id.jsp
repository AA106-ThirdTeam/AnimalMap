<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>
<jsp:useBean id="listCharges_ByMem_Id" scope="request" type="java.util.Set" />
<jsp:useBean id="memSvc" scope="page" class="com.mem_hua.model.MemService" />
<html>
<head>
	<title>listCharges_ByMemId</title>
</head>
<body>
	<h1>listCharges_ByMemId.jsp</h1>
	<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3> - listCharges_ByMemId.jsp</h3>
		<a href="<%=request.getContextPath()%>/back-end/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>
<%--錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>
<table border='1' bordercolor='#ccccff' width='800'>
	<tr>
		<th>儲值編號</th>
		<th>會員編號</th>
		<th>儲值金額</th>
		<th>付款方式</th>
		<th>儲值日期</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<tr>
	
</body>
</html>