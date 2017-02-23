<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:useBean id="listEmg_H_Msg_ByEmg_H_Id" scope="request" type="java.util.Set" />
	<jsp:useBean id="emg_HSvc" scope="page"	class="com.emg_H.model.Emg_HService" />

<%

String emg_H_Id=(String)request.getAttribute("emg_H_Id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listEmg_H_Msg_ByEmg_H_Id.jsp</title>
</head>
<body>

	<h3>緊急求救留言 - listEmg_H_Msg_ByEmg_H_Id.jsp</h3>
	<a href="<%=request.getContextPath()%>/front-end/emg_H_Msg/select_page.jsp">回首頁</a>

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

	<table border='1' bordercolor='#CCCCFF' width='1200'>
		<tr>
			<th>留言編號</th>
			<th>留言會員編號</th>
			<th>求救編號</th>
			<th>發布時間</th>
			<th>留言內容</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>

		<c:forEach var="emg_H_MsgVO" items="${listEmg_H_Msg_ByEmg_H_Id}">
			<tr align='center' valign='middle'
				${(emg_H_MsgVO.emg_H_Msg_Id==param.emg_H_Msg_Id) ? 'bgcolor=yellow':''}>
				<!--將修改的那一筆加入對比色而已-->

				<td>${emg_H_MsgVO.emg_H_Msg_Id}</td>
				<td>${emg_H_MsgVO.mem_Id}</td>

				<td><c:forEach var="emg_HVO" items="${emg_HSvc.all}">
						<c:if test="${emg_H_MsgVO.emg_H_Id==emg_HVO.emg_H_Id}">
	                    ${emg_HVO.emg_H_Id}【<font color=orange>${emg_HVO.emg_H_title}</font>】
                    </c:if>
					</c:forEach></td>


				<td>${emg_H_MsgVO.emg_H_Msg_start}</td>
				<td>${emg_H_MsgVO.emg_H_Msg_content}</td>

				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">
						<input type="submit" value="修改"> 
						<input type="hidden" name="emg_H_Msg_Id" value="${emg_H_MsgVO.emg_H_Msg_Id}">
						<input type="hidden" name="emg_H_Id" value="${emg_H_MsgVO.emg_H_Id}">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
						
						<!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">
						<input type="submit" value="刪除"> 
						<input type="hidden" name="emg_H_Msg_Id" value="${emg_H_MsgVO.emg_H_Msg_Id}">
						<input type="hidden" name="emg_H_Id" value="${emg_H_MsgVO.emg_H_Id}">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
						<!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>