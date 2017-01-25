package com.park.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:公園<br>
 *	英文:park<br>
 */ 
public class ParkJDBCDAO implements ParkDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO park (park_Id,emp_Id,park_title,park_content,park_pic,adp_start_date,adp_upDate,adp_city,park_town,park_road,park_lon,park_lat ) VALUES  ( park_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE park SET park_title=?,park_content=? ,park_pic=? ,adp_start_date=? ,adp_upDate=? ,adp_city=? ,park_town=? ,park_road=? ,park_lon=? ,park_lat=?  WHERE park_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM park WHERE park_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT park_Id,emp_Id,park_title,park_content,park_pic,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date,to_char(adp_upDate,'yyyy-mm-dd') adp_upDate,adp_city,park_town,park_road,park_lon,park_lat WHERE park_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT park_Id,emp_Id,park_title,park_content,park_pic,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date,to_char(adp_upDate,'yyyy-mm-dd') adp_upDate,adp_city,park_town,park_road,park_lon,park_lat WHERE park_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(ParkVO aParkVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ParkDAO.INSERT_STMT);
			pstmt.setString (1, aParkVO.getEmp_Id());
			pstmt.setString (2, aParkVO.getPark_title());
			pstmt.setString (3, aParkVO.getPark_content());
			pstmt.setBytes (4, aParkVO.getPark_pic());
			pstmt.setDate (5, aParkVO.getAdp_start_date());
			pstmt.setDate (6, aParkVO.getAdp_upDate());
			pstmt.setString (7, aParkVO.getAdp_city());
			pstmt.setString (8, aParkVO.getPark_town());
			pstmt.setString (9, aParkVO.getPark_road());
			pstmt.setDouble (10, aParkVO.getPark_lon());
			pstmt.setDouble (11, aParkVO.getPark_lat());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	//====以下是改寫update方法====
	@Override
	public void update(ParkVO aParkVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ParkDAO.UPDATE);
			pstmt.setString (1, aParkVO.getPark_title());
			pstmt.setString (2, aParkVO.getPark_content());
			pstmt.setBytes (3, aParkVO.getPark_pic());
			pstmt.setDate (4, aParkVO.getAdp_start_date());
			pstmt.setDate (5, aParkVO.getAdp_upDate());
			pstmt.setString (6, aParkVO.getAdp_city());
			pstmt.setString (7, aParkVO.getPark_town());
			pstmt.setString (8, aParkVO.getPark_road());
			pstmt.setDouble (9, aParkVO.getPark_lon());
			pstmt.setDouble (10, aParkVO.getPark_lat());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	//====以下是改寫delete方法====
	@Override
	public void delete(String  aPark){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ParkDAO.DELETE);
			pstmt.setString (1,aPark);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	//====以下是改寫findByPrimaryKey方法====
	@Override
	public ParkVO findByPrimaryKey(String  aPark){
		ParkVO parkVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ParkDAO.GET_ONE_STMT);
			pstmt.setString (1,aPark);
			pstmt.executeUpdate();
			while (rs.next()) {
				parkVO = new ParkVO();
				parkVO.setPark_Id(rs.getString("park_Id"));
				parkVO.setEmp_Id(rs.getString("emp_Id"));
				parkVO.setPark_title(rs.getString("park_title"));
				parkVO.setPark_content(rs.getString("park_content"));
				parkVO.setPark_pic(rs.getBytes("park_pic"));
				parkVO.setAdp_start_date(rs.getDate("adp_start_date"));
				parkVO.setAdp_upDate(rs.getDate("adp_upDate"));
				parkVO.setAdp_city(rs.getString("adp_city"));
				parkVO.setPark_town(rs.getString("park_town"));
				parkVO.setPark_road(rs.getString("park_road"));
				parkVO.setPark_lon(rs.getDouble("park_lon"));
				parkVO.setPark_lat(rs.getDouble("park_lat"));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return parkVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<ParkVO> getAll(){ 
		List<ParkVO> list = new ArrayList<ParkVO>();
		ParkVO parkVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return list;
	} 
}