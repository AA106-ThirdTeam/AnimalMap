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
	public Shop_commentVO addShop_comment(String shopComment_MemId,String shopComment_ShopId,String shopComment_content,java.sql.Date shopComment_SendTime){
		Shop_commentVO shop_commentVO = new Shop_commentVO();

		shop_commentVO.setShopComment_MemId(shopComment_MemId);
		shop_commentVO.setShopComment_ShopId(shopComment_ShopId);
		shop_commentVO.setShopComment_content(shopComment_content);
		shop_commentVO.setShopComment_SendTime(shopComment_SendTime);

		dao.insert(shop_commentVO);

		return shop_commentVO;
	}

	//====以下是update方法====
	public Shop_commentVO updateShop_comment(String shopComment_Id,String shopComment_MemId,String shopComment_ShopId,String shopComment_content,java.sql.Date shopComment_SendTime){

		Shop_commentVO shop_commentVO = new Shop_commentVO();

		shop_commentVO.setShopComment_Id(shopComment_Id);
		shop_commentVO.setShopComment_MemId(shopComment_MemId);
		shop_commentVO.setShopComment_ShopId(shopComment_ShopId);
		shop_commentVO.setShopComment_content(shopComment_content);
		shop_commentVO.setShopComment_SendTime(shopComment_SendTime);

		dao.update(shop_commentVO);

		return shop_commentVO;
	}

	//====以下是delete方法====
	public void deleteShop_comment(String  shopComment_Id){
		dao.delete(shopComment_Id);
	}

	//====以下是getOne方法====
	public Shop_commentVO getOneShop_comment(String  shopComment_Id){
		return dao.findByPrimaryKey(shopComment_Id);
	}

	//====以下是getAll方法====
	public List<Shop_commentVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Shop_commentVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Shop_commentVO> getShop_commentsByMem_Id(String shopComment_MemId) {
        return dao.getShop_commentsByMem_Id(shopComment_MemId);
    }

    //====以下是getSet方法====
    public Set<Shop_commentVO> getShop_commentsByShop_Id(String shopComment_ShopId) {
        return dao.getShop_commentsByShop_Id(shopComment_ShopId);
    }
}
