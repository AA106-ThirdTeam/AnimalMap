package com.stray_ani.model;

import java.util.*; 

public interface Stray_AniDAO_interface {
	public void insert(Stray_AniVO stray_aniVO);
	public void update(Stray_AniVO stray_aniVO);
    public void delete(String stray_Ani_Id);
	public Stray_AniVO findByPrimaryKey(String stray_Ani_Id);
	public List<Stray_AniVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Stray_AniVO> getAll(Map<String, String[]> map);

    //查詢某社區流浪動物的發布者會員編號(一對多)(回傳 Set)
    public Set<Stray_AniVO> getStray_AnisByMem_Id(String mem_Id);
}
