<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Stray_Ani_photos: Home</title>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
</head>
<body bgcolor='white'>
<div id="popupcalendar" class="text"></div>
<table class="table"  border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Stray_Ani_photos: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>社區流浪動物相簿資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_photos/listAllStray_Ani_photos.jsp'>List</a> all Stray_Ani_photoss. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_photos/stray_ani_photos.do" >
        <b>輸入社區流浪動物相簿編號 (如7001):</b>
        <input type="text" name="str_Ani_Pic_No">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="stray_ani_photosSvc" scope="page" class="heibernate_com.stray_ani_photos.model.Stray_Ani_photosService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_photos/stray_ani_photos.do" >
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
   <jsp:useBean id="stray_aniSvc" scope="page" class="heibernate_com.stray_ani.model.Stray_AniService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_photos/stray_ani_photos.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇社區動物編號:</font></b>
	       <select size="1" name="stray_Ani_Id">
	         <c:forEach var="stray_aniVO" items="${stray_aniSvc.all}" > 
	          <option value="${stray_aniVO.stray_Ani_Id}">${stray_aniVO.stray_Ani_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listStray_Ani_photoss_ByStray_Ani_Id_A">
       	</div>
     </FORM>
  </li>
   <jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_photos/stray_ani_photos.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇發布者會員編號:</font></b>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
	          <option value="${memVO.mem_Id}">${memVO.mem_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listStray_Ani_photoss_ByMem_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>社區流浪動物相簿管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_photos/addStray_Ani_photos.jsp'>Add</a> a new Stray_Ani_photos.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Stray_Ani管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/stray_ani/listAllStray_Ani.jsp'>List</a> all Stray_Anis. </li>
	    </ul>
	    <hr>
	    <h3><font color=orange>Mem管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/mem/listAllMem.jsp'>List</a> all Mems. </li>
	    </ul>
<!--  -->
</body>
</html>
