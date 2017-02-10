package com.anihome_photos.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:動物之家相簿<br>
 *	英文:aniHome_Photos<br>
 */ 
public class AniHome_PhotosService{
	private AniHome_PhotosDAO_interface dao; 

	public AniHome_PhotosService(){
		dao = new AniHome_PhotosDAO();
	}

	//====以下是insert方法====
	public AniHome_PhotosVO addAniHome_Photos(String aniHome_Id,byte[] aniHome_Photos_pic){
		AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();

		anihome_photosVO.setAniHome_Id(aniHome_Id);
		anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);

		dao.insert(anihome_photosVO);

		return anihome_photosVO;
	}

	//====以下是update方法====
	public AniHome_PhotosVO updateAniHome_Photos(String aniHome_Photos_Id,String aniHome_Id,byte[] aniHome_Photos_pic){

		AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();

		anihome_photosVO.setAniHome_Photos_Id(aniHome_Photos_Id);
		anihome_photosVO.setAniHome_Id(aniHome_Id);
		anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);

		dao.update(anihome_photosVO);

		return anihome_photosVO;
	}

	//====以下是delete方法====
	public void deleteAniHome_Photos(String  aniHome_Photos_Id){
		dao.delete(aniHome_Photos_Id);
	}

	//====以下是getOne方法====
	public AniHome_PhotosVO getOneAniHome_Photos(String  aniHome_Photos_Id){
		return dao.findByPrimaryKey(aniHome_Photos_Id);
	}

	//====以下是getAll方法====
	public List<AniHome_PhotosVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<AniHome_PhotosVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<AniHome_PhotosVO> getAniHome_PhotossByAniHome_Id(String aniHome_Id) {
        return dao.getAniHome_PhotossByAniHome_Id(aniHome_Id);
    }
}
