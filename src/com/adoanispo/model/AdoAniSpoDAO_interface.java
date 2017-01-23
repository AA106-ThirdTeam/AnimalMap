package com.adoanispo.model;

import java.util.*; 

public interface AdoAniSpoDAO_interface {
	public void insert(AdoAniSpoVO adoanispoVO);
	public void update(AdoAniSpoVO adoanispoVO);
	public void delete1(Integer adoAniSpoNo);
	public AdoAniSpoVO findByPrimaryKey1(Integer adoAniSpoNo);
	public List<AdoAniSpoVO> getAll();
}