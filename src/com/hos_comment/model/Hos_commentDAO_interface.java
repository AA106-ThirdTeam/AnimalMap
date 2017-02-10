package com.hos_comment.model;

import java.util.*; 

public interface Hos_commentDAO_interface {
	public void insert(Hos_commentVO hos_commentVO);
	public void update(Hos_commentVO hos_commentVO);
    public void delete(String hosComment_Id);
	public Hos_commentVO findByPrimaryKey(String hosComment_Id);
	public List<Hos_commentVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Hos_commentVO> getAll(Map<String, String[]> map);

    //查詢某診所留言的發送會員編號(一對多)(回傳 Set)
    public Set<Hos_commentVO> getHos_commentsByMem_Id(String hosComment_MemId);

    //查詢某診所留言的診所編號(一對多)(回傳 Set)
    public Set<Hos_commentVO> getHos_commentsByHos_Id(String hosComment_HosId);
}
