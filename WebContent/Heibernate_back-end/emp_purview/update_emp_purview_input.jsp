<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.emp_purview.model.*"%>
<%
    Emp_purviewVO emp_purviewVO = (Emp_purviewVO) request.getAttribute("emp_purviewVO"); //Emp_purviewServlet.java (Concroller), 存入req的emp_purviewVO物件 (包括幫忙取出的emp_purviewVO, 也包括輸入資料錯誤時的emp_purviewVO物件)
%>
<!--  -->
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
<html>
<head>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<title>員工權限資料修改 - update_emp_purview_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>員工權限資料 - ListOneEmp_purview.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/emp_purview/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="emp_purview.do" name="form1">
    <table border="0">
    <!--  -->
<jsp:useBean id="empSvc" scope="page" class="heibernate_com.emp.model.EmpService" />
	<tr>
		<td>員工編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="emp_No">
	         <c:forEach var="empVO" items="${empSvc.all}" > 
				<option value="${empVO.emp_No}" ${(emp_purviewVO.empVO.emp_No==empVO.emp_No)?'selected':'' } >
${empVO.emp_No}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
<jsp:useBean id="purviewSvc" scope="page" class="heibernate_com.purview.model.PurviewService" />
	<tr>
		<td>權限編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="purview_No">
	         <c:forEach var="purviewVO" items="${purviewSvc.all}" > 
				<option value="${purviewVO.purview_No}" ${(emp_purviewVO.purviewVO.purview_No==purviewVO.purview_No)?'selected':'' } >
${purviewVO.purview_No}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="emp_No" value="<%=emp_purviewVO.getEmpVO().getEmp_No()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllEmp_purview.jsp 與 複合查詢 listEmp_purviews_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
