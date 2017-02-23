package com.adoptani.model;

import java.util.List;



public interface AdoptaniDAO_interface {
	public void insert(AdoptaniVO adoptaniVO);
    public void update(AdoptaniVO adoptaniVO);
    public void delete(String adopt_Ani_Id);
    public AdoptaniVO findByPrimaryKey(String adopt_Ani_Id);
    public List<AdoptaniVO> getAll();
    public void changeLike(String adopt_Ani_Id,String likeOrNot);
    
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
    //public List<EmpVO> getAll(Map<String, String[]> map); 

}
