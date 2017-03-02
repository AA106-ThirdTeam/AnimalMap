<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="com.purview.model.*"%>
<%@ page import="com.emp_purview.model.*"%>

	
 	<jsp:useBean id="set" scope="request" type="java.util.Set" />
 	<jsp:useBean id="purviewSvc" scope="page" class="com.purview.model.PurviewService" />	
 	<jsp:useBean id="emp_purviewSvc" scope="page" class="com.emp_purview.model.Emp_purviewService" />	



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListEmg_purviewByEmp_No</title>
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>

		<div>
			<a href="<%=request.getContextPath()%>/back-end/emp/select_pageForView.jsp">返回</a>
		</div>

<h3>員工權限管理</h3>
<br>


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


	<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/back-end/emp_purview/emp_purview.do">

<table  class="table table-hover">
	<c:forEach var="purviewVO" items="${purviewSvc.all}" >


		
			<tr >

				<td> 
					<input type="checkbox" name="purview_No" value="${purviewVO.purview_No}" 
                    <%--用For迴圈跑出員工擁有的權限 --%>
					<c:forEach var="emp_purviewVO" items="${set}">
					${purviewVO.purview_No eq emp_purviewVO.purview_No? 'checked':''}
					</c:forEach>
					
					>
		
						【<font color='red'>${purviewVO.purview_name}</font>】
						
				</td>
				
				
		
			</tr>
	
			 </c:forEach>	
		</table>		
			 <br>
				
						<input type="submit" value="權限修改" class='btn btn-warning'> 
						<input type="hidden" name="emp_No" value="${emp_No}"> 
						<input type="hidden" name="action" value="addEmp_Purview">
				</FORM>					









</body>
</html>