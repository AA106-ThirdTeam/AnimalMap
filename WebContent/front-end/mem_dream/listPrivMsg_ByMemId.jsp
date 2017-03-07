<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Title Page</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			
			<c:forEach var="Priv_messageVO" items="${listPrivMsg_ByRecMemId}">
		<!-- 只列出一筆  -->
				<c:if test="${Priv_messageVO.privMsgSend_MemId!=sendAccount}">
					<div class="row" onclick="openChat(${Priv_messageVO.privMsgSend_MemId})">
						<div class="col-xs-3 col-sm-2">
							<img src="https://api.fnkr.net/testimg/80x80/00CED1/FFF/?text=img+placeholder" 
							style="border-radius: 25px;">
						</div>
						<div class="col-xs-6 col-sm-10">
							<div>${Priv_messageVO.privMsgSend_MemId}</div>
							<p style="margin-bottom: 0px">${Priv_messageVO.privMsg_content}</p>
							<div>${Priv_messageVO.privMsg_SendTime}</div>							
						</div>
					</div>
					<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do">
						<input type="hidden" name="requestURL" value="<%= request.getServletPath()%>"> 
 						<input type="hidden" name="privMsgSend_MemId" value="${Priv_messageVO.privMsgSend_MemId}">
						<input type="hidden" name="privMsgRec_MemId" value="${Priv_messageVO.privMsgRec_MemId}">
<!-- 							<input type="hidden" name="action" value="joinChat"> -->
					</form>
				</c:if>
				<c:set var="sendAccount" value="${Priv_messageVO.privMsgSend_MemId}"/>
			</c:forEach>
				

			<c:forEach var="AddedRel_ListVO" items="${listRelation_ByAddedMemId}">
				<div class="row">
					<div class="col-xs-9 col-sm-9" style="height:80px">
						<c:if test="${(AddedRel_ListVO.isInvited=='1')&&(rel_list_memVO.mem_Id==AddedRel_ListVO.added_MemId)}">
							<c:set var="sendInviteMemId" value="${AddedRel_ListVO.rel_MemId}"/>
							<c:set var="recieveInviteMemId" value="${AddedRel_ListVO.added_MemId}"/>
							<c:set var="displayConfirmButton" value="true"/>
							
							<c:if test="${displayConfirmButton}">
								${memSvc.getOneMem(sendInviteMemId).mem_nick_name}邀請你成為他的好友
					</div>
					<div class="col-xs-3 col-sm-3" style="height:80px">
								<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do">
								<button type="submit" class="btn btn-danger" type="submit">同意加入好友</button>
									
									<input type="hidden" name="requestURL" value="<%= request.getServletPath()%>">
									<input type="hidden" name="sendInviteMemId" value="${sendInviteMemId}">
									<input type="hidden" name="recieveInviteMemId" value="${recieveInviteMemId}">
									<input type="hidden" name="action" value="confirmAddFriend">
								</form>
					</div>
							</c:if>	
						</c:if>

				</div>			
			</c:forEach>	


				<c:forEach var="joinListVO" items="${listGrps_ByMemId}">
					<div class="row">
					<div class="col-xs-9 col-sm-9" style="height:80px">
				      <c:if test="${joinListVO.joinList_isInvited=='1'}">
				  		 ${memSvc.getOneMem(grpSvc.getOneGrp(joinListVO.joinList_GrpId).grp_MemId).mem_nick_name}邀請你加入
				  		 ${grpSvc.getOneGrp(joinListVO.joinList_GrpId).grp_name}
				  	</div>	 
				  	<div class="col-xs-3 col-sm-3" style="height:80px">
				  		<button type="button" class="btn btn-info" id="confirmJoinGrpBtn">同意入團</button>
				  		<form name="joinGrpForm" id="confirmJoinGrpForm">
				  			<input hidden name="joinList_GrpId" value="${joinListVO.joinList_GrpId}">
				  			<input hidden name="joinList_MemId" value="${joinListVO.joinList_MemId}">
				  			<input hidden name="requestURL" value="<%= request.getServletPath() %>">			  			
				  			<input hidden name="action" value="confirmJoinGrp">
				  		</form>
				  	</div>		
				  	  </c:if>
				  	</div>
			 	 </c:forEach>
		
				<c:forEach var="Priv_messageVO" items="${listPrivMsg_BySendMemId}">
		<!-- 只列出一筆  -->
				<c:if test="${Priv_messageVO.privMsgRec_MemId!=sendAccount}">
					<div class="row" onclick="openChat(${Priv_messageVO.privMsgSend_MemId})">
						<div class="col-xs-3 col-sm-2">
							<img src="https://api.fnkr.net/testimg/80x80/00CED1/FFF/?text=img+placeholder" 
							style="border-radius: 25px;">
						</div>
						<div class="col-xs-6 col-sm-10">
							<div>${Priv_messageVO.privMsgSend_MemId}</div>
							<p style="margin-bottom: 0px">${Priv_messageVO.privMsg_content}</p>
							<div>${Priv_messageVO.privMsg_SendTime}</div>							
						</div>
					</div>
					<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do">
						<input type="hidden" name="requestURL" value="<%= request.getServletPath()%>"> 
 						<input type="hidden" name="privMsgSend_MemId" value="${Priv_messageVO.privMsgSend_MemId}">
						<input type="hidden" name="privMsgRec_MemId" value="${Priv_messageVO.privMsgRec_MemId}">
<!-- 							<input type="hidden" name="action" value="joinChat"> -->
					</form>
				</c:if>
				<c:set var="sendAccount" value="${Priv_messageVO.privMsgSend_MemId}"/>
			</c:forEach>
		
		
		
		

		</div>
		<!-- containerDIV -->
		
		
	</body>
</html>