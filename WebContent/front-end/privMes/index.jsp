<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mem_dream.model.*"%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--     <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--     <meta name="description" content=""> -->
<!--     <meta name="author" content=""> -->
<!--     <title>SB Admin 2 - Bootstrap Admin Theme</title> -->
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css" media="screen">
    body {
        background-color: #f8f8f8;
        
    }
    
    #wrapper {
    	width:300px;
        height:394px;    
        
        }
    
    #page-wrapper {
        padding: 0 15px;
        min-height: 568px;
        background-color: white;
    }
    
    .chat {
        margin: 0;
        padding: 0;
        list-style: none;
    }
    
    .chat li {
        margin-bottom: 10px;
        padding-bottom: 5px;
        border-bottom: 1px dotted #999999;
    }
    
    .chat li.left .chat-body {
        margin-left: 60px;
    }
    
    .chat li.right .chat-body {
        margin-right: 60px;
    }
    
    .chat li .chat-body p {
        margin: 0;
    }
    
    .chat-panel .panel-body {
        height: 350px;
        overflow-y: scroll;
    }
    </style>
</head>

<body>


    <div id="wrapper" class="pull-right" style="float:right; transform: translate(-20px,-440px);">
        
        <div class="chat-panel panel panel-default">
            
            <div class="panel-heading ">
                <i class="fa fa-comments fa-fw"></i> Chat
                    <button type="button" class="btn btn-default btn-xs btn-danger pull-right" 
                    	id="closeBtn${privMsgRec_MemId}" style="margin-top: 2px;"><i class="glyphicon glyphicon-remove-sign"></i>
                        <i class="fa fa-chevron-down"></i>
                    </button>
                    
            </div>
            
            <!-- /.panel-heading -->
            
            <div class="panel-body">
                <ul class="chat" id="messagesArea${privMsgRec_MemId}">
                    
                </ul>
            </div>
           
            <!-- /.panel-body -->
            <div class="panel-footer">
                <div class="input-group">
                    <input id="sendMessageArea${privMsgRec_MemId}" type="text" class="form-control input-sm" 
                    maxlength="200" placeholder="Type your message here..." />
                    <span class="input-group-btn">
                        <button class="btn btn-warning btn-sm" id="sendMessage${privMsgRec_MemId}">
                           Send
                        </button>
                   </span>
                </div>
            </div>
            <!-- /.panel-footer -->
        </div>
        <!-- /.panel .chat-panel -->
    </div>
  
</body>

</html>


