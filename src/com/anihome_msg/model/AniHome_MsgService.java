package com.anihome_msg.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:動物之家留言<br>
 *	英文:aniHome_Msg<br>
 */ 
public class AniHome_MsgService{
	private AniHome_MsgDAO_interface dao; 

	public AniHome_MsgService(){
		dao = new AniHome_MsgDAO();
	}

	//====以下是insert方法====
	public AniHome_MsgVO addAniHome_Msg(String aniHome_Id,String mem_Id,String aniHome_Msg,java.sql.Date adp_start_date){
		AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();

		anihome_msgVO.setAniHome_Id(aniHome_Id);
		anihome_msgVO.setMem_Id(mem_Id);
		anihome_msgVO.setAniHome_Msg(aniHome_Msg);
		anihome_msgVO.setAdp_start_date(adp_start_date);

		dao.insert(anihome_msgVO);

		return anihome_msgVO;
	}

	//====以下是update方法====
	public AniHome_MsgVO updateAniHome_Msg(String aniHome_Msg_Id,String aniHome_Id,String mem_Id,String aniHome_Msg,java.sql.Date adp_start_date){

		AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();

		anihome_msgVO.setAniHome_Msg_Id(aniHome_Msg_Id);
		anihome_msgVO.setAniHome_Id(aniHome_Id);
		anihome_msgVO.setMem_Id(mem_Id);
		anihome_msgVO.setAniHome_Msg(aniHome_Msg);
		anihome_msgVO.setAdp_start_date(adp_start_date);

		dao.update(anihome_msgVO);

		return anihome_msgVO;
	}

	//====以下是delete方法====
	public void deleteAniHome_Msg(String  aniHome_Msg_Id){
		dao.delete(aniHome_Msg_Id);
	}

	//====以下是getOne方法====
	public AniHome_MsgVO getOneAniHome_Msg(String  aniHome_Msg_Id){
		return dao.findByPrimaryKey(aniHome_Msg_Id);
	}

	//====以下是getAll方法====
	public List<AniHome_MsgVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<AniHome_MsgVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<AniHome_MsgVO> getAniHome_MsgsByAniHome_Id(String aniHome_Id) {
        return dao.getAniHome_MsgsByAniHome_Id(aniHome_Id);
    }

    //====以下是getSet方法====
    public Set<AniHome_MsgVO> getAniHome_MsgsByMem_Id(String mem_Id) {
        return dao.getAniHome_MsgsByMem_Id(mem_Id);
    }
}
