<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.pet.model.*"%>
<%
PetVO petVO = (PetVO) request.getAttribute("petVO");
%>
<html>
<head>
<title>自家寵物新增 - addPet.jsp</title>
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
		<h3>自家寵物新增 - addPet.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/pet/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>自家寵物:</h3>
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
<FORM METHOD="post" ACTION="pet.do" name="form1">
<table border="0">
	<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>主人會員編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="memVO" items="${memSvc.all}">
				<option value="${memVO.mem_Id}" ${(petVO.memVO.mem_Id==memVO.mem_Id)? 'selected':'' } >${memVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>寵物名字:</td>
		<td><input type="TEXT" name="pet_name" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_name()%>" /></td>
	</tr>	
	<tr>
		<td>寵物種類:</td>
		<td><input type="TEXT" name="pet_type" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_type()%>" /></td>
	</tr>	
	<tr>
		<td>寵物性別:</td>
		<td><input type="TEXT" name="pet_gender" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_gender()%>" /></td>
	</tr>	
	<tr>
		<td>寵物健康狀況:</td>
		<td><input type="TEXT" name="pet_heal" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_heal()%>" /></td>
	</tr>	
	<tr>
		<td>寵物疫苗接踵:</td>
		<td><input type="TEXT" name="pet_Vac" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_Vac()%>" /></td>
	</tr>	
	<tr>
		<td>寵物毛色:</td>
		<td><input type="TEXT" name="pet_color" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_color()%>" /></td>
	</tr>	
	<tr>
		<td>寵物體型:</td>
		<td><input type="TEXT" name="pet_body" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_body()%>" /></td>
	</tr>	
	<tr>
		<td>寵物年齡:</td>
		<td><input type="TEXT" name="pet_age" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_age()%>" /></td>
	</tr>	
	<tr>
		<td>寵物節育:</td>
		<td><input type="TEXT" name="pet_Neu" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_Neu()%>" /></td>
	</tr>	
	<tr>
		<td>寵物晶片編號:</td>
		<td><input type="TEXT" name="pet_chip" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_chip()%>" /></td>
	</tr>	
	<tr>
		<%java.sql.Date date_pet_birth = new java.sql.Date(System.currentTimeMillis());%>
		<td>寵物生日:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="pet_birth" value="<%= (petVO==null)? date_pet_birth : petVO.getPet_birth()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','pet_birth','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="寵物生日"></a>
		</td>
	</tr>
	<tr>
		<td>寵物物件狀態:</td>
		<td><input type="TEXT" name="pet_status" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_status()%>" /></td>
	</tr>	
	<tr>
		<%java.sql.Date date_pet_CreDATE = new java.sql.Date(System.currentTimeMillis());%>
		<td>寵物建立時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="pet_CreDATE" value="<%= (petVO==null)? date_pet_CreDATE : petVO.getPet_CreDATE()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','pet_CreDATE','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="寵物建立時間"></a>
		</td>
	</tr>
	<tr>
		<td>縣市:</td>
		<td><input type="TEXT" name="pet_city" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_city()%>" /></td>
	</tr>	
	<tr>
		<td>鄉鎮市區:</td>
		<td><input type="TEXT" name="pet_town" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_town()%>" /></td>
	</tr>	
	<tr>
		<td>道路街名村里:</td>
		<td><input type="TEXT" name="pet_road" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_road()%>" /></td>
	</tr>	
	<tr>
		<td>送養地點經度:</td>
		<td><input type="TEXT" name="pet_FinLat" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_FinLat()%>" /></td>
	</tr>	
	<tr>
		<td>送養地點緯度:</td>
		<td><input type="TEXT" name="pet_FinLon" size="45"
			value="<%= (petVO==null)? "1" : petVO.getPet_FinLon()%>" /></td>
	</tr>	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
