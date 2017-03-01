<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rel_list.model.*"%>
<%@ page import="util.interpreter.*"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="listRelation_ByMemId" scope="request" type="java.util.Set" />
<jsp:useBean id="listRelation_ByAddedMemId" scope="request" type="java.util.Set" />
<jsp:useBean id="rel_list_memVO" scope="request" type="com.mem.model.MemVO" />
<jsp:useBean id="memSvc" scope="request" class="com.mem.model.MemService"/>
<html>
<head>
<style>
</style>

<script src="http://code.jquery.com/jquery-1.10.1.min.js">  </script>
<title>關係名單 - listRelation_ByMemId.jsp</title>

</head>
<body bgcolor='white'>

	<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>關係名單 - listRelation_ByMemId.jsp</h3> <a
				href="<%=request.getContextPath()%>/select_page.jsp"><img
					src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
			</td>
		</tr>
	</table>

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
			<th>會員編號-會員名稱</th>
			<th>被加入會員編號-會員名稱</th>
			<th>關係</th>
			<th>是否送出邀請</th>

		</tr>

		<c:forEach var="Rel_ListVO" items="${listRelation_ByMemId}">
			<c:set var="aRel_ListVO" value="${Rel_ListVO}" scope="request"/>
			<tr align='center' valign='middle'>
				<td>${Rel_ListVO.rel_MemId}</td>

				<td>${Rel_ListVO.added_MemId}</td>

				<td><%= InterpretAttribute.relation(((Rel_ListVO)request.getAttribute("aRel_ListVO")).getIsBlackList())%>
				</td>
				<td><%= InterpretAttribute.invited(((Rel_ListVO)request.getAttribute("aRel_ListVO")).getIsInvited())%>
				</td>
			</tr>
		</c:forEach>
				
	</table>
		<c:forEach var="AddedRel_ListVO" items="${listRelation_ByAddedMemId}">
<%-- 				rel_list_memVO.mem_Id--${rel_list_memVO.mem_Id}<br> --%>
<%-- 				AddedRel_ListVO.added_MemId--${AddedRel_ListVO.added_MemId}<br> --%>
<%-- 				isInvited--${AddedRel_ListVO.isInvited}<br> --%>
			<hr>
			
			<c:if test="${(AddedRel_ListVO.isInvited=='1')&&(rel_list_memVO.mem_Id==AddedRel_ListVO.added_MemId)}">
				<c:set var="sendInviteMemId" value="${AddedRel_ListVO.rel_MemId}"/>
				<c:set var="recieveInviteMemId" value="${AddedRel_ListVO.added_MemId}"/>
				<c:set var="displayConfirmButton" value="true"/>
				
				<c:if test="${displayConfirmButton}">
					${memSvc.getOneMem(sendInviteMemId).mem_nick_name}邀請你成為他的好友
					<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do">
						<input type="submit" value="同意加入好友">
						<input type="hidden" name="requestURL" value="<%= request.getServletPath()%>">
						<input type="hidden" name="sendInviteMemId" value="${sendInviteMemId}">
						<input type="hidden" name="recieveInviteMemId" value="${recieveInviteMemId}">
						<input type="hidden" name="action" value="confirmAddFriend">
					</form>
				</c:if>	
			</c:if>
		</c:forEach>	
	
						

	
	
	
	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
			<th>會員編號-會員名稱</th>
			<th>被加入會員編號-會員名稱</th>
			<th>關係</th>
			<th>是否收到好友邀請</th>

		</tr>

		<c:forEach var="AddedRel_ListVO" items="${listRelation_ByAddedMemId}">
			<c:set var="aAddedRel_ListVO" value="${AddedRel_ListVO}" scope="request"/>
			<tr align='center' valign='middle'>
				<td>${AddedRel_ListVO.rel_MemId}</td>

				<td>${AddedRel_ListVO.added_MemId}</td>

				<td><%= InterpretAttribute.relation(((Rel_ListVO)request.getAttribute("aAddedRel_ListVO")).getIsBlackList())%></td>
				<td><%= InterpretAttribute.invited(((Rel_ListVO)request.getAttribute("aAddedRel_ListVO")).getIsInvited())%></td>
			</tr>
		</c:forEach>
				
	</table>
	

	<br>本網頁的路徑:
	<br>
	<b> <font color=blue>request.getServletPath():</font> <%=request.getServletPath()%><br>
		<font color=blue>request.getRequestURI(): </font> <%=request.getRequestURI()%>
	</b>
</body>



</html>
