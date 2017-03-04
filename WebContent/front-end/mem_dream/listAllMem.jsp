<%@page import="heibernate_com.mem.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rel_list.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	MemService memSvc = new MemService();
	List<MemVO> list = memSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<%
	
	String loginMemId = (String) session.getAttribute("loginMemId");
	List<String> loginMemIdList = new ArrayList<String>();
	loginMemIdList.add("1000001");	
// 	loginMemIdList.add("1000002");	
	loginMemIdList.add("1000003");	
	loginMemIdList.add("1000004");	
	session.setAttribute("loginMemIdList",loginMemIdList);
%>

<html>

<head>
<title>所有一般會員資料 - listAllMem.jsp</title>
<script src="http://code.jquery.com/jquery-1.10.1.min.js">
</script>
</head>
<body bgcolor='white'>



	<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
	<table border='1' cellpadding='5' cellspacing='0'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>
					所有一般會員資料 - ListAllMem.jsp 現在登入會員ID:<%=loginMemId%></h3> <a
				href="<%=request.getContextPath()%>/mem_dream/select_page.jsp"><img
					src="<%=request.getContextPath()%>/images/back1.gif" width="100"
					height="32" border="0">回首頁</a>
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

	<table border='1' bordercolor='#CCCCFF'>
		<tr>
			<th>會員編號</th>
			<th>會員暱稱</th>
			<th>姓名</th>
			
			<th>修改</th>
			<th>刪除</th>
			<th>聊天</th>
			<th>有無新訊息</th>
			
		</tr>
		<!-- include page1部分 -->
		<%
			int rowsPerPage = 3; //每頁的筆數    
			int rowNumber = 0; //總筆數
			int pageNumber = 0; //總頁數      
			int whichPage = 1; //第幾頁
			int pageIndexArray[] = null;
			int pageIndex = 0;
		%>

		<%
			rowNumber = list.size();
			if (rowNumber % rowsPerPage != 0)
				pageNumber = rowNumber / rowsPerPage + 1;
			else
				pageNumber = rowNumber / rowsPerPage;

			pageIndexArray = new int[pageNumber];
			for (int i = 1; i <= pageIndexArray.length; i++)
				pageIndexArray[i - 1] = i * rowsPerPage - rowsPerPage;
		%>

		<%
			try {
				whichPage = Integer.parseInt(request.getParameter("whichPage"));
				pageIndex = pageIndexArray[whichPage - 1];
			} catch (NumberFormatException e) { //第一次執行的時候
				whichPage = 1;
				pageIndex = 0;
			} catch (ArrayIndexOutOfBoundsException e) { //總頁數之外的錯誤頁數
				if (pageNumber > 0) {
					whichPage = pageNumber;
					pageIndex = pageIndexArray[pageNumber - 1];
				}
			}
		%>
		<%
			if (pageNumber > 0) {
		%>
		<b><font color=red>第<%=whichPage%>/<%=pageNumber%>頁
		</font></b>
		<%
			}
		%>
		<b>●符 合 查 詢 條 件 如 下 所 示: 共<font color=red><%=rowNumber%></font>筆
		</b>
		<!-- END : include page1部分 -->

		<!-- 顯示查詢資料的部分 -->
		<c:forEach var="memVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>" varStatus="s">
			<c:set var="memVO" value="${memVO}" scope="request"></c:set>
			<tr align='center' valign='middle'>
				<!--將修改的那一筆加入對比色而已-->
				<td>${memVO.mem_Id}</td>
				<td>${memVO.mem_nick_name}</td>
				<td>${memVO.mem_name}</td>
				

				<!-- 修改按鈕部分 -->
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/mem_dream/mem.do">
						<input type="submit" value="修改"> <input type="hidden"
							name="mem_Id" value="${memVO.mem_Id}"> <input
							type="hidden" name="requestURL"
							value="<%=request.getServletPath()%>">
						<!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="whichPage" value="<%=whichPage%>">
						<!--送出當前是第幾頁給Controller-->
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>

				<!-- 刪除按鈕部分 -->
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/mem_dream/mem.do">
						<input type="submit" value="刪除"> <input type="hidden"
							name="mem_Id" value="${memVO.mem_Id}"> <input
							type="hidden" name="requestURL"
							value="<%=request.getServletPath()%>">
						<!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="whichPage" value="<%=whichPage%>">
						<!--送出當前是第幾頁給Controller-->
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>




				<%
						String checkRelation = null;

						Rel_ListService relSvc = new Rel_ListService();

						MemVO memVO = (MemVO) request.getAttribute("memVO");

						Set<Rel_ListVO> relList = relSvc.getRel_ListByRel_MemId(loginMemId);
						
						boolean isInRelationList = false;
						
						if ((relList.size() != 0)) {
							for (Rel_ListVO aRel_ListVO : relList) {

// 						有在關係名單裡且不為好友，為黑名單或是無關係，且未邀請。
								if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())
										&& aRel_ListVO.getIsInvited().equals("0") && (aRel_ListVO.getIsBlackList().equals("1")
												|| aRel_ListVO.getIsBlackList().equals("2"))) {
									checkRelation = "invite";
								}
// 						有在關係名單裡且為好友
								if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())
										&& aRel_ListVO.getIsBlackList().equals("0")) {
									checkRelation = "cancelFriend";
								}
// 						有在關係名單裡但且沒接受邀請
								if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())
										&& aRel_ListVO.getIsInvited().equals("1")) {
									checkRelation = "waitingForConfirmation";
								}
								
								if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())){
									isInRelationList=true;
								}
								
							}
						} else {
							checkRelation = "invite";
						}
						
						
						if(!isInRelationList){
							checkRelation = "invite";
						}
						
						request.setAttribute("loginMemId", loginMemId);
						request.setAttribute("checkRelation", checkRelation);

// 					System.out.print("LIST ALL MEM memVO.getMem_Id()="+memVO.getMem_Id());

						// 				System.out.println("loginMemId= "+loginMemId);
// 						System.out.println("LIST ALL MEM checkRelation= " + checkRelation);
				%>

				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/rel_list/rel_list.do">
						<c:if test="${checkRelation == 'invite'}">
							<input type="submit" value="邀請好友"
								${(memVO.mem_Id==loginMemId) ? 'hidden':''}>
							<input type="hidden" name="action" value="invite">
						</c:if>
						<c:if test="${checkRelation == 'cancelFriend'}">
							<input type="submit" value="取消好友"
								${(memVO.mem_Id==loginMemId) ? 'hidden':''}>
							<input type="hidden" name="action" value="cancelFriend">
						</c:if>
						<c:if test="${checkRelation == 'waitingForConfirmation'}">
							<input type="button" value="等待好友確認"
								${(memVO.mem_Id==loginMemId) ? 'hidden':''} disabled>
						</c:if>

						<input type="hidden" name="rel_MemId" value="<%=loginMemId%>">
						<input type="hidden" name="added_MemId" value="${memVO.mem_Id}">
						<input type="hidden" name="requestURL"
							value="<%=request.getServletPath()%>">
						<!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="whichPage" value="<%=whichPage%>">
						<!--送出當前是第幾頁給Controller-->
					</FORM>
				</td>

				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/mem_dream/mem.do">
						<input type="submit" value="檢查好友"> <input type="hidden"
							name="rel_MemId" value="${memVO.mem_Id}"> <input
							type="hidden" name="requestURL"
							value="<%=request.getServletPath()%>">
						<!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="whichPage" value="<%=whichPage%>">
						<!--送出當前是第幾頁給Controller-->
						<input type="hidden" name="action" value="listRelation_ByMemId">
					</FORM>
				</td>
				
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/privMsg/privMsg.do" name="chatForm">
						<button type="button" ${(memVO.mem_Id==loginMemId) ? 'hidden':''} id="openChatinlistALLMemBtn${memVO.mem_Id}"> 傳送訊息</button>
						<input type="hidden" name="privMsgRec_MemId" value="${memVO.mem_Id}">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
						<input type="hidden" name="action" value="sendMessage">
					</FORM>
				</td>
				
				<script>
				    
							 		var a${s.index} = document.getElementById("openChatinlistALLMemBtn${memVO.mem_Id}");
									
							 		
							 		$(function(){
							 			 a${s.index}.addEventListener("click",function(){
												openChat(${memVO.mem_Id});
	 											a${s.index}.disabled = true;
											},false);
							 		});
							 		
							         
				</script>  
				
				
				
				<td>
					<div class="notificationArea" Style="height:100px;width:100px;background-color:steelblue" ${(memVO.mem_Id!=loginMemId) ? 'hidden':''}
						onClick="showPrivMsg${s.index}()"></div>
					<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/mem_dream/mem.do" name="showPrivMsgForm${s.index}" id="${s.index}">						
						<input type="hidden" name="privMsgRec_MemId" value="${memVO.mem_Id}">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
						<input type="hidden" name="action" value="listPrivMsg_ByMemId">
					</FORM>
				</td>
				
				
				
				
			</tr>
			
			<script>
				function showPrivMsg${s.index}(){
					$("#${s.index}").submit();
				}
			</script>
			
		</c:forEach>
	</table>
	
			<div id="privMsgFormArea" >	
				<c:if test="${!empty listPrivMsg}">
					<jsp:include page="listPrivMsg_ByMemId.jsp" />
				</c:if>			
			</div>
			
			<div id="chatArea"  style="bottom:0;right:0;position:absolute;">				
			</div>
			
	<!-- page2部分 -->
	<table border="0">
		<tr>
			<%
				if (rowsPerPage < rowNumber) {
			%>
			<%
				if (pageIndex >= rowsPerPage) {
			%>
			<td><A href="<%=request.getRequestURI()%>?whichPage=1">至第一頁</A>&nbsp;</td>
			<td><A
				href="<%=request.getRequestURI()%>?whichPage=<%=whichPage - 1%>">上一頁
			</A>&nbsp;</td>
			<%
				}
			%>

			<%
				if (pageIndex < pageIndexArray[pageNumber - 1]) {
			%>
			<td><A
				href="<%=request.getRequestURI()%>?whichPage=<%=whichPage + 1%>">下一頁
			</A>&nbsp;</td>
			<td><A
				href="<%=request.getRequestURI()%>?whichPage=<%=pageNumber%>">至最後一頁</A>&nbsp;</td>
			<%
				}
			%>
			<%
				}
			%>
		</tr>
	</table>
	<%
		if (pageNumber > 1) {
	%>
	<table border="0">
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<FORM METHOD="post" ACTION="<%=request.getRequestURI()%>">
				<td><select size="1" name="whichPage">
						<%
							for (int i = 1; i <= pageNumber; i++) {
						%>
						<option value="<%=i%>">跳至第<%=i%>頁
							<%
							}
						%>
						
				</select> <input type="submit" value="確定"></td>
			</FORM>
		</tr>
	</table>
	<%
		}
	%>

	<br>本網頁的路徑:
	<br>
	<b> <font color=blue>request.getServletPath():</font> <%=request.getServletPath()%><br>
		<font color=blue>request.getRequestURI(): </font> <%=request.getRequestURI()%>
	</b>


	<%
		if (request.getAttribute("listRelation") != null) {
	%>
	<jsp:include page="listRelation_ByMemId.jsp"/>
	<%
		}
	%>
	
	
	

</body>

<script>

	
	
        
    var MyPoint1 = "/MyEchoServer/"+"notApplicable"+"/"+${loginMemId}+"/notification";
//     console.log(MyPoint1);
    var host = window.location.host;
    var path = window.location.pathname;
    var webCtx = path.substring(0, path.indexOf('/', 1));
    var endPointURL1 = "ws://" + window.location.host + webCtx + MyPoint1;
    
	var note = $(".notificationArea");
	var webSocket1;
	
	function connect1() {
// 		console.log(endPointURL1);
// 		console.log(host);
// 		console.log(path);
// 		console.log(webCtx);

		// 建立 websocket 物件
		webSocket1 = new WebSocket(endPointURL1);
		
		webSocket1.onopen = function(event) {
// 			updateStatus1("WebSocket 成功連線");
			
		};

		webSocket1.onmessage = function(event) {
			         
// 	        var jsonObj = JSON.parse(event.data);
// 	        var message = jsonObj.userName + ": " + jsonObj.message + "\r\n";
	        console.log(event.data);
// 	        updateStatus1(message);
	        
	        $.ajax({
				url : "<%=request.getContextPath()%>/mem_dream/mem.do",
				data : "action=getUnreadMsgCount" +"&mem_Id=" + ${loginMemId} +"&requestURL=<%=request.getServletPath()%>",
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
	        
		};

		webSocket1.onclose = function(event) {
			updateStatus1("WebSocket 已離線");
		};
	}
	
	
	function sendMessage1() {
	    
	}

	function disconnect1 () {
		webSocket1.close();
	}
	
	function updateStatus1(newStatus) {
		note.text(newStatus);
	}
	

	window.onload= function(){
			connect1();
	}	
	
	
	var vars = {};

	function openChat(sendToAccount){
		var startChatMsg;
		var messagesArea;

		var MyPoint = "/MyEchoServer/"+${loginMemId}+"/"+ sendToAccount + "/chatRoom";
// 	    console.log("MyPoint="+MyPoint);
	    var host = window.location.host;
	    var path = window.location.pathname;
	    var webCtx = path.substring(0, path.indexOf('/', 1));
	    var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
	    
		var statusOutput = document.getElementById("statusOutput");
		
		vars['webSocket '+sendToAccount] = new WebSocket(endPointURL);
		
			// 建立 websocket 物件
		
		var URLs = "<%=request.getContextPath()%>/privMsg/privMsg.do";
		var sendData="action=openChat&" + "privMsgRec_MemId=" + sendToAccount +"&requestURL=<%=request.getServletPath()%>";
// 		console.log(URLs);
		$.ajax({
			url : URLs,
			data : sendData,
			type : "POST",
			dataType : 'text',

			success : function(msg1) {
				
				$.ajax({
					url : "<%=request.getContextPath()%>/mem_dream/mem.do",
					data : "action=getStartChatMsg" +"&privMsgSend_MemId=" + ${loginMemId} + "&privMsgRec_MemId=" + sendToAccount +"&requestURL=<%=request.getServletPath()%>",
					type : "POST",
					dataType : 'text',

					success : function(msg) {
					    var inputMessage = document.getElementById("sendMessageArea"+sendToAccount);
					    startChatMsg = msg;
// 					    console.log("startChatMsg on ACCEPT"+startChatMsg);
					
				
				$("#chatArea").before("<div id='50'></div>");
				$("#50").attr("id","chatArea"+sendToAccount)
				
				var chatArea = document.getElementById("chatArea"+sendToAccount);
				
				chatArea.innerHTML=msg1;
			
				
				var closeBtn = document.getElementById("closeBtn"+sendToAccount);
				
				closeBtn.addEventListener("click",function(){
					chatArea.parentNode.removeChild(chatArea);
					vars['webSocket '+sendToAccount].close();
					
					},false);			
				
				
				$("[id*='closeBtn']").click(function(){
					var id = $(this).attr("id");
					var loginMemId= id.substr(8);
					console.log(!!document.getElementById("openChatinlistALLMemBtn"+loginMemId));
					//document.getElementById("openChatinlistALLMemBtn"+loginMemId)不存在的話回傳false
					if(!!document.getElementById("openChatinlistALLMemBtn"+loginMemId)){
						document.getElementById("openChatinlistALLMemBtn"+loginMemId).disabled=false;
					}else{
						document.getElementById("openChatBtn"+loginMemId).disabled=false;
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
				    if(privMsgSend_MemId!=${loginMemId}){
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
				  
				    console.log("privMsgSend_MemId!=${loginMemId}="+(privMsgSend_MemId!=${loginMemId}));
				  						    console.log(privMsgSend_MemId);
				  						    console.log(${loginMemId});
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
					
				    var userName = ${loginMemId};
				    				    
				    var inputMessage = document.getElementById("sendMessageArea"+sendToAccount);
				    var message = inputMessage.value.trim();
				    							    
				    if (message === ""){			        
				        inputMessage.focus();
				        return;
				    }else{
				        var jsonObj = {"userName" : userName, "message" : message};
// 				        console.log('vars['webSocket '+sendToAccount]' + sendToAccount);
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
		
// 		var statusOutput = document.getElementById("statusOutput");
		
// 		function updateStatus(newStatus) {
// 			statusOutput.innerHTML = newStatus;
// 		}
		
		vars['webSocket '+sendToAccount].onopen = function(event) {
// 			updateStatus("WebSocket 成功連線");
// 			document.getElementById('sendMessage').disabled = false;
// 			document.getElementById('connect').disabled = true;
// 			document.getElementById('disconnect').disabled = false;
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

			if(jsonObj.privMsgSend_MemId==${loginMemId}){
				messagesArea=document.getElementById("messagesArea"+jsonObj.privMsgRec_MemId);
			}else{
				messagesArea=document.getElementById("messagesArea"+jsonObj.privMsgSend_MemId);
			}
	        
			
			if(privMsgSend_MemId!=${loginMemId}){
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
	        
// 			var node = document.createElement("LI");
// 			var msginnerhtml=messagesArea.innerHTML;
// 			showedData;
			messagesArea.innerHTML=messagesArea.innerHTML+showedData;
			
	        messagesArea.scrollTop = messagesArea.scrollHeight;
		};


		
		vars['webSocket '+sendToAccount].onclose = function(event) {
// 			updateStatus("WebSocket 已離線");
		};
		
}
	
	$(function(){
	
		$.ajax({
			url : "<%=request.getContextPath()%>/mem_dream/mem.do",
			data : "action=getUnreadMsgCount" +"&mem_Id=" + ${loginMemId} +"&requestURL=<%=request.getServletPath()%>",
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







</html>
