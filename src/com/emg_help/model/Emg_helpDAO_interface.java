package com.emg_help.model;

import java.util.*; 

public interface Emg_helpDAO_interface {
	public void insert(Emg_helpVO emg_helpVO);
	public void update(Emg_helpVO emg_helpVO);
    public void delete(String emg_H_Id);
	public Emg_helpVO findByPrimaryKey(String emg_H_Id);
	public List<Emg_helpVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Emg_helpVO> getAll(Map<String, String[]> map);

    //查詢某緊急求救的發起人編號(一對多)(回傳 Set)
    public Set<Emg_helpVO> getEmg_helpsByMem_Id(String mem_Id);
}
