<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Adopt_Ani_message: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>表格 Adopt_Ani_message: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for Adopt_Ani_message: Home</p>

<hr>

<h3>送養動物留言資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/adopt_ani_message/listAllAdopt_Ani_message.jsp'>List</a> all Adopt_Ani_messages. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/adopt_ani_message/adopt_ani_message.do" >
        <b>輸入送養動物留言編號 (如7001):</b>
        <input type="text" name="ado_Ani_Mes_No">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="adopt_ani_messageSvc" scope="page" class="com.adopt_ani_message.model.Adopt_Ani_messageService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/adopt_ani_message/adopt_ani_message.do" >
       <b>選擇送養動物留言編號:</b>
       <select size="1" name="ado_Ani_Mes_No">
         <c:forEach var="adopt_ani_messageVO" items="${adopt_ani_messageSvc.all}" > 
          <option value="${adopt_ani_messageVO.ado_Ani_Mes_No}">${adopt_ani_messageVO.ado_Ani_Mes_No}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>

<hr>

<!--  -->
<h3>送養動物留言管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/adopt_ani_message/addAdopt_Ani_message.jsp'>Add</a> a new Adopt_Ani_message.</li>
</ul>

<!--  -->

</body>

</html>
