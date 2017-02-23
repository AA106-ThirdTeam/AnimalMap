<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 ShopPhoto: Home</title>
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
    <h3>表格 ShopPhoto: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>商家相片資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/shopphoto/listAllShopPhoto.jsp'>List</a> all ShopPhotos. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/shopphoto/shopphoto.do" >
        <b>輸入商家相片編號 (如7001):</b>
        <input type="text" name="shopPhoto_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="shopphotoSvc" scope="page" class="heibernate_com.shopphoto.model.ShopPhotoService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/shopphoto/shopphoto.do" >
       <b>選擇商家相片編號:</b>
       <select size="1" name="shopPhoto_Id">
         <c:forEach var="shopphotoVO" items="${shopphotoSvc.all}" > 
          <option value="${shopphotoVO.shopPhoto_Id}">${shopphotoVO.shopPhoto_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="petshopSvc" scope="page" class="heibernate_com.petshop.model.PetShopService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/shopphoto/shopphoto.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇商家編號(相片擁有商家):</font></b>
	       <select size="1" name="shopPhoto_ShopId">
	         <c:forEach var="petshopVO" items="${petshopSvc.all}" > 
	          <option value="${petshopVO.shop_Id}">${petshopVO.shop_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listShopPhotos_ByShop_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>商家相片管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/shopphoto/addShopPhoto.jsp'>Add</a> a new ShopPhoto.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>PetShop管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/petshop/listAllPetShop.jsp'>List</a> all PetShops. </li>
	    </ul>
<!--  -->
</body>
</html>
