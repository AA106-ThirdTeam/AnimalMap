<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 HosPhoto: Home</title>
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
    <h3>表格 HosPhoto: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>診所相片資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/hosphoto/listAllHosPhoto.jsp'>List</a> all HosPhotos. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/hosphoto/hosphoto.do" >
        <b>輸入診所相片編號 (如7001):</b>
        <input type="text" name="hosPhoto_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="hosphotoSvc" scope="page" class="heibernate_com.hosphoto.model.HosPhotoService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/hosphoto/hosphoto.do" >
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
   <jsp:useBean id="vet_hospitalSvc" scope="page" class="heibernate_com.vet_hospital.model.Vet_hospitalService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/hosphoto/hosphoto.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇診所編號(相片擁有診所):</font></b>
	       <select size="1" name="hosPhoto_HosId">
	         <c:forEach var="vet_hospitalVO" items="${vet_hospitalSvc.all}" > 
	          <option value="${vet_hospitalVO.hos_Id}">${vet_hospitalVO.hos_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listHosPhotos_ByHos_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/hosphoto/hosphoto.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
       <b>選擇相片編號編號:</b>
       <select size="1" name="hosPhoto_Id">
            <option value=""/>
         <c:forEach var="hosphotoVO" items="${hosphotoSvc.all}" > 
          <option value="${hosphotoVO.hosPhoto_Id}">${hosphotoVO.hosPhoto_Id}
         </c:forEach>   
       </select>   
       <br>  
       <b>選擇診所編號(相片擁有診所)編號:</b>
       <select size="1" name="hosPhoto_HosId">
         <c:forEach var="vet_hospitalVO" items="${vet_hospitalSvc.all}" > 
          <option value="${vet_hospitalVO.hos_Id}">${vet_hospitalVO.hos_Id}
         </c:forEach>   
       </select>
       <br> 
      <input type="submit" value="送出">
      <input type="hidden" name="action" value="list_ByCompositeQuery">
    </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>診所相片管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/hosphoto/addHosPhoto.jsp'>Add</a> a new HosPhoto.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Vet_hospital管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/vet_hospital/listAllVet_hospital.jsp'>List</a> all Vet_hospitals. </li>
	    </ul>
<!--  -->
</body>
</html>
