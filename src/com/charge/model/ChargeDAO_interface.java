package com.charge.model;

import java.util.*; 

public interface ChargeDAO_interface {
	public void insert(ChargeVO chargeVO);
	public void update(ChargeVO chargeVO);
	public void delete(String charge_no);
	public ChargeVO findByPrimaryKey(String charge_no);
	public List<ChargeVO> getAll();
}