<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rel_list.model.*"%>
<%@ page import="util.interpreter.*"%>

<jsp:useBean id="listPrivMsg_ByRecMemId" scope="request" type="java.util.Set" />
<jsp:useBean id="listPrivMsg_BySendMemId" scope="request" type="java.util.Set" />
<jsp:useBean id="memSvc" scope="request" class="com.mem_dream.model.MemService"/>
<jsp:useBean id="rel_list_memVO" scope="request" type="com.mem_dream.model.MemVO" />
<jsp:useBean id="listRelation_ByAddedMemId" scope="request" type="java.util.Set" />
<jsp:useBean id="listGrps_ByMemId" scope="request" type="java.util.Set" />
<jsp:useBean id="grpSvc" scope="request" class="com.grp.model.GrpService"/>

<html>
<head>
<style>
</style>

<script src="http://code.jquery.com/jquery-1.10.1.min.js">  </script>
<title>對話名單 - listPrivMsg_ByRecMemId.jsp</title>

</head>
<body bgcolor='white'>

	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
			<th>發送訊息會員編號</th>
			<th>接收訊息會員編號</th>
			<th>訊息內容</th>
			<th>發送時間</th>
			<th>是否已讀</th>
		</tr>

		<c:forEach var="Priv_messageVO" items="${listPrivMsg_ByRecMemId}">
<!-- 		只列出一筆  -->
			<c:if test="${Priv_messageVO.privMsgSend_MemId!=sendAccount}">
				<tr align='center' valign='middle'>
					<td>${Priv_messageVO.privMsgSend_MemId}</td>
					<td>${Priv_messageVO.privMsgRec_MemId}</td>
					<td>${Priv_messageVO.privMsg_content}</td>	
					<td>${Priv_messageVO.privMsg_SendTime}</td>		
					<td>${Priv_messageVO.privMsg_type}</td>	
					<td>
<%-- 						<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do"> --%>
							<input type="button" value="傳送訊息" onclick="openChat(${Priv_messageVO.privMsgSend_MemId})">
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
	
	
			  <c:forEach var="AddedRel_ListVO" items="${listRelation_ByAddedMemId}">
 				rel_list_memVO.mem_Id--${rel_list_memVO.mem_Id}<br> 
 				AddedRel_ListVO.added_MemId--${AddedRel_ListVO.added_MemId}<br> 
 				isInvited--${AddedRel_ListVO.isInvited}<br> 
			
			
			<c:if test="${(AddedRel_ListVO.isInvited=='1')&&(rel_list_memVO.mem_Id==AddedRel_ListVO.added_MemId)}">
				<c:set var="sendInviteMemId" value="${AddedRel_ListVO.rel_MemId}"/>
				<c:set var="recieveInviteMemId" value="${AddedRel_ListVO.added_MemId}"/>
				<c:set var="displayConfirmButton" value="true"/>
				
				<c:if test="${displayConfirmButton}">
					${memSvc.getOneMem(sendInviteMemId).mem_nick_name}邀請你成為他的好友
					<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do">
					<button type="submit" class="btn btn-danger" type=""submit"">同意加入好友</button><br/>
						
						<input type="hidden" name="requestURL" value="<%= request.getServletPath()%>">
						<input type="hidden" name="sendInviteMemId" value="${sendInviteMemId}">
						<input type="hidden" name="recieveInviteMemId" value="${recieveInviteMemId}">
						<input type="hidden" name="action" value="confirmAddFriend">
					</form>
				</c:if>	
			</c:if>
		</c:forEach>	
	 
	 
			  <c:forEach var="joinListVO" items="${listGrps_ByMemId}">
			      <c:if test="${joinListVO.joinList_isInvited=='1'}">
			  		 ${memSvc.getOneMem(grpSvc.getOneGrp(joinListVO.joinList_GrpId).grp_MemId).mem_nick_name}邀請你加入
			  		 ${grpSvc.getOneGrp(joinListVO.joinList_GrpId).grp_name}
			  		<button type="button" id="confirmJoinGrpBtn">同意入團</button>
			  		<form name="joinGrpForm" id="confirmJoinGrpForm">
			  			<input hidden name="joinList_GrpId" value="${joinListVO.joinList_GrpId}">
			  			<input hidden name="joinList_MemId" value="${joinListVO.joinList_MemId}">
			  			<input hidden name="requestURL" value="<%= request.getServletPath() %>">			  			
			  			<input hidden name="action" value="confirmJoinGrp">
			  		</form>
			  	  </c:if>
			  </c:forEach>
	 
	<br>本網頁的路徑:
	<br>
	<b>
	 <font color=blue>request.getServletPath():</font> <%=request.getServletPath()%><br>
	 <font color=blue>request.getRequestURI(): </font> <%=request.getRequestURI()%>
	</b>
	<script>
	
		$("#confirmJoinGrpBtn").click(function(){
			
			var URLs = "<%=request.getContextPath()%>/joinlist/joinlist.do";
//用之前SET過的變數
			var sendData = $("#confirmJoinGrpForm").serialize();
			
			console.log(sendData);
			
			$.ajax({
				url : URLs,
				data : sendData,
				type : "POST",
				dataType : 'text',
	
				success : function(msg) {
					location.reload();		
// 					alert("OK");
				},
	
				error : function(xhr, ajaxOptions, thrownError) {
					alert(xhr.status);
					alert(thrownError);
				}
			});
		})
	
	</script>
</body>
		


</html>
