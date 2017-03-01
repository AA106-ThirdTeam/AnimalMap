<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adoptani_sponsor.model.*"%>

<%=
	(AdoptaniSponsorVO) request.getAttribute("adoptaniSponsorVO")	
	//第一次進到此頁面是null，因為沒有這東西。
%>
<%
AdoptaniSponsorVO adoptaniSponsorVO = (AdoptaniSponsorVO) request.getAttribute("adoptaniSponsorVO");	
	//預防錯誤輸入，而保留user所輸入的所有內容，送出後若錯誤不用全部重打。
%>


<jsp:useBean id="AdoptaniSvc" scope="page" class="com.adoptani.model.AdoptaniService" />


<html>
<head>
<title>送養動物資料新增 - addAdoptani.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>





<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
			<h3>送養動物贊助新增 - addAdoptani Sponsor.jsp</h3>
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

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_sponsor/AdoptaniSponsorServlet.do" name="form1">
	<table border="0">
	
		<tr>
			<td>送養動物編號:</td>
			<td>
				<select size="1" name="adopt_Ani_Id">
	        		 <c:forEach var="adoptaniVO" items="${AdoptaniSvc.all}" > 
	         			 <option value="${adoptaniVO.adopt_Ani_Id}">(${adoptaniVO.adopt_Ani_Id})${adoptaniVO.adopt_Ani_name}
	        		 </c:forEach>   
	      		</select>
	      	</td>
		</tr>
		<tr>
			<td>贊助者會員編號:</td>
			<td><input type="TEXT" name="mem_Id" size="30" 	placeholder="請輸入會員編號ex.10000001"
				value="<%= (adoptaniSponsorVO==null)? "" : adoptaniSponsorVO.getMem_Id() %>" /></td>
		</td>
		<tr>
			<td>贊助金額:</td>
			<td><input type="TEXT" name="ado_Ani_Spo_money" size="30" 	placeholder="金額"
				value="<%= (adoptaniSponsorVO==null)? "" : adoptaniSponsorVO.getAdo_Ani_Spo_money() %>" /></td>
		</td>
		<tr>
			<td>贊助物資:</td>
			<td><input type="TEXT" name="ado_Ani_Spo_thing" size="30" 	placeholder="物資"
				value="<%= (adoptaniSponsorVO==null)? "" : adoptaniSponsorVO.getAdo_Ani_Spo_thing() %>" /></td>
		</td>
		</tr>  

		


	</table>
	<br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" value="送出新增">
	</FORM>
</body>

</html>

