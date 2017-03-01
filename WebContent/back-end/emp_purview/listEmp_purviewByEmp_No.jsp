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
</head>
<body>

<h3>員工權限清單 - ListEmg_purviewByEmp_No.jsp</h3>
<br>
<a href="<%=request.getContextPath()%>/back-end/emp/select_page.jsp">回首頁</a>

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
<br>
<br>

<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/back-end/emp_purview/emp_purview.do">


	<c:forEach var="purviewVO" items="${purviewSvc.all}" >


		
			<tr align='center' valign='middle'>

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
			 
			 <br>
			 <br>	
						<input type="submit" value="新增權限"> 
						<input type="hidden" name="emp_No" value="${emp_No}"> 
						<input type="hidden" name="action" value="addEmp_Purview">
				</FORM>					










</body>
</html>