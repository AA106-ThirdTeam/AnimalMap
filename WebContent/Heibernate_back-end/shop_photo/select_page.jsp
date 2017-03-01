<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Shop_photo: Home</title>
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
    <h3>表格 Shop_photo: Home</h3><font color=red>( MVC )</font>
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
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/listAllShop_photo.jsp'>List</a> all Shop_photos. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/shop_photo.do" >
        <b>輸入商家相片編號 (如7001):</b>
        <input type="text" name="shopPhoto_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="shop_photoSvc" scope="page" class="heibernate_com.shop_photo.model.Shop_photoService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/shop_photo.do" >
       <b>選擇商家相片編號:</b>
       <select size="1" name="shopPhoto_Id">
         <c:forEach var="shop_photoVO" items="${shop_photoSvc.all}" > 
          <option value="${shop_photoVO.shopPhoto_Id}">${shop_photoVO.shopPhoto_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="petshopSvc" scope="page" class="heibernate_com.petshop.model.PetShopService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/shop_photo.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇商家編號(相片擁有商家):</font></b>
	       <select size="1" name="shopPhoto_ShopId">
	         <c:forEach var="petshopVO" items="${petshopSvc.all}" > 
	          <option value="${petshopVO.shop_Id}">${petshopVO.shop_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listShop_photos_ByShop_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/shop_photo.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
       <b>選擇相片編號編號:</b>
       <select size="1" name="shopPhoto_Id">
            <option value=""/>
         <c:forEach var="shop_photoVO" items="${shop_photoSvc.all}" > 
          <option value="${shop_photoVO.shopPhoto_Id}">${shop_photoVO.shopPhoto_Id}
         </c:forEach>   
       </select>   
       <br>  
       <b>選擇商家編號(相片擁有商家)編號:</b>
       <select size="1" name="shopPhoto_ShopId">
         <c:forEach var="petShopVO" items="${petShopSvc.all}" > 
          <option value="${petShopVO.shop_Id}">${petShopVO.shop_Id}
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
<h3>商家相片管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/addShop_photo.jsp'>Add</a> a new Shop_photo.</li>
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
