package com.hosComm.model;

public class HosCommService {
	private HosCommDAO_interface hoscommdao;
	
	public HosCommService(){
		hoscommdao = new HosCommDAO();
	}
	
	public HosCommVO insert(HosCommVO hosCommVO){
		hoscommdao.insert(hosCommVO);
		return hosCommVO;
	}
	
	public void delete(String hosComment_Id){
		hoscommdao.delete(hosComment_Id);
	}
	
	public void update(HosCommVO hosCommVO){
		hoscommdao.update(hosCommVO);
	}
	
	
	
}
