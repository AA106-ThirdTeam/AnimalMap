package com.strayani_message.model;

import java.util.List;



public interface StrayaniMessageDAO_interface {
	public void insert(StrayaniMessageVO adoptaniMessageVO);
    public void update(StrayaniMessageVO adoptaniMessageVO);
    public void delete(String ado_Ani_Mes_No);
    public StrayaniMessageVO findByPrimaryKey(String str_Ani_Mes_No);
    public List<StrayaniMessageVO> getAll();
    public List<StrayaniMessageVO> getOneAllMessage(String Stray_Ani_Id);
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
    //public List<EmpVO> getAll(Map<String, String[]> map); 

}
