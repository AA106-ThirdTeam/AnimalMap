package com.adpphotos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:領養活動相簿<br>
 *	英文:adpPhotos<br>
 */ 
public class AdpPhotosJDBCDAO implements AdpPhotosDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";
	//====以下是一般指令====
	public static final String INSERT_STMT = "INSERT INTO adpPhotos (adpPhotos_Id,adp_Id,adpPhotosPic ) VALUES  ( adpPhotos_seq1.nextval , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adpPhotos SET adp_Id=?,adpPhotosPic=?  WHERE adpPhotos_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adpPhotos WHERE adpPhotos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT adpPhotos_Id,adp_Id,adpPhotosPic WHERE adpPhotos_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT adpPhotos_Id,adp_Id,adpPhotosPic WHERE adpPhotos_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(AdpPhotosVO aAdpPhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpPhotosDAO.INSERT_STMT);
			pstmt.setString (1, aAdpPhotosVO.getAdp_Id());
			pstmt.setBytes (2, aAdpPhotosVO.getAdpPhotosPic());
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
	public void update(AdpPhotosVO aAdpPhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpPhotosDAO.UPDATE);
			pstmt.setString (1, aAdpPhotosVO.getAdp_Id());
			pstmt.setBytes (2, aAdpPhotosVO.getAdpPhotosPic());
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
	public void delete(String  aAdpPhotos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpPhotosDAO.DELETE);
			pstmt.setString (1,aAdpPhotos);
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
	public AdpPhotosVO findByPrimaryKey(String  aAdpPhotos){
		AdpPhotosVO adpphotosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AdpPhotosDAO.GET_ONE_STMT);
			pstmt.setString (1,aAdpPhotos);
			pstmt.executeUpdate();
			while (rs.next()) {
				adpphotosVO = new AdpPhotosVO();
				adpphotosVO.setAdpPhotos_Id(rs.getString("adpPhotos_Id"));
				adpphotosVO.setAdp_Id(rs.getString("adp_Id"));
				adpphotosVO.setAdpPhotosPic(rs.getBytes("adpPhotosPic"));
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
		return adpphotosVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<AdpPhotosVO> getAll(){ 
		List<AdpPhotosVO> list = new ArrayList<AdpPhotosVO>();
		AdpPhotosVO adpphotosVO = null;
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