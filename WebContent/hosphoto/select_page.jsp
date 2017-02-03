<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 HosPhoto: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>表格 HosPhoto: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for HosPhoto: Home</p>

<hr>

<h3>診所相片資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/hosphoto/listAllHosPhoto.jsp'>List</a> all HosPhotos. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hosphoto/hosphoto.do" >
        <b>輸入診所相片編號 (如7001):</b>
        <input type="text" name="hosPhoto_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="hosphotoSvc" scope="page" class="com.hosphoto.model.HosPhotoService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hosphoto/hosphoto.do" >
       <b>選擇診所相片編號:</b>
       <select size="1" name="hosPhoto_Id">
         <c:forEach var="hosphotoVO" items="${hosphotoSvc.all}" > 
          <option value="${hosphotoVO.hosPhoto_Id}">${hosphotoVO.hosPhoto_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>

<hr>

<!--  -->
<h3>診所相片管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/hosphoto/addHosPhoto.jsp'>Add</a> a new HosPhoto.</li>
</ul>

<!--  -->

</body>

</html>
