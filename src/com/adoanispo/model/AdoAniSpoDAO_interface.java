package com.adoanispo.model;

import java.util.*; 

public interface AdoAniSpoDAO_interface {
	public void insert(AdoAniSpoVO adoanispoVO);
	public void update(AdoAniSpoVO adoanispoVO);
	public void delete(String adoAniSpoNo);
	public AdoAniSpoVO findByPrimaryKey(String adoAniSpoNo);
	public List<AdoAniSpoVO> getAll();
}