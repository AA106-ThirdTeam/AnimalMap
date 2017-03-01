package com.hosComm.model;

import java.util.List;

import com.grpComm.model.GrpCommVO;

public interface HosCommDAO_interface {
	public void insert(HosCommVO hosCommVO);
    public void update(HosCommVO hosCommVO);
    public void delete(String hosComment_Id);
    public HosCommVO findByPrimaryKey(String hosComment_Id);
    public List<HosCommVO> getAll();
}


