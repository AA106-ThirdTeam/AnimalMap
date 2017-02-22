<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.purview.model.*"%>
<%
PurviewVO purviewVO= (PurviewVO)request.getAttribute("purviewVO"); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>權限新增</title>
</head>
<body>

	<h3>權限資料新增 - addPurview.jsp</h3>


	<a href="<%=request.getContextPath() %>/back-end/purview/select_page.jsp">回首頁</a>




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


	<FORM METHOD="post" ACTION="<%=request.getContextPath() %>/back-end/purview/purview.do" name="form1">
		<table border="0">

			<tr>
				<td>權限名稱:</td>
				<td><input type="TEXT" name="purview_name" size="45"
					value="${purviewVO.purview_name }"></td>

			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>




</body>
</html>