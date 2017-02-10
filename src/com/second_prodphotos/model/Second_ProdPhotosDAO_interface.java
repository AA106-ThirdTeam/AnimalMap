package com.second_prodphotos.model;

import java.util.*; 

public interface Second_ProdPhotosDAO_interface {
	public void insert(Second_ProdPhotosVO second_prodphotosVO);
	public void update(Second_ProdPhotosVO second_prodphotosVO);
    public void delete(String second_ProdPhotos_Id);
	public Second_ProdPhotosVO findByPrimaryKey(String second_ProdPhotos_Id);
	public List<Second_ProdPhotosVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Second_ProdPhotosVO> getAll(Map<String, String[]> map);

    //查詢某二手商品相簿的二手商品編號(一對多)(回傳 Set)
    public Set<Second_ProdPhotosVO> getSecond_ProdPhotossBySecond_Prod_Id(String second_Prod_Id);
}
