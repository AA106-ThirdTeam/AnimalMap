package com.strayani_location.model;

import java.util.List;



public interface StrayaniLocationDAO_interface {
	public void insert(StrayaniLocationVO strayaniLocationVO);
    public void update(StrayaniLocationVO strayaniLocationVO);
    public void delete(String str_Ani_Loc_No);
    public StrayaniLocationVO findByPrimaryKey(String str_Ani_Loc_No);
    public List<StrayaniLocationVO> getAll();
    public List<StrayaniLocationVO> getOneAllLocation(String stray_Ani_Id);
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
    //public List<EmpVO> getAll(Map<String, String[]> map); 

}
