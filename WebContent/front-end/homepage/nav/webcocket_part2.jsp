<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function testeestset() {
		alert(this)
	}
</script>    
    
<script type="text/javascript">
var vars = {};


function openChat(sendToAccount){	
	var startChatMsg;
	var messagesArea;
	var MyPoint = "/MyEchoServer/"+${loginMemId}+"/"+ sendToAccount + "/chatRoom";
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
				data : "action=getStartChatMsg" +"&privMsgSend_MemId=" + ${loginMemId} + "&privMsgRec_MemId=" + sendToAccount +"&requestURL=<%=request.getServletPath()%>",
				type : "POST",
				dataType : 'text',

				success : function(msg) {
				    var inputMessage = document.getElementById("sendMessageArea"+sendToAccount);
				    startChatMsg = msg;
//					    console.log("startChatMsg on ACCEPT"+startChatMsg);
				
			
			$("#AM_map_chat").before("<div id='50'></div>");
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
				var memPhoto = jsonData.recievedJsonArray[i].memPhoto;
			    var userName = jsonData.recievedJsonArray[i].userName;
			    var message = jsonData.recievedJsonArray[i].message;
			    var sendTime = jsonData.recievedJsonArray[i].sendTime;
			    var privMsgSend_MemId = jsonData.recievedJsonArray[i].privMsgSend_MemId;
			    var showedData;
			    if(privMsgSend_MemId!=${loginMemId}){
				    showedData="<li class='left clearfix'>"+
		                   "<span class='chat-img pull-left'>"+
		                                    "<img src="+ memPhoto +" alt='User Avatar' class='img-circle' style='width:50px;height:50px' />"+
		                                "</span>"+
		                    "<div class='chat-body clearfix'>"+
		                        "<div class='header'>"+
		                            "<strong class='primary-font'>"+userName+"</strong>"+
		                            "<small class='pull-right text-muted'>"+
		                                            "<i class='fa fa-clock-o fa-fw'></i>"+ sendTime +
		                            "</small>"+
		                        "</div>"+
		                        "<p style='word-break: break-all;'>"+
		                        	message+
		                        "</p>"+
		                    "</div>"+
		                "</li>";
			    }else{
				    showedData="<li class='right clearfix'>"+
                        "<span class='chat-img pull-right'>"+
                                         "<img src="+ memPhoto +" alt='User Avatar' class='img-circle' style='width:50px;height:50px'/>"+
                                     "</span>"+
                         "<div class='chat-body clearfix'>"+
                             "<div class='header'>"+	                                 
                                 "<small class='text-muted'>"+
                                           "<i class='fa fa-clock-o fa-fw'></i>"+ sendTime +
                                  "</small>"+
                                  "<strong class='primary-font pull-right'>"+userName+"</strong>"+
                             "</div>"+
                             "<p style='text-align:right;width:100%;float:right;word-break: break-all;'>"+
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
				//document.getElementById('sendMessage').disabled = true;
				//document.getElementById('connect').disabled = false;
				//document.getElementById('disconnect').disabled = true;
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
//			//statusOutput.innerHTML = newStatus;
//		}
	
	vars['webSocket '+sendToAccount].onopen = function(event) {
//			updateStatus("WebSocket 成功連線");
//			//document.getElementById('sendMessage').disabled = false;
//			//document.getElementById('connect').disabled = true;
//			//document.getElementById('disconnect').disabled = false;
	};


	
	vars['webSocket '+sendToAccount].onmessage = function(event) {
		
		var jsonObj = JSON.parse(event.data);

		var d = new Date();
		var messagesArea;
		var userName = jsonObj.userName;
	    var message = jsonObj.message;
	    var memPhoto = jsonObj.memPhoto;
	    
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
                                    "<img src="+ memPhoto +" alt='User Avatar' class='img-circle' style='width:50px;height:50px'/>"+
                                "</span>"+
                    "<div class='chat-body clearfix'>"+
                        "<div class='header'>"+
                            "<strong class='primary-font'>"+userName+"</strong>"+
                            "<small class='pull-right text-muted'>"+
                                            "<i class='fa fa-clock-o fa-fw'></i>"+ displayTime +
                                        "</small>"+
                        "</div>"+
                        "<p style='word-break: break-all;'>"+
                        	message+
                        "</p>"+
                    "</div>"+
                "</li>";
	    }else{
	    	showedData="<li class='right clearfix'>"+
            "<span class='chat-img pull-right'>"+
                             "<img src="+ memPhoto +" alt='User Avatar' class='img-circle' style='width:50px;height:50px'/>"+
                         "</span>"+
             "<div class='chat-body clearfix'>"+
                 "<div class='header'>"+	                                 
                     "<small class='text-muted'>"+
                               "<i class='fa fa-clock-o fa-fw'></i>"+ displayTime +
                      "</small>"+
                      "<strong class='primary-font pull-right'>"+userName+"</strong>"+
                 "</div>"+
                 "<p style='text-align:right;width:100%;background-color:red;float:right;word-break: break-all'>"+
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
//openChat的時候做setUnreadToRead  在WEBSOCKETPART ONE裡有個方法叫DOCOUNT也是差不多意思少了設未讀成已讀

	$.ajax({
		url : "<%=request.getContextPath()%>/mem_dream/mem.do",
		data : "action=setUnreadToRead" + "&privMsgRec_MemId=" + ${loginMemId} +"&privMsgSend_MemId="+sendToAccount+"&requestURL=<%=request.getServletPath()%>",
		type : "POST",
		dataType : 'text',
		success : function(msg) {
			console.log(msg);
			$(".numberSysInfo").text(msg);			
		},
		
		error : function(xhr, ajaxOptions, thrownError) {
			alert(xhr.status);
			alert(thrownError);
		}
	})	
	
}


</script>