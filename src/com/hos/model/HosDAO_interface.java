package com.hos.model;

import java.util.List;
import java.util.Map;
import java.util.Set;


import com.hosComm.model.HosCommVO;
import com.hosPhoto.model.HosPhotoVO;

public interface HosDAO_interface {
	public List<HosVO> searchAll(String searchCondition);
	public HosVO insert(HosVO hosVO, List<HosPhotoVO> list);
    public void update(HosVO hosVO);
    public void delete(String hos_Id);
    public HosVO findByPrimaryKey(String hos_Id);
    public List<HosVO> getAll();
    
    public Set<HosPhotoVO> getPhotosByHosId(String hosId);
    public Set<HosCommVO> getCommentsByHosId(String hos_Id);
    public List<HosVO> getAll(Map<String, String[]> map); 
}
