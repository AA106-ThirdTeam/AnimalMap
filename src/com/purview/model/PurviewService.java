package com.purview.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:權限<br>
 *	英文:purview<br>
 */ 
public class PurviewService{
	private PurviewDAO_interface dao; 

	public PurviewService(){
		dao = new PurviewDAO();
	}

	//====以下是insert方法====
	public PurviewVO addPurview(String pruview_name){
		PurviewVO purviewVO = new PurviewVO();

		purviewVO.setPruview_name(pruview_name);

		dao.insert(purviewVO);

		return purviewVO;
	}

	//====以下是update方法====
	public PurviewVO updatePurview(String purview_No,String pruview_name){

		PurviewVO purviewVO = new PurviewVO();

		purviewVO.setPurview_No(purview_No);
		purviewVO.setPruview_name(pruview_name);

		dao.update(purviewVO);

		return purviewVO;
	}

	//====以下是delete方法====
	public void deletePurview(String  purview_No){
		dao.delete(purview_No);
	}

	//====以下是getOne方法====
	public PurviewVO getOnePurview(String  purview_No){
		return dao.findByPrimaryKey(purview_No);
	}

	//====以下是getAll方法====
	public List<PurviewVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<PurviewVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}
}
