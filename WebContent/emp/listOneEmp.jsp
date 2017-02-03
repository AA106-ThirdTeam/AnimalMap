 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.emp.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%EmpVO empVO = (EmpVO) request.getAttribute("empVO");%>

<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>員工資料 - ListOneEmp.jsp</h3>
        <a href="<%=request.getContextPath()%>/emp/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>員工編號</th>
		<th>員工姓名</th>
		<th>員工密碼</th>
		<th>員工信箱</th>
		<th>員工身分證</th>
		<th>員工出生年月日</th>
		<th>員工電話</th>
		<th>員工地址</th>
		<th>員工狀態</th>
		<th>員工照片</th>
		<th>員工照片副檔名</th>
		<th>雇用日期</th>
		<th>離職日期</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${empVO.emp_No}</td>
			<td>${empVO.emp_name}</td>
			<td>${empVO.emp_Pw}</td>
			<td>${empVO.emp_email}</td>
			<td>${empVO.emp_Id}</td>
			<td>${empVO.emp_birthday}</td>
			<td>${empVO.emp_phone}</td>
			<td>${empVO.emp_address}</td>
			<td>${empVO.emp_status}</td>
			<td>${empVO.emp_picture}</td>
			<td>${empVO.emp_Pic_format}</td>
			<td>${empVO.emp_hiredate}</td>
			<td>${empVO.emp_firedate}</td>
    
    </tr>
</table>

</body>
</html>        
