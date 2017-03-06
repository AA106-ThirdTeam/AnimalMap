package com.priv_message.model;

import java.util.Set;


public class Priv_messageService {
	
	private Priv_message_interface dao = new Priv_messageDAO();
	
		
	public void insert(Priv_messageVO priv_messageVO){
		dao.insert(priv_messageVO);
	}
	
	public void update(Priv_messageVO priv_messageVO){
		dao.update(priv_messageVO);
	}
	
	public Set<Priv_messageVO> getPriv_MessageBySend_MemId(String privMsgSend_MemId){
		return dao.getPriv_MessageBySend_MemId(privMsgSend_MemId);
		}
		
	public Set<Priv_messageVO> getPriv_MessageByRec_MemId(String privMsgRec_MemId){
		return dao.getPriv_MessageByRec_MemId(privMsgRec_MemId);
		}

	public Set<Priv_messageVO> getPriv_MessageByRec_MemId(String privMsgSend_MemId, String privMsgRec_MemId){
		return dao.getPriv_MessageByRec_MemId(privMsgSend_MemId, privMsgRec_MemId);
	}

	public Set<Priv_messageVO> getAllPriv_MessageByMem_Id(String privMsgSend_MemId,String privMsgRec_MemId) {
				return dao.getAllPriv_MessageByMem_Id(privMsgSend_MemId,privMsgRec_MemId);
	}
	
	public void batchUpdate(Set<Priv_messageVO> priv_messageSet){
		dao.batchUpdate(priv_messageSet);
	};
	
}
