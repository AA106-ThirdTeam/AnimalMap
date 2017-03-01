package com.strayani_message.model;

import java.util.List;

/**負責調派DAO**/

public class StrayaniMessageService {
	
	private StrayaniMessageDAO_interface dao;
	
	public StrayaniMessageService(){
		dao = new StrayaniMessageJNDIDAO();
	}
	
	public StrayaniMessageVO addStrayaniMessage(String Stray_Ani_Id, String Mem_Id, String Str_Ani_Mes){
		
		StrayaniMessageVO strayaniMessageVO = new StrayaniMessageVO();
		
//		strayaniVO.setStray_Ani_Id(Stray_Ani_Id);
		
		strayaniMessageVO.setStray_Ani_Id(Stray_Ani_Id);
		strayaniMessageVO.setMem_Id(Mem_Id);
		strayaniMessageVO.setStr_Ani_Mes(Str_Ani_Mes);

		
		dao.insert(strayaniMessageVO);
		
		return strayaniMessageVO;
	}
	
	/**修改
	 * @param Str_Ani_Mes_No:傳入訊息編號，辨識要更改哪一筆留言。
	 * @param Str_Ani_Mes:欲更改留言內容
	 * @return strayaniMessageVO 物件
	 * **/
	
	public StrayaniMessageVO updateStrayaniMessage(String Str_Ani_Mes_No, String Str_Ani_Mes){
		
		StrayaniMessageVO strayaniMessageVO = new StrayaniMessageVO();
		strayaniMessageVO.setStr_Ani_Mes(Str_Ani_Mes);
		strayaniMessageVO.setStr_Ani_Mes_No(Str_Ani_Mes_No);
		
		dao.update(strayaniMessageVO);
		
		return strayaniMessageVO;
	}
	
	public void deleteStrayaniMessage(String Str_Ani_Mes_No){
		dao.delete(Str_Ani_Mes_No);
		
	}
	public StrayaniMessageVO getOneStrayaniMessage(String Str_Ani_Mes_No){
		return dao.findByPrimaryKey(Str_Ani_Mes_No);
	}
	
	public List<StrayaniMessageVO> getOneStrayaniAllMessage(String Stray_Ani_Id){
		return dao.getOneAllMessage(Stray_Ani_Id);
	}
	
	public List<StrayaniMessageVO> getAllMessage() {
		return dao.getAll();
	}
	
}
