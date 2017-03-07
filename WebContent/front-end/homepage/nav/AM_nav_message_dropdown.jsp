<%@page import="util.time.Timestamp_util"%>
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


	
	<ul class="dropdown-menu privMsg001" style="width: 300px;">
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
		request.setAttribute("privMsgSvc", privMsgSvc);
	%>

	


<%
	util.time.Timestamp_util timeTranslate = new util.time.Timestamp_util();
	pageContext.setAttribute("timeTranslate",timeTranslate);	
%>


	<c:forEach var="Priv_messageVO" items="${listPrivMsg_ByRecMemId}" >
		<!-- 只列出一筆  -->	
		<c:set var="counter" value="0"/>
		
		<c:forEach var="Priv_messageVOinside" items="${listPrivMsg_ByRecMemId}">
			<c:if test="${(Priv_messageVOinside.privMsgSend_MemId==Priv_messageVO.privMsgSend_MemId)&&(Priv_messageVOinside.privMsg_type=='0')}">
				<c:set var="counter" value="${counter+1}"/>
			</c:if>				
		</c:forEach>
		
				
		
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
					<div style="display:inline">${timeTranslate.getBetweenTime(Priv_messageVO.privMsg_SendTime)}</div>
<%-- 					<c:if test="${counter!=0}"> --%>
						<div style="width:20px;background-color:red;color:white;text-align:center;border-radius:10px;float:right">${counter}</div>
<%-- 					</c:if> --%>
				</div>
			</div>
			<%-- 				<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do"> --%>
			<%-- 				<input type="hidden" name="requestURL" value="<%= request.getServletPath()%>">  --%>
			<%-- 				<input type="hidden" name="privMsgSend_MemId" value="${Priv_messageVO.privMsgSend_MemId}"> --%>
			<%-- 				<input type="hidden" name="privMsgRec_MemId" value="${Priv_messageVO.privMsgRec_MemId}"> --%>
			<!-- 				<input type="hidden" name="action" value="joinChat"> -->
			<!-- 				</form> -->

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

	<% Set<String> allSendButDidntRecSetMemId = new LinkedHashSet(); %>
	
	<c:forEach var="Priv_messageVO" items="${listPrivMsg_BySendMemId}" >
<%-- 		${Priv_messageVO.privMsgRec_MemId}=========${loginMemId} --%>
<!-- 	******************************************************************** -->
		
		<!-- 只列出一筆  -->	
			
<%-- 		${empty privMsgSvc.getPriv_MessageByRec_MemId(loginMemId,Priv_messageVO.privMsgRec_MemId)}	 --%>
		
<%-- 		${empty privMsgSvc.getPriv_MessageByRec_MemId(Priv_messageVO.privMsgRec_MemId,loginMemId)}	 --%>
		
		<c:if test="${empty privMsgSvc.getPriv_MessageByRec_MemId(loginMemId,Priv_messageVO.privMsgRec_MemId)}">		
		
			<c:set var="sendButDidntRecSet" value="${privMsgSvc.getPriv_MessageByRec_MemId(Priv_messageVO.privMsgRec_MemId,loginMemId)}" scope="request"/>
		
		</c:if>	
<% 
		
			System.out.println("(request.getAttribute(sendButDidntRecSet): "+(request.getAttribute("sendButDidntRecSet")));		

			if((request.getAttribute("sendButDidntRecSet")!=null)&&
					(!((LinkedHashSet<Priv_messageVO>)request.getAttribute("sendButDidntRecSet")).isEmpty())){				
			Set<Priv_messageVO> privMsgSet = (LinkedHashSet<Priv_messageVO>)request.getAttribute("sendButDidntRecSet");
			Priv_messageVO priv_messageVO[] = (Priv_messageVO[])(privMsgSet.toArray(new Priv_messageVO[privMsgSet.size()]));
			Priv_messageVO aPriv_messageVO = priv_messageVO[0];
			allSendButDidntRecSetMemId.add(aPriv_messageVO.getPrivMsgRec_MemId());
			request.setAttribute("allSendButDidntRecSetMemId",allSendButDidntRecSetMemId);
			}
%>			
		<c:set var="sendButDidntRecSet" value="" scope="request"/>	
	</c:forEach>
	
	
	<c:forEach var="aSendToMemId" items="${allSendButDidntRecSetMemId}" >			
			<div class="row"
				onclick="openChat(${aSendToMemId})"
				style="margin-left: -1px; width: 300px; border-bottom: 1px solid #d3d3d3">
				
				<div class="col-xs-8 col-sm-8" style="margin-left: 0px">
				你傳送了訊息給:<span class="align-middle" style="color:blue">${memSvc.getOneMem(aSendToMemId).mem_name}</span> 
<%-- 					<div class="pull-right">${tem_memVO.mem_name}</div> --%>
<%-- 					<p style="margin-bottom: 0px">${Priv_messageVO.privMsg_content}</p> --%>
<%-- 					<div style="display:inline">${timeTranslate.getBetweenTime(Priv_messageVO.privMsg_SendTime)}</div> --%>
<%-- 					<div style="width:20px;background-color:red;color:white;text-align:center;border-radius:10px;float:right">${counter}</div> --%>
<!-- 				</div>				 -->
				<div class="col-xs-6 col-sm-6">
					
				</div>
				<div class="col-xs-6 col-sm-6 pull-right" style="margin-left: 5px">
					<img src='${memSvc.getOneMem(aSendToMemId).mem_profile}'
						style="width: 50px; height: 50px;">						
				</div>				
			</div>
			</div>
	</c:forEach>		




</ul>
