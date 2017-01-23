package com.track.model;

import java.util.* 

public interface TrackDAO_interface {
	public void insert(TrackVO trackVO);
	public void update(TrackVO trackVO);
	public void delete(Integer empno);
	public TrackVO findByPrimaryKey(Integer empno);
	public List<TrackVO> getAll();
}