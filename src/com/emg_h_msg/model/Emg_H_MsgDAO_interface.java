package com.emg_h_msg.model;

import java.util.*; 

public interface Emg_H_MsgDAO_interface {
	public void insert(Emg_H_MsgVO emg_h_msgVO);
	public void update(Emg_H_MsgVO emg_h_msgVO);
    public void delete(String emg_H_Msg_Id);
	public Emg_H_MsgVO findByPrimaryKey(String emg_H_Msg_Id);
	public List<Emg_H_MsgVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Emg_H_MsgVO> getAll(Map<String, String[]> map);

    //查詢某緊急求救留言的留言會員編號(一對多)(回傳 Set)
    public Set<Emg_H_MsgVO> getEmg_H_MsgsByMem_Id(String mem_Id);

    //查詢某緊急求救留言的求救編號(一對多)(回傳 Set)
    public Set<Emg_H_MsgVO> getEmg_H_MsgsByEmg_H_Id(String emg_H_Id);
}
