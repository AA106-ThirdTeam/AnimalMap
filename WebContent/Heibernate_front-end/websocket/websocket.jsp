<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emp.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.post_Response.model.*"%>
<%@ page import="com.offiMsg.model.*" %>
<%@ page import="com.offiMsg.controller.*" %>

<%
%>

<!-- ==================================下面是HEAD部分=============================== -->

<!DOCTYPE html>
<html>
<head>
<!-- 載入共用CSS、JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>


<script>

var MyPoint = "/test/peter/206";
var host = window.location.host;
var path = window.location.pathname;
var webCtx = path.substring(0, path.indexOf('/', 1));
var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;

var statusOutput = document.getElementById("statusOutput");
var webSocket;

function connect() {
	// 建立 websocket 物件
	webSocket = new WebSocket(endPointURL);
	
	webSocket.onopen = function(event) {
		updateStatus("WebSocket 成功連線");
		document.getElementById('sendMessage').disabled = false;
		document.getElementById('connect').disabled = true;
		document.getElementById('disconnect').disabled = false;
		
	};

	webSocket.onmessage = function(event) {
		var messagesArea = document.getElementById("messagesArea");
        var message = event.data;
        var mesagesplit = message.split("_");
        
        var title = mesagesplit[1];
        var msg = mesagesplit[2];
        var finalmassage = "標題:"+title+"  內容:"+msg+"\r\n";
        messagesArea.value = messagesArea.value + finalmassage;
        messagesArea.scrollTop = messagesArea.scrollHeight;
        
	};

	
	webSocket.onclose = function(event) {
		updateStatus("WebSocket 已離線");
	};
}



function sendMessage() {
	
    var inputId =document.getElementById("userId");
    var inputTitle =document.getElementById("title");
    var inputMessage = document.getElementById("message");
    var Id =inputId.value.trim();
    var title = inputTitle.value.trim();
    var message = inputMessage.value.trim();
    
    var finalmassage = Id+"_"+title+"_"+message;
    
    if (message === ""){
        alert ("訊息請勿空白!");
        inputMessage.focus();	
    }else{
        webSocket.send(finalmassage);
        inputMessage.value = "";
        inputMessage.focus();
    }
}


function disconnect () {
	webSocket.close();
	document.getElementById('sendMessage').disabled = true;
	document.getElementById('connect').disabled = false;
	document.getElementById('disconnect').disabled = true;
}


function updateStatus(newStatus) {
	//statusOutput.innerHTML = newStatus;
}
</script>

</body>
</html>