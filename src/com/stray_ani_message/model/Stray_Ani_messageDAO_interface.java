package com.stray_ani_message.model;

import java.util.*; 

public interface Stray_Ani_messageDAO_interface {
	public void insert(Stray_Ani_messageVO stray_ani_messageVO);
	public void update(Stray_Ani_messageVO stray_ani_messageVO);
    public void delete(String str_Ani_Mes_No);
	public Stray_Ani_messageVO findByPrimaryKey(String str_Ani_Mes_No);
	public List<Stray_Ani_messageVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Stray_Ani_messageVO> getAll(Map<String, String[]> map);

    //查詢某社區流浪動物留言的社區動物編號(一對多)(回傳 Set)
    public Set<Stray_Ani_messageVO> getStray_Ani_messagesByStray_Ani_Id(String stray_Ani_Id);

    //查詢某社區流浪動物留言的發布者會員編號(一對多)(回傳 Set)
    public Set<Stray_Ani_messageVO> getStray_Ani_messagesByMem_Id(String mem_Id);
}
