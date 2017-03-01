<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mem_dream.model.*"%>
<%@ page import="com.rel_list.model.*"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="listRelation_ByMemId" scope="request" type="java.util.Set" />
<jsp:useBean id="listJoinMem_ByGrpId" scope="request" type="java.util.Set" />

<jsp:useBean id="memSvc" scope="request" class="com.mem_dream.model.MemService"/>

<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Title Page</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="relListcss/relList.css">
		<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		

	</head>
	<body>
		
<form name="inviteToGrpForm" action="<%=request.getContextPath()%>/joinlist/joinlist.do" method="post">
<div class="container" style="width:20vw; height:70vh; background-color:white">
    
    <div class="row" style="width:100%">
        <div class="col-xs-12 col-sm-12">
            <div class="panel panel-default" >
                <div class="panel-heading c-list">
                    <span class="title">Contacts</span>
<!--                     <ul class="pull-right c-controls"> -->
                        
<!--                     </ul> -->
                </div>
                
<!--                 <div class="row" style="display: none;"> -->
<!--                     <div class="col-xs-12"> -->
<!--                         <div class="input-group c-search"> -->
<!--                             <input type="text" class="form-control" id="contact-list-search"> -->
<!--                             <span class="input-group-btn"> -->
<!--                                 <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-user"></span></button> -->
<!--                             </span> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
                
                <ul class="list-group" id="contact-list">
                
                <c:set var="hasFriendToInvite" value="false"/>
<!--                 顯示不在joinlist裡的好友 -->
                <c:forEach var="Rel_ListVO" items="${listRelation_ByMemId}"  varStatus="s">
                    <c:if test="${(Rel_ListVO.isBlackList=='0')&&(Rel_ListVO.isInvited!='1')}">

                    	<c:set var="isInJoinList" value="false"/>
                    	<c:forEach var="joinListVO" items="${listJoinMem_ByGrpId}">
<!--                     	設GRPID為了後面傳給SERVLET用 -->
                    		<c:set var="grp_Id" value="${joinListVO.joinList_GrpId}"/>

                    		<c:if test="${(joinListVO.joinList_MemId==Rel_ListVO.added_MemId)}">
                    			<c:set var="isInJoinList" value="true"/>
                    		</c:if>
                    	</c:forEach>
                    		
                    	<c:if test="${!isInJoinList}">
                    		
                    		<c:set var="hasFriendToInvite" value="true"/>
                    		
                        <li class="list-group-item">
		                     <div class="col-xs-12 col-sm-3">
		                         <img src="<%= request.getContextPath()%>/util/memPhotoOutput?mem_Id=${Rel_ListVO.added_MemId} " alt="Scott Stevens" class="img-circle" 
		                         style="height:50px; width:50px"/>
		                     </div>
		                     <div class="col-xs-12 col-sm-9">
		                     
		                     		<c:set var="isOnline" value="false"/>
								<c:forEach var="seeLoginMemId" items="${loginMemIdList}">
									<c:if test="${seeLoginMemId==Rel_ListVO.added_MemId}">
										<c:set var="isOnline" value="true"/>
									</c:if>
								</c:forEach>
									<c:if test="${isOnline eq true}">
										<span><i class="glyphicon glyphicon-user" style="color:green"></i></span>
									</c:if>
									<c:if test="${isOnline eq false}">
										<span><i class="glyphicon glyphicon-user" style="color:red"></i></span>
									</c:if>                  
		                     
		                         <span class="name">${memSvc.getOneMem(Rel_ListVO.added_MemId).mem_name}</span><br/>
		                         <div class="checkbox">
     								 <label><input type="checkbox" name="invitedMemId" value="${Rel_ListVO.added_MemId}">邀請</label>
    							</div>
		                      </div>    
		                      <div class="clearfix"></div>
		                  </li>
                    </c:if>
                    </c:if>
                 </c:forEach>   
                </ul>
                
            </div>
        </div>
	</div>
	<c:if test="${hasFriendToInvite}">
   		<div class="col-xs-12 col-sm-12"><button class="btn btn-info btn-block" type="button" id="sendGrpInviteBtn">確認邀請</div>
   </c:if>
   <c:if test="${!hasFriendToInvite}">
   		<div class="col-xs-12 col-sm-12"><button class="btn btn-danger btn-block" type="button">朋友都邀請完囉</div>
   </c:if>
</div>
		<input type="hidden" name="action" value="inviteFriendToGrp">
		<input type="hidden" name="grp_Id" value="${grp_Id}">
		<input type="hidden" name="requestURL" value="<%= request.getServletPath() %>">
		
	</form>	
		<script>
			$(function(){
				$("#sendGrpInviteBtn").click(function(){
					$("form[name='inviteToGrpForm']").submit();
					alert("完成邀請");
				});
			});			
		</script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
	</body>
</html>