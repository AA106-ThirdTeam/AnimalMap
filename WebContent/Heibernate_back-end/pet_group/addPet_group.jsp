<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.pet_group.model.*"%>
<%
Pet_groupVO pet_groupVO = (Pet_groupVO) request.getAttribute("pet_groupVO");
%>
<html>
<head>
<title>揪團新增 - addPet_group.jsp</title>
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
		<h3>揪團新增 - addPet_group.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/pet_group/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>揪團:</h3>
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
<FORM METHOD="post" ACTION="pet_group.do" name="form1">
<table border="0">
	<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>會員編號(負責人):<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="memVO" items="${memSvc.all}">
				<option value="${memVO.mem_Id}" ${(pet_groupVO.memVO.mem_Id==memVO.mem_Id)? 'selected':'' } >${memVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>名稱:</td>
		<td><input type="TEXT" name="grp_name" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_name()%>" /></td>
	</tr>	
	<tr>
		<td>縣/市:</td>
		<td><input type="TEXT" name="grp_city" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_city()%>" /></td>
	</tr>	
	<tr>
		<td>鄉鎮市區道路:</td>
		<td><input type="TEXT" name="grp_Addr" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_Addr()%>" /></td>
	</tr>	
	<tr>
		<td>道路街名村里:</td>
		<td><input type="TEXT" name="grp_road" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_road()%>" /></td>
	</tr>	
	<tr>
		<td>開始時間:</td>
		<td><input type="TEXT" name="grp_StartTime" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_StartTime()%>" /></td>
	</tr>	
	<tr>
		<td>結束時間:</td>
		<td><input type="TEXT" name="grp_EndTime" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_EndTime()%>" /></td>
	</tr>	
	<tr>
		<td>揪團敘述:</td>
		<td><input type="TEXT" name="grp_Desc" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_Desc()%>" /></td>
	</tr>	
	<tr>
		<td>商家經度座標:</td>
		<td><input type="TEXT" name="grp_Long" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_Long()%>" /></td>
	</tr>	
	<tr>
		<td>商家緯度座標:</td>
		<td><input type="TEXT" name="grp_Lat" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_Lat()%>" /></td>
	</tr>	
	<tr>
		<%java.sql.Date date_grp_CreateTime = new java.sql.Date(System.currentTimeMillis());%>
		<td>建立時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="grp_CreateTime" value="<%= (pet_groupVO==null)? date_grp_CreateTime : pet_groupVO.getGrp_CreateTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','grp_CreateTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="建立時間"></a>
		</td>
	</tr>
	<tr>
		<td>物件顯示狀態:</td>
		<td><input type="TEXT" name="grp_visible" size="45"
			value="<%= (pet_groupVO==null)? "1" : pet_groupVO.getGrp_visible()%>" /></td>
	</tr>	
	<tr>
		<td>:</td>
		<td><input type="file" name="grp_photo" size=45></td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
