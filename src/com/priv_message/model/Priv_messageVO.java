package com.priv_message.model;

import java.sql.Timestamp;

public class Priv_messageVO {
	private String privMsg_Id;
	private String privMsgSend_MemId;
	private String privMsgRec_MemId;
	private String privMsg_content;
	private Timestamp privMsg_SendTime;
	private String privMsg_type;

	public String getPrivMsg_Id() {
		return privMsg_Id;
	}

	public String getPrivMsgSend_MemId() {
		return privMsgSend_MemId;
	}
	public String getPrivMsgRec_MemId() {
		return privMsgRec_MemId;
	}
	public String getPrivMsg_content() {
		return privMsg_content;
	}
	public Timestamp getPrivMsg_SendTime() {
		return privMsg_SendTime;
	}
	public String getPrivMsg_type() {
		return privMsg_type;
	}

	
	public void setPrivMsg_Id(String privMsg_Id) {
		this.privMsg_Id = privMsg_Id;
	}
	public void setPrivMsgSend_MemId(String privMsgSend_MemId) {
		this.privMsgSend_MemId = privMsgSend_MemId;
	}
	public void setPrivMsgRec_MemId(String privMsgRec_MemId) {
		this.privMsgRec_MemId = privMsgRec_MemId;
	}
	public void setPrivMsg_content(String privMsg_content) {
		this.privMsg_content = privMsg_content;
	}
	public void setPrivMsg_SendTime(Timestamp privMsg_SendTime) {
		this.privMsg_SendTime = privMsg_SendTime;
	}
	public void setPrivMsg_type(String privMsg_type) {
		this.privMsg_type = privMsg_type;
	}

}