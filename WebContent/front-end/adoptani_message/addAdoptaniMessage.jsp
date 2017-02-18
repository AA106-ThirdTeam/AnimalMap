<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adoptani_message.model.*"%>

<%=
	(AdoptaniMessageVO) request.getAttribute("adoptaniMessageVO")	
	//第一次進到此頁面是null，因為沒有這東西。
%>
<%
	AdoptaniMessageVO adoptaniMessageVO = (AdoptaniMessageVO) request.getAttribute("adoptaniMessageVO");	
	//預防錯誤輸入，而保留user所輸入的所有內容，送出後若錯誤不用全部重打。
%>
<%
/**
	※錯誤訊息要注意經緯度的錯誤處理。
**/
%>


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
			<h3>送養動物留言新增 - addAdoptani.jsp</h3>
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

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_message/AdoptaniMessageServlet.do" name="form1">
	<table border="0">
	
		<tr>
			<td>送養動物編號:</td>
			<td><input type="TEXT" name="adopt_Ani_Id" size="30" 	placeholder="請輸入送養動物編號ex.40000001"
				value="<%= (adoptaniMessageVO==null)? "" : adoptaniMessageVO.getAdopt_Ani_Id()%>" /></td>
		</tr>
		<tr>
			<td>發布者會員編號:</td>
			<td><input type="TEXT" name="mem_Id" size="30" 	placeholder="請輸入會員編號ex.10000001"
				value="<%= (adoptaniMessageVO==null)? "" : adoptaniMessageVO.getMem_Id() %>" /></td>
		</td>
		</tr>  
		
		<tr>
			<td>留言內容:</td>
			<td>
				<textarea cols="50" rows="5" name="ado_Ani_Mes" ><%=(adoptaniMessageVO==null)?"":adoptaniMessageVO.getAdo_Ani_Mes()%></textarea>
			
<!-- 			<input type="TEXT" name="Mem_Id" size="20" placeholder="8碼" -->
<%-- 				value="<%= (adoptaniVO==null)? "" : adoptaniVO.getMem_Id()%>" /></td> --%>
		</tr>
		


	</table>
	<br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" value="送出新增">
	</FORM>
</body>

</html>

