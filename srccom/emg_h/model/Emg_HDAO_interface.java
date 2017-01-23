package com.emg_h.model;

import java.util.* 

public interface Emg_HDAO_interface {
	public void insert(Emg_HVO emg_hVO);
	public void update(Emg_HVO emg_hVO);
	public void delete(Integer empno);
	public Emg_HVO findByPrimaryKey(Integer empno);
	public List<Emg_HVO> getAll();
}