<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.joinlist.model.*"%>
<%
    JoinListVO joinlistVO = (JoinListVO) request.getAttribute("joinlistVO"); //JoinListServlet.java (Concroller), 存入req的joinlistVO物件 (包括幫忙取出的joinlistVO, 也包括輸入資料錯誤時的joinlistVO物件)
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
	<title>揪團參加名單資料修改 - update_joinlist_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>揪團參加名單資料 - ListOneJoinList.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/joinlist/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="joinlist.do" name="form1">
    <table border="0">
    <!--  -->
<jsp:useBean id="petGroupSvc" scope="page" class="heibernate_com.petgroup.model.PetGroupService" />
	<tr>
		<td>活動編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="joinList_GrpId">
	         <c:forEach var="petGroupVO" items="${petGroupSvc.all}" > 
				<option value="${petGroupVO.grp_Id}" ${(joinlistVO.petGroupVO.grp_Id==petGroupVO.grp_Id)?'selected':'' } >
${petGroupVO.grp_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>會員編號(參加者):<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="joinList_MemId">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(joinlistVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
${memVO.mem_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
    <tr>
        <td>是否被邀請:</td>
        <td><input type="TEXT" name="JOINLIST_ISINVITED" size="45" value="<%=joinlistVO.getJOINLIST_ISINVITED()%>" /></td>
    </tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="grp_Id" value="<%=joinlistVO.getPetGroupVO().getGrp_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllJoinList.jsp 與 複合查詢 listJoinLists_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
