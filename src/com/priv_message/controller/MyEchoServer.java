package com.priv_message.controller;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.mem.model.MemService;
import com.mem.model.MemVO;
import com.priv_message.model.Priv_messageService;
import com.priv_message.model.Priv_messageVO;


@ServerEndpoint("/MyEchoServer/{privMsgSend_MemId}/{privMsgRec_MemId}/{type}")
public class MyEchoServer {
	
private static final Map<String,Session> chatSessions = new Hashtable<String,Session>();
private static final Map<String,Session> notificationSessions = new Hashtable<String,Session>();
	
	@OnOpen
	public void onOpen(@PathParam("privMsgSend_MemId") String privMsgSend_MemId, @PathParam("privMsgRec_MemId") String privMsgRec_MemId, 
			@PathParam("type") String type , Session userSession) throws IOException {
		
		if("notification".equals(type)){
			notificationSessions.put(privMsgRec_MemId, userSession);
		}else{
			chatSessions.put(privMsgSend_MemId, userSession);
		}
				
		System.out.println(userSession.getId() + ": 已連線");
		System.out.println(privMsgSend_MemId + ": 送出訊息會員");
		System.out.println(privMsgRec_MemId + ": 接收訊息會員");
		System.out.println(type + ": 類型");
//		userSession.getBasicRemote().sendText("WebSocket �s�u���\");
	}

	
	@OnMessage
	public void onMessage(@PathParam("privMsgSend_MemId") String privMsgSend_MemId, @PathParam("privMsgRec_MemId") String privMsgRec_MemId, 
			@PathParam("type") String type , Session userSession, String message) {

		
		JsonReader jsonReader = Json.createReader(new StringReader(message));
	    JsonObject jsonObj = jsonReader.readObject();
	    jsonReader.close();
	    
	    System.out.println(jsonObj.getString("message").trim());
		
	    Priv_messageVO privMsgVO = new Priv_messageVO();
	    privMsgVO.setPrivMsgSend_MemId(privMsgSend_MemId);
	    privMsgVO.setPrivMsgRec_MemId(privMsgRec_MemId);
	    privMsgVO.setPrivMsg_SendTime(new Timestamp(System.currentTimeMillis()));
	    privMsgVO.setPrivMsg_type("0");
	    privMsgVO.setPrivMsg_content(jsonObj.getString("message").trim());
	    
	    Priv_messageService privMsgSvc = new Priv_messageService();
	    privMsgSvc.insert(privMsgVO);
	    
	    MemService memSvc = new MemService();
	    MemVO memVO = memSvc.getOneMem(privMsgSend_MemId);
	    String userName = memVO.getMem_nick_name();
	    String newMessage = jsonObj.getString("message").trim();
	    
	    JsonObject value = Json.createObjectBuilder().add("userName",userName).add("message",jsonObj.getString("message").trim()).build();
	    
	    System.out.println(value.toString());
	    
		if(notificationSessions.get(privMsgRec_MemId)!=null){
			notificationSessions.get(privMsgRec_MemId).getAsyncRemote().sendText(value.toString());
		}		
		
		if((chatSessions.get(privMsgRec_MemId)!=null)){
			chatSessions.get(privMsgRec_MemId).getAsyncRemote().sendText(value.toString());
			chatSessions.get(privMsgSend_MemId).getAsyncRemote().sendText(value.toString());
			}else{
				chatSessions.get(privMsgSend_MemId).getAsyncRemote().sendText(value.toString());
			}
		
		
		
	}
	
	@OnError
	public void onError(Session userSession, Throwable e){
		e.printStackTrace();
	}
	
	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		chatSessions.remove(userSession);
		notificationSessions.remove(userSession);
		System.out.println(userSession.getId() + ": Disconnected: " + Integer.toString(reason.getCloseCode().getCode()));
	}

 
}
