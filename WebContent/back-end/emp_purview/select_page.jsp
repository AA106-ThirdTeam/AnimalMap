<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Emp_purview: Home</title>
	
	<!-- 共用HEAD -->
	
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
	<%@include file="/back-end/js/calendarcode.jsp"%>
</head>

<body bgcolor='white'>
<div id="popupcalendar" class="text"></div>

<table class="table"  border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Emp_purview: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>

<hr>

<h2>員工權限資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/back-end/emp_purview/listAllEmp_purview.jsp'>List</a> all Emp_purviews. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp_purview/emp_purview.do" >
        <b>輸入員工權限編號 (如7001):</b>
        <input type="text" name="emp_No">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="emp_purviewSvc" scope="page" class="com.emp_purview.model.Emp_purviewService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp_purview/emp_purview.do" >
       <b>選擇員工權限編號:</b>
       <select size="1" name="emp_No">
         <c:forEach var="emp_purviewVO" items="${emp_purviewSvc.all}" > 
          <option value="${emp_purviewVO.emp_No}">${emp_purviewVO.emp_No}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>


   <jsp:useBean id="empSvc" scope="page" class="com.emp.model.EmpService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp_purview/emp_purview.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇員工編號:</font></b>
	       <select size="1" name="emp_No">
	         <c:forEach var="empVO" items="${empSvc.all}" > 
	          <option value="${empVO.emp_No}">${empVO.emp_No}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listEmp_purviews_ByEmp_No_A">
       	</div>
     </FORM>
  </li>

   <jsp:useBean id="purviewSvc" scope="page" class="com.purview.model.PurviewService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp_purview/emp_purview.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇權限編號:</font></b>
	       <select size="1" name="purview_No">
	         <c:forEach var="purviewVO" items="${purviewSvc.all}" > 
	          <option value="${purviewVO.purview_No}">${purviewVO.purview_No}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listEmp_purviews_ByPurview_No_A">
       	</div>
     </FORM>
  </li>


</ul>



<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp_purview/emp_purview.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>

       <b>選擇員工編號編號:</b>
       <select size="1" name="emp_No">
         <c:forEach var="empVO" items="${empSvc.all}" > 
          <option value="${empVO.emp_No}">${empVO.emp_No}
         </c:forEach>   
       </select>
       <br> 

       <b>選擇權限編號編號:</b>
       <select size="1" name="purview_No">
         <c:forEach var="purviewVO" items="${purviewSvc.all}" > 
          <option value="${purviewVO.purview_No}">${purviewVO.purview_No}
         </c:forEach>   
       </select>
       <br> 

      <input type="submit" value="送出">
      <input type="hidden" name="action" value="listEmp_purviews_ByCompositeQuery">
    </FORM>
  </li>
</ul>

<hr>

<!--  -->
<h3>員工權限管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/emp_purview/addEmp_purview.jsp'>Add</a> a new Emp_purview.</li>
</ul>

<!--  -->

	    <hr>

	    <h3><font color=orange>Emp管理</font></h3>

	    <ul>
	      <li><a href='<%=request.getContextPath()%>/back-end/emp/listAllEmp.jsp'>List</a> all Emps. </li>
	    </ul>

	    <hr>

	    <h3><font color=orange>Purview管理</font></h3>

	    <ul>
	      <li><a href='<%=request.getContextPath()%>/back-end/purview/listAllPurview.jsp'>List</a> all Purviews. </li>
	    </ul>
	    		

<!--  -->

</body>

</html>
