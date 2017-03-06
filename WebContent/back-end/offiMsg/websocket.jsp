<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emp.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.post_Response.model.*"%>
<%@ page import="com.offiMsg.model.*" %>
<%@ page import="com.offiMsg.controller.*" %>

<%
	boolean isLogin = false;
	// 【從 session 判斷此user是否登入過】
	EmpVO empVO = (EmpVO)session.getAttribute("empVO");
	System.out.println("empVO : " + empVO);
	
	if (empVO != null) {
		isLogin = true;
	}
	request.setAttribute("isLogin", isLogin);
%>

<!-- ==================================下面是HEAD部分=============================== -->

<!DOCTYPE html>
<html>
<head>
  <!-- 載入共用CSS、JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="css/styles.css" type="text/css"/>
   
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
</head>
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
/* .w3-sidenav a,.w3-sidenav h4 {padding: 12px;} */
/* .w3-bar a { */
/*     padding-top: 12px; */
/*     padding-bottom: 12px; */
/* } */
 	.container{
     text-align:center;
    }
    #messagesArea{
    width: 700px;
    height: 300px;
    }
    
</style>
<body>


<!-- Overlay effect when opening sidenav on small screens -->

<!-- Main content: shift it to the right by 250 pixels when the sidenav is visible -->
<div class="w3-main" style="margin-left:250px">



  <div class="w3-row w3-padding-65" style="padding-top: 30px;">
  <div class="col-md-offset-5">
    <div class="w3-twothird w3-container">
      <h1 class="w3-text-teal">WebSocket</h1>
     
    <div class="w3-third w3-container">
     <div class="row">
    <body onload="connect();" onunload="disconnect();">
	    <h3 id="statusOutput" class="statusOutput"></h3>
	    <div><table>
	   
	    <textarea id="messagesArea" class=" message-area" readonly ></textarea></table></div>
        
        <div class="panel input-area" >
    
<!--        	員工編號:<input id="userId" class="text-field" type="text" placeholder="員工標號" style="padding-left: 20px;width: 700"/><br> -->
			<%if(isLogin){ %>
			員工編號:<%=empVO.getEmp_No() %>
			
			<input id="userId" class="text-field" type="hidden" style="padding-left: 20px;width: 700" value="<%=empVO.getEmp_No()%>" /><br>
       		訊息標題:<input id="title" class="text-field" type="text" placeholder="標題" style="padding-left: 20px;width: 700px;"/><br>
      		 訊息內容:<input id="message"  class="text-field" type="text" placeholder="系統通知訊息" onkeydown="if (event.keyCode == 13) sendMessage();" style="height: 50px;width: 700px;"/>
      		 <%} %>
          <br>
 
          <input type="submit" id="sendMessage" class="button" value="送出" onclick="sendMessage();"/>
		 <input type="button" id="connect"  class="button" value="連線" onclick="connect();"/>
		    <input type="button" id="disconnect"  class="button" value="離線" onclick="disconnect();"/>
	  
	    </div>
    </body>
      </div>
    </div>
  </div>
  </div>

 

 

 

  <!-- Pagination -->
  
</div>
<!-- END MAIN -->
</div>

<script>
// Get the Sidenav
var mySidenav = document.getElementById("mySidenav");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidenav, and add overlay effect
function w3_open() {
    if (mySidenav.style.display === 'block') {
        mySidenav.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        mySidenav.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

// Close the sidenav with the close button
function w3_close() {
    mySidenav.style.display = "none";
    overlayBg.style.display = "none";
}
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