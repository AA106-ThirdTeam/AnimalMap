<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>

<html>
<head>
<title>IBM Emp: Home</title>

<style>



#login_out{
margin:0 700px;
}


</style>



</head>
<body bgcolor='white'>

	 <!-- 透過Session得到LOGIN進來的 empVO 物件(emp_NO,emp_name,e_mail,pw) -->
<table>
	<div id='login_out'>
					<FORM METHOD="post"	ACTION="<%=request.getContextPath() %>/login">
						<input type="submit" value="登出"> 
						<input type="hidden" name="action" value="login_Out">
						
					</FORM>
	</div>

<td><h3 id='account'><font color=red > ${empVO.emp_name} </font>您好</h3></td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/emp/emp.do">
						<input type="submit" value="俢改個人資料"> 
						<input type="hidden" name="emp_No" value="${empVO.emp_No}"> 
						<input type="hidden" name="action" value="getOne_For_Update">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
					</FORM>
				</td>	
</table>	 


	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>IBM Emp: Home</h3>
				<font color=red>( MVC )</font></td>
		</tr>
	</table>

	<p>This is the Home page for IBM Emp: Home</p>


	<h3>資料查詢:</h3>
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

	<ul>
		<li><a href="<%=request.getContextPath()%>/back-end/emp/listAllEmp.jsp">List</a> all Emps.</li>
		<br>
		<br>



		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp/emp.do">
				<b>輸入員工編號 (如10001):</b> <input type="text" name="emp_No"> <input
					type="submit" value="送出"> <input type="hidden"
					name="action" value="getOne_For_Display">
			</FORM>
		</li>

		<jsp:useBean id="empSvc" scope="page" class="com.emp.model.EmpService" />

		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp/emp.do">
				<b>選擇員工編號:</b> <select size="1" name="emp_No">
					<c:forEach var="empVO" items="${empSvc.all}">
						<option value="${empVO.emp_No}">${empVO.emp_No}
					</c:forEach>
				</select> <input type="submit" value="送出"> <input type="hidden"
					name="action" value="getOne_For_Display">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp/emp.do">
				<b>選擇員工姓名:</b> <select size="1" name="emp_No">
					<c:forEach var="empVO" items="${empSvc.all}">
						<option value="${empVO.emp_No}">${empVO.emp_name}
					</c:forEach>
				</select> <input type="submit" value="送出"> <input type="hidden"
					name="action" value="getOne_For_Display">
			</FORM>
		</li>
	</ul>


	<h3>員工管理</h3>

	<ul>
		<li><a href="<%=request.getContextPath()%>/back-end/emp/addEmp.jsp">Add</a> a new Emp.</li>
	</ul>
	
	<h3>全員工權限清單</h3>

	<ul>
		<li><a href="<%=request.getContextPath()%>/back-end/emp_purview/listAllEmp_purview.jsp">List</a>All Emp_purview</li>
	</ul>

</body>

</html>
