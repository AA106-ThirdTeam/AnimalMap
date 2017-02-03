<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Emp_purview: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Emp_purview: Home</h3><font color=red>( MVC )</font>
        <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
    </td>
  </tr>
</table>

<p>This is the Home page for Emp_purview: Home</p>

<hr>

<h3>員工權限資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/emp_purview/listAllEmp_purview.jsp'>List</a> all Emp_purviews. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp_purview/emp_purview.do" >
        <b>輸入員工權限編號 (如7001):</b>
        <input type="text" name="{PK英文名稱}">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="emp_purviewSvc" scope="page" class="com.emp_purview.model.Emp_purviewService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp_purview/emp_purview.do" >
       <b>選擇員工權限編號:</b>
       <select size="1" name="{PK英文名稱}">
         <c:forEach var="emp_purviewVO" items="${emp_purviewSvc.all}" > 
          <option value="${emp_purviewVO.{PK英文名稱}}">${emp_purviewVO.{PK英文名稱}}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>



<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp_purview/emp_purview.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
        









        










      <input type="submit" value="送出">
      <input type="hidden" name="action" value="listEmps_ByCompositeQuery">
    </FORM>
  </li>
</ul>

<hr>

<!--  -->
<h3>員工權限管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/emp_purview/addEmp_purview.jsp'>Add</a> a new Emp_purview.</li>
</ul>

<!--  -->


    <hr>

    <h3><font color=orange>員工管理</font></h3>

    <ul>
      <li><a href='<%=request.getContextPath()%>/emp/listAllEmp.jsp'>List</a> all Emps. </li>
    </ul>

    <hr>

    <h3><font color=orange>權限管理</font></h3>

    <ul>
      <li><a href='<%=request.getContextPath()%>/purview/listAllPurview.jsp'>List</a> all Purviews. </li>
    </ul>



<!--  -->

</body>

</html>
