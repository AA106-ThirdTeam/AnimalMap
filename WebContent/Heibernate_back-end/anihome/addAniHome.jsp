<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.anihome.model.*"%>
<%
AniHomeVO anihomeVO = (AniHomeVO) request.getAttribute("anihomeVO");
%>
<html>
<head>
<title>動物之家新增 - addAniHome.jsp</title>
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
		<h3>動物之家新增 - addAniHome.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/anihome/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>動物之家:</h3>
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
<FORM METHOD="post" ACTION="anihome.do" name="form1">
<table border="0">
	<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>會員編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="memVO" items="${memSvc.all}">
				<option value="${memVO.mem_Id}" ${(anihomeVO.memVO.mem_Id==memVO.mem_Id)? 'selected':'' } >${memVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>動物之家標題:</td>
		<td><input type="TEXT" name="aniHome_title" size="45"
			value="<%= (anihomeVO==null)? "1" : anihomeVO.getAniHome_title()%>" /></td>
	</tr>	
	<tr>
		<td>動物之家內容:</td>
		<td><input type="TEXT" name="aniHome_content" size="45"
			value="<%= (anihomeVO==null)? "1" : anihomeVO.getAniHome_content()%>" /></td>
	</tr>	
	<tr>
		<%java.sql.Timestamp date_aniHome_start_date = new java.sql.Timestamp(System.currentTimeMillis());%>
		<td>動物之家發布時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="aniHome_start_date" value="<%= (anihomeVO==null)? date_aniHome_start_date : anihomeVO.getAniHome_start_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','aniHome_start_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="動物之家發布時間"></a>
		</td>
	</tr>
	<tr>
		<%java.sql.Timestamp date_aniHome_upDate = new java.sql.Timestamp(System.currentTimeMillis());%>
		<td>動物之家更新時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="aniHome_upDate" value="<%= (anihomeVO==null)? date_aniHome_upDate : anihomeVO.getAniHome_upDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','aniHome_upDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="動物之家更新時間"></a>
		</td>
	</tr>
	<tr>
		<td>縣市:</td>
		<td><input type="TEXT" name="aniHome_city" size="45"
			value="<%= (anihomeVO==null)? "1" : anihomeVO.getAniHome_city()%>" /></td>
	</tr>	
	<tr>
		<td>鄉鎮市區:</td>
		<td><input type="TEXT" name="aniHome_town" size="45"
			value="<%= (anihomeVO==null)? "1" : anihomeVO.getAniHome_town()%>" /></td>
	</tr>	
	<tr>
		<td>道路街名村里:</td>
		<td><input type="TEXT" name="aniHome_road" size="45"
			value="<%= (anihomeVO==null)? "1" : anihomeVO.getAniHome_road()%>" /></td>
	</tr>	
	<tr>
		<td>地址:</td>
		<td><input type="TEXT" name="aniHome_addr" size="45"
			value="<%= (anihomeVO==null)? "1" : anihomeVO.getAniHome_addr()%>" /></td>
	</tr>	
	<tr>
		<td>動物之家經度座標:</td>
		<td><input type="TEXT" name="aniHome_lon" size="45"
			value="<%= (anihomeVO==null)? "1" : anihomeVO.getAniHome_lon()%>" /></td>
	</tr>	
	<tr>
		<td>緯度座標緯度座標:</td>
		<td><input type="TEXT" name="aniHome_lat" size="45"
			value="<%= (anihomeVO==null)? "1" : anihomeVO.getAniHome_lat()%>" /></td>
	</tr>	
	<tr>
		<td>預覽圖:</td>
		<td><input type="TEXT" name="aniHome_pic" size="45"
			value="<%= (anihomeVO==null)? "1" : anihomeVO.getAniHome_pic()%>" /></td>
	</tr>	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
