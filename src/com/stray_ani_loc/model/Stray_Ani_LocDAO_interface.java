package com.stray_ani_loc.model;

import java.util.*; 

public interface Stray_Ani_LocDAO_interface {
	public void insert(Stray_Ani_LocVO stray_ani_locVO);
	public void update(Stray_Ani_LocVO stray_ani_locVO);
	public void delete1(Integer str_Ani_Loc_No);
	public Stray_Ani_LocVO findByPrimaryKey1(Integer str_Ani_Loc_No);
	public List<Stray_Ani_LocVO> getAll();
}