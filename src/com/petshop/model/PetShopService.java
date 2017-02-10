package com.petshop.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:寵物商店<br>
 *	英文:petShop<br>
 */ 
public class PetShopService{
	private PetShopDAO_interface dao; 

	public PetShopService(){
		dao = new PetShopDAO();
	}

	//====以下是insert方法====
	public PetShopVO addPetShop(String shop_MemId,String shop_name,String shop_city,String shop_town,String shop_road,Integer shop_Eval,String shop_URL,String shop_StartTime,String shop_EndTime,String shop_Tel,String shop_Desc,Double shop_Long,Double shop_Lat,java.sql.Date shop_CreateTime,String shop_visible){
		PetShopVO petshopVO = new PetShopVO();

		petshopVO.setShop_MemId(shop_MemId);
		petshopVO.setShop_name(shop_name);
		petshopVO.setShop_city(shop_city);
		petshopVO.setShop_town(shop_town);
		petshopVO.setShop_road(shop_road);
		petshopVO.setShop_Eval(shop_Eval);
		petshopVO.setShop_URL(shop_URL);
		petshopVO.setShop_StartTime(shop_StartTime);
		petshopVO.setShop_EndTime(shop_EndTime);
		petshopVO.setShop_Tel(shop_Tel);
		petshopVO.setShop_Desc(shop_Desc);
		petshopVO.setShop_Long(shop_Long);
		petshopVO.setShop_Lat(shop_Lat);
		petshopVO.setShop_CreateTime(shop_CreateTime);
		petshopVO.setShop_visible(shop_visible);

		dao.insert(petshopVO);

		return petshopVO;
	}

	//====以下是update方法====
	public PetShopVO updatePetShop(String shop_Id,String shop_MemId,String shop_name,String shop_city,String shop_town,String shop_road,Integer shop_Eval,String shop_URL,String shop_StartTime,String shop_EndTime,String shop_Tel,String shop_Desc,Double shop_Long,Double shop_Lat,java.sql.Date shop_CreateTime,String shop_visible){

		PetShopVO petshopVO = new PetShopVO();

		petshopVO.setShop_Id(shop_Id);
		petshopVO.setShop_MemId(shop_MemId);
		petshopVO.setShop_name(shop_name);
		petshopVO.setShop_city(shop_city);
		petshopVO.setShop_town(shop_town);
		petshopVO.setShop_road(shop_road);
		petshopVO.setShop_Eval(shop_Eval);
		petshopVO.setShop_URL(shop_URL);
		petshopVO.setShop_StartTime(shop_StartTime);
		petshopVO.setShop_EndTime(shop_EndTime);
		petshopVO.setShop_Tel(shop_Tel);
		petshopVO.setShop_Desc(shop_Desc);
		petshopVO.setShop_Long(shop_Long);
		petshopVO.setShop_Lat(shop_Lat);
		petshopVO.setShop_CreateTime(shop_CreateTime);
		petshopVO.setShop_visible(shop_visible);

		dao.update(petshopVO);

		return petshopVO;
	}

	//====以下是delete方法====
	public void deletePetShop(String  shop_Id){
		dao.delete(shop_Id);
	}

	//====以下是getOne方法====
	public PetShopVO getOnePetShop(String  shop_Id){
		return dao.findByPrimaryKey(shop_Id);
	}

	//====以下是getAll方法====
	public List<PetShopVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<PetShopVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<PetShopVO> getPetShopsByMem_Id(String shop_MemId) {
        return dao.getPetShopsByMem_Id(shop_MemId);
    }
}
