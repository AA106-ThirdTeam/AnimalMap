package com.anihome.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:動物之家<br>
 *	英文:aniHome<br>
 */ 
public class AniHomeDAO implements AniHomeDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (aniHome_Id,mem_Id,aniHome_title,aniHome_content,aniHome_start_date,aniHome_upDate,aniHome_city,aniHome_town,aniHome_road,aniHome_lon,aniHome_lat ) VALUES  ( aniHome_seq1.nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE aniHome SET aniHome_title=?,aniHome_content=? ,aniHome_start_date=? ,aniHome_upDate=? ,aniHome_city=? ,aniHome_town=? ,aniHome_road=? ,aniHome_lon=? ,aniHome_lat=?  WHERE aniHome_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM aniHome WHERE aniHome_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT aniHome_Id,mem_Id,aniHome_title,aniHome_content,to_char(aniHome_start_date,'yyyy-mm-dd') aniHome_start_date,to_char(aniHome_upDate,'yyyy-mm-dd') aniHome_upDate,aniHome_city,aniHome_town,aniHome_road,aniHome_lon,aniHome_lat WHERE aniHome_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT aniHome_Id,mem_Id,aniHome_title,aniHome_content,to_char(aniHome_start_date,'yyyy-mm-dd') aniHome_start_date,to_char(aniHome_upDate,'yyyy-mm-dd') aniHome_upDate,aniHome_city,aniHome_town,aniHome_road,aniHome_lon,aniHome_lat WHERE aniHome_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_ANIHOME_TITLE =" UPDATE aniHome set ANIHOME_TITLE=?  WHERE aniHome_Id=? " ; 
	private static final String UPDATE_ANIHOME_CONTENT =" UPDATE aniHome set ANIHOME_CONTENT=?  WHERE aniHome_Id=? " ; 
	private static final String UPDATE_ANIHOME_START_DATE =" UPDATE aniHome set ANIHOME_START_DATE=?  WHERE aniHome_Id=? " ; 
	private static final String UPDATE_ANIHOME_UPDATE =" UPDATE aniHome set ANIHOME_UPDATE=?  WHERE aniHome_Id=? " ; 
	private static final String UPDATE_ANIHOME_CITY =" UPDATE aniHome set ANIHOME_CITY=?  WHERE aniHome_Id=? " ; 
	private static final String UPDATE_ANIHOME_TOWN =" UPDATE aniHome set ANIHOME_TOWN=?  WHERE aniHome_Id=? " ; 
	private static final String UPDATE_ANIHOME_ROAD =" UPDATE aniHome set ANIHOME_ROAD=?  WHERE aniHome_Id=? " ; 
	private static final String UPDATE_ANIHOME_LON =" UPDATE aniHome set ANIHOME_LON=?  WHERE aniHome_Id=? " ; 
	private static final String UPDATE_ANIHOME_LAT =" UPDATE aniHome set ANIHOME_LAT=?  WHERE aniHome_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(AniHomeVO aAniHomeVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHomeDAO.INSERT_STMT);
			pstmt.setString (1, aAniHomeVO.getMem_Id());
			pstmt.setString (2, aAniHomeVO.getAniHome_title());
			pstmt.setString (3, aAniHomeVO.getAniHome_content());
			pstmt.setDate (4, aAniHomeVO.getAniHome_start_date());
			pstmt.setDate (5, aAniHomeVO.getAniHome_upDate());
			pstmt.setString (6, aAniHomeVO.getAniHome_city());
			pstmt.setString (7, aAniHomeVO.getAniHome_town());
			pstmt.setString (8, aAniHomeVO.getAniHome_road());
			pstmt.setDouble (9, aAniHomeVO.getAniHome_lon());
			pstmt.setDouble (10, aAniHomeVO.getAniHome_lat());
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
	public void update(AniHomeVO aAniHomeVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHomeDAO.UPDATE);
			pstmt.setString (1, aAniHomeVO.getAniHome_title());
			pstmt.setString (2, aAniHomeVO.getAniHome_content());
			pstmt.setDate (3, aAniHomeVO.getAniHome_start_date());
			pstmt.setDate (4, aAniHomeVO.getAniHome_upDate());
			pstmt.setString (5, aAniHomeVO.getAniHome_city());
			pstmt.setString (6, aAniHomeVO.getAniHome_town());
			pstmt.setString (7, aAniHomeVO.getAniHome_road());
			pstmt.setDouble (8, aAniHomeVO.getAniHome_lon());
			pstmt.setDouble (9, aAniHomeVO.getAniHome_lat());
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
	public void delete(String  aAniHome){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHomeDAO.DELETE);
			pstmt.setString (1,aAniHome);
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
	public AniHomeVO findByPrimaryKey(String  aAniHome){
	AniHomeVO anihomeVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHomeDAO.DELETE);
			pstmt.setString (1,aAniHome);
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
		return anihomeVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<AniHomeVO> getAll(){ 
		List<AniHomeVO> list = new ArrayList<AniHomeVO>();
		AniHomeVO anihomeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHomeDAO.DELETE);
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