<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="com.purview.model.*"%>
<%@ page import="com.emp_purview.model.*"%>

<%  
	 Emp_purviewService emp_purviewSvc = new Emp_purviewService();
	 List<Emp_purviewVO> list =emp_purviewSvc.getAll();
	 pageContext.setAttribute("list",list);
 %>
 
	<jsp:useBean id="empSvc" scope="page" class="com.emp.model.EmpService" />
 	<jsp:useBean id="purviewSvc" scope="page" class="com.purview.model.PurviewService" />	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Emp_Purview</title>
</head>





<body>
<h3>權限清單 - ListAllEmg_purview.jsp</h3>
	<a href="<%=request.getContextPath()%>/back-end/emp/select_page.jsp">回首頁</a>


	


<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
			<th>員工姓名</th>
			<th>權限名稱</th>			
			
			

		</tr>
		


		
		<c:forEach var="emp_purviewVO" items="${list}" >
			<tr align='center' valign='middle'>

		
				
				<td><c:forEach var="empVO" items="${empSvc.all}">
                    <c:if test="${empVO.emp_No==emp_purviewVO.emp_No}">
	                    ${emp_purviewVO.emp_No} 【<font color='red'>${empVO.emp_name}</font>】
                    </c:if>
                </c:forEach>
				</td>		
				
				<td><c:forEach var="purviewVO" items="${purviewSvc.all}">
				
                    <c:if test="${purviewVO.purview_No==emp_purviewVO.purview_No}">
	                    ${emp_purviewVO.purview_No} 【<font color='red'>${purviewVO.purview_name}</font>】
                    </c:if>
                  
                </c:forEach>
				</td>
				


				 
				
							
		</c:forEach>
	</table>




</body>
</html>