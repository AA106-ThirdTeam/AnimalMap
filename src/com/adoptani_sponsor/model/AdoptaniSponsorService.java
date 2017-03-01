package com.adoptani_sponsor.model;

import java.util.List;

/**負責調派DAO**/

public class AdoptaniSponsorService {
	
	private AdoptaniSponsorDAO_interface dao;
	
	public AdoptaniSponsorService(){
		dao = new AdoptaniSponsorJNDIDAO();
	}
	
	public AdoptaniSponsorVO addAdoptaniSponsor(String adopt_Ani_Id, String Mem_Id, Integer ado_Ani_Spo_money, String ado_Ani_Spo_thing ){
		
		AdoptaniSponsorVO adoptaniSponsorVO = new AdoptaniSponsorVO();
		
//		adoptaniVO.setAdopt_Ani_Id(Adopt_Ani_Id);
		
		adoptaniSponsorVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adoptaniSponsorVO.setMem_Id(Mem_Id);
		adoptaniSponsorVO.setAdo_Ani_Spo_thing(ado_Ani_Spo_thing) ;
		adoptaniSponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money) ;

		
		dao.insert(adoptaniSponsorVO);
		
		return adoptaniSponsorVO;
	}
	
	/**修改
	 * @param Ado_Ani_Mes_No:傳入訊息編號，辨識要更改哪一筆留言。
	 * @param Ado_Ani_Mes:欲更改留言內容
	 * @return adoptaniMessageVO 物件
	 * **/
	
	public AdoptaniSponsorVO updateAdoptaniSponsor(String ado_Ani_Spo_No, String adopt_Ani_Id, String Mem_Id, Integer ado_Ani_Spo_money, String ado_Ani_Spo_thing){
		
		AdoptaniSponsorVO adoptaniSponsorVO = new AdoptaniSponsorVO();
		adoptaniSponsorVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adoptaniSponsorVO.setMem_Id(Mem_Id);
		adoptaniSponsorVO.setAdo_Ani_Spo_thing(ado_Ani_Spo_thing) ;
		adoptaniSponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money) ;
		adoptaniSponsorVO.setAdo_Ani_Spo_No(ado_Ani_Spo_No) ;
		dao.update(adoptaniSponsorVO);
		
		return adoptaniSponsorVO;
	}
	
	public void deleteAdoptaniSponsor(String ado_Ani_Spo_No){
		dao.delete(ado_Ani_Spo_No);
		
	}
	public AdoptaniSponsorVO getOneAdoptaniSponsor(String ado_Ani_Spo_No){
		return dao.findByPrimaryKey(ado_Ani_Spo_No);
	}
	
	public List<AdoptaniSponsorVO> getOneAdoptaniAllSponsor(String Adopt_Ani_Id){
		return dao.getOneAllSponsor(Adopt_Ani_Id);
	}
	
	public List<AdoptaniSponsorVO> getAllSponsor() {
		return dao.getAll();
	}
	
	public Integer getOneAllMoney(String Adopt_Ani_Id) {
		return dao.getOneAllSponsorMoney(Adopt_Ani_Id);
	}
	
}
