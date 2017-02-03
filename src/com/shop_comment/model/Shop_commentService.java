package com.shop_comment.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:商家留言<br>
 *	英文:shop_comment<br>
 */ 
public class Shop_commentService{
	private Shop_commentDAO_interface dao; 

	public Shop_commentService(){
		dao = new Shop_commentDAO();
	}

	//====以下是insert方法====
	public Shop_commentVO addShop_comment(String shopComm_MemId,String shopComm_ShopId,String shopComm_content,java.sql.Date shopComm_SendTime){
		Shop_commentVO shop_commentVO = new Shop_commentVO();

		shop_commentVO.setShopComm_MemId(shopComm_MemId);
		shop_commentVO.setShopComm_ShopId(shopComm_ShopId);
		shop_commentVO.setShopComm_content(shopComm_content);
		shop_commentVO.setShopComm_SendTime(shopComm_SendTime);

		dao.insert(shop_commentVO);

		return shop_commentVO;
	}

	//====以下是update方法====
	public Shop_commentVO updateShop_comment(String shopComm_Id,String shopComm_MemId,String shopComm_ShopId,String shopComm_content,java.sql.Date shopComm_SendTime){

		Shop_commentVO shop_commentVO = new Shop_commentVO();

		shop_commentVO.setShopComm_Id(shopComm_Id);
		shop_commentVO.setShopComm_MemId(shopComm_MemId);
		shop_commentVO.setShopComm_ShopId(shopComm_ShopId);
		shop_commentVO.setShopComm_content(shopComm_content);
		shop_commentVO.setShopComm_SendTime(shopComm_SendTime);

		dao.update(shop_commentVO);

		return shop_commentVO;
	}

	//====以下是delete方法====
	public void deleteShop_comment(String  shopComm_Id){
		dao.delete(shopComm_Id);
	}

	//====以下是getOne方法====
	public Shop_commentVO getOneShop_comment(String  shopComm_Id){
		return dao.findByPrimaryKey(shopComm_Id);
	}

	//====以下是getAll方法====
	public List<Shop_commentVO> getAll(){
		return dao.getAll();
	}
}
