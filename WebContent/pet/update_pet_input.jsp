 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pet.model.*"%>
<%
    PetVO petVO = (PetVO) request.getAttribute("petVO"); //PetServlet.java (Concroller), 存入req的petVO物件 (包括幫忙取出的petVO, 也包括輸入資料錯誤時的petVO物件)
%>

<!--  -->

<html>
<head>
<title>自家寵物資料修改 - update_pet_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>自家寵物資料 - ListOnePet.jsp</h3>
        <a href="<%=request.getContextPath()%>/pet/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
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

<FORM METHOD="post" ACTION="pet.do" name="form1">
    <table border="0">

    <!--  -->
        <tr>
        <td>寵物編號編號:<font color=red><b>*</b></font></td>
        <td><%=petVO.getPet_Id()%></td>
    </tr>
    <tr>
        <td>主人會員編號:</td>
        <td><input type="TEXT" name="mem_Id" size="45" value="<%=petVO.getMem_Id()%>" /></td>
    </tr>
    <tr>
        <td>寵物名字:</td>
        <td><input type="TEXT" name="pet_name" size="45" value="<%=petVO.getPet_name()%>" /></td>
    </tr>
    <tr>
        <td>寵物種類:</td>
        <td><input type="TEXT" name="pet_type" size="45" value="<%=petVO.getPet_type()%>" /></td>
    </tr>
    <tr>
        <td>寵物性別:</td>
        <td><input type="TEXT" name="pet_gender" size="45" value="<%=petVO.getPet_gender()%>" /></td>
    </tr>
    <tr>
        <td>寵物健康狀況:</td>
        <td><input type="TEXT" name="pet_heal" size="45" value="<%=petVO.getPet_heal()%>" /></td>
    </tr>
    <tr>
        <td>寵物疫苗接踵:</td>
        <td><input type="TEXT" name="pet_Vac" size="45" value="<%=petVO.getPet_Vac()%>" /></td>
    </tr>
    <tr>
        <td>寵物毛色:</td>
        <td><input type="TEXT" name="pet_color" size="45" value="<%=petVO.getPet_color()%>" /></td>
    </tr>
    <tr>
        <td>寵物體型:</td>
        <td><input type="TEXT" name="pet_body" size="45" value="<%=petVO.getPet_body()%>" /></td>
    </tr>
    <tr>
        <td>寵物年齡:</td>
        <td><input type="TEXT" name="pet_age" size="45" value="<%=petVO.getPet_age()%>" /></td>
    </tr>
    <tr>
        <td>寵物節育:</td>
        <td><input type="TEXT" name="pet_Neu" size="45" value="<%=petVO.getPet_Neu()%>" /></td>
    </tr>
    <tr>
        <td>寵物晶片編號:</td>
        <td><input type="TEXT" name="pet_chip" size="45" value="<%=petVO.getPet_chip()%>" /></td>
    </tr>
	<tr>
		<td>寵物生日:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="pet_birth" value="<%=petVO.getPet_birth()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','pet_birth','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="寵物生日"></a>
		</td>
	</tr>
    <tr>
        <td>寵物物件狀態:</td>
        <td><input type="TEXT" name="pet_status" size="45" value="<%=petVO.getPet_status()%>" /></td>
    </tr>
	<tr>
		<td>寵物建立時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="pet_CreDATE" value="<%=petVO.getPet_CreDATE()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','pet_CreDATE','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="寵物建立時間"></a>
		</td>
	</tr>
    <tr>
        <td>縣市:</td>
        <td><input type="TEXT" name="pet_city" size="45" value="<%=petVO.getPet_city()%>" /></td>
    </tr>
    <tr>
        <td>鄉鎮市區:</td>
        <td><input type="TEXT" name="pet_town" size="45" value="<%=petVO.getPet_town()%>" /></td>
    </tr>
    <tr>
        <td>道路街名村里:</td>
        <td><input type="TEXT" name="pet_road" size="45" value="<%=petVO.getPet_road()%>" /></td>
    </tr>
    <tr>
        <td>送養地點經度:</td>
        <td><input type="TEXT" name="pet_FinLat" size="45" value="<%=petVO.getPet_FinLat()%>" /></td>
    </tr>
    <tr>
        <td>送養地點緯度:</td>
        <td><input type="TEXT" name="pet_FinLon" size="45" value="<%=petVO.getPet_FinLon()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="pet_Id" value="<%=petVO.getPet_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllPet.jsp 與 複合查詢 listPets_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
