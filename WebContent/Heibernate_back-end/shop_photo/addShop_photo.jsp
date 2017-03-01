<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.shop_photo.model.*"%>
<%
Shop_photoVO shop_photoVO = (Shop_photoVO) request.getAttribute("shop_photoVO");
%>
<html>
<head>
<title>商家相片新增 - addShop_photo.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
</head>
<body bgcolor='white'>
<!--  -->
<div id="popupcalendar" class="text"></div>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>商家相片新增 - addShop_photo.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>商家相片:</h3>
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
<FORM METHOD="post" ACTION="shop_photo.do" name="form1">
<table border="0">
	<jsp:useBean id="petshopSvc" scope="page" class="heibernate_com.petshop.model.PetShopService" />
	<tr>
		<td>商家編號(相片擁有商家):<font color=red><b>*</b></font></td>
		<td><select size="1" name="shop_Id">
			<c:forEach var="petshopVO" items="${petshopSvc.all}">
				<option value="${petshopVO.shop_Id}" ${(shop_photoVO.petshopVO.shop_Id==petshopVO.shop_Id)? 'selected':'' } >${petshopVO.shop_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>相片:</td>
		<td><input type="file" name="shopPhoto_photo" size=45></td>
	</tr>
	<tr>
		<td>是否為大頭貼相片:</td>
		<td><input type="TEXT" name="isDisp_shopPhoto" size="45"
			value="<%= (shop_photoVO==null)? "1" : shop_photoVO.getIsDisp_shopPhoto()%>" /></td>
	</tr>	
	<tr>
		<td>相片名稱:</td>
		<td><input type="TEXT" name="shopPhoto_name" size="45"
			value="<%= (shop_photoVO==null)? "1" : shop_photoVO.getShopPhoto_name()%>" /></td>
	</tr>	
	<tr>
		<td>相片副檔名:</td>
		<td><input type="TEXT" name="SHOPPHOTO_EXTENTION" size="45"
			value="<%= (shop_photoVO==null)? "1" : shop_photoVO.getSHOPPHOTO_EXTENTION()%>" /></td>
	</tr>	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
