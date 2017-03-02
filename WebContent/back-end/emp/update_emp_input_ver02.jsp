<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>
<%
	EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java (Concroller), 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		

<title>員工資料修改 - update_emp_input.jsp</title>

<style>
.pic {
	max-height: 150px;
	max-width: 150px;
}
</style>


</head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

	
<div><a href="<%=request.getContextPath() %>/back-end/emp/select_pageForView.jsp">返回</a></div>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>請修正以下錯誤:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp/emp.do" name="form1"
		enctype="multipart/form-data">
		<table >

			<tr>
				<td>員工頭像:<font color=red><b>*</b></font></td>
				<td><img
					src="<%= request.getContextPath()%>/EmpPhotoReader?emp_No=${empVO.emp_No}"
					class="pic img-rounded"></td>
			</tr>
			<tr>
				<td>頭像更改:</td>
				<td><input type="file" name="emp_picture" /></td>
			</tr>


			<tr>
				<td>員工編號:<font color=red><b>*</b></font></td>
				<td>${empVO.emp_No}</td>
			</tr>
			<tr>
				<td>員工姓名:</td>
				<td><input type="TEXT" name="emp_name" size="45" 
					value="${empVO.emp_name}" /></td>
			</tr>
			<tr>
				<td>密碼:</td>
				<td><input type="password" name="emp_Pw" size="45"
					value="${empVO.emp_Pw} " /></td>
			</tr>
			<tr>
				<td>信箱:</td>
				<td><input type="TEXT" name="emp_email" size="45"
					value="${empVO.emp_email}" /></td>
			</tr>
			<tr>
				<td>ID:</td>
				<td><input type="TEXT" name="emp_Id" size="45"
					value="${empVO.emp_Id }" /></td>
			</tr>
			<tr>
				<td>出生日期:</td>
				
				<td><input type="date" name="emp_birthday"
					value="${empVO.emp_birthday}"></td>
			</tr>
			<tr>
				<td>電話:</td>
				<td><input type="TEXT" name="emp_phone" size="45"
					value="${empVO.emp_phone}" /></td>
			</tr>
			<tr>
				<td>住址:</td>
				<td><input type="TEXT" name="emp_address" size="45"
					value="${empVO.emp_address}" /></td>
			</tr>


			<tr>
				<td>員工狀態:<font color=red><b>*</b></font></td>
				<td>在職 <input type="radio" name="emp_status" value="1"
					${(empVO.emp_status)==1?'checked':''} /></td>
				<td>離職 <input type="radio" name="emp_status" value="0"
					${(empVO.emp_status)==0?'checked':''} /></td>

			</tr>
			<tr>
				<td>雇用日期:</td>
				<td><input type="date" name="emp_hiredate"
					value="${empVO.emp_hiredate}"></td>
			<tr>

				<td>離職日期:</td>
				<td><input type="date" name="emp_firedate"
					value="${empVO.emp_firedate}"></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="update"> 
		<input type="hidden" name="emp_No" value="${empVO.emp_No}"> 
		<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL") %>">
		
			<input type="submit" value="送出修改" class="btn btn-warning">
	</FORM>

</body>
</html>