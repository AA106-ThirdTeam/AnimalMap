package com.adopt_ani.model;

import java.util.*; 

public interface Adopt_AniDAO_interface {
	public void insert(Adopt_AniVO adopt_aniVO);
	public void update(Adopt_AniVO adopt_aniVO);
    public void delete(String adopt_Ani_Id);
	public Adopt_AniVO findByPrimaryKey(String adopt_Ani_Id);
	public List<Adopt_AniVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Adopt_AniVO> getAll(Map<String, String[]> map);

    //查詢某送養動物的發布者會員編號(一對多)(回傳 Set)
    public Set<Adopt_AniVO> getAdopt_AnisByMem_Id(String mem_Id);
}
