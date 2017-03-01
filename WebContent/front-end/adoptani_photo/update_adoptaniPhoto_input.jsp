<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adoptani_photo.model.*"%>
<%
	AdoptaniPhotoVO adoptaniPhotoVO = (AdoptaniPhotoVO) request.getAttribute("adoptaniPhotoVO"); //AdoptaniServlet.java (Concroller), 存入req的adoptaniVO物件 (包括幫忙取出的adoptaniVO, 也包括輸入資料錯誤時的adoptaniVO物件)
%>
<html>
<head>
<title>送養動物相片資料修改 - update_adoptaniPhoto_input.jsp</title></head>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>員工資料修改 - update_adoptani_input.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td>
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_photo/adoptani_photo.do" name="form1">
<table border="0">


	<tr>
		<td>送養動物相片類型(大頭貼or一般照片)</td>
		<td>
			<input type="TEXT" name="ado_Pic_type" size="20" value="<%=adoptaniPhotoVO.getAdo_Pic_type()%>">
		</td>
	</tr>

	

</table>


<br>
<input type="hidden" name="action" value="update">



<input type="hidden" name="ado_Ani_Pic_No" value="<%=adoptaniPhotoVO.getAdo_Ani_Pic_No()%>">
<input type="submit" value="送出修改"></FORM>

</body>
</html>
