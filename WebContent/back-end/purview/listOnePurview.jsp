<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.purview.model.*"%>
<% PurviewVO purviewVO= (PurviewVO)request.getAttribute("purviewVO"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<style>
td {
	
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>權限資料</title>
</head>
<body>

	<h3>員工資料 - ListOnePurview.jsp</h3>
	<a href="<%=request.getContextPath() %>/back-end/purview/select_page.jsp">回首頁</a>

	<table border='1' bordercolor='#CCCCFF' width='600'>

		<tr>
			<th>權限編號</th>
			<th>權限名稱</th>
		</tr>

		<tr aling="center" valign="middle">

			<td>${purviewVO.purview_No}</td>
			<td>${purviewVO.purview_name}</td>

		</tr>
	</table>

</body>
</html>