package com.adopt_ani_photos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:送養動物相簿<br>
 *	英文:adopt_Ani_photos<br>
 */ 
public class Adopt_Ani_photosDAO implements Adopt_Ani_photosDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (ado_Ani_Pic_No,adopt_Ani_Id,mem_Id,ado_Ani_Pic,ado_Pic_name,ado_Pic_extent,ado_Pic_time,ado_Pic_type ) VALUES  ( adopt_Ani_photos_seq1.nextval , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE adopt_Ani_photos SET ado_Ani_Pic=?,ado_Pic_name=? ,ado_Pic_extent=? ,ado_Pic_time=? ,ado_Pic_type=?  WHERE ado_Ani_Pic_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM adopt_Ani_photos WHERE ado_Ani_Pic_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT ado_Ani_Pic_No,adopt_Ani_Id,mem_Id,ado_Ani_Pic,ado_Pic_name,ado_Pic_extent,to_char(ado_Pic_time,'yyyy-mm-dd') ado_Pic_time,ado_Pic_type WHERE ado_Ani_Pic_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT ado_Ani_Pic_No,adopt_Ani_Id,mem_Id,ado_Ani_Pic,ado_Pic_name,ado_Pic_extent,to_char(ado_Pic_time,'yyyy-mm-dd') ado_Pic_time,ado_Pic_type WHERE ado_Ani_Pic_No=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_ADO_ANI_PIC =" UPDATE adopt_Ani_photos set ADO_ANI_PIC=?  WHERE ado_Ani_Pic_No=? " ; 
	private static final String UPDATE_ADO_PIC_NAME =" UPDATE adopt_Ani_photos set ADO_PIC_NAME=?  WHERE ado_Ani_Pic_No=? " ; 
	private static final String UPDATE_ADO_PIC_EXTENT =" UPDATE adopt_Ani_photos set ADO_PIC_EXTENT=?  WHERE ado_Ani_Pic_No=? " ; 
	private static final String UPDATE_ADO_PIC_TIME =" UPDATE adopt_Ani_photos set ADO_PIC_TIME=?  WHERE ado_Ani_Pic_No=? " ; 
	private static final String UPDATE_ADO_PIC_TYPE =" UPDATE adopt_Ani_photos set ADO_PIC_TYPE=?  WHERE ado_Ani_Pic_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Adopt_Ani_photosVO aAdopt_Ani_photosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_photosDAO.INSERT_STMT);
			pstmt.setString (1, aAdopt_Ani_photosVO.getAdopt_Ani_Id());
			pstmt.setString (2, aAdopt_Ani_photosVO.getMem_Id());
			pstmt.setBytes (3, aAdopt_Ani_photosVO.getAdo_Ani_Pic());
			pstmt.setString (4, aAdopt_Ani_photosVO.getAdo_Pic_name());
			pstmt.setString (5, aAdopt_Ani_photosVO.getAdo_Pic_extent());
			pstmt.setDate (6, aAdopt_Ani_photosVO.getAdo_Pic_time());
			pstmt.setString (7, aAdopt_Ani_photosVO.getAdo_Pic_type());
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
	public void update(Adopt_Ani_photosVO aAdopt_Ani_photosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_photosDAO.UPDATE);
			pstmt.setBytes (1, aAdopt_Ani_photosVO.getAdo_Ani_Pic());
			pstmt.setString (2, aAdopt_Ani_photosVO.getAdo_Pic_name());
			pstmt.setString (3, aAdopt_Ani_photosVO.getAdo_Pic_extent());
			pstmt.setDate (4, aAdopt_Ani_photosVO.getAdo_Pic_time());
			pstmt.setString (5, aAdopt_Ani_photosVO.getAdo_Pic_type());
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
	public void delete(String  aAdopt_Ani_photos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_photosDAO.DELETE);
			pstmt.setString (1,aAdopt_Ani_photos);
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
	public Adopt_Ani_photosVO findByPrimaryKey(String  aAdopt_Ani_photos){
	Adopt_Ani_photosVO adopt_ani_photosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_photosDAO.DELETE);
			pstmt.setString (1,aAdopt_Ani_photos);
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
		return adopt_ani_photosVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Adopt_Ani_photosVO> getAll(){ 
		List<Adopt_Ani_photosVO> list = new ArrayList<Adopt_Ani_photosVO>();
		Adopt_Ani_photosVO adopt_ani_photosVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Adopt_Ani_photosDAO.DELETE);
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