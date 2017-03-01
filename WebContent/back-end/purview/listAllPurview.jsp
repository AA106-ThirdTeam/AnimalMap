<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.purview.model.* "%>

<% 
	
    PurviewService  purviewSvc = new  PurviewService();
    List<PurviewVO> list = purviewSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有權限資料</title>
</head>
<body>

	<h3>所有權限資料 - ListAllPurview.jsp</h3>
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

	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>

			<th>權限編號</th>
			<th>權限名稱</th>
			<th>刪除</th>

		</tr>


		<c:forEach var="purviewVO" items="${list}">
			<tr align='center' valign='middle'>


				<td>${purviewVO.purview_No}</td>
				<td>${purviewVO.purview_name}</td>



				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath() %>/back-end/purview/purview.do">
						<input type="submit" value="刪除"> <input type="hidden"
							name="purview_No" value="${purviewVO.purview_No}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>