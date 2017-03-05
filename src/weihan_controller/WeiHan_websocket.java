package weihan_controller;


import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/echoSocket")
public class WeiHan_websocket {

	public WeiHan_websocket() {
		System.out.println("EchoSocket.EchoSocket()");
	}
	
	@OnOpen
	public  void open(Session  session ){
		System.out.println("使用者ID:"+session.getId());
	}
	
	@OnMessage
	public  void receive(Session session, String msg){
		System.out.println(msg);
		
		try {
			session.getBasicRemote().sendText("接收");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@OnClose
	public void  close(Session  session){
		System.out.println(session.getId()+"session ");
	}
	
}

