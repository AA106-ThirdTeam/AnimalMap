<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 AniHome: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>表格 AniHome: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for AniHome: Home</p>

<hr>

<h3>動物之家資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/anihome/listAllAniHome.jsp'>List</a> all AniHomes. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/anihome/anihome.do" >
        <b>輸入動物之家編號 (如7001):</b>
        <input type="text" name="aniHome_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="anihomeSvc" scope="page" class="com.anihome.model.AniHomeService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/anihome/anihome.do" >
       <b>選擇動物之家編號:</b>
       <select size="1" name="aniHome_Id">
         <c:forEach var="anihomeVO" items="${anihomeSvc.all}" > 
          <option value="${anihomeVO.aniHome_Id}">${anihomeVO.aniHome_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>

<hr>

<!--  -->
<h3>動物之家管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/anihome/addAniHome.jsp'>Add</a> a new AniHome.</li>
</ul>

<!--  -->

</body>

</html>
