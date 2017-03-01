package com.emg_H_Msg.model;

import java.util.List;



public interface Emg_H_Msg_interface {
	
	public void insert (Emg_H_MsgVO emg_H_MsgVO);
	public void update (Emg_H_MsgVO emg_H_MsgVO);
	public void delete (String Emg_H_Msg_Id);
	 public Emg_H_MsgVO findByPrimaryKey(String Emg_H_Msg_Id);
     public List<Emg_H_MsgVO> getAll();
	

}
