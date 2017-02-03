<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 AdpMsg: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>表格 AdpMsg: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for AdpMsg: Home</p>

<hr>

<h3>領養活動留言資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/adpmsg/listAllAdpMsg.jsp'>List</a> all AdpMsgs. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/adpmsg/adpmsg.do" >
        <b>輸入領養活動留言編號 (如7001):</b>
        <input type="text" name="adpMsg_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="adpmsgSvc" scope="page" class="com.adpmsg.model.AdpMsgService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/adpmsg/adpmsg.do" >
       <b>選擇領養活動留言編號:</b>
       <select size="1" name="adpMsg_Id">
         <c:forEach var="adpmsgVO" items="${adpmsgSvc.all}" > 
          <option value="${adpmsgVO.adpMsg_Id}">${adpmsgVO.adpMsg_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>

<hr>

<!--  -->
<h3>領養活動留言管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/adpmsg/addAdpMsg.jsp'>Add</a> a new AdpMsg.</li>
</ul>

<!--  -->

</body>

</html>
