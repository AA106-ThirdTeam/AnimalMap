package com.hosphoto.model;

import java.util.*; 

public interface HosPhotoDAO_interface {
	public void insert(HosPhotoVO hosphotoVO);
	public void update(HosPhotoVO hosphotoVO);
    public void delete(String hosPhoto_Id);
	public HosPhotoVO findByPrimaryKey(String hosPhoto_Id);
	public List<HosPhotoVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<HosPhotoVO> getAll(Map<String, String[]> map);

    //查詢某診所相片的診所編號(相片擁有診所)(一對多)(回傳 Set)
    public Set<HosPhotoVO> getHosPhotosByHos_Id(String hosPhoto_HosId);
}
