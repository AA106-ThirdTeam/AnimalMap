<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.shop_photo.model.*"%>
<%
    Shop_photoVO shop_photoVO = (Shop_photoVO) request.getAttribute("shop_photoVO"); //Shop_photoServlet.java (Concroller), 存入req的shop_photoVO物件 (包括幫忙取出的shop_photoVO, 也包括輸入資料錯誤時的shop_photoVO物件)
%>
<!--  -->
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
<html>
<head>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<title>商家相片資料修改 - update_shop_photo_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>商家相片資料 - ListOneShop_photo.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="shop_photo.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>相片編號編號:<font color=red><b>*</b></font></td>
        <td><%=shop_photoVO.getShopPhoto_Id()%></td>
    </tr>
<jsp:useBean id="petShopSvc" scope="page" class="heibernate_com.petshop.model.PetShopService" />
	<tr>
		<td>商家編號(相片擁有商家):<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="shopPhoto_ShopId">
	         <c:forEach var="petShopVO" items="${petShopSvc.all}" > 
				<option value="${petShopVO.shop_Id}" ${(shop_photoVO.petShopVO.shop_Id==petShopVO.shop_Id)?'selected':'' } >
${petShopVO.shop_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
	<tr>
		<td>相片:</td>
		<td><input type="file" name="shopPhoto_photo" size=45></td>
	</tr>	
    <tr>
        <td>是否為大頭貼相片:</td>
        <td><input type="TEXT" name="isDisp_shopPhoto" size="45" value="<%=shop_photoVO.getIsDisp_shopPhoto()%>" /></td>
    </tr>
    <tr>
        <td>相片名稱:</td>
        <td><input type="TEXT" name="shopPhoto_name" size="45" value="<%=shop_photoVO.getShopPhoto_name()%>" /></td>
    </tr>
    <tr>
        <td>相片副檔名:</td>
        <td><input type="TEXT" name="SHOPPHOTO_EXTENTION" size="45" value="<%=shop_photoVO.getSHOPPHOTO_EXTENTION()%>" /></td>
    </tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="shopPhoto_Id" value="<%=shop_photoVO.getShopPhoto_Id()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllShop_photo.jsp 與 複合查詢 listShop_photos_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
