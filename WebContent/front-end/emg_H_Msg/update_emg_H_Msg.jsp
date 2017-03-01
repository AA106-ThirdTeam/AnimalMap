<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emg_H_Msg.model.*"%>


<%
	Emg_H_MsgVO emg_H_MsgVO = (Emg_H_MsgVO) request.getAttribute("emg_H_MsgVO"); //emg_H_MsgVOServlet.java (Concroller), 存入req的emg_H_MsgVOVO物件 (包括幫忙取出的emg_H_MsgVO, 也包括輸入資料錯誤時的emg_H_MsgVO物件)
	//String emg_H_Id=(String)request.getAttribute("emg_H_Id");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update_Emg_H_Msg</title>
</head>
<body>

	<h3>留言資料修改 - update_emg_H_Msg_input.jsp</h3>
	<a href="<%=request.getContextPath()%>/front-end/emg_H_Msg/select_page.jsp">回首頁</a>
	</td>


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

	<FORM METHOD="post" ACTION="emg_H_Msg.do" name="form1">

		<table border="0">
			<tr>
				<td>留言編號:<font color=red><b>*</b></font></td>
				<td><%=emg_H_MsgVO.getEmg_H_Msg_Id() %></td>
			</tr>

			<tr>
				<td>會員編號:<font color=red><b>*</b></font></td>
				<td><input type="hidden" name="mem_Id" size="45"
					value="${emg_H_MsgVO.mem_Id} " />${emg_H_MsgVO.mem_Id}</td>
			</tr>

			<jsp:useBean id="emg_HSvc" scope="page"	class="com.emg_H.model.Emg_HService" />

			<tr>
				<td>求救標題:<font color=red><b>*</b></font></td>

				<td><select size="1" name="emg_H_Id">
						<c:forEach var="emg_HVO" items="${emg_HSvc.all}">
							<option value="${emg_HVO.emg_H_Id}"
								${(emg_H_MsgVO.emg_H_Id==emg_HVO.emg_H_Id)?'selected':'' }>
								${emg_HVO.emg_H_Id} ${emg_HVO.emg_H_title}
						</c:forEach>
				</select></td>


			</tr>


		</table>

		<br> 留言內容
		<textarea cols="30" rows="5" maxlength="100" name="emg_H_Msg_content"
			value="${emg_H_MsgVO.emg_H_Msg_content}"></textarea>
		<br> <br> <input type="hidden" name="action" value="update">
		<input type="hidden" name="emg_H_Id" value="<%=emg_H_MsgVO.getEmg_H_Id() %>"> 
		<input type="hidden" name="emg_H_Msg_Id" value="<%=emg_H_MsgVO.getEmg_H_Msg_Id() %>"> 
		<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>">
		<!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
		<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">
		<!--只用於:istAllEmg_H_Msg.jsp-->
		<input type="submit" value="送出修改">
	</FORM>




</body>
</html>