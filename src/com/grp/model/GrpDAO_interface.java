package com.grp.model;

import java.util.List;
import java.util.Set;

import com.grpComm.model.GrpCommVO;
import com.hosComm.model.HosCommVO;

public interface GrpDAO_interface {
	public void insert(GrpVO grpVO);
    public void update(GrpVO grpVO);
    public void delete(String grp_Id);
    public GrpVO findByPrimaryKey(String grp_Id);
    public List<GrpVO> getAll();
    public Set<GrpCommVO> getCommentsByGrpId(String grp_Id);
}
