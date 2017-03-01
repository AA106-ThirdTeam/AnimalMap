package com.report.model;

import java.util.List;

public interface ReportDAO_interface {

	
	public void insert (ReportVO reportVO);
	public void update (ReportVO reportVO);
	public  void delete (String report_No);
	
	public void update_front_status (ReportVO reportVO);
	
	public List<ReportVO> getAll();
	
	
}
