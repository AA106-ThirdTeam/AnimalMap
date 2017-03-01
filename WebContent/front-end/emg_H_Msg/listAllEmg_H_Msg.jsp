<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emg_H_Msg.model.*"%>

<%
	Emg_H_MsgService emg_H_MsgSvc = new Emg_H_MsgService();
	List<Emg_H_MsgVO> list = emg_H_MsgSvc.getAll();
	pageContext.setAttribute("list",list);
%>

<jsp:useBean id="emg_HSvc" scope="page"
	class="com.emg_H.model.Emg_HService" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Emg_H_Msg</title>
</head>
<body>

	<h3>�Ҧ����D�ϯd����� - ListAllEmg_H_Msg.jsp</h3>
	<a href="<%=request.getContextPath()%>/front-end/emg_H_Msg/select_page.jsp">�^����</a>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>�Эץ��H�U���~:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>


	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
			<th>���D�ϯd���s��</th>
			<th>�d���|���s��</th>
			<th>�D�Ͻs��</th>
			<th>�o���ɶ�</th>
			<th>�d�����e</th>

		</tr>
		<%@ include file="pages/page1.file"%>

		<c:forEach var="emg_H_MsgVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr align='center' valign='middle'
				${(emg_H_MsgVO.emg_H_Msg_Id==param.emg_H_Msg_Id) ? 'bgcolor=yellow':''}>
				<!--�N�ק諸���@���[�J����Ӥw-->

				<td>${emg_H_MsgVO.emg_H_Msg_Id}</td>
				<td>${emg_H_MsgVO.mem_Id}</td>

				<td><c:forEach var="emg_HVO" items="${emg_HSvc.all}">
						<c:if test="${emg_H_MsgVO.emg_H_Id==emg_HVO.emg_H_Id}">
	                    ${emg_HVO.emg_H_Id}�i ${emg_HVO.emg_H_title} �j
                    </c:if>
					</c:forEach></td>

				<!-- Servlet3.0 ��k 			
<td>
${emg_HSvc.getOneEmg_H(emg_H_MsgVO.emg_H_Id).emg_H_Id}�i${emg_HSvc.getOneEmg_H(emg_H_MsgVO.emg_H_Id).emg_H_title}�j
</td>
-->

				<td>${emg_H_MsgVO.emg_H_Msg_start}</td>
				<td>${emg_H_MsgVO.emg_H_Msg_content}</td>


				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">
						<input type="submit" value="�ק�"> <input type="hidden" name="emg_H_Msg_Id" value="${emg_H_MsgVO.emg_H_Msg_Id}">
						<input type="hidden" name="requestURL"
							value="<%=request.getServletPath()%>">
						<!--�e�X�����������|��Controller-->
						<input type="hidden" name="whichPage" value="<%=whichPage%>">
						<!--�e�X��e�O�ĴX����Controller-->
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">						<input type="submit" value="�R��"> <input type="hidden"
							name="emg_H_Msg_Id" value="${emg_H_MsgVO.emg_H_Msg_Id}">
						<input type="hidden" name="requestURL"
							value="<%=request.getServletPath()%>">
						<!--�e�X�����������|��Controller-->
						<input type="hidden" name="whichPage" value="<%=whichPage%>">
						<!--�e�X��e�O�ĴX����Controller-->
						<input type="hidden" name="action" value="delete">

					</FORM>
				</td>
				
				
				
				
			</tr>
		</c:forEach>
	</table>

	<%@ include file="pages/page2.file"%>




</body>
</html>