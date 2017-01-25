package com.anihome_photos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:動物之家相簿<br>
 *	英文:aniHome_Photos<br>
 */ 
public class AniHome_PhotosJDBCDAO implements AniHome_PhotosDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO aniHome_Photos (aniHome_Photos_Id,aniHome_Id,aniHome_Photos_pic ) VALUES  ( aniHome_Photos_seq1.nextval , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE aniHome_Photos SET aniHome_Photos_pic=? WHERE aniHome_Photos_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM aniHome_Photos WHERE aniHome_Photos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT aniHome_Photos_Id,aniHome_Id,aniHome_Photos_pic WHERE aniHome_Photos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT aniHome_Photos_Id,aniHome_Id,aniHome_Photos_pic WHERE aniHome_Photos_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(AniHome_PhotosVO aAniHome_PhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_PhotosDAO.INSERT_STMT);
			pstmt.setString (1, aAniHome_PhotosVO.getAniHome_Id());
			pstmt.setBytes (2, aAniHome_PhotosVO.getAniHome_Photos_pic());
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
	public void update(AniHome_PhotosVO aAniHome_PhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_PhotosDAO.UPDATE);
			pstmt.setBytes (1, aAniHome_PhotosVO.getAniHome_Photos_pic());
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
	public void delete(String  aAniHome_Photos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_PhotosDAO.DELETE);
			pstmt.setString (1,aAniHome_Photos);
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
	public AniHome_PhotosVO findByPrimaryKey(String  aAniHome_Photos){
		AniHome_PhotosVO anihome_photosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AniHome_PhotosDAO.GET_ONE_STMT);
			pstmt.setString (1,aAniHome_Photos);
			pstmt.executeUpdate();
			while (rs.next()) {
				anihome_photosVO = new AniHome_PhotosVO();
				anihome_photosVO.setAniHome_Photos_Id(rs.getString("aniHome_Photos_Id"));
				anihome_photosVO.setAniHome_Id(rs.getString("aniHome_Id"));
				anihome_photosVO.setAniHome_Photos_pic(rs.getBytes("aniHome_Photos_pic"));
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
		return anihome_photosVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<AniHome_PhotosVO> getAll(){ 
		List<AniHome_PhotosVO> list = new ArrayList<AniHome_PhotosVO>();
		AniHome_PhotosVO anihome_photosVO = null;
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