package com.stray_ani_photos.model;

import java.util.*;
import java.sql.*; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 
/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物相簿<br>
 *	英文:stray_Ani_photos<br>
 */ 
public class Stray_Ani_photosDAO implements Stray_Ani_photosDAO_interface{
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
	public static final String INSERT_STMT = "INSERT INTO (str_Ani_Pic_No,stray_Ani_Id,mem_Id,stray_Ani_Pic,stray_Pic_name,stray_Pic_extent,stray_Pic_time,stray_Pic_type ) VALUES  ( stray_Ani_photos_seq1.nextval , ? , ? , ? , ? , ? , ? , ?  )  " ; 
	//====以下是更新指令====
	public static final String UPDATE = "UPDATE stray_Ani_photos SET stray_Ani_Pic=?,stray_Pic_name=? ,stray_Pic_extent=? ,stray_Pic_time=? ,stray_Pic_type=?  WHERE str_Ani_Pic_No=? " ; 
	//====以下是刪除指令====
	public static final String DELETE = "DELETE FROM stray_Ani_photos WHERE str_Ani_Pic_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ONE_STMT = "SELECT str_Ani_Pic_No,stray_Ani_Id,mem_Id,stray_Ani_Pic,stray_Pic_name,stray_Pic_extent,to_char(stray_Pic_time,'yyyy-mm-dd') stray_Pic_time,stray_Pic_type WHERE str_Ani_Pic_No=? " ; 
	//====以下是單筆資料查詢指令====
	public static final String GET_ALL_STMT = "SELECT str_Ani_Pic_No,stray_Ani_Id,mem_Id,stray_Ani_Pic,stray_Pic_name,stray_Pic_extent,to_char(stray_Pic_time,'yyyy-mm-dd') stray_Pic_time,stray_Pic_type WHERE str_Ani_Pic_No=? " ; 
	//====以下是新增指令====
	private static final String UPDATE_STRAY_ANI_PIC =" UPDATE stray_Ani_photos set STRAY_ANI_PIC=?  WHERE str_Ani_Pic_No=? " ; 
	private static final String UPDATE_STRAY_PIC_NAME =" UPDATE stray_Ani_photos set STRAY_PIC_NAME=?  WHERE str_Ani_Pic_No=? " ; 
	private static final String UPDATE_STRAY_PIC_EXTENT =" UPDATE stray_Ani_photos set STRAY_PIC_EXTENT=?  WHERE str_Ani_Pic_No=? " ; 
	private static final String UPDATE_STRAY_PIC_TIME =" UPDATE stray_Ani_photos set STRAY_PIC_TIME=?  WHERE str_Ani_Pic_No=? " ; 
	private static final String UPDATE_STRAY_PIC_TYPE =" UPDATE stray_Ani_photos set STRAY_PIC_TYPE=?  WHERE str_Ani_Pic_No=? " ; 
	//====以下是改寫insert方法====
	@Override
	public void insert(Stray_Ani_photosVO aStray_Ani_photosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_photosDAO.INSERT_STMT);
			pstmt.setString (1, aStray_Ani_photosVO.getStray_Ani_Id());
			pstmt.setString (2, aStray_Ani_photosVO.getMem_Id());
			pstmt.setBytes (3, aStray_Ani_photosVO.getStray_Ani_Pic());
			pstmt.setString (4, aStray_Ani_photosVO.getStray_Pic_name());
			pstmt.setString (5, aStray_Ani_photosVO.getStray_Pic_extent());
			pstmt.setDate (6, aStray_Ani_photosVO.getStray_Pic_time());
			pstmt.setString (7, aStray_Ani_photosVO.getStray_Pic_type());
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
	public void update(Stray_Ani_photosVO aStray_Ani_photosVO){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_photosDAO.UPDATE);
			pstmt.setBytes (1, aStray_Ani_photosVO.getStray_Ani_Pic());
			pstmt.setString (2, aStray_Ani_photosVO.getStray_Pic_name());
			pstmt.setString (3, aStray_Ani_photosVO.getStray_Pic_extent());
			pstmt.setDate (4, aStray_Ani_photosVO.getStray_Pic_time());
			pstmt.setString (5, aStray_Ani_photosVO.getStray_Pic_type());
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
	public void delete(String  aStray_Ani_photos){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_photosDAO.DELETE);
			pstmt.setString (1,aStray_Ani_photos);
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
	public Stray_Ani_photosVO findByPrimaryKey(String  aStray_Ani_photos){
		Stray_Ani_photosVO stray_ani_photosVO = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(Stray_Ani_photosDAO.GET_ONE_STMT);
			pstmt.setString (1,aStray_Ani_photos);
			pstmt.executeUpdate();
			while (rs.next()) {
				stray_ani_photosVO = new Stray_Ani_photosVO();
				stray_ani_photosVO.setStr_Ani_Pic_No(rs.getString("str_Ani_Pic_No"));
				stray_ani_photosVO.setStray_Ani_Id(rs.getString("stray_Ani_Id"));
				stray_ani_photosVO.setMem_Id(rs.getString("mem_Id"));
				stray_ani_photosVO.setStray_Ani_Pic(rs.getBytes("stray_Ani_Pic"));
				stray_ani_photosVO.setStray_Pic_name(rs.getString("stray_Pic_name"));
				stray_ani_photosVO.setStray_Pic_extent(rs.getString("stray_Pic_extent"));
				stray_ani_photosVO.setStray_Pic_time(rs.getDate("stray_Pic_time"));
				stray_ani_photosVO.setStray_Pic_type(rs.getString("stray_Pic_type"));
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
		return stray_ani_photosVO; 
	} 
	//====以下是改寫getAll方法====
	@Override
	public List<Stray_Ani_photosVO> getAll(){ 
		List<Stray_Ani_photosVO> list = new ArrayList<Stray_Ani_photosVO>();
		Stray_Ani_photosVO stray_ani_photosVO = null;
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