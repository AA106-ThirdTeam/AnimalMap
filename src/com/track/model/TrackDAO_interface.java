package com.track.model;

import java.util.*; 

public interface TrackDAO_interface {
	public void insert(TrackVO trackVO);
	public void update(TrackVO trackVO);
	public void delete1(Integer track_Id);
	public TrackVO findByPrimaryKey1(Integer track_Id);
	public List<TrackVO> getAll();
}