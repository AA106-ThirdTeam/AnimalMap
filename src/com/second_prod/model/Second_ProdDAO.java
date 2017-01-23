package com.second_prod.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:二手商品<br>
 *	英文:second_Prod<br>
 */ 
public class Second_ProdDAO implements Second_ProdDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (second_Prod_Id,mem_Id,second_Prod_Title,second_Prod_Content,second_Prod_adp_start_date,second_Prod_adp_end_date,second_Prod_adp_upDate,second_Prod_adp_city,second_Prod_Town,second_Prod_Road,second_Prod_Lon,second_Prod_Lat ) VALUES  ( second_Prod_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE second_Prod SET second_Prod_Title=?,second_Prod_Content=? ,second_Prod_adp_start_date=? ,second_Prod_adp_end_date=? ,second_Prod_adp_upDate=? ,second_Prod_adp_city=? ,second_Prod_Town=? ,second_Prod_Road=? ,second_Prod_Lon=? ,second_Prod_Lat=?  WHERE second_Prod_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM second_Prod WHERE second_Prod_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT second_Prod_Id,mem_Id,second_Prod_Title,second_Prod_Content,to_char(second_Prod_adp_start_date,'yyyy-mm-dd') second_Prod_adp_start_date,to_char(second_Prod_adp_end_date,'yyyy-mm-dd') second_Prod_adp_end_date,to_char(second_Prod_adp_upDate,'yyyy-mm-dd') second_Prod_adp_upDate,second_Prod_adp_city,second_Prod_Town,second_Prod_Road,second_Prod_Lon,second_Prod_Lat WHERE second_Prod_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT second_Prod_Id,mem_Id,second_Prod_Title,second_Prod_Content,to_char(second_Prod_adp_start_date,'yyyy-mm-dd') second_Prod_adp_start_date,to_char(second_Prod_adp_end_date,'yyyy-mm-dd') second_Prod_adp_end_date,to_char(second_Prod_adp_upDate,'yyyy-mm-dd') second_Prod_adp_upDate,second_Prod_adp_city,second_Prod_Town,second_Prod_Road,second_Prod_Lon,second_Prod_Lat WHERE second_Prod_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_SECOND_PROD_TITLE =" UPDATE second_Prod set SECOND_PROD_TITLE=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_CONTENT =" UPDATE second_Prod set SECOND_PROD_CONTENT=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ADP_START_DATE =" UPDATE second_Prod set SECOND_PROD_ADP_START_DATE=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ADP_END_DATE =" UPDATE second_Prod set SECOND_PROD_ADP_END_DATE=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ADP_UPDATE =" UPDATE second_Prod set SECOND_PROD_ADP_UPDATE=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ADP_CITY =" UPDATE second_Prod set SECOND_PROD_ADP_CITY=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_TOWN =" UPDATE second_Prod set SECOND_PROD_TOWN=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_ROAD =" UPDATE second_Prod set SECOND_PROD_ROAD=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_LON =" UPDATE second_Prod set SECOND_PROD_LON=?  WHERE second_Prod_Id=? " ; 
	private static final String UPDATE_SECOND_PROD_LAT =" UPDATE second_Prod set SECOND_PROD_LAT=?  WHERE second_Prod_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Second_ProdVO aSecond_ProdVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdDAO.INSERT_STMT);
			pstmt.setString (1, aSecond_ProdVO.getMem_Id());
			pstmt.setString (2, aSecond_ProdVO.getSecond_Prod_Title());
			pstmt.setString (3, aSecond_ProdVO.getSecond_Prod_Content());
			pstmt.setDate (4, aSecond_ProdVO.getSecond_Prod_adp_start_date());
			pstmt.setDate (5, aSecond_ProdVO.getSecond_Prod_adp_end_date());
			pstmt.setDate (6, aSecond_ProdVO.getSecond_Prod_adp_upDate());
			pstmt.setString (7, aSecond_ProdVO.getSecond_Prod_adp_city());
			pstmt.setString (8, aSecond_ProdVO.getSecond_Prod_Town());
			pstmt.setString (9, aSecond_ProdVO.getSecond_Prod_Road());
			pstmt.setDouble (10, aSecond_ProdVO.getSecond_Prod_Lon());
			pstmt.setDouble (11, aSecond_ProdVO.getSecond_Prod_Lat());
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
	public void update(Second_ProdVO aSecond_ProdVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdDAO.UPDATE);
			pstmt.setString (1, aSecond_ProdVO.getSecond_Prod_Title());
			pstmt.setString (2, aSecond_ProdVO.getSecond_Prod_Content());
			pstmt.setDate (3, aSecond_ProdVO.getSecond_Prod_adp_start_date());
			pstmt.setDate (4, aSecond_ProdVO.getSecond_Prod_adp_end_date());
			pstmt.setDate (5, aSecond_ProdVO.getSecond_Prod_adp_upDate());
			pstmt.setString (6, aSecond_ProdVO.getSecond_Prod_adp_city());
			pstmt.setString (7, aSecond_ProdVO.getSecond_Prod_Town());
			pstmt.setString (8, aSecond_ProdVO.getSecond_Prod_Road());
			pstmt.setDouble (9, aSecond_ProdVO.getSecond_Prod_Lon());
			pstmt.setDouble (10, aSecond_ProdVO.getSecond_Prod_Lat());
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
	public void delete(String  aSecond_Prod){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdDAO.DELETE);
			pstmt.setString (1,aSecond_Prod);
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
	public Second_ProdVO findByPrimaryKey(String  aSecond_Prod){
	Second_ProdVO second_prodVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdDAO.DELETE);
			pstmt.setString (1,aSecond_Prod);
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
		return second_prodVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Second_ProdVO> getAll(){ 
		List<Second_ProdVO> list = new ArrayList<Second_ProdVO>();
		Second_ProdVO second_prodVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Second_ProdDAO.DELETE);
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