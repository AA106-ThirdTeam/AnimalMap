package com.emg_H_Msg.model;

import java.util.List;

import com.emg_H.model.Emg_HVO;


public class Emg_H_MsgService {
	
	private Emg_H_Msg_interface dao;
	
	public Emg_H_MsgService(){
		dao=new Emg_H_MsgDAO();
	}
	
	public List<Emg_H_MsgVO> getAll(){
		return dao.getAll();
	}
	
	
	public void delete(String emg_H_Msg_Id) {
		dao.delete(emg_H_Msg_Id);
	}
	
	public  Emg_H_MsgVO updateEmg_H_Msg(String mem_Id, String emg_H_Id,String emg_H_Msg_Id,java.sql.Timestamp emg_H_Msg_start, String emg_H_Msg_content){

		Emg_H_MsgVO emg_H_MsgVO =new Emg_H_MsgVO();
		emg_H_MsgVO.setEmg_H_Msg_start(emg_H_Msg_start);
		emg_H_MsgVO.setMem_Id(mem_Id);
		emg_H_MsgVO.setEmg_H_Id(emg_H_Id);
		emg_H_MsgVO.setEmg_H_Msg_Id(emg_H_Msg_Id);
		emg_H_MsgVO.setEmg_H_Msg_content(emg_H_Msg_content);
		dao.update(emg_H_MsgVO);
		
		return emg_H_MsgVO;	

	}
	
	public Emg_H_MsgVO addEmg_H_Msg(String mem_Id,String emg_H_Id,java.sql.Timestamp emg_H_Msg_start,String emg_H_Msg_content){
		
		Emg_H_MsgVO emg_H_MsgVO =new Emg_H_MsgVO();
		
		emg_H_MsgVO.setMem_Id(mem_Id);
		emg_H_MsgVO.setEmg_H_Id(emg_H_Id);
		emg_H_MsgVO.setEmg_H_Msg_start(emg_H_Msg_start);
		emg_H_MsgVO.setEmg_H_Msg_content(emg_H_Msg_content);
		dao.insert(emg_H_MsgVO);
				
		return emg_H_MsgVO;
	}
	
	
	public Emg_H_MsgVO getOneEmg_H_Msg(String emg_H_Msg_Id) {
		return dao.findByPrimaryKey(emg_H_Msg_Id);
	}

	

}
