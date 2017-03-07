package com.priv_message.controller;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

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

import com.mem_dream.model.MemService;
import com.mem_dream.model.MemVO;
import com.priv_message.model.Priv_messageService;
import com.priv_message.model.Priv_messageVO;


@ServerEndpoint("/MyEchoServer/{privMsgSend_MemId}/{privMsgRec_MemId}/{type}")
public class MyEchoServer {
	
private static final Map<String,Session> chatSessions = new Hashtable<String,Session>();
public static final Map<String,Session> notificationSessions = new Hashtable<String,Session>();
	
	@OnOpen
	public void onOpen(@PathParam("privMsgSend_MemId") String privMsgSend_MemId, @PathParam("privMsgRec_MemId") String privMsgRec_MemId, 
			@PathParam("type") String type , Session userSession) throws IOException {
		
		if("notification".equals(type)){
			notificationSessions.put(privMsgRec_MemId, userSession);
		}else{
			chatSessions.put(privMsgSend_MemId, userSession);
		}

		if("grpInvite".equals(type)){
			if((notificationSessions.get(privMsgRec_MemId)!=null)&&(notificationSessions.get(privMsgRec_MemId).isOpen())){
				notificationSessions.get(privMsgRec_MemId).getAsyncRemote().sendText("doCount");
				//userSession.getAsyncRemote().sendText("closeWebSocket");
			}	
		}
		
		if("adoptMsg".equals(type)){
			if((notificationSessions.get(privMsgRec_MemId)!=null)&&(notificationSessions.get(privMsgRec_MemId).isOpen())){
				notificationSessions.get(privMsgRec_MemId).getAsyncRemote().sendText("doCount");
				//userSession.getAsyncRemote().sendText("closeWebSocket");
			}	
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

		
//=====================================[ 檢舉過來的   Session] ============================================================================		
		if(type.equals("report")){
			Set<Session> partSessions = Collections.synchronizedSet(new HashSet<Session>());
			
			for(String key:notificationSessions.keySet()){
					partSessions.add(notificationSessions.get(key));				
			}
			
			
			for (Session session : partSessions) {
				if (session.isOpen()){
					//System.out.println(message+" 111111111111111111111");
					session.getAsyncRemote().sendText(String.valueOf(message));
				}
			System.out.println("Message received: " + message);
			
			}
			
		} 
//===================================================================================================================
		
		if(!type.equals("report")){
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
	    String memPhoto = memVO.getMem_profile();
	 
	    JsonObject value = Json.createObjectBuilder().add("userName",userName).add("message",jsonObj.getString("message").trim())
	    		.add("memPhoto",memPhoto).add("privMsgSend_MemId", privMsgSend_MemId).add("privMsgRec_MemId", privMsgRec_MemId).build();
	    
	    System.out.println(value.toString());
	    
		if((notificationSessions.get(privMsgRec_MemId)!=null)&&(notificationSessions.get(privMsgRec_MemId).isOpen())){
			notificationSessions.get(privMsgRec_MemId).getAsyncRemote().sendText(value.toString());
		}		
		
		
		System.out.println("privMsgRec_MemId in ECHO==============================="+privMsgRec_MemId);
		
		if(((chatSessions.get(privMsgRec_MemId)!=null))&&(chatSessions.get(privMsgRec_MemId).isOpen())){
			chatSessions.get(privMsgRec_MemId).getAsyncRemote().sendText(value.toString());
			chatSessions.get(privMsgSend_MemId).getAsyncRemote().sendText(value.toString());
			}else{
				chatSessions.get(privMsgSend_MemId).getAsyncRemote().sendText(value.toString());
			}
		
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
