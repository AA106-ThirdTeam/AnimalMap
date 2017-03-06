<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.strayani.model.*"%>
<%
	StrayaniVO strayaniVO = (StrayaniVO) request.getAttribute("strayaniVO"); //StrayaniServlet.java (Concroller), 存入req的strayaniVO物件 (包括幫忙取出的strayaniVO, 也包括輸入資料錯誤時的strayaniVO物件)
%>

<%/**
	Q:update_strayani_input.jsp  ${(strayaniVO.stray_Ani_gender==1) ? 'checked':''}
		沒有set也可以用EL取到。
	A:Control裡面有set。


**/ %>


<html>
<head>
<title>社區動物資料修改 - update_strayani_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>



<h3>資料修改:</h3>
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
		<td>社區動物名字</td>
		<td>
			<input type="TEXT" name="Stray_Ani_name" size="20" value="<%=strayaniVO.getStray_Ani_name()%>">
		</td>
	</tr>
	<tr>
		<td>社區動物動物種類</td>
		<td>
			<input type="TEXT" name="Stray_Ani_type" size="1" value="<%=strayaniVO.getStray_Ani_type()%>">
		</td>
	</tr>
	<tr>
		<td>社區動物性別</td>
		<td>
			<input type="radio" name="Stray_Ani_gender" size="20" value="1" ${(strayaniVO.stray_Ani_gender==1) ? 'checked':''}>公	
			<input type="radio" name="Stray_Ani_gender" size="20" value="0" ${(strayaniVO.stray_Ani_gender==0) ? 'checked':''}>母
		</td>
	</tr>
	<tr>
		<td>社區動物健康狀況</td>
		<td>
			<input type="TEXT" name="Stray_Ani_heal" size="20" value="<%=strayaniVO.getStray_Ani_heal()%>">
		</td>
	</tr>
	<tr>
		<td>社區動物疫苗接踵</td>
		<td>
			<input type="TEXT" name="Stray_Ani_Vac" size="20" value="<%=strayaniVO.getStray_Ani_Vac()%>">
		</td>
	</tr>
	<tr>
		<td>社區動物毛色</td>
		<td>
			<input type="TEXT" name="Stray_Ani_color" size="20" value="<%=strayaniVO.getStray_Ani_color()%>">
		</td>
	</tr>
	<tr>
		<td>社區動物體型</td>
		<td>
			<input type="TEXT" name="Stray_Ani_body" size="20" value="<%=strayaniVO.getStray_Ani_body()%>">
		</td>
	</tr>
	<tr>
		<td>社區動物年齡</td>
		<td>
			<input type="TEXT" name="Stray_Ani_age" size="20" value="<%=strayaniVO.getStray_Ani_age()%>">
		</td>
	</tr>
	<tr>
		<td>社區動物節育</td>
		<td>
			<input type="radio" name="Stray_Ani_Neu" size="20" value="1" ${(strayaniVO.stray_Ani_Neu==1) ? 'checked':''}>已結紮	
			<input type="radio" name="Stray_Ani_Neu" size="20" value="0" ${(strayaniVO.stray_Ani_Neu==0) ? 'checked':''}>未結紮
		</td>
	</tr>
	<tr>
		<td>社區動物晶片編號</td>
		<td>
			<input type="TEXT" name="Stray_Ani_chip" size="15" value="<%=strayaniVO.getStray_Ani_chip()%>">
		</td>
	</tr>

	<tr>
		<!-- 沒有選擇時間就自動填入現在時間 -->
		<%java.sql.Timestamp date_SQL = new java.sql.Timestamp(System.currentTimeMillis());%>
		<td>社區時間:</td>
		<td>
			<input id="datetimepicker1" readonly name="Stray_Ani_date" type="text" value="<%=(strayaniVO==null)? date_SQL : strayaniVO.getStray_Ani_date() %>" />
		</td>
	</tr>
	<tr>
		<td>社區動物物件狀態</td>
		<td>
			<input type="radio" name="Stray_Ani_status" size="20" value="1" ${(strayaniVO.stray_Ani_status==1) ? 'checked':''}>顯　示	
			<input type="radio" name="Stray_Ani_status" size="20" value="0" ${(strayaniVO.stray_Ani_status==0) ? 'checked':''}>不顯示
		</td>
	</tr>

	<tr>
		<td>社區地點經度</td>
		<td>
			<input type="TEXT" name="Stray_Ani_FinLat" size="20" value="<%=strayaniVO.getStray_Ani_FinLat()%>">
		</td>
	</tr>
	<tr>
		<td>社區地點緯度</td>
		<td>
			<input type="TEXT" name="Stray_Ani_FinLon" size="20" value="<%=strayaniVO.getStray_Ani_FinLon()%>">
		</td>
	</tr>
	<tr>
		<td>縣/市</td>
		<td>
			<input type="TEXT" name="Stray_Ani_city" size="20" value="<%=strayaniVO.getStray_Ani_city()%>">
		</td>
	</tr>
	<tr>
		<td>鄉鎮市區</td>
		<td>
			<input type="TEXT" name="Stray_Ani_town" size="20" value="<%=strayaniVO.getStray_Ani_town()%>">
		</td>
	</tr>
	<tr>
		<td>道路街名村里</td>
		<td>
			<input type="TEXT" name="Stray_Ani_road" size="20" value="<%=strayaniVO.getStray_Ani_road()%>">
		</td>
	

</table>


<br>
<input type="hidden" name="action" value="update_formView">
<input type="hidden" name="stray_Ani_Id" value="<%=strayaniVO.getStray_Ani_Id()%>">
<input type="hidden" name="mem_Id" value="<%=strayaniVO.getMem_Id()%>">
<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllEmp.jsp 與 複合查詢 listEmps_ByCompositeQuery.jsp-->
<input type="submit" value="送出修改" ></FORM>



</body>
</html>
