package com.charge.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChargeService {
	private ChargeDAO_interface dao;
	
	public ChargeService() {
		dao = new ChargeDAO();
		
	}
//Insert
	public ChargeVO addCharge(String mem_id,Integer charge_number,Integer pay,java.sql.Date applytime){
		
		ChargeVO chargeVO = new ChargeVO();
		
		chargeVO.setMem_id(mem_id);
		chargeVO.setCharge_number(charge_number);
		chargeVO.setPay(pay);
		chargeVO.setApplytime(applytime);
		dao.insert(chargeVO);
		
		return chargeVO;
		
	}
//Update
	public ChargeVO updateCharge(String charge_no,String mem_id,Integer charge_number,Integer pay,java.sql.Date applytime){
		
		ChargeVO chargeVO = new ChargeVO();
		chargeVO.setCharge_no(charge_no);
		chargeVO.setMem_id(mem_id);
		chargeVO.setCharge_number(charge_number);
		chargeVO.setPay(pay);
		chargeVO.setApplytime(applytime);
		dao.update(chargeVO);
		
		return chargeVO;
	}
	public void deleteCharge(String charge_no)	{
		dao.delete(charge_no);
	}
	public ChargeVO getOneCharge(String charge_no) {
		return dao.findByPrimaryKey(charge_no);
	}
	
	public List<ChargeVO> getAll(){
		return dao.getAll();
	}
	
	public List<ChargeVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
	
	public Set<ChargeVO> getChargesByMem_Id(String mem_Id) {
        return dao.getChargesByMem_Id(mem_Id);
    }
}
