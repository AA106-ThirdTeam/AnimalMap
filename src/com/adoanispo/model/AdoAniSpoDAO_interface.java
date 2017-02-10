package com.adoanispo.model;

import java.util.*; 

public interface AdoAniSpoDAO_interface {
	public void insert(AdoAniSpoVO adoanispoVO);
	public void update(AdoAniSpoVO adoanispoVO);
    public void delete(String adoAniSpoNo);
	public AdoAniSpoVO findByPrimaryKey(String adoAniSpoNo);
	public List<AdoAniSpoVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<AdoAniSpoVO> getAll(Map<String, String[]> map);

    //查詢某送養動物領養人的送養動物編號(一對多)(回傳 Set)
    public Set<AdoAniSpoVO> getAdoAniSposByAdopt_Ani_Id(String adoAniSpoAniId);

    //查詢某送養動物領養人的贊助者會員編號(一對多)(回傳 Set)
    public Set<AdoAniSpoVO> getAdoAniSposByMem_Id(String adoAniSpomem_Id);
}
