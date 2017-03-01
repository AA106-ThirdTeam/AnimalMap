package com.purview.model;

import java.util.List;

public class PurviewService {

	public PurviewDAO_interface dao;
	
	public PurviewService() {
		dao = new PurviewDAO();
	}
	
	public PurviewVO addPurview( String purview_name) {

		PurviewVO purviewVO = new PurviewVO();

	
		purviewVO.setPurview_name(purview_name);
				
		dao.insert(purviewVO);

		return purviewVO;
	}
	
	public void deletePurview(String purview_No) {
		dao.delete(purview_No);
	}

	public PurviewVO getOnePurview(String purview_No) {
		return dao.findByPrimaryKey(purview_No);
	}

	public List<PurviewVO> getAll() {
		return dao.getAll();
	}
	
}
