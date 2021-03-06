<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.petgroup.model.*"%>
<%
    PetGroupVO petgroupVO = (PetGroupVO) request.getAttribute("petgroupVO"); //PetGroupServlet.java (Concroller), 存入req的petgroupVO物件 (包括幫忙取出的petgroupVO, 也包括輸入資料錯誤時的petgroupVO物件)
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
	<title>揪團資料修改 - update_petgroup_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>揪團資料 - ListOnePetGroup.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/petgroup/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="petgroup.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>活動編號編號:<font color=red><b>*</b></font></td>
        <td><%=petgroupVO.getGrp_Id()%></td>
    </tr>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>會員編號(負責人):<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="grp_MemId">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(petgroupVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
${memVO.mem_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
    <tr>
        <td>名稱:</td>
        <td><input type="TEXT" name="grp_name" size="45" value="<%=petgroupVO.getGrp_name()%>" /></td>
    </tr>
    <tr>
        <td>縣/市:</td>
        <td><input type="TEXT" name="grp_city" size="45" value="<%=petgroupVO.getGrp_city()%>" /></td>
    </tr>
    <tr>
        <td>鄉鎮市區道路:</td>
        <td><input type="TEXT" name="GRP_TOWN" size="45" value="<%=petgroupVO.getGRP_TOWN()%>" /></td>
    </tr>
    <tr>
        <td>道路街名村里:</td>
        <td><input type="TEXT" name="grp_road" size="45" value="<%=petgroupVO.getGrp_road()%>" /></td>
    </tr>
	<tr>
		<td>結束時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="grp_EndTime" value="<%=petgroupVO.getGrp_EndTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','grp_EndTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="結束時間"></a>
		</td>
	</tr>
	<tr>
		<td>開始時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="grp_StartTime" value="<%=petgroupVO.getGrp_StartTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','grp_StartTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="開始時間"></a>
		</td>
	</tr>
	<tr>
		<td>建立時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="grp_CreateTime" value="<%=petgroupVO.getGrp_CreateTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','grp_CreateTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="建立時間"></a>
		</td>
	</tr>
    <tr>
        <td>揪團敘述:</td>
        <td><input type="TEXT" name="grp_Desc" size="45" value="<%=petgroupVO.getGrp_Desc()%>" /></td>
    </tr>
    <tr>
        <td>商家經度座標:</td>
        <td><input type="TEXT" name="grp_Long" size="45" value="<%=petgroupVO.getGrp_Long()%>" /></td>
    </tr>
    <tr>
        <td>商家緯度座標:</td>
        <td><input type="TEXT" name="grp_Lat" size="45" value="<%=petgroupVO.getGrp_Lat()%>" /></td>
    </tr>
    <tr>
        <td>物件顯示狀態:</td>
        <td><input type="TEXT" name="grp_visible" size="45" value="<%=petgroupVO.getGrp_visible()%>" /></td>
    </tr>
	<tr>
		<td>揪團照片:</td>
		<td><input type="file" name="GRP_PHOTO" size=45></td>
	</tr>	
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="grp_Id" value="<%=petgroupVO.getGrp_Id()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllPetGroup.jsp 與 複合查詢 listPetGroups_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
