package com.adopt_ani_sponsor.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:送養動物贊助<br>
 *	英文:adopt_Ani_sponsor<br>
 */ 
public class Adopt_Ani_sponsorService{
	private Adopt_Ani_sponsorDAO_interface dao; 

	public Adopt_Ani_sponsorService(){
		dao = new Adopt_Ani_sponsorDAO();
	}

	//====以下是insert方法====
	public Adopt_Ani_sponsorVO addAdopt_Ani_sponsor(String adopt_Ani_Id,String mem_Id,Integer ado_Ani_Spo_money,String adoAniSpoMat){
		Adopt_Ani_sponsorVO adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();

		adopt_ani_sponsorVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_sponsorVO.setMem_Id(mem_Id);
		adopt_ani_sponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money);
		adopt_ani_sponsorVO.setAdoAniSpoMat(adoAniSpoMat);

		dao.insert(adopt_ani_sponsorVO);

		return adopt_ani_sponsorVO;
	}

	//====以下是update方法====
	public Adopt_Ani_sponsorVO updateAdopt_Ani_sponsor(String ado_Ani_Spo_No,String adopt_Ani_Id,String mem_Id,Integer ado_Ani_Spo_money,String adoAniSpoMat){

		Adopt_Ani_sponsorVO adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();

		adopt_ani_sponsorVO.setAdo_Ani_Spo_No(ado_Ani_Spo_No);
		adopt_ani_sponsorVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_sponsorVO.setMem_Id(mem_Id);
		adopt_ani_sponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money);
		adopt_ani_sponsorVO.setAdoAniSpoMat(adoAniSpoMat);

		dao.update(adopt_ani_sponsorVO);

		return adopt_ani_sponsorVO;
	}

	//====以下是delete方法====
	public void deleteAdopt_Ani_sponsor(String  ado_Ani_Spo_No){
		dao.delete(ado_Ani_Spo_No);
	}

	//====以下是getOne方法====
	public Adopt_Ani_sponsorVO getOneAdopt_Ani_sponsor(String  ado_Ani_Spo_No){
		return dao.findByPrimaryKey(ado_Ani_Spo_No);
	}

	//====以下是getAll方法====
	public List<Adopt_Ani_sponsorVO> getAll(){
		return dao.getAll();
	}
}
