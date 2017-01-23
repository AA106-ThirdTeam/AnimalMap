package com.anihome_msg.model;

import java.util.*; 

public interface AniHome_MsgDAO_interface {
	public void insert(AniHome_MsgVO anihome_msgVO);
	public void update(AniHome_MsgVO anihome_msgVO);
	public void delete(String aniHome_Msg_Id);
	public AniHome_MsgVO findByPrimaryKey(String aniHome_Msg_Id);
	public List<AniHome_MsgVO> getAll();
}