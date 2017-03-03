<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mem_dream.model.*"%>

<style>
body {
/* 	background: #e9e9e9; */
/* 	color: #9a9a9a; */
/* 	font: 100%/1.5em "Droid Sans", sans-serif; */
/* 	margin: 0; */
}

#live-chat a { text-decoration: none; }

#live-chat fieldset {
	border: 0;
	margin: 0;
	padding: 0;
}

#live-chat h4, #live-chat h5 {
	line-height: 1.5em;
	margin: 0;
}

#live-chat hr {
	background: #e9e9e9;
    border: 0;
    -moz-box-sizing: content-box;
    box-sizing: content-box;
    height: 1px;
    margin: 0;
    min-height: 1px;
}

#live-chat img {
    border: 0;
    display: block;
    height: auto;
    max-width: 100%;
}

#live-chat input {
	border: 0;
	color: inherit;
    font-family: inherit;
    font-size: 100%;
    line-height: normal;
    margin: 0;
}

#live-chat p { margin: 0; }

.clearfix { *zoom: 1; } /* For IE 6/7 */
.clearfix:before, .clearfix:after {
    content: "";
    display: table;
}.
.clearfix:after { clear: both; }

/* ---------- LIVE-CHAT ---------- */

#live-chat {
	font: 100%/1.5em "Droid Sans", sans-serif;
    bottom: 0px;
    font-size: 12px;
    right: 24px;
    position: absolute;
    width: 300px;
}

#live-chat header {
	background: rgba(0, 0, 0, 0.7);;
	border-radius: 5px 5px 0 0;
	color: #fff;
	cursor: pointer;
	padding: 16px 24px;
}

#live-chat h4:before {
	background: #1a8a34;
	border-radius: 50%;
	content: "";
	display: inline-block;
	height: 8px;
	margin: 0 8px 0 0;
	width: 8px;
}

#live-chat h4 {
	font-size: 12px;
}

#live-chat h5 {
	font-size: 10px;
}

#live-chat form {
	padding: 24px;
}

#live-chat input[type="text"] {
	border: 1px solid #ccc;
	border-radius: 3px;
 	padding: 8px; 
	outline: none;
    width: 100%;
}
</style>

<style>
.chat-message-counter {
	background: #e62727;
	border: 1px solid #fff;
	border-radius: 50%;
	display: none;
	font-size: 12px;
	font-weight: bold;
	height: 28px;
	left: 0;
	line-height: 28px;
	margin: -15px 0 0 -15px;
	position: absolute;
	text-align: center;
	top: 0;
	width: 28px;
}

.chat-close {
	background: #1b2126;
	border-radius: 50%;
	color: #fff;
	display: block;
	float: right;
	font-size: 10px;
	height: 16px;
	line-height: 16px;
	margin: 2px 0 0 0;
	text-align: center;
	width: 16px;
}

.chat {
	background: #fff;
}

.chat-history {
	height: 252px;
	padding: 8px 24px;
	overflow-y: scroll;
}

.chat-message {
	margin: 16px 0;
}

.chat-message img {
	border-radius: 50%;
	float: left;
}

.chat-message-content {
	margin-left: 56px;
}

.chat-time {
	float: right;
	font-size: 10px;
}

.chat-feedback {
	font-style: italic;	
	margin: 0 0 0 80px;
}
</style>
		<script type="text/javascript">
			function chat_message_hide(id_val) {
				//alert(id_val);
				$('#chat-message-counter_'+id_val).fadeToggle(300, 'swing');
				$('#chat_'+id_val).slideToggle(300, 'swing');
			}
			function chat_message_close(id_val) {
// 				e.preventDefault();
				$('.live-chat_'+id_val).fadeOut(300);
			}			
		</script>
<%for(int i = 0 ; i < 3 ;i ++){ %>
	<div id="live-chat" class='live-chat_<%= i%>'  style="margin-right: <%=320*i%>px">
		<header class="clearfix" onclick="chat_message_hide('<%= i%>');">
			
			<a href="#" class="chat-close" onclick="chat_message_close('<%= i%>')">x</a>

			<h4></h4>

			<span class="chat-message-counter" id="chat-message-counter_<%= i%>">3</span>

		</header>

		<div class="chat" id="chat_<%= i%>">
			
			<div class="chat-history">
				
				<div class="chat-message clearfix">
					
					<ul class="chat" id="messagesArea${privMsgRec_MemId}">
                    
                	</ul>
				</div> <!-- end chat-message -->

				<hr>

			</div> <!-- end chat-history -->

			<form action="#" method="post">
				<fieldset>
					<input type="text" placeholder="Type your message…" autofocus>
					<input type="hidden">
				</fieldset>
			</form>

		</div> <!-- end chat -->

	</div> <!-- end live-chat -->
	
<%} %>	
	
