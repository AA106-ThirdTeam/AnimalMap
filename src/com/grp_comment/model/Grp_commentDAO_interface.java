package com.grp_comment.model;

import java.util.*; 

public interface Grp_commentDAO_interface {
	public void insert(Grp_commentVO grp_commentVO);
	public void update(Grp_commentVO grp_commentVO);
    public void delete(String grpComment_Id);
	public Grp_commentVO findByPrimaryKey(String grpComment_Id);
	public List<Grp_commentVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Grp_commentVO> getAll(Map<String, String[]> map);

    //查詢某揪團留言的發送會員編號(一對多)(回傳 Set)
    public Set<Grp_commentVO> getGrp_commentsByMem_Id(String grpComment_MemId);

    //查詢某揪團留言的揪團編號(一對多)(回傳 Set)
    public Set<Grp_commentVO> getGrp_commentsByGrp_Id(String grpComment_GrpId);
}
