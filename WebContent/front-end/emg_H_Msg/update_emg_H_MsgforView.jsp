<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emg_H_Msg.model.*"%>


<%
	Emg_H_MsgVO emg_H_MsgVO = (Emg_H_MsgVO) request.getAttribute("emg_H_MsgVO"); //emg_H_MsgVOServlet.java (Concroller), 存入req的emg_H_MsgVOVO物件 (包括幫忙取出的emg_H_MsgVO, 也包括輸入資料錯誤時的emg_H_MsgVO物件)

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update_Emg_H_Msg</title>
</head>
<body>

	


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
<!-- 			<tr> -->
<!-- 				<td>留言編號:<font color=red><b>*</b></font></td> -->
<%-- 				<td><%=emg_H_MsgVO.getEmg_H_Msg_Id() %> --%>
<!-- 				</td> -->
<!-- 			</tr> -->

			<tr>
				
				<td><input type="hidden" name="mem_Id" size="45"
					value="${account.mem_Id} " />  會員 : ${account.mem_name}</td>
			</tr>

			<jsp:useBean id="emg_HSvc" scope="page"	class="com.emg_H.model.Emg_HService" />

			<tr>
			<td>
<!-- 	 		利用表格裡的編號外來鍵 來找緊急求救getOne的方法  join tomcat 7.0 以上  -->
				求救標題: ${emg_HSvc.getOneEmg_H(emg_H_MsgVO.emg_H_Id).emg_H_title}</td>
			</tr>


		</table>

		<br> 留言內容
		<textarea cols="40" rows="5" maxlength="100" name="emg_H_Msg_content"
			value=""></textarea>
		<br> <br> 
		<input type="hidden" name="action" value="updateForView">
		<input type="hidden" name="emg_H_Id" value="<%=emg_H_MsgVO.getEmg_H_Id() %>"> 
		<input type="hidden" name="emg_H_Msg_Id" value="<%=emg_H_MsgVO.getEmg_H_Msg_Id() %>"> 
		<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>">
		<!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
		
		<input type="submit" value="送出修改" class="btn btn-warning">
	</FORM>




</body>
</html>