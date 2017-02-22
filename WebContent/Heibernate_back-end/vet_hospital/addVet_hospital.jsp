<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.vet_hospital.model.*"%>
<%
Vet_hospitalVO vet_hospitalVO = (Vet_hospitalVO) request.getAttribute("vet_hospitalVO");
%>
<html>
<head>
<title>診所新增 - addVet_hospital.jsp</title>
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
		<h3>診所新增 - addVet_hospital.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/vet_hospital/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>診所:</h3>
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
<FORM METHOD="post" ACTION="vet_hospital.do" name="form1">
<table border="0">
	<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>會員編號(負責人):<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="memVO" items="${memSvc.all}">
				<option value="${memVO.mem_Id}" ${(vet_hospitalVO.memVO.mem_Id==memVO.mem_Id)? 'selected':'' } >${memVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>診所名稱:</td>
		<td><input type="TEXT" name="hos_name" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_name()%>" /></td>
	</tr>	
	<tr>
		<td>縣/市:</td>
		<td><input type="TEXT" name="hos_city" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_city()%>" /></td>
	</tr>	
	<tr>
		<td>鄉鎮市區:</td>
		<td><input type="TEXT" name="hos_town" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_town()%>" /></td>
	</tr>	
	<tr>
		<td>道路街名村里:</td>
		<td><input type="TEXT" name="hos_road" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_road()%>" /></td>
	</tr>	
	<tr>
		<td>評價:</td>
		<td><input type="TEXT" name="hos_Eval" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_Eval()%>" /></td>
	</tr>	
	<tr>
		<td>URL:</td>
		<td><input type="TEXT" name="hos_URL" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_URL()%>" /></td>
	</tr>	
	<tr>
		<td>開始營業時間:</td>
		<td><input type="TEXT" name="hos_StartTime" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_StartTime()%>" /></td>
	</tr>	
	<tr>
		<td>結束營業時間:</td>
		<td><input type="TEXT" name="hos_EndTime" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_EndTime()%>" /></td>
	</tr>	
	<tr>
		<td>電話:</td>
		<td><input type="TEXT" name="hos_Tel" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_Tel()%>" /></td>
	</tr>	
	<tr>
		<td>診所敘述:</td>
		<td><input type="TEXT" name="hos_Desc" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_Desc()%>" /></td>
	</tr>	
	<tr>
		<td>診所經度座標:</td>
		<td><input type="TEXT" name="hos_Long" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_Long()%>" /></td>
	</tr>	
	<tr>
		<td>診所緯度座標:</td>
		<td><input type="TEXT" name="hos_Lat" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_Lat()%>" /></td>
	</tr>	
	<tr>
		<%java.sql.Date date_hos_CreateTime = new java.sql.Date(System.currentTimeMillis());%>
		<td>建立時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="hos_CreateTime" value="<%= (vet_hospitalVO==null)? date_hos_CreateTime : vet_hospitalVO.getHos_CreateTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','hos_CreateTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="建立時間"></a>
		</td>
	</tr>
	<tr>
		<td>物件顯示狀態:</td>
		<td><input type="TEXT" name="hos_visible" size="45"
			value="<%= (vet_hospitalVO==null)? "1" : vet_hospitalVO.getHos_visible()%>" /></td>
	</tr>	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
