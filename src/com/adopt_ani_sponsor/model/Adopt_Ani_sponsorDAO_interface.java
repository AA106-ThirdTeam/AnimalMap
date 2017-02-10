package com.adopt_ani_sponsor.model;

import java.util.*; 

public interface Adopt_Ani_sponsorDAO_interface {
	public void insert(Adopt_Ani_sponsorVO adopt_ani_sponsorVO);
	public void update(Adopt_Ani_sponsorVO adopt_ani_sponsorVO);
    public void delete(String ado_Ani_Spo_No);
	public Adopt_Ani_sponsorVO findByPrimaryKey(String ado_Ani_Spo_No);
	public List<Adopt_Ani_sponsorVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Adopt_Ani_sponsorVO> getAll(Map<String, String[]> map);

    //查詢某送養動物贊助的送養動物編號(一對多)(回傳 Set)
    public Set<Adopt_Ani_sponsorVO> getAdopt_Ani_sponsorsByAdopt_Ani_Id(String adopt_Ani_Id);

    //查詢某送養動物贊助的贊助者會員編號(一對多)(回傳 Set)
    public Set<Adopt_Ani_sponsorVO> getAdopt_Ani_sponsorsByMem_Id(String mem_Id);
}
