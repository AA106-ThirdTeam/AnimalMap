package com.grp.model;

import java.util.List;
import java.util.Set;

import com.grpComm.model.GrpCommVO;
import com.hosComm.model.HosCommVO;
import com.joinlist.model.JoinListVO;

public interface GrpDAO_interface {
	public GrpVO insert(GrpVO grpVO);
    public void update(GrpVO grpVO);
    public void delete(String grp_Id);
    public GrpVO findByPrimaryKey(String grp_Id);
    public List<GrpVO> getAll();
    public Set<GrpCommVO> getCommentsByGrpId(String grp_Id);

    public Set<JoinListVO> getJoinListByGrpId(String grp_Id);
    public Set<JoinListVO> getJoinListByMemId(String mem_Id);
	public int get_count_By_joinList_GrpId(String joinList_GrpId);

}
