package com.pet_message.model;

import java.util.*; 

public interface Pet_MessageDAO_interface {
	public void insert(Pet_MessageVO pet_messageVO);
	public void update(Pet_MessageVO pet_messageVO);
    public void delete(String pet_Mes_No);
	public Pet_MessageVO findByPrimaryKey(String pet_Mes_No);
	public List<Pet_MessageVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Pet_MessageVO> getAll(Map<String, String[]> map);

    //查詢某自家寵物留言的寵物編號(一對多)(回傳 Set)
    public Set<Pet_MessageVO> getPet_MessagesByPet_Id(String pet_Id);

    //查詢某自家寵物留言的發布者會員編號(一對多)(回傳 Set)
    public Set<Pet_MessageVO> getPet_MessagesByMem_Id(String mem_Id);
}
