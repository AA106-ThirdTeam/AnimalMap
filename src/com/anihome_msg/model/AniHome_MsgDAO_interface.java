package com.anihome_msg.model;

import java.util.*; 

public interface AniHome_MsgDAO_interface {
	public void insert(AniHome_MsgVO anihome_msgVO);
	public void update(AniHome_MsgVO anihome_msgVO);
    public void delete(String aniHome_Msg_Id);
	public AniHome_MsgVO findByPrimaryKey(String aniHome_Msg_Id);
	public List<AniHome_MsgVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<AniHome_MsgVO> getAll(Map<String, String[]> map);

    //查詢某動物之家留言的動物之家編號(一對多)(回傳 Set)
    public Set<AniHome_MsgVO> getAniHome_MsgsByAniHome_Id(String aniHome_Id);

    //查詢某動物之家留言的留言會員編號(一對多)(回傳 Set)
    public Set<AniHome_MsgVO> getAniHome_MsgsByMem_Id(String mem_Id);
}
