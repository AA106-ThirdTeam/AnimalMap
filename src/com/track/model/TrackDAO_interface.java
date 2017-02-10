package com.track.model;

import java.util.*; 

public interface TrackDAO_interface {
	public void insert(TrackVO trackVO);
	public void update(TrackVO trackVO);
    public void delete(String track_Id);
	public TrackVO findByPrimaryKey(String track_Id);
	public List<TrackVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<TrackVO> getAll(Map<String, String[]> map);

    //查詢某追蹤收藏的會員編號(一對多)(回傳 Set)
    public Set<TrackVO> getTracksByMem_Id(String mem_Id);
}
