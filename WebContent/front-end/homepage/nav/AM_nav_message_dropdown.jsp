<%@page import="com.joinlist.model.JoinListVO"%>
<%@page import="com.grp.model.GrpService"%>
<%@page import="com.priv_message.model.Priv_messageVO"%>
<%@page import="com.priv_message.model.Priv_messageService"%>
<%@page import="com.rel_list.model.Rel_ListVO"%>
<%@page import="heibernate_com.mem.model.MemVO"%>
<%@page import="heibernate_com.mem.model.MemService"%>
<%@page import="com.rel_list.model.Rel_ListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="java.util.*"%>	 --%>
<%-- <%@page import="heibernate_com.mem.model.MemVO"%> --%>
<%@ page import="java.util.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.post_Response.model.*"%>
<%@ page import="com.offiMsg.model.*"%>
<%@ page import="com.offiMsg.controller.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	
	<ul class="dropdown-menu" style="width: 300px;">
	<%
		Rel_ListService relSvc = new Rel_ListService();
		MemService memSvc = new MemService();
		MemVO memVO = (MemVO) session.getAttribute("account");
		
		System.out.println("memVO : " + memVO);
		
		String mem_Id_2 = memVO.getMem_Id();
		Set<Rel_ListVO> addedMemIdSet = relSvc.getRel_ListByAdded_MemId(mem_Id_2);

		Priv_messageService privMsgSvc = new Priv_messageService();

		Set<Priv_messageVO> listPrivMsg_ByRecMemId = privMsgSvc.getPriv_MessageByRec_MemId(mem_Id_2);
		Set<Priv_messageVO> listPrivMsg_BySendMemId = privMsgSvc.getPriv_MessageBySend_MemId(mem_Id_2);
		GrpService grpSvc = new GrpService();
		Set<JoinListVO> listGrps_ByMemId = grpSvc.getJoinListByMemId(mem_Id_2);

		request.setAttribute("loginMemId", mem_Id_2);
		request.setAttribute("rel_list_memVO", memVO);
		request.setAttribute("listRelation_ByAddedMemId", addedMemIdSet);
		request.setAttribute("listPrivMsg_ByRecMemId", listPrivMsg_ByRecMemId);
		request.setAttribute("listPrivMsg_BySendMemId", listPrivMsg_BySendMemId);
		request.setAttribute("listGrps_ByMemId", listGrps_ByMemId);
		request.setAttribute("memSvc", memSvc);
	%>


	<c:forEach var="Priv_messageVO" items="${listPrivMsg_ByRecMemId}">
		<!-- 只列出一筆  -->
		<c:if test="${Priv_messageVO.privMsgSend_MemId!=sendAccount}">
			<c:set var="tem_memVO"
				value="${memSvc.getOneMem(Priv_messageVO.privMsgSend_MemId)}" />
			<div class="row msg"
				onclick="openChat(${Priv_messageVO.privMsgSend_MemId})"
				style="margin-left: -1px; width: 300px; border-bottom: 1px solid #d3d3d3">
				<div class="col-xs-2 col-sm-2" style="margin-left: 5px">
					<img src='${tem_memVO.mem_profile}'
						style="width: 50px; height: 50px;">
				</div>
				<div class="col-xs-7 col-sm-7" style="margin-left: 15px">
					<div>${tem_memVO.mem_name}</div>
					<p style="margin-bottom: 0px">${Priv_messageVO.privMsg_content}</p>
					<div>${Priv_messageVO.privMsg_SendTime}</div>
				</div>
			</div>
			<%-- 													<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do"> --%>
			<%-- 														<input type="hidden" name="requestURL" value="<%= request.getServletPath()%>">  --%>
			<%-- 								 						<input type="hidden" name="privMsgSend_MemId" value="${Priv_messageVO.privMsgSend_MemId}"> --%>
			<%-- 														<input type="hidden" name="privMsgRec_MemId" value="${Priv_messageVO.privMsgRec_MemId}"> --%>
			<!-- 															<input type="hidden" name="action" value="joinChat"> -->
			<!-- 													</form> -->

		</c:if>
		<c:set var="sendAccount" value="${Priv_messageVO.privMsgSend_MemId}" />
	</c:forEach>


	<c:forEach var="AddedRel_ListVO" items="${listRelation_ByAddedMemId}">
		<c:if
			test="${(AddedRel_ListVO.isInvited=='1')&&(rel_list_memVO.mem_Id==AddedRel_ListVO.added_MemId)}">
			<div class="row inviteFriendMsg"
				style="margin-left: -1px; width: 300px; border-bottom: 1px solid #d3d3d3">
				<div class="col-xs-9 col-sm-9" style="height: 80px;">
					<c:set var="sendInviteMemId" value="${AddedRel_ListVO.rel_MemId}" />
					<c:set var="recieveInviteMemId"
						value="${AddedRel_ListVO.added_MemId}" />
					<c:set var="displayConfirmButton" value="true" />

					<c:if test="${displayConfirmButton}">
									${memSvc.getOneMem(sendInviteMemId).mem_nick_name}邀請你成為他的好友
						
				
				</div>
				<div class="col-xs-3 col-sm-3" style="height: 80px">
					<form method="post"
						action="<%=request.getContextPath()%>/rel_list/rel_list.do">
						<button type="submit" class="btn btn-danger" type="submit">同意加入好友</button>

						<input type="hidden" name="requestURL"
							value="<%=request.getServletPath()%>"> <input
							type="hidden" name="sendInviteMemId" value="${sendInviteMemId}">
						<input type="hidden" name="recieveInviteMemId"
							value="${recieveInviteMemId}"> <input type="hidden"
							name="action" value="confirmAddFriend">
					</form>
				</div>
		</c:if>
		</c:if>

		</div>
	</c:forEach>


	<c:forEach var="joinListVO" items="${listGrps_ByMemId}">
		<c:if test="${joinListVO.joinList_isInvited=='1'}">
			<div class="row inviteGrpMsg"
				style="margin-left: -1px; width: 300px; border-bottom: 1px solid #d3d3d3">
				<div class="col-xs-9 col-sm-9" style="height: 80px;"></div>
				<div class="col-xs-3 col-sm-3" style="height: 80px">
					<button type="button" class="btn btn-info" id="confirmJoinGrpBtn">同意入團</button>
					<form name="joinGrpForm" id="confirmJoinGrpForm">
						<input hidden name="joinList_GrpId"
							value="${joinListVO.joinList_GrpId}"> <input hidden
							name="joinList_MemId" value="${joinListVO.joinList_MemId}">
						<input hidden name="requestURL"
							value="<%=request.getServletPath()%>"> <input hidden
							name="action" value="confirmJoinGrp">
					</form>
				</div>
		</c:if>
		</div>
	</c:forEach>






</ul>
