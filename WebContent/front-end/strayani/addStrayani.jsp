<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.strayani.model.*"%>

<%=
	(StrayaniVO) request.getAttribute("strayaniVO")	
	//第一次進到此頁面是null，因為沒有這東西。
%>
<%
	StrayaniVO strayaniVO = (StrayaniVO) request.getAttribute("strayaniVO");	
	//預防錯誤輸入，而保留user所輸入的所有內容，送出後若錯誤不用全部重打。
%>
<%
/**
	※錯誤訊息要注意經緯度的錯誤處理。
**/
%>


<html>
<head>
<title>送養動物資料新增 - addStrayani.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link href="js/jquery-ui-timepicker-addon.css" rel="stylesheet"></link>
<script src="js/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script src="js/jquery-ui-sliderAccess.js" type="text/javascript"></script>




<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
			<h3>送養動物資料新增 - addStrayani.jsp</h3>
			</td>
			<td>
			   <a href="select_page.jsp"><img src="images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
		    </td>
		</tr>
	</table>
	
	<h3>送養動物資料:</h3>
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

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/strayani/strayani.do" name="form1">
	<table border="0">
	
		<tr>
			<td>送養動物名字:</td>
			<td><input type="TEXT" name="Stray_Ani_name" size="20" 	placeholder="請輸入16字元內之名字"
				value="<%= (strayaniVO==null)? "" : strayaniVO.getStray_Ani_name()%>" /></td>
		</tr>
		<tr>
			<!-- 沒有選擇時間就自動填入現在時間 -->
			<%java.sql.Timestamp date_SQL = new java.sql.Timestamp(System.currentTimeMillis());%>
			<td>送養時間:</td>
			<td bgcolor="#CCCCFF" >
			    <input id="datetimepicker1" readonly name="Stray_Ani_date" type="text" value="<%=(strayaniVO==null)? date_SQL : strayaniVO.getStray_Ani_date() %>" />
		</td>
		</tr>  
		
		<tr>
			<td>發布者會員編號:</td>
			<td><input type="TEXT" name="Mem_Id" size="20" placeholder="8碼"
				value="<%= (strayaniVO==null)? "" : strayaniVO.getMem_Id()%>" /></td>
		</tr>
		<tr>
			<td>送養動物動物種類:</td>
			<td><input type="TEXT" name="Stray_Ani_type" size="20" placeholder="貓、狗...."
				value="<%= (strayaniVO==null)? "" : strayaniVO.getStray_Ani_type()%>" /></td>
		</tr>
		<tr>
			<td>送養動物性別:</td>
			<td>
				<input type="radio" name="Stray_Ani_gender" size="20" value="1" ${(strayaniVO.stray_Ani_gender==1) ? 'checked':''}>公	
				<input type="radio" name="Stray_Ani_gender" size="20" value="0" ${(strayaniVO.stray_Ani_gender==0) ? 'checked':''}>母
			</td>
		</tr>
		<tr>
			<td>送養動物健康狀況:</td>
			<td><input type="TEXT" name="Stray_Ani_heal" size="20" placeholder="20字內描述"
				value="<%= (strayaniVO==null)? "" : strayaniVO.getStray_Ani_heal()%>" /></td>
		</tr>
		<tr>
			<td>送養動物疫苗接踵:</td>
			<td><input type="TEXT" name="Stray_Ani_Vac" size="20" placeholder="20字內描述"
				value="<%= (strayaniVO==null)? "" : strayaniVO.getStray_Ani_Vac()%>" /></td>
		</tr>
		<tr>
			<td>送養動物毛色:</td>
			<td><input type="TEXT" name="Stray_Ani_color" size="20" placeholder="20字元內描述"
				value="<%= (strayaniVO==null)? "" : strayaniVO.getStray_Ani_color()%>" /></td>
		</tr>
		<tr>
			<td>送養動物體型:</td>
			<td><input type="TEXT" name="Stray_Ani_body" size="20" placeholder="20字元內描述"
				value="<%= (strayaniVO==null)? "" : strayaniVO.getStray_Ani_body()%>" /></td>
		</tr>

		<tr>
			<td>送養動物年齡:</td>
			<td><input type="TEXT" name="Stray_Ani_age" size="20" placeholder="5字內描述"
				value="<%= (strayaniVO==null)? "" : strayaniVO.getStray_Ani_age()%>" /></td>
		</tr>
		<tr>
			<td>送養動物節育:</td>
			<td>
				<input type="radio" name="Stray_Ani_Neu" size="20" value="1" ${(strayaniVO.stray_Ani_Neu==1) ? 'checked':''}>已結紮	
				<input type="radio" name="Stray_Ani_Neu" size="20" value="0" ${(strayaniVO.stray_Ani_Neu==0) ? 'checked':''}>未結紮
			</td>
		</tr>

		<tr>
			<td>送養動物晶片編號:</td>
			<td><input type="TEXT" name="Stray_Ani_chip" size="20" placeholder="請輸入15碼晶片編號"
				value="<%= (strayaniVO==null)? "" : strayaniVO.getStray_Ani_chip()%>" /></td>
		</tr>
		
		<tr>
			<td>送養動物物件狀態:</td>
			<td>
				<input type="radio" name="Stray_Ani_status" size="20" value="1" ${(strayaniVO.stray_Ani_status==1) ? 'checked':''}>顯　示	
				<input type="radio" name="Stray_Ani_status" size="20" value="0" ${(strayaniVO.stray_Ani_status==0) ? 'checked':''}>不顯示
			</td>
		</tr>		

		<tr>
			<td>縣/市:</td>
			<td><input type="TEXT" name="Stray_Ani_city" size="45"
				value="<%= (strayaniVO==null)? "MANAGER" : strayaniVO.getStray_Ani_city()%>" /></td>
		</tr>
		<tr>
			<td>鄉鎮市區:</td>
			<td><input type="TEXT" name="Stray_Ani_town" size="45"
				value="<%= (strayaniVO==null)? "MANAGER" : strayaniVO.getStray_Ani_town()%>" /></td>
		</tr>
		<tr>
			<td>道路街名村里:</td>
			<td><input type="TEXT" name="Stray_Ani_road" size="45"
				value="<%= (strayaniVO==null)? "MANAGER" : strayaniVO.getStray_Ani_road()%>" /></td>
		</tr>
		<tr>
			<td>送養地點經度:</td>
			<td><input type="TEXT" name="Stray_Ani_FinLat" size="45"
				value="<%= (strayaniVO==null)? "MANAGER" : strayaniVO.getStray_Ani_FinLat()%>" /></td>
		</tr>
		<tr>
			<td>送養地點緯度:</td>
			<td><input type="TEXT" name="Stray_Ani_FinLon" size="45"
				value="<%= (strayaniVO==null)? "MANAGER" : strayaniVO.getStray_Ani_FinLon()%>" /></td>
		</tr>


	</table>
	<br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" value="送出新增">
	</FORM>
</body>

</html>

<script>
	var opt={dateFormat: 'yy-mm-dd',
	        timeFormat: 'HH:mm:ss'
	        };
	$('#datetimepicker1').datetimepicker(opt);
</script>
