package com.adopt_ani_message.model;

import java.util.*; 

public interface Adopt_Ani_messageDAO_interface {
	public void insert(Adopt_Ani_messageVO adopt_ani_messageVO);
	public void update(Adopt_Ani_messageVO adopt_ani_messageVO);
    public void delete(String ado_Ani_Mes_No);
	public Adopt_Ani_messageVO findByPrimaryKey(String ado_Ani_Mes_No);
	public List<Adopt_Ani_messageVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Adopt_Ani_messageVO> getAll(Map<String, String[]> map);

    //查詢某送養動物留言的社區動物編號(一對多)(回傳 Set)
    public Set<Adopt_Ani_messageVO> getAdopt_Ani_messagesByAdopt_Ani_Id(String adopt_Ani_Id);

    //查詢某送養動物留言的送養動物會員編號(一對多)(回傳 Set)
    public Set<Adopt_Ani_messageVO> getAdopt_Ani_messagesByMem_Id(String mem_Id);
}
