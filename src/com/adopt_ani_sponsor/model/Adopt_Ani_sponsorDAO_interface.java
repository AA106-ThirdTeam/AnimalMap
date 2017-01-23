package com.adopt_ani_sponsor.model;

import java.util.*; 

public interface Adopt_Ani_sponsorDAO_interface {
	public void insert(Adopt_Ani_sponsorVO adopt_ani_sponsorVO);
	public void update(Adopt_Ani_sponsorVO adopt_ani_sponsorVO);
	public void delete(String ado_Ani_Spo_No);
	public Adopt_Ani_sponsorVO findByPrimaryKey(String ado_Ani_Spo_No);
	public List<Adopt_Ani_sponsorVO> getAll();
}