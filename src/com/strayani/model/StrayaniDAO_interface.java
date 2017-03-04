package com.strayani.model;

import java.util.List;



public interface StrayaniDAO_interface {
	public void insert(StrayaniVO strayaniVO);
    public void update(StrayaniVO strayaniVO);
    public void delete(String stray_Ani_Id);
    public StrayaniVO findByPrimaryKey(String stray_Ani_Id);
    public List<StrayaniVO> getAll();
    public void changeLike(String stray_Ani_Id,String likeOrNot);
    //查詢某部門的員工(一對多)(回傳 Set)
    //public List<EmpVO> getAll(Map<String, String[]> map); 

}
