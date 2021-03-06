package com.purview.model;

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
import javax.sql.*;

import com.emp.model.EmpVO;

public class PurviewDAOJDBC implements PurviewDAO_interface {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "AA106";
	String passwd = "aa106";
	
	
	private static final String INSERT_STMT =
			"INSERT INTO purview (purview_No,purview_name) VALUES (purview_seq1.NEXTVAL, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT purview_No,purview_name from purview order by purview_No";
	private static final String GET_ONE_STMT = 
			"SELECT purview_No,purview_name from purview  where purview_No = ?";
	
	private static final String DELETE_EMP_PURVIEW = 
			"DELETE FROM emp_purview where purview_No = ?";
	private static final String DELETE_PURVIEW = 
			"DELETE FROM purview where purview_No = ?";
		
	
	
	

	@Override
	public void insert(PurviewVO purviewVO) {
		// TODO Auto-generated method stub
		
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			 pstmt=con.prepareStatement(INSERT_STMT);
			  	
		  	
			  	pstmt.setString(1, purviewVO.getPurview_name());				
			
				pstmt.executeUpdate();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
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
	public void delete(String purview_No) {
		// TODO Auto-generated method stub
		
		int updateCount_EmgMsg = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			// 1●設定於 pstm.executeUpdate()之前
						con.setAutoCommit(false);

						// 先刪除 權限明細Table權限編號
						pstmt = con.prepareStatement(DELETE_EMP_PURVIEW);
						pstmt.setString(1, purview_No);
						updateCount_EmgMsg = pstmt.executeUpdate();
						// 再刪除權限名稱Table權限編號
						pstmt = con.prepareStatement(DELETE_PURVIEW);
						pstmt.setString(1, purview_No);
						pstmt.executeUpdate();

						// 2●設定於 pstm.executeUpdate()之後
						con.commit();
						con.setAutoCommit(true);
						System.out.println("刪除權限名稱 " + purview_No + " 時,權限明細 " + updateCount_EmgMsg + " 同時被刪除");

			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} catch (ClassNotFoundException e) {
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
	public PurviewVO findByPrimaryKey(String purview_No) {
		// TODO Auto-generated method stub
		
		PurviewVO purviewVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
		  	pstmt=con.prepareStatement(GET_ONE_STMT);


			pstmt.setString(1, purview_No);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				purviewVO = new PurviewVO();
				purviewVO.setPurview_No(rs.getString("purview_No"));
				purviewVO.setPurview_name(rs.getString("purview_name"));
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
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
		return purviewVO;
	}

	@Override
	public List<PurviewVO> getAll() {
		// TODO Auto-generated method stub
		List<PurviewVO> list = new ArrayList<PurviewVO>();
		PurviewVO purviewVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
		  	pstmt=con.prepareStatement(GET_ALL_STMT);
		  	rs=pstmt.executeQuery();
		  	
			while (rs.next()) {

				purviewVO = new PurviewVO();
				purviewVO.setPurview_No(rs.getString("purview_No"));
				purviewVO.setPurview_name(rs.getString("purview_name"));
				list.add(purviewVO);

			}

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// insert 
		PurviewDAOJDBC dao=new PurviewDAOJDBC();
		
//		PurviewVO purviewVO=new PurviewVO();
//		purviewVO.setPurview_name("管理訊息");
//		dao.insert(purviewVO);
		
//		//delete
//		dao.delete("15008");
//		
		//getOne
//		PurviewVO purviewVO2=dao.findByPrimaryKey("15000");
//		System.out.println(purviewVO2.getPurview_No());
//		System.out.println(purviewVO2.getPurview_name());
//		
//		//getAll
//		List<PurviewVO> list=dao.getAll();
//		for(PurviewVO aPurview:list){
//			System.out.println(aPurview.getPurview_No());
//			System.out.println(aPurview.getPurview_name());
//			System.out.println("---------------------------------------");
//		}
//		
		
		
		
	}

}
