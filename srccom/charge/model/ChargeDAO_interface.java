package com.charge.model;

import java.util.* 

public interface ChargeDAO_interface {
	public void insert(ChargeVO chargeVO);
	public void update(ChargeVO chargeVO);
	public void delete(Integer empno);
	public ChargeVO findByPrimaryKey(Integer empno);
	public List<ChargeVO> getAll();
}