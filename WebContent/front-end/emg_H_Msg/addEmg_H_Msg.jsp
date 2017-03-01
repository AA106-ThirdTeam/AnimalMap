<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emg_H_Msg.model.*"%>
<%@ page import="com.emg_H.model.*"%>

<%
	Emg_H_MsgVO emg_H_MsgVO = (Emg_H_MsgVO) request.getAttribute("emg_H_MsgVO");
	Emg_HVO emg_HVO = (Emg_HVO) request.getAttribute("emg_HVO");

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add Emg_H_Msg</title>
</head>
<body>

	<h3>留言新增 - add Emg_H_Msg.jsp</h3>


	<a href="<%=request.getContextPath()%>/front-end/emg_H_Msg/select_page.jsp">回首頁</a>

	<br>
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
	<br>

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do" name="form1">
		<table border="0">



			<tr >
				<td>留言會員編號:<font color=red><b>*</b></font></td>
				<td>
				<%--目前TEST 文章本身MEM 等SESSION 綁定memVO.Id --%>
				${emg_HVO.mem_Id}
				<input type="hidden" name="mem_Id" size="30"
					value="<%= (emg_HVO==null)? "1000000" : emg_HVO.getMem_Id()%>" /></td>
			</tr>



			<jsp:useBean id="emg_HSvc" scope="page"	class="com.emg_H.model.Emg_HService" />
			<tr>
			
				<td>求救標題:<font color=red><b>*</b></font></td>
				<td> 
				${emg_HVO.emg_H_Id} - ${emg_HVO.emg_H_title}
				<input type="hidden" name="emg_H_Id" value="<%= (emg_HVO==null)? "50000" : emg_HVO.getEmg_H_Id()%>">
				</td>
			</tr>

		</table>

		<br> 內容 <br>

		<textarea type="textarea" name="emg_H_Msg_content" cols="30" rows="5"
			maxlength="100"
			value="<%= (emg_H_MsgVO==null)? "" : emg_H_MsgVO.getEmg_H_Msg_content()%>"></textarea>

		<br> <input type="hidden" name="action" value="insert"> 
			<input type="submit" value="送出新增">
			<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>">
			
	</FORM>
</body>




</body>
</html>