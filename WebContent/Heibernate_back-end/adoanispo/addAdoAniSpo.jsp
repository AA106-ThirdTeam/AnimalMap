<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.adoanispo.model.*"%>
<%
AdoAniSpoVO adoanispoVO = (AdoAniSpoVO) request.getAttribute("adoanispoVO");
%>
<html>
<head>
<title>送養動物領養人新增 - addAdoAniSpo.jsp</title>
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
		<h3>送養動物領養人新增 - addAdoAniSpo.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/adoanispo/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>送養動物領養人:</h3>
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
<FORM METHOD="post" ACTION="adoanispo.do" name="form1">
<table border="0">
	<jsp:useBean id="adopt_aniSvc" scope="page" class="heibernate_com.adopt_ani.model.Adopt_AniService" />
	<tr>
		<td>送養動物編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="adopt_Ani_Id">
			<c:forEach var="adopt_aniVO" items="${adopt_aniSvc.all}">
				<option value="${adopt_aniVO.adopt_Ani_Id}" ${(adoanispoVO.adopt_aniVO.adopt_Ani_Id==adopt_aniVO.adopt_Ani_Id)? 'selected':'' } >${adopt_aniVO.adopt_Ani_Id}
			</c:forEach>
		</select></td>
	</tr>
	<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>贊助者會員編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="mem_Id">
			<c:forEach var="memVO" items="${memSvc.all}">
				<option value="${memVO.mem_Id}" ${(adoanispoVO.memVO.mem_Id==memVO.mem_Id)? 'selected':'' } >${memVO.mem_Id}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>贊助送養動物金額:</td>
		<td><input type="TEXT" name="adoAniSpoMoney" size="45"
			value="<%= (adoanispoVO==null)? "1" : adoanispoVO.getAdoAniSpoMoney()%>" /></td>
	</tr>	
	<tr>
		<td>贊助送養動物物資:</td>
		<td><input type="TEXT" name="adoAniSpoMat" size="45"
			value="<%= (adoanispoVO==null)? "1" : adoanispoVO.getAdoAniSpoMat()%>" /></td>
	</tr>	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>
