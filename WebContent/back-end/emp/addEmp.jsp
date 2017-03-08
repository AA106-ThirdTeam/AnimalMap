<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>
<%
EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>

<html>
<head>
<title>員工資料新增 - addEmp.jsp</title>

<style>

	table{
	margin-top:50px;
	}

	.form-control{
	margin-top:8px;
	}


</style>




</head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<body >

	
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
	<table>

			<tr>
				<td>上傳頭像:</td>
				<td><input type="file" name="emp_picture" /></td>

			</tr>


			<tr>
				<td>員工姓名:</td>
				<td><input type="TEXT" name="emp_name" size="45"  class="form-control"
<%-- 				value="<%= (empVO==null)? "吳永志" : empVO.getEmp_name()%>"  --%>
					id="emp_name"
					/></td>
			</tr>

			<tr>
				<td>員工信箱:</td>
				<td><input type="TEXT" name="emp_email" size="45" id="emp_email"  class="form-control"
<%-- 					value="<%= (empVO==null)? "justlovedance@gmail.com" : empVO.getEmp_email()%>"  --%>
					/></td>
			</tr>
			<tr>
				<td>員工ID:</td>
				<td><input type="TEXT" name="emp_Id" size="45" id="emp_Id"  class="form-control"
<%-- 					value="<%= (empVO==null)? "test123" : empVO.getEmp_Id()%>"  --%>
					/></td>
			</tr>
			<tr>
				<%java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());%>
				<td>生日日期:</td>


				<td><input type="date" name="emp_birthday"  class="form-control"
					value="<%= (empVO==null)? date_SQL : empVO.getEmp_birthday()%>"></td>
			</tr>
			<tr>
				<td>電話:</td>
				<td><input type="TEXT" name="emp_phone" size="45" id="emp_phone"  class="form-control"
<%-- 					value="<%= (empVO==null)? "0123456789" : empVO.getEmp_phone()%>"  --%>
					/></td>
			</tr>
			<tr>
				<td>住址:</td>
				<td><input type="TEXT" name="emp_address" size="45" id="emp_address"  class="form-control"
<%-- 					value="<%= (empVO==null)? "台北市" : empVO.getEmp_address()%>"  --%>
					/>
					</td>
			</tr>



			<tr>
				<td>員工狀態:<font color=red><b>*</b></font></td> 
				<td>在職 <input type="radio" name="emp_status"  id="emp_status"  
				value="1" 
<%-- 				${(empVO==null)?'checked':'chrcked'}  --%>
				/>
					</td>



			</tr>
			<tr>
				<%java.sql.Date date_SQL2 = new java.sql.Date(System.currentTimeMillis());%>
				<td>雇用日期:</td>


				<td><input type="date" name="emp_hiredate"  class="form-control"
					value="<%= (empVO==null)? date_SQL2 : empVO.getEmp_hiredate()%>"></td>


			</tr>
</table>

		
		<br> 
		<input type="hidden" name="action" value="insert"> 
		<input type="submit" value="送出新增" class="btn btn-success">
		
	</FORM>
	
	<button onclick="btn_magic()"></button>
	
	<script>
		//利用神奇小按鈕給值
		function btn_magic(){
			
			$("#emp_name").val("RJ");
			$("#emp_email").val("justlovedance308@gmail.com"); // 唯一值
			$("#emp_Id").val("H123456789"); // 唯一值
			$("#emp_phone").val("0123456789");
			$("#emp_address").val("中壢資策會");
			
			//radio checked 的方式
			$("[name=emp_status]").val(["1"]);
			//$("#emp_status").prop("checked", true);
		
		}
		
	</script>
	
	
	
	
	
	
	
</body>   

</html>                                                  
