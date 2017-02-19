<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 AdoAniSpo: Home</title>
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
    <h3>表格 AdoAniSpo: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>送養動物領養人資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/adoanispo/listAllAdoAniSpo.jsp'>List</a> all AdoAniSpos. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/adoanispo/adoanispo.do" >
        <b>輸入送養動物領養人編號 (如7001):</b>
        <input type="text" name="adoAniSpoNo">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="adoanispoSvc" scope="page" class="heibernate_com.adoanispo.model.AdoAniSpoService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/adoanispo/adoanispo.do" >
       <b>選擇送養動物領養人編號:</b>
       <select size="1" name="adoAniSpoNo">
         <c:forEach var="adoanispoVO" items="${adoanispoSvc.all}" > 
          <option value="${adoanispoVO.adoAniSpoNo}">${adoanispoVO.adoAniSpoNo}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="adopt_aniSvc" scope="page" class="heibernate_com.adopt_ani.model.Adopt_AniService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/adoanispo/adoanispo.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇送養動物編號:</font></b>
	       <select size="1" name="adopt_Ani_Id">
	         <c:forEach var="adopt_aniVO" items="${adopt_aniSvc.all}" > 
	          <option value="${adopt_aniVO.adopt_Ani_Id}">${adopt_aniVO.adopt_Ani_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listAdoAniSpos_ByAdopt_Ani_Id_A">
       	</div>
     </FORM>
  </li>
   <jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/adoanispo/adoanispo.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇贊助者會員編號:</font></b>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
	          <option value="${memVO.mem_Id}">${memVO.mem_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listAdoAniSpos_ByMem_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>送養動物領養人管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/adoanispo/addAdoAniSpo.jsp'>Add</a> a new AdoAniSpo.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Adopt_Ani管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/adopt_ani/listAllAdopt_Ani.jsp'>List</a> all Adopt_Anis. </li>
	    </ul>
	    <hr>
	    <h3><font color=orange>Mem管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/mem/listAllMem.jsp'>List</a> all Mems. </li>
	    </ul>
<!--  -->
</body>
</html>
