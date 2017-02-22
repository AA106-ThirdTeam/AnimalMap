<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.second_prod.model.*"%>
<%
    Second_ProdVO second_prodVO = (Second_ProdVO) request.getAttribute("second_prodVO"); //Second_ProdServlet.java (Concroller), 存入req的second_prodVO物件 (包括幫忙取出的second_prodVO, 也包括輸入資料錯誤時的second_prodVO物件)
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
	<title>二手商品資料修改 - update_second_prod_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>二手商品資料 - ListOneSecond_Prod.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/second_prod/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="second_prod.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>二手商品編號編號:<font color=red><b>*</b></font></td>
        <td><%=second_prodVO.getSecond_Prod_Id()%></td>
    </tr>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>發布會員編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(second_prodVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
${memVO.mem_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
    <tr>
        <td>二手商品標題:</td>
        <td><input type="TEXT" name="second_Prod_Title" size="45" value="<%=second_prodVO.getSecond_Prod_Title()%>" /></td>
    </tr>
    <tr>
        <td>二手商品內容:</td>
        <td><input type="TEXT" name="second_Prod_Content" size="45" value="<%=second_prodVO.getSecond_Prod_Content()%>" /></td>
    </tr>
	<tr>
		<td>二手商品發布時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="second_Prod_adp_start_date" value="<%=second_prodVO.getSecond_Prod_adp_start_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','second_Prod_adp_start_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="二手商品發布時間"></a>
		</td>
	</tr>
	<tr>
		<td>二手商品截止時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="second_Prod_adp_end_date" value="<%=second_prodVO.getSecond_Prod_adp_end_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','second_Prod_adp_end_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="二手商品截止時間"></a>
		</td>
	</tr>
	<tr>
		<td>二手商品更新時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="second_Prod_adp_upDate" value="<%=second_prodVO.getSecond_Prod_adp_upDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','second_Prod_adp_upDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="二手商品更新時間"></a>
		</td>
	</tr>
    <tr>
        <td>縣市:</td>
        <td><input type="TEXT" name="second_Prod_adp_city" size="45" value="<%=second_prodVO.getSecond_Prod_adp_city()%>" /></td>
    </tr>
    <tr>
        <td>鄉鎮市區:</td>
        <td><input type="TEXT" name="second_Prod_Town" size="45" value="<%=second_prodVO.getSecond_Prod_Town()%>" /></td>
    </tr>
    <tr>
        <td>道路街名村里:</td>
        <td><input type="TEXT" name="second_Prod_Road" size="45" value="<%=second_prodVO.getSecond_Prod_Road()%>" /></td>
    </tr>
    <tr>
        <td>二手商品經度座標:</td>
        <td><input type="TEXT" name="second_Prod_Lon" size="45" value="<%=second_prodVO.getSecond_Prod_Lon()%>" /></td>
    </tr>
    <tr>
        <td>緯度座標緯度座標:</td>
        <td><input type="TEXT" name="second_Prod_Lat" size="45" value="<%=second_prodVO.getSecond_Prod_Lat()%>" /></td>
    </tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="second_Prod_Id" value="<%=second_prodVO.getSecond_Prod_Id()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllSecond_Prod.jsp 與 複合查詢 listSecond_Prods_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
