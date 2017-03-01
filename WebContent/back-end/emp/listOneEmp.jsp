<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.emp.model.*"%>
<%
EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>
<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>

<style>
.pic {
	max-height: 200px;
	max-width: 200px;
}

 
</style>

</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='600'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>員工資料 - ListOneEmp.jsp</h3> <a href="<%=request.getContextPath() %>/back-end/emp/select_page.jsp"><img
					src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
			</td>
		</tr>
	</table>

	<table border='1' bordercolor='#CCCCFF' width='600'>
		<tr>

			<th>員工頭像</th>
			<th>員工編號</th>
			<th>員工姓名</th>
			<th>信箱</th>
			<th>ID</th>
			<th>出身日期</th>
			<th>電話</th>
			<th>住址</th>
			<th>員工狀態</th>
			<th>雇用日期</th>
			<th>離職日期</th>

		</tr>
		<tr align='center' valign='middle'>

			<td><img
				src="<%= request.getContextPath()%>/EmpPhotoReader?emp_No=${empVO.emp_No}"
				class="pic"></td>
			<td>${empVO.emp_No}</td>
			<td>${empVO.emp_name}</td>
			<td>${empVO.emp_email}</td>
			<td>${empVO.emp_Id}</td>
			<td>${empVO.emp_birthday}</td>
			<td>${empVO.emp_phone}</td>
			<td>${empVO.emp_address}</td>
			<td>${(empVO.emp_status)==1?'在職':'離職'}</td>
			<td>${empVO.emp_hiredate}</td>
			<td>${empVO.emp_firedate}</td>

		</tr>
	</table>

</body>
</html>
