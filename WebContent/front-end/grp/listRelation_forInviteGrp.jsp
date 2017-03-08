<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mem_dream.model.*"%>
<%@ page import="com.rel_list.model.*"%>
<%@ page import="com.priv_message.controller.MyEchoServer"%>
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
		<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		
	</head>
	<body>
		
<form name="inviteToGrpForm" action="<%=request.getContextPath()%>/joinList/joinList.do" method="post">
<div class="container" style="width:50vw; height:70vh; background-color:white">
    
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

                    		<c:if test="${(joinListVO.joinList_MemId==Rel_ListVO.added_MemId)}">
                    			<c:set var="isInJoinList" value="true"/>
                    		</c:if>
                    	</c:forEach>
                    		
                    	<c:if test="${!isInJoinList}">
                    		
                    		<c:set var="hasFriendToInvite" value="true"/>
                    		
                        <li class="list-group-item">
		                     <div class="col-xs-12 col-sm-3">
		                         <img src="${memSvc.getOneMem(Rel_ListVO.added_MemId).mem_profile} " alt="Scott Stevens" class="img-circle" 
		                         style="height:50px; width:50px"/>
		                         <div class="name">${memSvc.getOneMem(Rel_ListVO.added_MemId).mem_name}</div><br/>
		                     </div>
		                     <div class="col-xs-12 col-sm-9">
		                     
		                     		<c:set var="isOnline" value="false"/>
					 <%	                 
	                  	Map allSession =  MyEchoServer.notificationSessions;
	                  	application.setAttribute("allSession", allSession);		                  	
	                  %>   
		                  		<c:forEach var="seeLoginMemId" items="${allSession}">								
									<c:if test="${seeLoginMemId.key==Rel_ListVO.added_MemId}">
										<c:set var="isOnline" value="true"/>
									</c:if>
								</c:forEach>
		                  
									<c:if test="${isOnline eq true}">
										<span><i class="glyphicon glyphicon-user" style="color:green"></i></span>
									</c:if>
									<c:if test="${isOnline eq false}">
										<span><i class="glyphicon glyphicon-user" style="color:red"></i></span>
									</c:if>                  
		                     
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
<!-- 		進此頁面時有存一個grp_Id進req -->
		<input type="hidden" name="grp_Id" value="${grp_Id}">
		<input type="hidden" name="requestURL" value="<%= request.getServletPath() %>">
	
	</form>	
		<script>
			$(function(){
				$("#sendGrpInviteBtn").click(function(){
					var selectedBox = $(":checked");
					console.log(selectedBox.length);
					var webSocket1;
					for(var i = 0 ; i<selectedBox.length ; i++){
						var MyPoint1 = "/MyEchoServer/"+"notApplicable"+"/"+selectedBox[i].value+"/grpInvite";
					     console.log(MyPoint1);
					    var host = window.location.host;
					    var path = window.location.pathname;
					    var webCtx = path.substring(0, path.indexOf('/', 1));
					    var endPointURL1 = "ws://" + window.location.host + webCtx + MyPoint1;
					    
						
							// 建立 websocket 物件
							webSocket1 = new WebSocket(endPointURL1);
							
							webSocket1.onopen = function(event) {
								console.log("webSocket連線");
							};

							webSocket1.onmessage = function(event) {	
// 								邀請完會重新刷新頁面讓WEBSOCKET斷線
// 								webSocket1.close();	
							};

							webSocket1.onclose = function(event) {
								console.log("webSocket斷線");
							};											
					}
													
					$("form[name='inviteToGrpForm']").submit();
// 					alert("完成邀請");
				});
				
// 				$("#test").click(function(){
// 					var selectedBox = $(":checked");
// 					var webSocket1;
// 					for(var i = 0 ; i<selectedBox.length ; i++){
// 						var MyPoint1 = "/MyEchoServer/"+"notApplicable"+"/"+selectedBox[i].value+"/grpInvite";
// 					     console.log(MyPoint1);
// 					    var host = window.location.host;
// 					    var path = window.location.pathname;
// 					    var webCtx = path.substring(0, path.indexOf('/', 1));
// 					    var endPointURL1 = "ws://" + window.location.host + webCtx + MyPoint1;
					    
						
// 							// 建立 websocket 物件
// 							webSocket1 = new WebSocket(endPointURL1);
							
// 							webSocket1.onopen = function(event) {
// 								console.log("webSocket連線");
// 							};

// 							webSocket1.onmessage = function(event) {					     
// 								webSocket1.close();	
// 							};

// 							webSocket1.onclose = function(event) {
// 								console.log("webSocket斷線");
// 							};
							
												
// 					}
							
// 				});
				
				
			});			
		</script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
	</body>
</html>