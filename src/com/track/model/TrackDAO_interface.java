package com.track.model;

import java.util.*; 

public interface TrackDAO_interface {
	public void insert(TrackVO trackVO);
	public void update(TrackVO trackVO);
    public void delete(String track_Id);
	public TrackVO findByPrimaryKey(String track_Id);
	public List<TrackVO> getAll();
}