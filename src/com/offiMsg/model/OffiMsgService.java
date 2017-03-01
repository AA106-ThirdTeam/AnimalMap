package com.offiMsg.model;

import java.util.List;

public class OffiMsgService {

	private OffiMsgDAO_interface dao;

	public OffiMsgService() {
		dao = new OffiMsgDAO();
	}
	
	public OffiMsgVO addOffiMsg(String offiMsg_empId, String offiMsg_Title,
			String offiMsg_Content, java.sql.Date offiMsg_Date) {

		OffiMsgVO offiMsgVO = new OffiMsgVO();

		offiMsgVO.setOffiMsg_empId(offiMsg_empId);
		offiMsgVO.setOffiMsg_Title(offiMsg_Title);
		offiMsgVO.setOffiMsg_Content(offiMsg_Content);
		offiMsgVO.setOffiMsg_Date(offiMsg_Date);
		dao.insert(offiMsgVO);

		return offiMsgVO;
	}

	public OffiMsgVO updateOffiMsg(String offiMsg_Id, String offiMsg_empId, String offiMsg_Title,
			String offiMsg_Content, java.sql.Date offiMsg_Date) {

		OffiMsgVO offiMsgVO = new OffiMsgVO();

		offiMsgVO.setOffiMsg_Id(offiMsg_Id);
		offiMsgVO.setOffiMsg_empId(offiMsg_empId);
		offiMsgVO.setOffiMsg_Title(offiMsg_Title);
		offiMsgVO.setOffiMsg_Content(offiMsg_Content);
		offiMsgVO.setOffiMsg_Date(offiMsg_Date);
		dao.update(offiMsgVO);

		return offiMsgVO;
	}

	public void deleteOffiMsg(String offiMsg_Id) {
		dao.delete(offiMsg_Id);
	}

	public OffiMsgVO getOneOffiMsg(String offiMsg_Id) {
		return dao.findByPrimaryKey(offiMsg_Id);
	}

	public List<OffiMsgVO> getAll() {
		return dao.getAll();
	}
	
}
