<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Rel_List: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>表格 Rel_List: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for Rel_List: Home</p>

<hr>

<h3>關係名單資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/rel_list/listAllRel_List.jsp'>List</a> all Rel_Lists. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/rel_list/rel_list.do" >
        <b>輸入關係名單編號 (如7001):</b>
        <input type="text" name="{PK英文名稱}">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="rel_listSvc" scope="page" class="com.rel_list.model.Rel_ListService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/rel_list/rel_list.do" >
       <b>選擇關係名單編號:</b>
       <select size="1" name="{PK英文名稱}">
         <c:forEach var="rel_listVO" items="${rel_listSvc.all}" > 
          <option value="${rel_listVO.{PK英文名稱}}">${rel_listVO.{PK英文名稱}}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>

<hr>

<!--  -->
<h3>關係名單管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/rel_list/addRel_List.jsp'>Add</a> a new Rel_List.</li>
</ul>

<!--  -->

</body>

</html>
