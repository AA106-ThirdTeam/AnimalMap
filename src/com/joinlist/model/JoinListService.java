package com.joinlist.model;

import java.util.List;
import java.util.Set;

/** 
 *表格名稱 : <br>
 *	中文:揪團參加名單<br>
 *	英文:JoinList<br>
 */ 
public class JoinListService{
	private JoinListDAO_interface dao; 

	public JoinListService(){
		dao = new JoinListDAO();
	}

	//====以下是insert方法====
	public JoinListVO addJoinList(JoinListVO joinlistVO){
		
		dao.insert(joinlistVO);

		return joinlistVO;
	}

	//====以下是update方法====
	public JoinListVO update(JoinListVO joinlistVO){

		dao.update(joinlistVO);

		return joinlistVO;
	}

	//====以下是delete方法====
	public void delete(String  joinList_GrpId,String joinList_MemId){
		dao.delete_By_joinList_GrpId_joinList_MemId( joinList_GrpId, joinList_MemId);
	}

	public void deleteJoinList_By_joinList_MemId(String  joinList_MemId){
		dao.delete_By_joinList_MemId(joinList_MemId);
	}

	//====以下是getOne方法====
	public JoinListVO getOneJoinList_By_joinList_GrpId(String  joinList_GrpId){
		return dao.findByPrimaryKey_By_joinList_GrpId(joinList_GrpId);
	}

	public JoinListVO getOneJoinList_By_joinList_MemId(String  joinList_MemId){
		return dao.findByPrimaryKey_By_joinList_MemId(joinList_MemId);
	}

	//====以下是getAll方法====
	public List<JoinListVO> getAll(){
		return dao.getAll();
	}
	
	public void BatchInsert(Set<JoinListVO> joinlistVOSet){
		dao.BatchInsert(joinlistVOSet);
	}
	
	public Set<JoinListVO> getJoinListByMemId(String joinList_MemId){
		return dao.getJoinListByMemId(joinList_MemId);
	}
	
	
}
