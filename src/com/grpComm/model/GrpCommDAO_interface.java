package com.grpComm.model;

import java.util.List;

public interface GrpCommDAO_interface {
	public void insert(GrpCommVO grpCommVO);
    public void update(GrpCommVO grpCommVO);
    public void delete(String grpComment_Id);
    public GrpCommVO findByPrimaryKey(String grpComment_Id);
    public List<GrpCommVO> getAll();
}
