package com.track.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:追蹤收藏<br>
 *	英文:track<br>
 */ 
public class TrackService{
	private TrackDAO_interface dao; 

	public TrackService(){
		dao = new TrackDAO();
	}

	//====以下是insert方法====
	public TrackVO addTrack(String mem_Id,String track_record_class,String track_record_class_Id){
		TrackVO trackVO = new TrackVO();

		trackVO.setMem_Id(mem_Id);
		trackVO.setTrack_record_class(track_record_class);
		trackVO.setTrack_record_class_Id(track_record_class_Id);

		dao.insert(trackVO);

		return trackVO;
	}

	//====以下是update方法====
	public TrackVO updateTrack(String track_Id,String mem_Id,String track_record_class,String track_record_class_Id){

		TrackVO trackVO = new TrackVO();

		trackVO.setTrack_Id(track_Id);
		trackVO.setMem_Id(mem_Id);
		trackVO.setTrack_record_class(track_record_class);
		trackVO.setTrack_record_class_Id(track_record_class_Id);

		dao.update(trackVO);

		return trackVO;
	}

	//====以下是delete方法====
	public void deleteTrack(String  track_Id){
		dao.delete(track_Id);
	}

	//====以下是getOne方法====
	public TrackVO getOneTrack(String  track_Id){
		return dao.findByPrimaryKey(track_Id);
	}

	//====以下是getAll方法====
	public List<TrackVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<TrackVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<TrackVO> getTracksByMem_Id(String mem_Id) {
        return dao.getTracksByMem_Id(mem_Id);
    }
}
