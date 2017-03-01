package com.grpComm.model;

public class GrpCommService {
	private GrpCommDAO_interface grpcommdao;
	
	public GrpCommService(){
		grpcommdao = new GrpCommDAO();
	}
	
	public GrpCommVO insert(GrpCommVO grpCommVO){
		grpcommdao.insert(grpCommVO);
		return grpCommVO;
	}
	
	public void delete(String grpComment_Id){
		grpcommdao.delete(grpComment_Id);
	}
	
	public void update(GrpCommVO grpCommVO){
		grpcommdao.update(grpCommVO);
	}
	
	
	
}
