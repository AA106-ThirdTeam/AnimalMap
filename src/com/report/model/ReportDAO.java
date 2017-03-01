package com.report.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ReportDAO implements  ReportDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AnimalMapDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
		private static final String INSERT =
			"INSERT INTO report (report_No,report_name,report_class,report_class_No,report_class_No_value,report_content,report_status,mem_Id_active,mem_Id_passive,report_time,report_class_status) VALUES (report_seq1.NEXTVAL, ?, ?, ?,?, ?, ?, ?, ?, ?,?)"; 
		private static final String UPDATE = 
			"UPDATE report set report_status=? where report_No = ?";
		private static final String GET_ALL_STMT =
			"SELECT report_No,report_name,report_class,report_class_No,report_class_No_value,report_content,report_status,mem_Id_active,mem_Id_passive,to_char(report_time,'yyyy-mm-dd') report_time,report_class_status from report order by report_No desc";
		private static final String DELETE =
			"Delete from report where report_No=?";
		
			

	@Override
	public void insert(ReportVO reportVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(INSERT);

		
			pstmt.setString(1, reportVO.getReport_name());
			pstmt.setString(2, reportVO.getReport_class());
			pstmt.setString(3, reportVO.getReport_class_No());
			pstmt.setString(4, reportVO.getReport_class_No_value());			
			pstmt.setString(5, reportVO.getReport_content());
			pstmt.setString(6, reportVO.getReport_status());
			pstmt.setString(7, reportVO.getMem_Id_active());
			pstmt.setString(8, reportVO.getMem_Id_passive());
			pstmt.setDate(9,reportVO.getReport_time());
			pstmt.setString(10,reportVO.getReport_class_status());
			

			pstmt.executeUpdate();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(ReportVO reportVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con=ds.getConnection();			
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, reportVO.getReport_status());
			pstmt.setString(2, reportVO.getReport_No());
			
		
			pstmt.executeQuery();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public List<ReportVO> getAll() {
		// TODO Auto-generated method stub
		List<ReportVO> list = new ArrayList<ReportVO>();
		ReportVO reportVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				reportVO = new ReportVO();
				reportVO.setReport_No(rs.getString("report_No"));
				reportVO.setReport_name(rs.getString("report_name"));
				reportVO.setReport_class(rs.getString("report_class"));
				reportVO.setReport_class_No(rs.getString("report_class_No"));
				reportVO.setReport_class_No_value(rs.getString("report_class_No_value"));
				reportVO.setReport_class_status(rs.getString("report_class_status"));
				reportVO.setReport_content(rs.getString("report_content"));
				reportVO.setReport_status(rs.getString("report_status"));
				reportVO.setMem_Id_active(rs.getString("mem_Id_active"));
				reportVO.setMem_Id_passive(rs.getString("mem_Id_passive"));
				reportVO.setReport_time(rs.getDate("report_time"));
				
				list.add(reportVO);

			}

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;

	}

	public void delete(String report_No) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			
			
			
			con=ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, report_No);

			pstmt.executeQuery();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update_front_status(ReportVO reportVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			String report_class=reportVO.getReport_class();
			String report_class_No=reportVO.getReport_class_No();
			String report_class_No_value=reportVO.getReport_class_No_value();
			String report_class_status=reportVO.getReport_class_status();
			
			//用字串連接 動態Update 其他TABLE 的檢舉狀態列
			StringBuffer delete_front_Object=new StringBuffer();
			delete_front_Object.append("Update "+report_class+" set "+report_class_status+" where "+report_class_No+" = "+report_class_No_value);
			
			con=ds.getConnection();
			
			pstmt = con.prepareStatement(delete_front_Object.toString());
					
			pstmt.executeQuery();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	

}
