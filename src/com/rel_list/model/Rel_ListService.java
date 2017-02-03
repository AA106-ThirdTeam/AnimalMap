package com.rel_list.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:關係名單<br>
 *	英文:rel_List<br>
 */ 
public class Rel_ListService{
	private Rel_ListDAO_interface dao; 

	public Rel_ListService(){
		dao = new Rel_ListDAO();
	}

	//====以下是insert方法====
	public Rel_ListVO addRel_List(String isBlackList,String isInvited){
		Rel_ListVO rel_listVO = new Rel_ListVO();

		rel_listVO.setIsBlackList(isBlackList);
		rel_listVO.setIsInvited(isInvited);

		dao.insert(rel_listVO);

		return rel_listVO;
	}

	//====以下是update方法====
	public Rel_ListVO updateRel_List(String rel_MemId,String added_MemId,String isBlackList,String isInvited){

		Rel_ListVO rel_listVO = new Rel_ListVO();

		rel_listVO.setRel_MemId(rel_MemId);
		rel_listVO.setAdded_MemId(added_MemId);
		rel_listVO.setIsBlackList(isBlackList);
		rel_listVO.setIsInvited(isInvited);

		dao.update(rel_listVO);

		return rel_listVO;
	}

	//====以下是delete方法====
	public void deleteRel_List_By_rel_MemId(String  rel_MemId){
		dao.delete_By_rel_MemId(rel_MemId);
	}

	public void deleteRel_List_By_added_MemId(String  added_MemId){
		dao.delete_By_added_MemId(added_MemId);
	}

	//====以下是getOne方法====
	public Rel_ListVO getOneRel_List_By_rel_MemId(String  rel_MemId){
		return dao.findByPrimaryKey_By_rel_MemId(rel_MemId);
	}

	public Rel_ListVO getOneRel_List_By_added_MemId(String  added_MemId){
		return dao.findByPrimaryKey_By_added_MemId(added_MemId);
	}

	//====以下是getAll方法====
	public List<Rel_ListVO> getAll(){
		return dao.getAll();
	}
}
