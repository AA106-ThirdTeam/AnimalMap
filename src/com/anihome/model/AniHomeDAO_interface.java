package com.anihome.model;

import java.util.*; 

public interface AniHomeDAO_interface {
	public void insert(AniHomeVO anihomeVO);
	public void update(AniHomeVO anihomeVO);
    public void delete(String aniHome_Id);
	public AniHomeVO findByPrimaryKey(String aniHome_Id);
	public List<AniHomeVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<AniHomeVO> getAll(Map<String, String[]> map);

    //查詢某動物之家的會員編號(一對多)(回傳 Set)
    public Set<AniHomeVO> getAniHomesByMem_Id(String mem_Id);
}
