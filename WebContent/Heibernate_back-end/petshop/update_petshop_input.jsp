<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.petshop.model.*"%>
<%
    PetShopVO petshopVO = (PetShopVO) request.getAttribute("petshopVO"); //PetShopServlet.java (Concroller), 存入req的petshopVO物件 (包括幫忙取出的petshopVO, 也包括輸入資料錯誤時的petshopVO物件)
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
	<title>寵物商店資料修改 - update_petshop_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>寵物商店資料 - ListOnePetShop.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/petshop/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="petshop.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>商家編號編號:<font color=red><b>*</b></font></td>
        <td><%=petshopVO.getShop_Id()%></td>
    </tr>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>會員編號(負責人):<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="shop_MemId">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(petshopVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
${memVO.mem_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
    <tr>
        <td>商家名稱:</td>
        <td><input type="TEXT" name="shop_name" size="45" value="<%=petshopVO.getShop_name()%>" /></td>
    </tr>
    <tr>
        <td>縣/市:</td>
        <td><input type="TEXT" name="shop_city" size="45" value="<%=petshopVO.getShop_city()%>" /></td>
    </tr>
    <tr>
        <td>鄉鎮市區:</td>
        <td><input type="TEXT" name="shop_town" size="45" value="<%=petshopVO.getShop_town()%>" /></td>
    </tr>
    <tr>
        <td>道路街名村里:</td>
        <td><input type="TEXT" name="shop_road" size="45" value="<%=petshopVO.getShop_road()%>" /></td>
    </tr>
    <tr>
        <td>評價:</td>
        <td><input type="TEXT" name="shop_Eval" size="45" value="<%=petshopVO.getShop_Eval()%>" /></td>
    </tr>	
    <tr>
        <td>URL:</td>
        <td><input type="TEXT" name="shop_URL" size="45" value="<%=petshopVO.getShop_URL()%>" /></td>
    </tr>
    <tr>
        <td>開始營業時間:</td>
        <td><input type="TEXT" name="shop_StartTime" size="45" value="<%=petshopVO.getShop_StartTime()%>" /></td>
    </tr>
    <tr>
        <td>結束營業時間:</td>
        <td><input type="TEXT" name="shop_EndTime" size="45" value="<%=petshopVO.getShop_EndTime()%>" /></td>
    </tr>
    <tr>
        <td>電話:</td>
        <td><input type="TEXT" name="shop_Tel" size="45" value="<%=petshopVO.getShop_Tel()%>" /></td>
    </tr>
    <tr>
        <td>商家敘述:</td>
        <td><input type="TEXT" name="shop_Desc" size="45" value="<%=petshopVO.getShop_Desc()%>" /></td>
    </tr>
    <tr>
        <td>商家經度座標:</td>
        <td><input type="TEXT" name="shop_Long" size="45" value="<%=petshopVO.getShop_Long()%>" /></td>
    </tr>
    <tr>
        <td>商家緯度座標:</td>
        <td><input type="TEXT" name="shop_Lat" size="45" value="<%=petshopVO.getShop_Lat()%>" /></td>
    </tr>
	<tr>
		<td>建立時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="shop_CreateTime" value="<%=petshopVO.getShop_CreateTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','shop_CreateTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="建立時間"></a>
		</td>
	</tr>
    <tr>
        <td>物件顯示狀態:</td>
        <td><input type="TEXT" name="shop_visible" size="45" value="<%=petshopVO.getShop_visible()%>" /></td>
    </tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="shop_Id" value="<%=petshopVO.getShop_Id()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllPetShop.jsp 與 複合查詢 listPetShops_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
