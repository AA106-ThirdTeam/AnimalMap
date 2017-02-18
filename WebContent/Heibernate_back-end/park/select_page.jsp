<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Park: Home</title>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
</head>
<body bgcolor='white'>
<div id="popupcalendar" class="text"></div>
<table class="table"  border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Park: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>公園資料查詢:</h2>
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
<!--  -->
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/park/listAllPark.jsp'>List</a> all Parks. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/park/park.do" >
        <b>輸入公園編號 (如7001):</b>
        <input type="text" name="park_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="parkSvc" scope="page" class="heibernate_com.park.model.ParkService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/park/park.do" >
       <b>選擇公園編號:</b>
       <select size="1" name="park_Id">
         <c:forEach var="parkVO" items="${parkSvc.all}" > 
          <option value="${parkVO.park_Id}">${parkVO.park_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="empSvc" scope="page" class="heibernate_com.emp.model.EmpService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/park/park.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇員工編號:</font></b>
	       <select size="1" name="emp_No">
	         <c:forEach var="empVO" items="${empSvc.all}" > 
	          <option value="${empVO.emp_No}">${empVO.emp_No}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listParks_ByEmp_No_A">
       	</div>
     </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>公園管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/park/addPark.jsp'>Add</a> a new Park.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Emp管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/emp/listAllEmp.jsp'>List</a> all Emps. </li>
	    </ul>
<!--  -->
</body>
</html>
