package com.hosphoto.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:診所相片<br>
 *	英文:hosPhoto<br>
 */ 
public class HosPhotoDAO implements HosPhotoDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (hosPhoto_Id,hosPhoto_HosId,hosPhoto_photo,isDisp_HosPhoto,hosPhoto_name,hosPhoto_extent ) VALUES  ( hosPhoto_seq1.nextval , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE hosPhoto SET hosPhoto_photo=?,isDisp_HosPhoto=? ,hosPhoto_name=? ,hosPhoto_extent=?  WHERE hosPhoto_Id=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM hosPhoto WHERE hosPhoto_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT hosPhoto_Id,hosPhoto_HosId,hosPhoto_photo,isDisp_HosPhoto,hosPhoto_name,hosPhoto_extent WHERE hosPhoto_Id=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT hosPhoto_Id,hosPhoto_HosId,hosPhoto_photo,isDisp_HosPhoto,hosPhoto_name,hosPhoto_extent WHERE hosPhoto_Id=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_HOSPHOTO_PHOTO =" UPDATE hosPhoto set HOSPHOTO_PHOTO=?  WHERE hosPhoto_Id=? " ; 
	private static final String UPDATE_ISDISP_HOSPHOTO =" UPDATE hosPhoto set ISDISP_HOSPHOTO=?  WHERE hosPhoto_Id=? " ; 
	private static final String UPDATE_HOSPHOTO_NAME =" UPDATE hosPhoto set HOSPHOTO_NAME=?  WHERE hosPhoto_Id=? " ; 
	private static final String UPDATE_HOSPHOTO_EXTENT =" UPDATE hosPhoto set HOSPHOTO_EXTENT=?  WHERE hosPhoto_Id=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(HosPhotoVO aHosPhotoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(HosPhotoDAO.INSERT_STMT);
			pstmt.setString (1, aHosPhotoVO.getHosPhoto_HosId());
			pstmt.setBytes (2, aHosPhotoVO.getHosPhoto_photo());
			pstmt.setString (3, aHosPhotoVO.getIsDisp_HosPhoto());
			pstmt.setString (4, aHosPhotoVO.getHosPhoto_name());
			pstmt.setString (5, aHosPhotoVO.getHosPhoto_extent());
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
	public void update(HosPhotoVO aHosPhotoVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(HosPhotoDAO.UPDATE);
			pstmt.setBytes (1, aHosPhotoVO.getHosPhoto_photo());
			pstmt.setString (2, aHosPhotoVO.getIsDisp_HosPhoto());
			pstmt.setString (3, aHosPhotoVO.getHosPhoto_name());
			pstmt.setString (4, aHosPhotoVO.getHosPhoto_extent());
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
	public void delete(String  aHosPhoto){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(HosPhotoDAO.DELETE);
			pstmt.setString (1,aHosPhoto);
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
	public HosPhotoVO findByPrimaryKey(String  aHosPhoto){
	HosPhotoVO hosphotoVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(HosPhotoDAO.DELETE);
			pstmt.setString (1,aHosPhoto);
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
		return hosphotoVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<HosPhotoVO> getAll(){ 
		List<HosPhotoVO> list = new ArrayList<HosPhotoVO>();
		HosPhotoVO hosphotoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(HosPhotoDAO.DELETE);
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