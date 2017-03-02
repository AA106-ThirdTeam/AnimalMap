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
<%@ page import="com.offiMsg.model.*" %>
<%@ page import="com.offiMsg.controller.*" %>
<style>
	
	.navbar-inverse .navbar-nav>li>a {
		color: rgba(1,1, 1, 1);
	
	}
	</style>
	<nav class="navbar navbar-inverse " role="navigation" style="background-color: rgba(27, 156, 176, 1);border-color:rgba(27, 156, 176, 1);">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">選單切換</span>
				<span class="icon-bar"></span>
				<!-- <span class="icon-bar"></span> -->
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/front-end/homepage/index.jsp" style="color:black; font-size:30px;"><b>Animal Map</b></a>
		</div>
	
		<!-- 手機隱藏選單區 -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<!-- 左選單 -->
			<ul class="nav navbar-nav">
				<li class="active" ><a href="#" style="padding-top: 0 ;padding-bottom:0; background-color:rgba(27, 156, 176, 1)"><img class="img-circle" width="50" height="50" style="padding-top: 0" src="https://i.imgur.com/rv4YG8U.jpg"></a></li>
				<li><a href="<%=request.getContextPath()%>/front-end/aboutUs/index.html" style="">關於我們</a></li>
			</ul>
	
			<!-- 搜尋表單 -->
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="請輸入關鍵字">
				</div>
				<button type="submit" class="btn btn-default">搜尋</button>
			</form>
	
			<!-- 右選單 -->
			<ul class="nav navbar-nav navbar-right">
				<% 
				{
					if((Boolean)request.getAttribute("isLogin")){
						String tem_str = ((heibernate_com.mem.model.MemVO)session.getAttribute("account")).getMem_name();
						%>	
						<li><a href="#" class="glyphicon glyphicon-user">　<%=tem_str %>　您好</a></li>
						<%
					}else{
						%>
						<li><a href="#" class="glyphicon glyphicon-user">　訪客 您好</a></li>	
						<%
					}
				}
				%>
				<% 
				{
					if((Boolean)request.getAttribute("isLogin")){
						String tem_str = ((heibernate_com.mem.model.MemVO)session.getAttribute("account")).getMem_Id();
						%>	
							<FORM id="am_log_out" METHOD="post" ACTION="<%=request.getContextPath()%>/weihan_controller.do" style="position: absolute;">
								<input type="hidden" name="action" value="set_account_null">
								<input type="hidden" name="requestURL" value="<%=request.getContextPath() %>/front-end/homepage/index.jsp">
							</FORM>
							<li><a href="#" class="glyphicon glyphicon-log-out" onclick="log_out()">　登出</a></li>
							<script type="text/javascript">
								function log_out() {
									$( "#am_log_out" ).submit();
								}
							</script>
						<%
					}else{
						%>
							<FORM id="am_log_in" METHOD="post" ACTION="<%=request.getContextPath() %>/front-end/login/index.jsp" style="position: absolute;">
								<input type="hidden" name="action" value="login_in">
								<input type="hidden" name="requestURL" value="<%=request.getContextPath() %>/front-end/homepage/index.jsp">
							</FORM>	
							<li><a href="#" class="glyphicon glyphicon-log-out" onclick="log_in()">　登入</a></li>
							<script type="text/javascript">
								function log_in() {
									$( "#am_log_in" ).submit();
								}
							</script>												
<!-- 							<li> -->
<%-- 								<a style="cursor: pointer;" 　href="<%=request.getContextPath() %>/front-end/login/index.jsp">　登入</a> --%>
<!-- 							</li>						 -->
						<%
					}
				}
				%>					
				<% 
				{
					if((Boolean)request.getAttribute("isLogin")){
						String tem_str = ((heibernate_com.mem.model.MemVO)session.getAttribute("account")).getMem_Id();
						%>	
						<li>
							<a  class="glyphicon glyphicon-cog"  href="<%=request.getContextPath() %>/Heibernate_back-end/mem/mem.do?action=getOne_For_Update&mem_Id=<%=tem_str%>">　個人設定</a>
						</li>
<!-- 						<li class="dropdown"> -->
<!-- 							<a href="#"  class="glyphicon glyphicon-envelope dropdown-toggle" data-toggle="dropdown">　訊息通知 <b class="caret"></b></a> -->
<!-- 							<ul class="dropdown-menu" style="width: 300px;"> -->
<!-- 								<li><a href="#modal-id" data-toggle="modal" class="btn" style="padding-left: 20px;">標題:</a></li>						 -->
<!-- 							</ul> -->
<!-- 						</li>	 -->
						<li class="dropdown">
							<a href="#"  class="glyphicon glyphicon-envelope dropdown-toggle" data-toggle="dropdown">　訊息通知 <b class="caret"></b></a>
							<ul class="dropdown-menu" style="width: 300px;">
											<%
												Rel_ListService relSvc = new Rel_ListService();
												MemService memSvc = new MemService();
												MemVO memVO = (MemVO)session.getAttribute("account");
												String mem_Id = memVO.getMem_Id();
												Set<Rel_ListVO> addedMemIdSet = relSvc.getRel_ListByAdded_MemId(mem_Id);
												
												
												Priv_messageService privMsgSvc = new Priv_messageService();
												
												Set<Priv_messageVO> listPrivMsg_ByRecMemId = privMsgSvc.getPriv_MessageByRec_MemId(mem_Id);
												Set<Priv_messageVO> listPrivMsg_BySendMemId = privMsgSvc.getPriv_MessageBySend_MemId(mem_Id);
												GrpService grpSvc = new GrpService();
												Set<JoinListVO> listGrps_ByMemId = grpSvc.getJoinListByMemId(mem_Id);
												
												request.setAttribute("memId", mem_Id);
												request.setAttribute("rel_list_memVO", memVO);
												request.setAttribute("listRelation_ByAddedMemId", addedMemIdSet);
												request.setAttribute("listPrivMsg_ByRecMemId", listPrivMsg_ByRecMemId);
												request.setAttribute("listPrivMsg_BySendMemId", listPrivMsg_BySendMemId);    
												request.setAttribute("listGrps_ByMemId", listGrps_ByMemId);
											
											%>
								
									
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
<%-- 													<form method="post" action="<%= request.getContextPath()%>/rel_list/rel_list.do"> --%>
<%-- 														<input type="hidden" name="requestURL" value="<%= request.getServletPath()%>">  --%>
<%-- 								 						<input type="hidden" name="privMsgSend_MemId" value="${Priv_messageVO.privMsgSend_MemId}"> --%>
<%-- 														<input type="hidden" name="privMsgRec_MemId" value="${Priv_messageVO.privMsgRec_MemId}"> --%>
<!-- 															<input type="hidden" name="action" value="joinChat"> -->
<!-- 													</form> -->
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

								
								
							
							
							</ul>
						</li>	
						
						
						<%
					}else{
						%>
						<%
					}
				}
				%>	
							
				<li class="dropdown">
					<a href="#" class="glyphicon glyphicon-globe dropdown-toggle" data-toggle="dropdown">　系統訊息 <b class="caret"></b></a>
					<ul class="dropdown-menu" style="width: 300px;">
						<%
						OffiMsgService offiMsgSvc = new OffiMsgService();
						List<OffiMsgVO> listOffiMsg = offiMsgSvc.getAll();
						request.setAttribute("listOffiMsg", listOffiMsg);
						%>
						
						<c:forEach var="OffiMsgVO" items="${listOffiMsg}">
							<div class="row" style="width: 100px;">
								<li><a href="#modal-id${OffiMsgVO.offiMsg_Id}" data-toggle="modal" class="btn" style="padding-left: 20px;">標題:${OffiMsgVO.offiMsg_Title}</a></li>
							</div>
						</c:forEach>
					</ul>
				</li>

			
			</ul>
		</div>
		<!-- 手機隱藏選單區結束 -->
	</nav>


<!--==================================================清     單=====================================================================-->
	
				
	<c:forEach var="OffiMsgVO" items="${listOffiMsg}">
					
			<div class="modal fade" id="modal-id${OffiMsgVO.offiMsg_Id}">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
					
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						
							${OffiMsgVO.offiMsg_Id}<h4 class="modal-title"><b>標題${OffiMsgVO.offiMsg_Title}</h4>
						</div>
						<div class="modal-body">
							<a>內容:${OffiMsgVO.offiMsg_Content}</a>
						</div>
					
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
						
						</div>
				
				</div>
			</div>
		</div>
		</c:forEach>
		
		
<!-- 		<script src="https://code.jquery.com/jquery.js"></script> -->
<!-- 		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<!-- 	</body> -->
<!-- </html> -->



<script>
				var vars = {};
				
				
				function openChat(sendToAccount){	
					alert(${memId});
					var startChatMsg;
					var messagesArea;
					
					var MyPoint = "/MyEchoServer/"+${memId}+"/"+ sendToAccount + "/chatRoom";
				//	    console.log("MyPoint="+MyPoint);
				    var host = window.location.host;
				    var path = window.location.pathname;
				    var webCtx = path.substring(0, path.indexOf('/', 1));
				    var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
				    
					var statusOutput = document.getElementById("statusOutput");
					
					vars['webSocket '+sendToAccount] = new WebSocket(endPointURL);
					
						// 建立 websocket 物件
					
					var URLs = "<%=request.getContextPath()%>/privMsg/privMsg.do";
					var sendData="action=openChat&" + "privMsgRec_MemId=" + sendToAccount +"&requestURL=<%=request.getServletPath()%>";
				//		console.log(URLs);
					$.ajax({
						url : URLs,
						data : sendData,
						type : "POST",
						dataType : 'text',
				
						success : function(msg1) {
							
							$.ajax({
								url : "<%=request.getContextPath()%>/mem_dream/mem.do",
								data : "action=getStartChatMsg" +"&privMsgSend_MemId=" + ${memId} + "&privMsgRec_MemId=" + sendToAccount +"&requestURL=<%=request.getServletPath()%>",
								type : "POST",
								dataType : 'text',
				
								success : function(msg) {
								    var inputMessage = document.getElementById("sendMessageArea"+sendToAccount);
								    startChatMsg = msg;
				//					    console.log("startChatMsg on ACCEPT"+startChatMsg);
								
							
							$("#AM_map_chat").html("<div id='50'></div>");
							$("#50").attr("id","chatArea"+sendToAccount);
							var chatArea = document.getElementById("chatArea"+sendToAccount);
							
							chatArea.innerHTML=msg1;
						
							
							var closeBtn = document.getElementById("closeBtn"+sendToAccount);
							
							closeBtn.addEventListener("click",function(){
								chatArea.parentNode.removeChild(chatArea);
								vars['webSocket '+sendToAccount].close();
								
								},false);			
							
							
							$("[id*='closeBtn']").click(function(){
								var id = $(this).attr("id");
								var memId= id.substr(8);
								console.log(!!document.getElementById("openChatinlistALLMemBtn"+memId));
								//document.getElementById("openChatinlistALLMemBtn"+memId)不存在的話回傳false
								if(!!document.getElementById("openChatinlistALLMemBtn"+memId)){
									document.getElementById("openChatinlistALLMemBtn"+memId).disabled=false;
								}else{
									document.getElementById("openChatBtn"+memId).disabled=false;
								}
							});
							
							messagesArea = document.getElementById("messagesArea"+sendToAccount);
				
						    var jsonData = JSON.parse(startChatMsg);
						    var showedDataOnload="";
						    
							for (var i = 0; i < jsonData.recievedJsonArray.length; i++) {
							    var userName = jsonData.recievedJsonArray[i].userName;
							    var message = jsonData.recievedJsonArray[i].message;
							    var sendTime = jsonData.recievedJsonArray[i].sendTime;
							    var privMsgSend_MemId = jsonData.recievedJsonArray[i].privMsgSend_MemId;
							    var showedData;
							    if(privMsgSend_MemId!=${memId}){
								    showedData="<li class='left clearfix'>"+
						                   "<span class='chat-img pull-left'>"+
						                                    "<img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' />"+
						                                "</span>"+
						                    "<div class='chat-body clearfix'>"+
						                        "<div class='header'>"+
						                            "<strong class='primary-font'>"+userName+"</strong>"+
						                            "<small class='pull-right text-muted'>"+
						                                            "<i class='fa fa-clock-o fa-fw'></i>"+ sendTime +
						                            "</small>"+
						                        "</div>"+
						                        "<p>"+
						                        	message+
						                        "</p>"+
						                    "</div>"+
						                "</li>";
							    }else{
								    showedData="<li class='right clearfix'>"+
				                        "<span class='chat-img pull-right'>"+
				                                         "<img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' />"+
				                                     "</span>"+
				                         "<div class='chat-body clearfix'>"+
				                             "<div class='header'>"+	                                 
				                                 "<small class='text-muted'>"+
				                                           "<i class='fa fa-clock-o fa-fw'></i>"+ sendTime +
				                                  "</small>"+
				                                  "<strong class='primary-font pull-right'>"+userName+"</strong>"+
				                             "</div>"+
				                             "<p style='text-align:right;width:100%;float:right'>"+
				                                 message+
				                             "</p>"+
				                         "</div>"+
				                     "</li>";
							    }
							    
							    showedDataOnload = showedDataOnload+showedData; 
							    
							    messagesArea.innerHTML=showedDataOnload;
							  
							    console.log("privMsgSend_MemId!=${memId}="+(privMsgSend_MemId!=${memId}));
							  						    console.log(privMsgSend_MemId);
							  						    console.log(${memId});
							}
							
							
							console.log("sendMessage"+sendToAccount);
						  
										
							
							document.getElementById("sendMessage"+sendToAccount).addEventListener("click", function(){ sendMessage(sendToAccount);} ,false);
							
							document.getElementById("sendMessageArea"+sendToAccount).addEventListener("keydown", function(event){
								if (event.keyCode == 13) {sendMessage(sendToAccount);};
							} ,false);
							
							
							function disconnect () {
								vars['webSocket '+sendToAccount].close();
								document.getElementById('sendMessage').disabled = true;
								document.getElementById('connect').disabled = false;
								document.getElementById('disconnect').disabled = true;
							}
							
							function sendMessage(sendToAccount){
								
							    var userName = ${memId};
							    				    
							    var inputMessage = document.getElementById("sendMessageArea"+sendToAccount);
							    var message = inputMessage.value.trim();
							    							    
							    if (message === ""){			        
							        inputMessage.focus();
							        return;
							    }else{
							        var jsonObj = {"userName" : userName, "message" : message};
				//				        console.log('vars['webSocket '+sendToAccount]' + sendToAccount);
							        vars['webSocket '+sendToAccount].send(JSON.stringify(jsonObj));
							        
							        inputMessage.value = "";
							        inputMessage.focus();
							    }
							}
							
						},
				
						error : function(xhr, ajaxOptions, thrownError) {
							alert(xhr.status);
							alert(thrownError);
						}
					});
							
						}
					,
				
					error : function(xhr, ajaxOptions, thrownError) {
						alert(xhr.status);
						alert(thrownError);
					}
				});
					
				//		var statusOutput = document.getElementById("statusOutput");
					
				//		function updateStatus(newStatus) {
				//			statusOutput.innerHTML = newStatus;
				//		}
					
					vars['webSocket '+sendToAccount].onopen = function(event) {
				//			updateStatus("WebSocket 成功連線");
				//			document.getElementById('sendMessage').disabled = false;
				//			document.getElementById('connect').disabled = true;
				//			document.getElementById('disconnect').disabled = false;
					};
				
				
					
					vars['webSocket '+sendToAccount].onmessage = function(event) {
						
						var jsonObj = JSON.parse(event.data);
				
						var d = new Date();
						var messagesArea;
						var userName = jsonObj.userName;
					    var message = jsonObj.message;
					    
					    var privMsgSend_MemId = jsonObj.privMsgSend_MemId;
					    var showedData;
						
						
						var displayTime = d.getFullYear()+"/"+("0"+(d.getMonth()+1)).slice(-2)+"/"+("0"+d.getDate()).slice(-2)+"  "+
											("0"+d.getHours()).slice(-2)+":"+("0"+d.getMinutes()).slice(-2)+":"+("0"+d.getSeconds()).slice(-2);
									
						
				//第二次傳入的sendToAccount被刷成第二次的會員編號，每次ONMESSAGE傳入的都會顯示在最後一次點開的對話框
				
						if(jsonObj.privMsgSend_MemId==${memId}){
							messagesArea=document.getElementById("messagesArea"+jsonObj.privMsgRec_MemId);
						}else{
							messagesArea=document.getElementById("messagesArea"+jsonObj.privMsgSend_MemId);
						}
				        
						
						if(privMsgSend_MemId!=${memId}){
						    showedData="<li class='left clearfix'>"+
				                   "<span class='chat-img pull-left'>"+
				                                    "<img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' />"+
				                                "</span>"+
				                    "<div class='chat-body clearfix'>"+
				                        "<div class='header'>"+
				                            "<strong class='primary-font'>"+userName+"</strong>"+
				                            "<small class='pull-right text-muted'>"+
				                                            "<i class='fa fa-clock-o fa-fw'></i>"+ displayTime +
				                                        "</small>"+
				                        "</div>"+
				                        "<p>"+
				                        	message+
				                        "</p>"+
				                    "</div>"+
				                "</li>";
					    }else{
					    	showedData="<li class='right clearfix'>"+
				            "<span class='chat-img pull-right'>"+
				                             "<img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' />"+
				                         "</span>"+
				             "<div class='chat-body clearfix'>"+
				                 "<div class='header'>"+	                                 
				                     "<small class='text-muted'>"+
				                               "<i class='fa fa-clock-o fa-fw'></i>"+ displayTime +
				                      "</small>"+
				                      "<strong class='primary-font pull-right'>"+userName+"</strong>"+
				                 "</div>"+
				                 "<p style='text-align:right;width:100%;background-color:red;float:right'>"+
				                     message+
				                 "</p>"+
				             "</div>"+
				         "</li>";
					    }
				        
				//			var node = document.createElement("LI");
				//			var msginnerhtml=messagesArea.innerHTML;
				//			showedData;
						messagesArea.innerHTML=messagesArea.innerHTML+showedData;
						
				        messagesArea.scrollTop = messagesArea.scrollHeight;
					};
				
				
					
					vars['webSocket '+sendToAccount].onclose = function(event) {
				//			updateStatus("WebSocket 已離線");
					};
					
				}
				
				$(function(){
				
					$.ajax({
						url : "<%=request.getContextPath()%>/mem_dream/mem.do",
						data : "action=getUnreadMsgCount" +"&mem_Id=" + ${memId} +"&requestURL=<%=request.getServletPath()%>",
						type : "POST",
						dataType : 'text',
						success : function(msg) {
							console.log(msg);
							$(".notificationArea").text(msg);
						},
						
						error : function(xhr, ajaxOptions, thrownError) {
							alert(xhr.status);
							alert(thrownError);
						}
					})
										
				})




</script>

