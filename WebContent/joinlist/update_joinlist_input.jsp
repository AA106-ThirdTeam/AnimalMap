 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.joinlist.model.*"%>
<%
    JoinListVO joinlistVO = (JoinListVO) request.getAttribute("joinlistVO"); //JoinListServlet.java (Concroller), 存入req的joinlistVO物件 (包括幫忙取出的joinlistVO, 也包括輸入資料錯誤時的joinlistVO物件)
%>

<!--  -->

<html>
<head>
<title>揪團參加名單資料修改 - update_joinlist_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>揪團參加名單資料 - ListOneJoinList.jsp</h3>
        <a href="<%=request.getContextPath()%>/joinlist/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
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

<FORM METHOD="post" ACTION="joinlist.do" name="form1">
    <table border="0">

    <!--  -->
        <tr>
        <td>活動編號編號:<font color=red><b>*</b></font></td>
        <td><%=joinlistVO.getJoinList_GrpId()%></td>
    </tr>
    <tr>
        <td>會員編號(參加者)編號:<font color=red><b>*</b></font></td>
        <td><%=joinlistVO.getJoinList_MemId()%></td>
    </tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="joinList_GrpId" value="<%=joinlistVO.getJoinList_GrpId()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllJoinList.jsp 與 複合查詢 listJoinLists_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
