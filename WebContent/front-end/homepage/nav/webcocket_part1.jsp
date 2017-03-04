<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>		
var MyPoint1 = "/MyEchoServer/"+"notApplicable"+"/"+${memId}+"/notification";
//console.log(MyPoint1);
var host = window.location.host;
var path = window.location.pathname;
var webCtx = path.substring(0, path.indexOf('/', 1));
var endPointURL1 = "ws://" + window.location.host + webCtx + MyPoint1;

var note = $(".numberSysInfo");
var webSocket1;

function connect1() {
//	console.log(endPointURL1);
//	console.log(host);
//	console.log(path);
//	console.log(webCtx);

	// 建立 websocket 物件
	webSocket1 = new WebSocket(endPointURL1);
	
	webSocket1.onopen = function(event) {
//		updateStatus1("WebSocket 成功連線");
		
	};

	webSocket1.onmessage = function(event) {
		         
//      var jsonObj = JSON.parse(event.data);
//      var message = jsonObj.userName + ": " + jsonObj.message + "\r\n";
     console.log("event.data=  "+event.data);
//      updateStatus1(message);
     
     $.ajax({
			url : "<%=request.getContextPath()%>/mem_dream/mem.do",
			data : "action=getUnreadMsgCount" +"&mem_Id="+ ${memId} +"&requestURL=<%=request.getServletPath()%>",
			type : "POST",
			dataType : 'text',
			success : function(msg) {								
				$(".numberSysInfo").text(msg);
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

$(function(){

	$.ajax({
		url : "<%=request.getContextPath()%>/mem_dream/mem.do",
		data : "action=getUnreadMsgCount" +"&mem_Id=" + ${memId} +"&requestURL=<%=request.getServletPath()%>",
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
		
})
							
</script>
