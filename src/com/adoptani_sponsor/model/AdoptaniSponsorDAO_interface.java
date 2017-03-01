package com.adoptani_sponsor.model;

import java.util.List;



public interface AdoptaniSponsorDAO_interface {
	public void insert(AdoptaniSponsorVO adoptaniSponsorVO);
    public void update(AdoptaniSponsorVO adoptaniSponsorVO);
    public void delete(String ado_Ani_Spo_No);
    public AdoptaniSponsorVO findByPrimaryKey(String ado_Ani_Spo_No);
    public List<AdoptaniSponsorVO> getAll();
    public List<AdoptaniSponsorVO> getOneAllSponsor(String Adopt_Ani_Id);
    public Integer getOneAllSponsorMoney(String Adopt_Ani_Id);
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
    //public List<EmpVO> getAll(Map<String, String[]> map); 

}
