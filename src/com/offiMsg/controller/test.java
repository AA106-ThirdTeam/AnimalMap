package com.offiMsg.controller;

import java.io.*;
import java.util.*;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.offiMsg.model.*;

@ServerEndpoint("/test/{myName}/{myId}")
public class test {
	
private static final Set<Session> allSessions = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void onOpen(@PathParam("myName") String myName, @PathParam("myId") int myId, Session userSession) throws IOException {
		allSessions.add(userSession);
		System.out.println(userSession.getId() + ": 已連線");
		System.out.println(myName + ": 已連線");
		System.out.println(myId + ": 編號");
//		userSession.getBasicRemote().sendText("WebSocket 連線成功");
	}

	
	@OnMessage
	public void onMessage(Session userSession, String message) {
		
		String[] messagesplit = message.split("_");
		String id = messagesplit[0];
		String title = messagesplit[1];
		String msg = messagesplit[2];
		
		OffiMsgService offiMsgSvc = new OffiMsgService();
		offiMsgSvc.addOffiMsg(id, title, msg, null);
		
		for (Session session : allSessions) {
			if (session.isOpen())
				session.getAsyncRemote().sendText(message);
		}
		System.out.println("Message received: " + message);
	}
	
	@OnError
	public void onError(Session userSession, Throwable e){
//		e.printStackTrace();
	}
	
	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		allSessions.remove(userSession);
		System.out.println(userSession.getId() + ": Disconnected: " + Integer.toString(reason.getCloseCode().getCode()));
	}

}