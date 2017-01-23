package com.stray_ani_message.model;

import java.util.*; 

public interface Stray_Ani_messageDAO_interface {
	public void insert(Stray_Ani_messageVO stray_ani_messageVO);
	public void update(Stray_Ani_messageVO stray_ani_messageVO);
	public void delete1(Integer str_Ani_Mes_No);
	public Stray_Ani_messageVO findByPrimaryKey1(Integer str_Ani_Mes_No);
	public List<Stray_Ani_messageVO> getAll();
}