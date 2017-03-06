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
<title>所有員工資料 - listAllEmp.jsp</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		

<style>
	.pic {
		max-height: 150px;
		max-width: 150px;
	}
	
	
	
	table{
	margin-top:10px;
	}
	
	#page{
	margin:auto 15px;
	}
	
	#addEmp{
	margin-top:30px;
	margin-left:15px;
	}


</style>




</head>
<body >
	
	
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
	
		<div id='addEmp'>
			<a href="<%=request.getContextPath()%>/back-end/emp/addEmp.jsp"><h4>新增員工</h4></a>	
		</div>
	
	<table class="table table-hover" width="1300">
			
			<thead>
				<tr >
					<th >員工頭像</th>
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
					<th></th>
<!-- 					<th></th> -->
					<th></th>
				</tr>
				</thead>
			<tbody>
			
		<div id="page">	
		<%@ include file="pages/page1 forView.file"%>	
		</div>		
		<c:forEach var="empVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
			<tr    style="${(empVO.emp_No==param.emp_No) ? 'background-color:#FFFF77':''}" 
			>

				<td><img
					src="<%= request.getContextPath()%>/EmpPhotoReader?emp_No=${empVO.emp_No}"
					class="pic img-rounded"></td>
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
						<input type="submit" value="修改" class="btn btn-warning"> 
						<input type="hidden" name="emp_No" value="${empVO.emp_No}"> 
						<input type="hidden" name="whichPage"	value="<%=whichPage%>">  
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"> <%--傳送這個網頁的URL 到controller --%>
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
<!-- 				<td> -->
<%-- 					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp/emp.do"> --%>
<!-- 						<input type="submit" value="刪除" class="btn btn-danger">  -->
<%-- 						<input type="hidden" name="emp_No" value="${empVO .emp_No}">  --%>
<!-- 						<input type="hidden" name="action" value="delete"> -->
<!-- 					</FORM> -->
<!-- 				</td> -->
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp_purview/emp_purview.do">
						<input type="submit" value="權限管理" class="btn btn-info"> 
						<input type="hidden" name="emp_No" value="${empVO.emp_No}"> 
						<input type="hidden" name="action" value="updateEmp_Purview">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	
	
				
				
				
				
				
			</tbody>
		</table>
	<%@ include file="pages/page2 forView.file"%>	
	
	
	
	

		

</body>
</html>
