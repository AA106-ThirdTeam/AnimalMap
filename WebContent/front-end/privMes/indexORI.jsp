<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mem_dream.model.*"%>


<html>
    <head>
        <title>Chat Room</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/front-end/privMes/styles.css" type="text/css"/>
    </head>
    
    <body name="chatroom">
        <h1> Chat Room </h1><div id="closeBtn${privMsgRec_MemId}" style="width:30px; height:30px; background-color:red;"></div>
	    <h3 id="statusOutput" class="statusOutput"></h3>
        <textarea id="messagesArea${privMsgRec_MemId}" class="panel message-area" readonly ></textarea>
        <div class="panel input-area">
            
            <input id="sendMessageArea${privMsgRec_MemId}"  class="text-field" type="text" placeholder="訊息"/>
            <input type="submit" id="sendMessage${privMsgRec_MemId}" class="button" value="送出" />
		    <input type="button" id="connect"     class="button" value="連線" />
		    <input type="button" id="disconnect"  class="button" value="離線"/>
	    </div>
    </body>    
</html>
