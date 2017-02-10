package com.res_ponse.model;

import java.util.*; 

public interface Res_ponseDAO_interface {
	public void insert(Res_ponseVO res_ponseVO);
	public void update(Res_ponseVO res_ponseVO);
    public void delete(String res_Id);
	public Res_ponseVO findByPrimaryKey(String res_Id);
	public List<Res_ponseVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Res_ponseVO> getAll(Map<String, String[]> map);

    //查詢某討論區留言的會員編號(發文者)(一對多)(回傳 Set)
    public Set<Res_ponseVO> getRes_ponsesByMem_Id(String mem_Id);

    //查詢某討論區留言的文章編號(一對多)(回傳 Set)
    public Set<Res_ponseVO> getRes_ponsesByPost_Id(String post_Id);
}
