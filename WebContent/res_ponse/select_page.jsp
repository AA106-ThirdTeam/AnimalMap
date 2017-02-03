<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Res_ponse: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>表格 Res_ponse: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for Res_ponse: Home</p>

<hr>

<h3>討論區留言資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/res_ponse/listAllRes_ponse.jsp'>List</a> all Res_ponses. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/res_ponse/res_ponse.do" >
        <b>輸入討論區留言編號 (如7001):</b>
        <input type="text" name="res_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="res_ponseSvc" scope="page" class="com.res_ponse.model.Res_ponseService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/res_ponse/res_ponse.do" >
       <b>選擇討論區留言編號:</b>
       <select size="1" name="res_Id">
         <c:forEach var="res_ponseVO" items="${res_ponseSvc.all}" > 
          <option value="${res_ponseVO.res_Id}">${res_ponseVO.res_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>

<hr>

<!--  -->
<h3>討論區留言管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/res_ponse/addRes_ponse.jsp'>Add</a> a new Res_ponse.</li>
</ul>

<!--  -->

</body>

</html>
