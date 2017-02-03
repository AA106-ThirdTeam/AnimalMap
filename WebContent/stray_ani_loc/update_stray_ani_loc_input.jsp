 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.stray_ani_loc.model.*"%>
<%
    Stray_Ani_LocVO stray_ani_locVO = (Stray_Ani_LocVO) request.getAttribute("stray_ani_locVO"); //Stray_Ani_LocServlet.java (Concroller), 存入req的stray_ani_locVO物件 (包括幫忙取出的stray_ani_locVO, 也包括輸入資料錯誤時的stray_ani_locVO物件)
%>

<!--  -->

<html>
<head>
<title>社區流浪動物出沒範圍資料修改 - update_stray_ani_loc_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>社區流浪動物出沒範圍資料 - ListOneStray_Ani_Loc.jsp</h3>
        <a href="<%=request.getContextPath()%>/stray_ani_loc/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
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

<FORM METHOD="post" ACTION="stray_ani_loc.do" name="form1">
    <table border="0">

    <!--  -->
        <tr>
        <td>流浪動物出沒編號編號:<font color=red><b>*</b></font></td>
        <td><%=stray_ani_locVO.getStr_Ani_Loc_No()%></td>
    </tr>
    <tr>
        <td>社區動物編號:</td>
        <td><input type="TEXT" name="stray_Ani_Id" size="45" value="<%=stray_ani_locVO.getStray_Ani_Id()%>" /></td>
    </tr>
    <tr>
        <td>發布者會員編號:</td>
        <td><input type="TEXT" name="mem_Id" size="45" value="<%=stray_ani_locVO.getMem_Id()%>" /></td>
    </tr>
    <tr>
        <td>送養地點經度:</td>
        <td><input type="TEXT" name="str_Ani_LocLat" size="45" value="<%=stray_ani_locVO.getStr_Ani_LocLat()%>" /></td>
    </tr>
    <tr>
        <td>送養地點緯度:</td>
        <td><input type="TEXT" name="str_Ani_LocLon" size="45" value="<%=stray_ani_locVO.getStr_Ani_LocLon()%>" /></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="str_Ani_Loc_No" value="<%=stray_ani_locVO.getStr_Ani_Loc_No()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllStray_Ani_Loc.jsp 與 複合查詢 listStray_Ani_Locs_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
