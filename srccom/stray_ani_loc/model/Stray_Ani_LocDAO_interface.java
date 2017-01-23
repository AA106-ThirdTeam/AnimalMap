package com.stray_ani_loc.model;

import java.util.* 

public interface Stray_Ani_LocDAO_interface {
	public void insert(Stray_Ani_LocVO stray_ani_locVO);
	public void update(Stray_Ani_LocVO stray_ani_locVO);
	public void delete(Integer empno);
	public Stray_Ani_LocVO findByPrimaryKey(Integer empno);
	public List<Stray_Ani_LocVO> getAll();
}