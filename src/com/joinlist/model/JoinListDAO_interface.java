package com.joinlist.model;

import java.util.*; 

public interface JoinListDAO_interface {
	public void insert(JoinListVO joinlistVO);
	public void update(JoinListVO joinlistVO);
    public void delete_By_joinList_GrpId(String joinList_GrpId);
	public JoinListVO findByPrimaryKey_By_joinList_GrpId(String joinList_GrpId);
    public void delete_By_joinList_MemId(String joinList_MemId);
	public JoinListVO findByPrimaryKey_By_joinList_MemId(String joinList_MemId);
	public List<JoinListVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<JoinListVO> getAll(Map<String, String[]> map);

    //查詢某揪團參加名單的活動編號(一對多)(回傳 Set)
    public Set<JoinListVO> getJoinListsByGrp_Id(String joinList_GrpId);

    //查詢某揪團參加名單的會員編號(參加者)(一對多)(回傳 Set)
    public Set<JoinListVO> getJoinListsByMem_Id(String joinList_MemId);
}
