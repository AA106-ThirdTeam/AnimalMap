<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Track: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Track: Home</h3><font color=red>( MVC )</font>
        <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
    </td>
  </tr>
</table>

<p>This is the Home page for Track: Home</p>

<hr>

<h3>追蹤收藏資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/track/listAllTrack.jsp'>List</a> all Tracks. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/track/track.do" >
        <b>輸入追蹤收藏編號 (如7001):</b>
        <input type="text" name="track_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="trackSvc" scope="page" class="com.track.model.TrackService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/track/track.do" >
       <b>選擇追蹤收藏編號:</b>
       <select size="1" name="track_Id">
         <c:forEach var="trackVO" items="${trackSvc.all}" > 
          <option value="${trackVO.track_Id}">${trackVO.track_Id}
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
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/track/track.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
       <b>選擇收藏編號編號:</b>
       <select size="1" name="track_Id">
         <c:forEach var="trackVO" items="${trackSvc.all}" > 
          <option value="${trackVO.track_Id}">${trackVO.track_Id}
         </c:forEach>   
       </select>   
       <br>     
        










      <input type="submit" value="送出">
      <input type="hidden" name="action" value="listEmps_ByCompositeQuery">
    </FORM>
  </li>
</ul>

<hr>

<!--  -->
<h3>追蹤收藏管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/track/addTrack.jsp'>Add</a> a new Track.</li>
</ul>

<!--  -->


    <hr>

    <h3><font color=orange>一般會員管理</font></h3>

    <ul>
      <li><a href='<%=request.getContextPath()%>/mem/listAllMem.jsp'>List</a> all Mems. </li>
    </ul>



<!--  -->

</body>

</html>
