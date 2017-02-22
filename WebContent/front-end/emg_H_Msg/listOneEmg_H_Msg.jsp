<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.emg_H_Msg.model.*"%>
<%@ page import="com.emg_H.model.*"%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%Emg_H_MsgVO emg_H_MsgVO = (Emg_H_MsgVO) request.getAttribute("emg_H_MsgVO");%>

<!-- 取出 對應的DeptVO物件 -->
<%
  	Emg_HService emg_HSvc = new Emg_HService();
	Emg_HVO emg_HVO = emg_HSvc.getOneEmg_H(emg_H_MsgVO.getEmg_H_Id());
	
	
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>留言資料 - ListOneEmp.jsp</h3>
	<a href="<%=request.getContextPath()%>/front-end/emg_H_Msg/select_page.jsp">回首頁</a>

	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
			<th>留言編號</th>
			<th>留言會員編號</th>
			<th>求救編號</th>
			<th>發布時間</th>
			<th>留言內容</th>

		</tr>
		<tr align='center' valign='middle'>
			<td>${emg_H_MsgVO.emg_H_Msg_Id }</td>
			<td>${emg_H_MsgVO.mem_Id }</td>
			<td>${emg_H_MsgVO.emg_H_Id }【<%= emg_HVO.getEmg_H_title() %>】
			</td>
			<td>${emg_H_MsgVO.emg_H_Msg_start }</td>
			<td>${emg_H_MsgVO.emg_H_Msg_content }</td>

		</tr>
	</table>





</body>
</html>