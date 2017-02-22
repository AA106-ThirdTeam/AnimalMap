package com.charge.model;

import java.util.*;

public interface ChargeDAO_interface {
	public void insert(ChargeVO chargeVO);
	public void update(ChargeVO chargeVO);
	public void delete(String charge_no);
	public ChargeVO findByPrimaryKey(String charge_no);
	public List<ChargeVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<ChargeVO> getAll(Map<String, String[]> map);
    //查詢某儲值的會員編號(一對多)(回傳 Set)

    public Set<ChargeVO> getChargesByMem_Id(String mem_Id);

}
