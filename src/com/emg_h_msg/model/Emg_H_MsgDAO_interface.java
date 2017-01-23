package com.emg_h_msg.model;

import java.util.*; 

public interface Emg_H_MsgDAO_interface {
	public void insert(Emg_H_MsgVO emg_h_msgVO);
	public void update(Emg_H_MsgVO emg_h_msgVO);
	public void delete(String emg_H_Msg_Id);
	public Emg_H_MsgVO findByPrimaryKey(String emg_H_Msg_Id);
	public List<Emg_H_MsgVO> getAll();
}