package com.report.model;

import java.util.List;


public class ReportService  {
	
	private ReportDAO_interface dao;

	public ReportService() {
		dao = new ReportDAO();
	
	}

	public ReportVO insert(String report_name,String report_class,String report_class_No,String report_class_No_value,String report_content,String report_status,String mem_Id_active,String mem_Id_passive,java.sql.Date report_time,String report_class_status)
	{
	
		ReportVO reportVO=new ReportVO();
		reportVO.setReport_name(report_name);
		reportVO.setReport_class(report_class);
		reportVO.setReport_class_No(report_class_No);
		reportVO.setReport_class_No_value(report_class_No_value);
		reportVO.setReport_class_status(report_class_status);
		reportVO.setReport_content(report_content);
		reportVO.setReport_status(report_status);	
		reportVO.setMem_Id_active(mem_Id_active);
		reportVO.setMem_Id_passive(mem_Id_passive);
		reportVO.setReport_time(report_time);
		dao.insert(reportVO);
		
		
		return reportVO;
	}
	
	
		public ReportVO updateStatus( String report_No,String report_status){
			
		
		ReportVO reportVO=new ReportVO();
		reportVO.setReport_No(report_No);
		reportVO.setReport_status(report_status);
		dao.update(reportVO);
		return reportVO;
	
	}
	
		public List<ReportVO> getAll() {
			return dao.getAll();
		}
	
	   public void delete(String report_No){
		    dao.delete(report_No);
	   }
	   
	   public ReportVO update_Object(String report_class,String report_class_No,String report_class_No_value,String report_class_status ){
		   
		   ReportVO reportVO=new ReportVO();
		   reportVO.setReport_class(report_class);
		   reportVO.setReport_class_No(report_class_No);
		   reportVO.setReport_class_No_value(report_class_No_value);		   
		   reportVO.setReport_class_status(report_class_status);		   
		   dao.update_front_status(reportVO);
		
		   return reportVO;
	   }
}
