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
public class ParkDAO implements ParkDAO_interface{
	private static DataSource ds = null; 
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO (park_Id,emp_Id,park_title,park_content,park_pic,adp_start_date,adp_upDate,adp_city,park_town,park_road,park_lon,park_lat ) VALUES  ( park_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE park SET park_title=?,park_content=? ,park_pic=? ,adp_start_date=? ,adp_upDate=? ,adp_city=? ,park_town=? ,park_road=? ,park_lon=? ,park_lat=?  WHERE park_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM park WHERE park_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT park_Id,emp_Id,park_title,park_content,park_pic,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date,to_char(adp_upDate,'yyyy-mm-dd') adp_upDate,adp_city,park_town,park_road,park_lon,park_lat WHERE park_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT park_Id,emp_Id,park_title,park_content,park_pic,to_char(adp_start_date,'yyyy-mm-dd') adp_start_date,to_char(adp_upDate,'yyyy-mm-dd') adp_upDate,adp_city,park_town,park_road,park_lon,park_lat WHERE park_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_PARK_TITLE =" UPDATE park set PARK_TITLE=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_CONTENT =" UPDATE park set PARK_CONTENT=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_PIC =" UPDATE park set PARK_PIC=?  WHERE park_Id=? " ; 
	private static final String UPDATE_ADP_START_DATE =" UPDATE park set ADP_START_DATE=?  WHERE park_Id=? " ; 
	private static final String UPDATE_ADP_UPDATE =" UPDATE park set ADP_UPDATE=?  WHERE park_Id=? " ; 
	private static final String UPDATE_ADP_CITY =" UPDATE park set ADP_CITY=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_TOWN =" UPDATE park set PARK_TOWN=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_ROAD =" UPDATE park set PARK_ROAD=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_LON =" UPDATE park set PARK_LON=?  WHERE park_Id=? " ; 
	private static final String UPDATE_PARK_LAT =" UPDATE park set PARK_LAT=?  WHERE park_Id=? " ; 
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
		return parkVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<ParkVO> getAll(){ 
		List<ParkVO> list = new ArrayList<ParkVO>();
		ParkVO parkVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ParkDAO.DELETE);
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
		return list;	} 
}