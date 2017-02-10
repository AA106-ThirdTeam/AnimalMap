package com.charge.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:儲值<br>
 *	英文:charge<br>
 */ 
public class ChargeService{
	private ChargeDAO_interface dao; 

	public ChargeService(){
		dao = new ChargeDAO();
	}

	//====以下是insert方法====
	public ChargeVO addCharge(String mem_Id,Integer charge_NUMBER,Integer pay,java.sql.Date applytime){
		ChargeVO chargeVO = new ChargeVO();

		chargeVO.setMem_Id(mem_Id);
		chargeVO.setCharge_NUMBER(charge_NUMBER);
		chargeVO.setPay(pay);
		chargeVO.setApplytime(applytime);

		dao.insert(chargeVO);

		return chargeVO;
	}

	//====以下是update方法====
	public ChargeVO updateCharge(String charge_no,String mem_Id,Integer charge_NUMBER,Integer pay,java.sql.Date applytime){

		ChargeVO chargeVO = new ChargeVO();

		chargeVO.setCharge_no(charge_no);
		chargeVO.setMem_Id(mem_Id);
		chargeVO.setCharge_NUMBER(charge_NUMBER);
		chargeVO.setPay(pay);
		chargeVO.setApplytime(applytime);

		dao.update(chargeVO);

		return chargeVO;
	}

	//====以下是delete方法====
	public void deleteCharge(String  charge_no){
		dao.delete(charge_no);
	}

	//====以下是getOne方法====
	public ChargeVO getOneCharge(String  charge_no){
		return dao.findByPrimaryKey(charge_no);
	}

	//====以下是getAll方法====
	public List<ChargeVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<ChargeVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<ChargeVO> getChargesByMem_Id(String mem_Id) {
        return dao.getChargesByMem_Id(mem_Id);
    }
}
