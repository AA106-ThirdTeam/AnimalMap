package com.emg_H.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.emg_H_Msg.model.Emg_H_MsgVO;




public interface Emg_HDAO_interface{

	//insert 進去後  回傳一個PK值
	 public Emg_HVO insert(Emg_HVO emg_HVO);  
     public void delete(String emg_H_Id);     
     public Emg_HVO findByPrimaryKey(String emg_H_Id);
     public List<Emg_HVO> getAll();
     
     //查求救留言透過求救編號 (一對多)
      public Set<Emg_H_MsgVO> getEmg_H_MsgByEmg_H_Id(String emg_H_Id);
     
}
