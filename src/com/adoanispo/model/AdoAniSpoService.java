package com.adoanispo.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:送養動物領養人<br>
 *	英文:adoAniSpo<br>
 */ 
public class AdoAniSpoService{
	private AdoAniSpoDAO_interface dao; 

	public AdoAniSpoService(){
		dao = new AdoAniSpoDAO();
	}

	//====以下是insert方法====
	public AdoAniSpoVO addAdoAniSpo(String adoAniSpoAniId,String adoAniSpomem_Id,Integer adoAniSpoMoney,String adoAniSpoMat){
		AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();

		adoanispoVO.setAdoAniSpoAniId(adoAniSpoAniId);
		adoanispoVO.setAdoAniSpomem_Id(adoAniSpomem_Id);
		adoanispoVO.setAdoAniSpoMoney(adoAniSpoMoney);
		adoanispoVO.setAdoAniSpoMat(adoAniSpoMat);

		dao.insert(adoanispoVO);

		return adoanispoVO;
	}

	//====以下是update方法====
	public AdoAniSpoVO updateAdoAniSpo(String adoAniSpoNo,String adoAniSpoAniId,String adoAniSpomem_Id,Integer adoAniSpoMoney,String adoAniSpoMat){

		AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();

		adoanispoVO.setAdoAniSpoNo(adoAniSpoNo);
		adoanispoVO.setAdoAniSpoAniId(adoAniSpoAniId);
		adoanispoVO.setAdoAniSpomem_Id(adoAniSpomem_Id);
		adoanispoVO.setAdoAniSpoMoney(adoAniSpoMoney);
		adoanispoVO.setAdoAniSpoMat(adoAniSpoMat);

		dao.update(adoanispoVO);

		return adoanispoVO;
	}

	//====以下是delete方法====
	public void deleteAdoAniSpo(String  adoAniSpoNo){
		dao.delete(adoAniSpoNo);
	}

	//====以下是getOne方法====
	public AdoAniSpoVO getOneAdoAniSpo(String  adoAniSpoNo){
		return dao.findByPrimaryKey(adoAniSpoNo);
	}

	//====以下是getAll方法====
	public List<AdoAniSpoVO> getAll(){
		return dao.getAll();
	}
}
