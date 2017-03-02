<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    EmpService empSvc = new EmpService();
    List<EmpVO> list = empSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>所有員工資料 - listAllEmp.jsp</title>

<style>
.pic {
	max-height: 200px;
	max-width: 200px;
}
</style>




</head>
<body bgcolor='white'>
	
	<table border='1' cellpadding='5' cellspacing='0' width='1200'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>所有員工資料 - ListAllEmp.jsp</h3> <a href="<%=request.getContextPath() %>/back-end/emp/select_page.jsp"><img
					src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
			</td>
		</tr>
	</table>

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

	<table border='1' bordercolor='#CCCCFF' width='1400'>
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
			<th>修改</th>
			<th>刪除</th>
			<th>修改權限</th>
		</tr>
		<%@ include file="pages/page1.file"%>
		<c:forEach var="empVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
			<tr align='center' valign='middle'
			${(empVO.emp_No==param.emp_No) ? 'bgcolor=yellow':''}
			>

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
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/emp/emp.do">
						<input type="submit" value="修改"> 
						<input type="hidden" name="emp_No" value="${empVO.emp_No}"> 
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"> <%--傳送這個網頁的URL 到controller --%>
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp/emp.do">
						<input type="submit" value="刪除"> 
						<input type="hidden" name="emp_No" value="${empVO .emp_No}"> 
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp_purview/emp_purview.do">
						<input type="submit" value="修改權限"> 
						<input type="hidden" name="emp_No" value="${empVO.emp_No}"> 
						<input type="hidden" name="action" value="updateEmp_Purview">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="pages/page2.file"%>

</body>
</html>
