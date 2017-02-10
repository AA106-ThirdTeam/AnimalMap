package com.rel_list.model;

import java.util.*; 

public interface Rel_ListDAO_interface {
	public void insert(Rel_ListVO rel_listVO);
	public void update(Rel_ListVO rel_listVO);
    public void delete_By_rel_MemId(String rel_MemId);
	public Rel_ListVO findByPrimaryKey_By_rel_MemId(String rel_MemId);
    public void delete_By_added_MemId(String added_MemId);
	public Rel_ListVO findByPrimaryKey_By_added_MemId(String added_MemId);
	public List<Rel_ListVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Rel_ListVO> getAll(Map<String, String[]> map);

    //查詢某關係名單的會員編號(一對多)(回傳 Set)
    public Set<Rel_ListVO> getRel_ListsByMem_Id(String rel_MemId);

    //查詢某關係名單的被加會員編號(一對多)(回傳 Set)
    public Set<Rel_ListVO> getRel_ListsByMem_Id2(String added_MemId);
}
