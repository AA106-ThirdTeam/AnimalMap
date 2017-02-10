package com.grp_comment.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:揪團留言<br>
 *	英文:grp_comment<br>
 */ 
public class Grp_commentService{
	private Grp_commentDAO_interface dao; 

	public Grp_commentService(){
		dao = new Grp_commentDAO();
	}

	//====以下是insert方法====
	public Grp_commentVO addGrp_comment(String grpComment_MemId,String grpComment_GrpId,String grpComment_content,java.sql.Date grpComment_SendTime){
		Grp_commentVO grp_commentVO = new Grp_commentVO();

		grp_commentVO.setGrpComment_MemId(grpComment_MemId);
		grp_commentVO.setGrpComment_GrpId(grpComment_GrpId);
		grp_commentVO.setGrpComment_content(grpComment_content);
		grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);

		dao.insert(grp_commentVO);

		return grp_commentVO;
	}

	//====以下是update方法====
	public Grp_commentVO updateGrp_comment(String grpComment_Id,String grpComment_MemId,String grpComment_GrpId,String grpComment_content,java.sql.Date grpComment_SendTime){

		Grp_commentVO grp_commentVO = new Grp_commentVO();

		grp_commentVO.setGrpComment_Id(grpComment_Id);
		grp_commentVO.setGrpComment_MemId(grpComment_MemId);
		grp_commentVO.setGrpComment_GrpId(grpComment_GrpId);
		grp_commentVO.setGrpComment_content(grpComment_content);
		grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);

		dao.update(grp_commentVO);

		return grp_commentVO;
	}

	//====以下是delete方法====
	public void deleteGrp_comment(String  grpComment_Id){
		dao.delete(grpComment_Id);
	}

	//====以下是getOne方法====
	public Grp_commentVO getOneGrp_comment(String  grpComment_Id){
		return dao.findByPrimaryKey(grpComment_Id);
	}

	//====以下是getAll方法====
	public List<Grp_commentVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Grp_commentVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Grp_commentVO> getGrp_commentsByMem_Id(String grpComment_MemId) {
        return dao.getGrp_commentsByMem_Id(grpComment_MemId);
    }

    //====以下是getSet方法====
    public Set<Grp_commentVO> getGrp_commentsByGrp_Id(String grpComment_GrpId) {
        return dao.getGrp_commentsByGrp_Id(grpComment_GrpId);
    }
}
