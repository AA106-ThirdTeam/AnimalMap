<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<p>This is the Home page for Emg_H_Msg</p>

	<h3>資料查詢:</h3>
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
	<br> 緊急求救留言管理
	<br>
	<a href='<%=request.getContextPath()%>/front-end/emg_H_Msg/listAllEmg_H_Msg.jsp'>List</a>
	all Emg_H_Msg.

	<br>
	<br>

	<li>
		<FORM METHOD="post"
			ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">
			<b>輸入留言編號 (如55001):</b> <input type="text" name="emg_H_Msg_Id">
			<input type="submit" value="送出"> <input type="hidden"
				name="action" value="getOne_For_Display">
		</FORM>
	</li>

	<jsp:useBean id="emg_H_MsgSvc" scope="page"
		class="com.emg_H_Msg.model.Emg_H_MsgService" />

	<li>
		<FORM METHOD="post"
			ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">
			<b>選擇留言編號:</b> <select size="1" name="emg_H_Msg_Id">
				<c:forEach var="emg_H_MsgVO" items="${emg_H_MsgSvc.all}">
					<option value="${emg_H_MsgVO.emg_H_Msg_Id}">${emg_H_MsgVO.emg_H_Msg_Id}
				</c:forEach>
			</select> <input type="submit" value="送出"> <input type="hidden"
				name="action" value="getOne_For_Display">
		</FORM>
	</li>

	<jsp:useBean id="emg_HSvc" scope="page"
		class="com.emg_H.model.Emg_HService" />

	<li>
		<FORM METHOD="post"
			ACTION="<%=request.getContextPath()%>/front-end/emg_H/emg_H.do">
			<b><font color=orange>選擇求救標題:</font></b> 
			<select size="1"
				name="emg_H_Id">
				<c:forEach var="emg_HVO" items="${emg_HSvc.all}">
					<option value="${emg_HVO.emg_H_Id}">${emg_HVO.emg_H_title}
				</c:forEach>
			</select> 
			<input type="submit" value="送出"> 
			<input type="hidden" name="action" value="listEmg_H_Msg_ByEmg_H_Id_A">
		</FORM>
	</li>
	</ul>

	<br>
	<br>
	<br> 新增緊急標題
	<br>
	<a href='<%=request.getContextPath()%>/front-end/emg_H/addEmg_H.jsp'>add</a>
	Emg_H.
	<br>
	<br> 緊急求救管理
	<br>
	<a href='<%=request.getContextPath()%>/front-end/emg_H/listAllEmg_H.jsp'>list</a>
	AllEmg_H.
	<br>
	<br>


</body>
</html>