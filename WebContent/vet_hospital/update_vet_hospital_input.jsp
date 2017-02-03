 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.vet_hospital.model.*"%>
<%
    Vet_hospitalVO vet_hospitalVO = (Vet_hospitalVO) request.getAttribute("vet_hospitalVO"); //Vet_hospitalServlet.java (Concroller), 存入req的vet_hospitalVO物件 (包括幫忙取出的vet_hospitalVO, 也包括輸入資料錯誤時的vet_hospitalVO物件)
%>

<!--  -->

<html>
<head>
<title>診所資料修改 - update_vet_hospital_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>診所資料 - ListOneVet_hospital.jsp</h3>
        <a href="<%=request.getContextPath()%>/vet_hospital/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

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

<FORM METHOD="post" ACTION="vet_hospital.do" name="form1">
    <table border="0">

    <!--  -->
        <tr>
        <td>診所編號編號:<font color=red><b>*</b></font></td>
        <td><%=vet_hospitalVO.getHos_Id()%></td>
    </tr>
    <tr>
        <td>會員編號(負責人):</td>
        <td><input type="TEXT" name="mem_Id" size="45" value="<%=vet_hospitalVO.getMem_Id()%>" /></td>
    </tr>
    <tr>
        <td>診所名稱:</td>
        <td><input type="TEXT" name="hos_name" size="45" value="<%=vet_hospitalVO.getHos_name()%>" /></td>
    </tr>
    <tr>
        <td>縣/市:</td>
        <td><input type="TEXT" name="hos_city" size="45" value="<%=vet_hospitalVO.getHos_city()%>" /></td>
    </tr>
    <tr>
        <td>鄉鎮市區:</td>
        <td><input type="TEXT" name="hos_town" size="45" value="<%=vet_hospitalVO.getHos_town()%>" /></td>
    </tr>
    <tr>
        <td>道路街名村里:</td>
        <td><input type="TEXT" name="hos_road" size="45" value="<%=vet_hospitalVO.getHos_road()%>" /></td>
    </tr>
    <tr>
        <td>評價:</td>
        <td><input type="TEXT" name="hos_Eval" size="45" value="<%=vet_hospitalVO.getHos_Eval()%>" /></td>
    </tr>
    <tr>
        <td>URL:</td>
        <td><input type="TEXT" name="hos_URL" size="45" value="<%=vet_hospitalVO.getHos_URL()%>" /></td>
    </tr>
    <tr>
        <td>開始營業時間:</td>
        <td><input type="TEXT" name="hos_StartTime" size="45" value="<%=vet_hospitalVO.getHos_StartTime()%>" /></td>
    </tr>
    <tr>
        <td>結束營業時間:</td>
        <td><input type="TEXT" name="hos_EndTime" size="45" value="<%=vet_hospitalVO.getHos_EndTime()%>" /></td>
    </tr>
    <tr>
        <td>電話:</td>
        <td><input type="TEXT" name="hos_Tel" size="45" value="<%=vet_hospitalVO.getHos_Tel()%>" /></td>
    </tr>
    <tr>
        <td>診所敘述:</td>
        <td><input type="TEXT" name="hos_Desc" size="45" value="<%=vet_hospitalVO.getHos_Desc()%>" /></td>
    </tr>
    <tr>
        <td>診所經度座標:</td>
        <td><input type="TEXT" name="hos_Long" size="45" value="<%=vet_hospitalVO.getHos_Long()%>" /></td>
    </tr>
    <tr>
        <td>診所緯度座標:</td>
        <td><input type="TEXT" name="hos_Lat" size="45" value="<%=vet_hospitalVO.getHos_Lat()%>" /></td>
    </tr>
	<tr>
		<td>建立時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="hos_CreateTime" value="<%=vet_hospitalVO.getHos_CreateTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','hos_CreateTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="建立時間"></a>
		</td>
	</tr>
    <tr>
        <td>物件顯示狀態:</td>
        <td><input type="TEXT" name="hos_visible" size="45" value="<%=vet_hospitalVO.getHos_visible()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="hos_Id" value="<%=vet_hospitalVO.getHos_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllVet_hospital.jsp 與 複合查詢 listVet_hospitals_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
