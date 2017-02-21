package com.priv_message.model;

import java.util.List;
import java.util.Set;

import com.priv_message.model.Priv_messageVO;


public interface Priv_message_interface {
	public List<Priv_messageVO> getAll();
	public Priv_messageVO findByPrimaryKey(String privMsgSend_MemId, String privMsgRec_MemId);

	public void insert(Priv_messageVO priv_messageVO);
	public void update(Priv_messageVO priv_messageVO);
	public Set<Priv_messageVO> getPriv_MessageBySend_MemId(String privMsgSend_MemId);
	public Set<Priv_messageVO> getPriv_MessageByRec_MemId(String privMsgRec_MemId);
	public Set<Priv_messageVO> getAllPriv_MessageByMem_Id(String privMsgSend_MemId);

}
