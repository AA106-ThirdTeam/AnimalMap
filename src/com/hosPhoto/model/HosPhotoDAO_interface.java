package com.hosPhoto.model;

import java.util.List;

import com.hos.model.HosVO;

public interface HosPhotoDAO_interface {
	public void insert(String hos_Id, List<HosPhotoVO> list);
    public void update(HosPhotoVO hosPhotoVO);
    public void delete(String hosPhoto_Id);
    public HosPhotoVO findByPrimaryKey(String hosPhoto_Id);
    public List<HosPhotoVO> getAll();
    public void setDisplayPhoto(String hosPhoto_Id, String hosPhoto_HosId);
}
