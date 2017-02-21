<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rel_list.model.*"%>
<%@ page import="util.interpreter.*"%>

<jsp:useBean id="listPrivMsg_ByRecMemId" scope="request" type="java.util.Set" />
<jsp:useBean id="listPrivMsg_BySendMemId" scope="request" type="java.util.Set" />

<html>
<head>
<style>
</style>

<script src="http://code.jquery.com/jquery-1.10.1.min.js">  </script>
<title>��ܦW�� - listPrivMsg_ByRecMemId.jsp</title>

</head>
<body bgcolor='white'>

	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
			<th>�o�e�T���|���s��</th>
			<th>�����T���|���s��</th>
			<th>�T�����e</th>
			<th>�o�e�ɶ�</th>
			<th>�O�_�wŪ</th>
		</tr>

		<c:forEach var="Priv_messageVO" items="${listPrivMsg_ByRecMemId}">
			<c:if test="${Priv_messageVO.privMsgSend_MemId!=sendAccount}">
				<tr align='center' valign='middle'>
					<td>${Priv_messageVO.privMsgSend_MemId}</td>
					<td>${Priv_messageVO.privMsgRec_MemId}</td>
					<td>${Priv_messageVO.privMsg_content}</td>	
					<td>${Priv_messageVO.privMsg_SendTime}</td>		
					<td>${Priv_messageVO.privMsg_type}</td>	
					<td>
<%-- 						<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do"> --%>
							<input type="button" value="�ǰe�T��" onclick="openChat(${Priv_messageVO.privMsgSend_MemId})">
<%-- 							<input type="hidden" name="requestURL" value="<%= request.getServletPath()%>"> --%>
<%-- 							<input type="hidden" name="privMsgSend_MemId" value="${Priv_messageVO.privMsgSend_MemId}"> --%>
<%-- 							<input type="hidden" name="privMsgRec_MemId" value="${Priv_messageVO.privMsgRec_MemId}"> --%>
<!-- 							<input type="hidden" name="action" value="joinChat"> -->
						</form>
					</td>
				</tr>
			</c:if>
			<c:set var="sendAccount" value="${Priv_messageVO.privMsgSend_MemId}"/>
		</c:forEach>
		
		<c:forEach var="Priv_messageVO" items="${listPrivMsg_BySendMemId}">
			<tr align='center' valign='middle'>
				<td>${Priv_messageVO.privMsgSend_MemId}</td>
				<td>${Priv_messageVO.privMsgRec_MemId}</td>
				<td>${Priv_messageVO.privMsg_content}</td>	
				<td>${Priv_messageVO.privMsg_SendTime}</td>		
				<td>${Priv_messageVO.privMsg_type}</td>	
			</tr>
		</c:forEach>				
	</table>
			
	 
	<br>�����������|:
	<br>
	<b> <font color=blue>request.getServletPath():</font> <%=request.getServletPath()%><br>
		<font color=blue>request.getRequestURI(): </font> <%=request.getRequestURI()%>
	</b>
</body>
		


</html>
