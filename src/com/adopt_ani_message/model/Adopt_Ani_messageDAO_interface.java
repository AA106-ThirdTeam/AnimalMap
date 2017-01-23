package com.adopt_ani_message.model;

import java.util.*; 

public interface Adopt_Ani_messageDAO_interface {
	public void insert(Adopt_Ani_messageVO adopt_ani_messageVO);
	public void update(Adopt_Ani_messageVO adopt_ani_messageVO);
	public void delete1(Integer ado_Ani_Mes_No);
	public Adopt_Ani_messageVO findByPrimaryKey1(Integer ado_Ani_Mes_No);
	public List<Adopt_Ani_messageVO> getAll();
}