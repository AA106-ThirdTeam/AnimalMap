package com.stray_ani_loc.model;

import java.util.*; 

public interface Stray_Ani_LocDAO_interface {
	public void insert(Stray_Ani_LocVO stray_ani_locVO);
	public void update(Stray_Ani_LocVO stray_ani_locVO);
    public void delete(String str_Ani_Loc_No);
	public Stray_Ani_LocVO findByPrimaryKey(String str_Ani_Loc_No);
	public List<Stray_Ani_LocVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Stray_Ani_LocVO> getAll(Map<String, String[]> map);

    //查詢某社區流浪動物出沒範圍的社區動物編號(一對多)(回傳 Set)
    public Set<Stray_Ani_LocVO> getStray_Ani_LocsByStray_Ani_Id(String stray_Ani_Id);

    //查詢某社區流浪動物出沒範圍的發布者會員編號(一對多)(回傳 Set)
    public Set<Stray_Ani_LocVO> getStray_Ani_LocsByMem_Id(String mem_Id);
}
