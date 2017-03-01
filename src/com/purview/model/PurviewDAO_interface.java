

package com.purview.model;

import java.util.List;

public interface PurviewDAO_interface {
	
	public void insert (PurviewVO purviewVO);
	public void delete (String purview_No);
	public PurviewVO findByPrimaryKey(String purview_No);
	public List<PurviewVO> getAll();
	
	
}
