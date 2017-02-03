<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Stray_Ani_photos: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Stray_Ani_photos: Home</h3><font color=red>( MVC )</font>
        <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
    </td>
  </tr>
</table>

<p>This is the Home page for Stray_Ani_photos: Home</p>

<hr>

<h3>社區流浪動物相簿資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/stray_ani_photos/listAllStray_Ani_photos.jsp'>List</a> all Stray_Ani_photoss. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/stray_ani_photos/stray_ani_photos.do" >
        <b>輸入社區流浪動物相簿編號 (如7001):</b>
        <input type="text" name="str_Ani_Pic_No">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="stray_ani_photosSvc" scope="page" class="com.stray_ani_photos.model.Stray_Ani_photosService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/stray_ani_photos/stray_ani_photos.do" >
       <b>選擇社區流浪動物相簿編號:</b>
       <select size="1" name="str_Ani_Pic_No">
         <c:forEach var="stray_ani_photosVO" items="${stray_ani_photosSvc.all}" > 
          <option value="${stray_ani_photosVO.str_Ani_Pic_No}">${stray_ani_photosVO.str_Ani_Pic_No}
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
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/stray_ani_photos/stray_ani_photos.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
       <b>選擇相片編號編號:</b>
       <select size="1" name="str_Ani_Pic_No">
         <c:forEach var="stray_ani_photosVO" items="${stray_ani_photosSvc.all}" > 
          <option value="${stray_ani_photosVO.str_Ani_Pic_No}">${stray_ani_photosVO.str_Ani_Pic_No}
         </c:forEach>   
       </select>   
       <br>     
        









        









        <b>相片發布時間:</b>
        <input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="text" name="stray_Pic_time" value="1981-11-17">
        <a class="so-BtnLink" href="javascript:calClick();return false;" onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','stray_Pic_time','BTN_date');return false;">
            <img align="middle" border="0" name="BTN_date"  src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="相片發布時間">
        </a>
        <br>

      <input type="submit" value="送出">
      <input type="hidden" name="action" value="listEmps_ByCompositeQuery">
    </FORM>
  </li>
</ul>

<hr>

<!--  -->
<h3>社區流浪動物相簿管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/stray_ani_photos/addStray_Ani_photos.jsp'>Add</a> a new Stray_Ani_photos.</li>
</ul>

<!--  -->


    <hr>

    <h3><font color=orange>社區流浪動物管理</font></h3>

    <ul>
      <li><a href='<%=request.getContextPath()%>/stray_ani/listAllStray_Ani.jsp'>List</a> all Stray_Anis. </li>
    </ul>

    <hr>

    <h3><font color=orange>一般會員管理</font></h3>

    <ul>
      <li><a href='<%=request.getContextPath()%>/mem/listAllMem.jsp'>List</a> all Mems. </li>
    </ul>



<!--  -->

</body>

</html>
