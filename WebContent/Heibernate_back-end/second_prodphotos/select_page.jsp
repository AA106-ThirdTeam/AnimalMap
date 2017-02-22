<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Second_ProdPhotos: Home</title>
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
    <h3>表格 Second_ProdPhotos: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>二手商品相簿資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/second_prodphotos/listAllSecond_ProdPhotos.jsp'>List</a> all Second_ProdPhotoss. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/second_prodphotos/second_prodphotos.do" >
        <b>輸入二手商品相簿編號 (如7001):</b>
        <input type="text" name="second_ProdPhotos_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="second_prodphotosSvc" scope="page" class="heibernate_com.second_prodphotos.model.Second_ProdPhotosService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/second_prodphotos/second_prodphotos.do" >
       <b>選擇二手商品相簿編號:</b>
       <select size="1" name="second_ProdPhotos_Id">
         <c:forEach var="second_prodphotosVO" items="${second_prodphotosSvc.all}" > 
          <option value="${second_prodphotosVO.second_ProdPhotos_Id}">${second_prodphotosVO.second_ProdPhotos_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="second_prodSvc" scope="page" class="heibernate_com.second_prod.model.Second_ProdService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/second_prodphotos/second_prodphotos.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇二手商品編號:</font></b>
	       <select size="1" name="second_Prod_Id">
	         <c:forEach var="second_prodVO" items="${second_prodSvc.all}" > 
	          <option value="${second_prodVO.second_Prod_Id}">${second_prodVO.second_Prod_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listSecond_ProdPhotoss_BySecond_Prod_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>二手商品相簿管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/second_prodphotos/addSecond_ProdPhotos.jsp'>Add</a> a new Second_ProdPhotos.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Second_Prod管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/second_prod/listAllSecond_Prod.jsp'>List</a> all Second_Prods. </li>
	    </ul>
<!--  -->
</body>
</html>
