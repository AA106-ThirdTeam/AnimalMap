package com.pet_photos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:自家寵物相簿<br>
 *	英文:pet_Photos<br>
 */ 
public class Pet_PhotosDAO implements Pet_PhotosDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (pet_Pic_No,pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,pet_Pic_time,pet_Pic_type ) VALUES  ( pet_Photos_seq1.nextval , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE pet_Photos SET pet_Pic=?,pet_Pic_name=? ,pet_Pic_extent=? ,pet_Pic_time=? ,pet_Pic_type=?  WHERE pet_Pic_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM pet_Photos WHERE pet_Pic_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT pet_Pic_No,pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,to_char(pet_Pic_time,'yyyy-mm-dd') pet_Pic_time,pet_Pic_type WHERE pet_Pic_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT pet_Pic_No,pet_Id,mem_Id,pet_Pic,pet_Pic_name,pet_Pic_extent,to_char(pet_Pic_time,'yyyy-mm-dd') pet_Pic_time,pet_Pic_type WHERE pet_Pic_No=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_PET_PIC =" UPDATE pet_Photos set PET_PIC=?  WHERE pet_Pic_No=? " ; 
	private static final String UPDATE_PET_PIC_NAME =" UPDATE pet_Photos set PET_PIC_NAME=?  WHERE pet_Pic_No=? " ; 
	private static final String UPDATE_PET_PIC_EXTENT =" UPDATE pet_Photos set PET_PIC_EXTENT=?  WHERE pet_Pic_No=? " ; 
	private static final String UPDATE_PET_PIC_TIME =" UPDATE pet_Photos set PET_PIC_TIME=?  WHERE pet_Pic_No=? " ; 
	private static final String UPDATE_PET_PIC_TYPE =" UPDATE pet_Photos set PET_PIC_TYPE=?  WHERE pet_Pic_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Pet_PhotosVO aPet_PhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_PhotosDAO.INSERT_STMT);
			pstmt.setString (1, aPet_PhotosVO.getPet_Id());
			pstmt.setString (2, aPet_PhotosVO.getMem_Id());
			pstmt.setBytes (3, aPet_PhotosVO.getPet_Pic());
			pstmt.setString (4, aPet_PhotosVO.getPet_Pic_name());
			pstmt.setString (5, aPet_PhotosVO.getPet_Pic_extent());
			pstmt.setDate (6, aPet_PhotosVO.getPet_Pic_time());
			pstmt.setString (7, aPet_PhotosVO.getPet_Pic_type());
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
	public void update(Pet_PhotosVO aPet_PhotosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_PhotosDAO.UPDATE);
			pstmt.setBytes (1, aPet_PhotosVO.getPet_Pic());
			pstmt.setString (2, aPet_PhotosVO.getPet_Pic_name());
			pstmt.setString (3, aPet_PhotosVO.getPet_Pic_extent());
			pstmt.setDate (4, aPet_PhotosVO.getPet_Pic_time());
			pstmt.setString (5, aPet_PhotosVO.getPet_Pic_type());
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
	public void delete(String  aPet_Photos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_PhotosDAO.DELETE);
			pstmt.setString (1,aPet_Photos);
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
	public Pet_PhotosVO findByPrimaryKey(String  aPet_Photos){
	Pet_PhotosVO pet_photosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_PhotosDAO.DELETE);
			pstmt.setString (1,aPet_Photos);
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
		return pet_photosVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Pet_PhotosVO> getAll(){ 
		List<Pet_PhotosVO> list = new ArrayList<Pet_PhotosVO>();
		Pet_PhotosVO pet_photosVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Pet_PhotosDAO.DELETE);
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