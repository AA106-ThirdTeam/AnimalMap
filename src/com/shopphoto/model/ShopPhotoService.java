package com.shopphoto.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:商家相片<br>
 *	英文:shopPhoto<br>
 */ 
public class ShopPhotoService{
	private ShopPhotoDAO_interface dao; 

	public ShopPhotoService(){
		dao = new ShopPhotoDAO();
	}

	//====以下是insert方法====
	public ShopPhotoVO addShopPhoto(String shopPhoto_ShopId,byte[] shopPhoto_photo,String isDisp_shopPhoto,String shopPhoto_name,String shopPhoto_extent){
		ShopPhotoVO shopphotoVO = new ShopPhotoVO();

		shopphotoVO.setShopPhoto_ShopId(shopPhoto_ShopId);
		shopphotoVO.setShopPhoto_photo(shopPhoto_photo);
		shopphotoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
		shopphotoVO.setShopPhoto_name(shopPhoto_name);
		shopphotoVO.setShopPhoto_extent(shopPhoto_extent);

		dao.insert(shopphotoVO);

		return shopphotoVO;
	}

	//====以下是update方法====
	public ShopPhotoVO updateShopPhoto(String shopPhoto_Id,String shopPhoto_ShopId,byte[] shopPhoto_photo,String isDisp_shopPhoto,String shopPhoto_name,String shopPhoto_extent){

		ShopPhotoVO shopphotoVO = new ShopPhotoVO();

		shopphotoVO.setShopPhoto_Id(shopPhoto_Id);
		shopphotoVO.setShopPhoto_ShopId(shopPhoto_ShopId);
		shopphotoVO.setShopPhoto_photo(shopPhoto_photo);
		shopphotoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
		shopphotoVO.setShopPhoto_name(shopPhoto_name);
		shopphotoVO.setShopPhoto_extent(shopPhoto_extent);

		dao.update(shopphotoVO);

		return shopphotoVO;
	}

	//====以下是delete方法====
	public void deleteShopPhoto(String  shopPhoto_Id){
		dao.delete(shopPhoto_Id);
	}

	//====以下是getOne方法====
	public ShopPhotoVO getOneShopPhoto(String  shopPhoto_Id){
		return dao.findByPrimaryKey(shopPhoto_Id);
	}

	//====以下是getAll方法====
	public List<ShopPhotoVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<ShopPhotoVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<ShopPhotoVO> getShopPhotosByShop_Id(String shopPhoto_ShopId) {
        return dao.getShopPhotosByShop_Id(shopPhoto_ShopId);
    }
}
