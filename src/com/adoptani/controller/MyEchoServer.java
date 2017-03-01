package com.adoptani.controller;
import java.io.*;
import java.util.*;

import org.json.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnMessage;
import javax.websocket.OnError;
import javax.websocket.OnClose;
import javax.websocket.CloseReason;
import com.adoptani_sponsor.model.*;


@ServerEndpoint("/MyEchoServer_adoptani/{adoptani_id}/{myId}")
public class MyEchoServer {
	static Map<Session, String> MyEchoServerSessionMap = Collections.synchronizedMap(new HashMap<Session, String>());;
	private static final Set<Session> allSessions = Collections.synchronizedSet(new HashSet<Session>());
	
	
	@OnOpen
	public void onOpen(@PathParam("adoptani_id") String adoptani_id, @PathParam("myId") String myId, Session userSession) throws IOException {
		allSessions.add(userSession);
		
		//(※1)將每個session用hashMap綁定他是從哪個adoptani_id近來的。
		MyEchoServerSessionMap.put(userSession,adoptani_id);
		
		
		System.out.println("------AnimalMap Adopt Sponsor-------");
		System.out.println("into MyEchoServer_adoptani");
		System.out.println("userSession :"+userSession.getId());
		System.out.println("adoptani_id :"+adoptani_id);
		System.out.println("myRoom :"+myId);
		
//		onMessage(userSession,userSession.getId());
//		userSession.getBasicRemote().sendText("WebSocket �s�u���\");
		
	}

	
	@OnMessage
	public void onMessage(Session userSession, String message) {
		System.out.println("message:"+message);
//		JSONObject jsonObj = new JSONObject(message);
		try{
		    Thread.currentThread().sleep(1000);
		}catch(InterruptedException ie){
		    ie.printStackTrace();
		}
		Set<Session> partSessions = Collections.synchronizedSet(new HashSet<Session>());
		AdoptaniSponsorService adoptaniSponsorSvc = new AdoptaniSponsorService();
		Integer TotalSponsor = adoptaniSponsorSvc.getOneAllMoney(message);
		
		//(※2)keySet()方法回傳Map裡面所有的Key值，並一一比對其中的value與傳進來的message(adoptani_id)是否相同，若相同，變將Session加到partSessions中。
		for(Session key:MyEchoServerSessionMap.keySet()){
			System.out.println(!key.equals(userSession));//沒用，本來自己就會斷，因為進controller了。
			if(MyEchoServerSessionMap.get(key).equals(message) && !key.equals(userSession) ){
				
				partSessions.add(key);
			}
		}
		
		System.out.println("------------------");
		System.out.println("partSessions size:"+partSessions.size());
		System.out.println("------------------");
		for (Session session : partSessions) {
			if (session.isOpen()){
				System.out.println("session : " + session.getId());
				System.out.println("TotalSponsor : " + TotalSponsor);
				session.getAsyncRemote().sendText(String.valueOf(TotalSponsor));
			}
		System.out.println("Message received: " + message);
		
		}
		
		
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
