package com.priv_message.model;

import java.util.* 

public interface Priv_messageDAO_interface {
	public void insert(Priv_messageVO priv_messageVO);
	public void update(Priv_messageVO priv_messageVO);
	public void delete(Integer empno);
	public Priv_messageVO findByPrimaryKey(Integer empno);
	public List<Priv_messageVO> getAll();
}