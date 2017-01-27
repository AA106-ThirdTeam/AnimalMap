package com.adoanispo.model;

import java.util.* 

public interface AdoAniSpoDAO_interface {
	public void insert(AdoAniSpoVO adoanispoVO);
	public void update(AdoAniSpoVO adoanispoVO);
	public void delete(Integer empno);
	public AdoAniSpoVO findByPrimaryKey(Integer empno);
	public List<AdoAniSpoVO> getAll();
}