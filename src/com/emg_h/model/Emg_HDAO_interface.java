package com.emg_h.model;

import java.util.*; 

public interface Emg_HDAO_interface {
	public void insert(Emg_HVO emg_hVO);
	public void update(Emg_HVO emg_hVO);
    public void delete(String emg_H_Id);
	public Emg_HVO findByPrimaryKey(String emg_H_Id);
	public List<Emg_HVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Emg_HVO> getAll(Map<String, String[]> map);

    //查詢某緊急求救的發起人編號(一對多)(回傳 Set)
    public Set<Emg_HVO> getEmg_HsByMem_Id(String mem_Id);
}
